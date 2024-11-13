package com.marsview.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.marsview.controller.basic.BasicController;
import com.marsview.controller.basic.Builder;
import com.marsview.controller.basic.ResultResponse;
import com.marsview.domain.Menu;
import com.marsview.domain.Pages;
import com.marsview.dto.MenuDto;
import com.marsview.dto.PagesDto;
import com.marsview.dto.UsersDto;
import com.marsview.mapper.RolesMapper;
import com.marsview.service.MenuService;
import com.marsview.service.PagesService;
import com.marsview.util.ConvertEntityUtil;
import com.marsview.util.SessionUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>类说明</p>
 *
 * @author yangshare simayifeng@gmail.com
 * @createTime: 2024/9/27 16:28
 */
@RestController
@RequestMapping("api/page")
public class PageController extends BasicController {

    @Autowired
    private PagesService pagesService;

    @Autowired
    private MenuService menuService;

    @Resource
    private RolesMapper rolesMapper;

    /**
     * 创建页面
     *
     * @param request
     * @param response
     * @param pages
     */
    @PostMapping("create")
    public ResultResponse create(HttpServletRequest request, HttpServletResponse response, @RequestBody Pages pages) {
        UsersDto users = SessionUtils.getUser(request);
        pages.setUser_id(users.getId());
        pages.setUser_name(users.getUserName());
        pages.setCreated_at(new Date());
        return getUpdateResponse(pagesService.save(pages), "创建失败");
    }

    /**
     * 获取页面列表
     *
     * @param request
     * @param response
     * @param pageNum
     * @param pageSize
     * @param type
     */
    @GetMapping("list")
    public ResultResponse list(HttpServletRequest request, HttpServletResponse response, int pageNum, int pageSize, Integer type) {
        UsersDto users = SessionUtils.getUser(request);
        QueryWrapper<Pages> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", users.getId());
        if (type != 0) {
            queryWrapper.eq("is_public", type);
        }

        Page<Pages> page = new Page<>(pageNum, pageSize);
        IPage<Pages> pageInfo = pagesService.page(page, queryWrapper);
        List<Pages> records = pageInfo.getRecords();
        List<PagesDto> pagesDtos = new ArrayList<>(records.size());
        for (Pages record : records) {
            pagesDtos = ConvertEntityUtil.ConvertToDto(record, pagesDtos.getClass());
        }
        return Builder.of(ResultResponse::new)
                .with(ResultResponse::setData, Map.of(
                        "list", pagesDtos,
                        "pageNum", pageInfo.getCurrent(),
                        "pageSize", pageInfo.getSize(),
                        "total", pageInfo.getTotal()
                ))
                .build();
    }

    /**
     * 获取页面角色列表
     *
     * @param response
     * @param menu
     */
    @PostMapping("/role/list")
    public ResultResponse list(HttpServletRequest request, HttpServletResponse response, @RequestBody MenuDto menu) {
        UsersDto users = SessionUtils.getUser(request);
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", users.getId());
        if (menu != null) {
            queryWrapper.eq("page_id", menu.getPage_id());
        }
        menu.setUser_id(users.getId());
        return getResponse(Map.of("list", menuService.list(queryWrapper)));
    }

    /**
     * 获取页面信息
     *
     * @param response
     * @param page_id
     */
    @GetMapping("/detail/{page_id}")
    public ResultResponse detail(HttpServletRequest request, HttpServletResponse response,
                                 @PathVariable("page_id") Long page_id) {
        UsersDto users = SessionUtils.getUser(request);
        QueryWrapper<Pages> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", users.getId());
        if (page_id == null) {
            return getErrorResponse("参数错误");
        }
        queryWrapper.eq("id", page_id);
        Pages pages = pagesService.getOne(queryWrapper);
        if (pages == null) {
            return getErrorResponse("页面不存在");
        }
        return getResponse(ConvertEntityUtil.ConvertToDto(pages, PagesDto.class));
    }

    /**
     * 更新页面信息
     *
     * @param response
     * @param pagesDto
     */
    @PostMapping("update")
    public ResultResponse update(HttpServletResponse response, @RequestBody PagesDto pagesDto) {
        Pages pages = new Pages();
        BeanUtils.copyProperties(pagesDto, pages);
        pages.setUpdated_at(new Date());
        pages.setIs_edit(pagesDto.getIs_edit());
        pages.setIs_public(pagesDto.getIs_public());
        pages.setPage_data(pagesDto.getPage_data());
        return getUpdateResponse(pagesService.updateById(pages), "保存失败");
    }

    /**
     * 页面回滚
     *
     * @param response
     * @param dto
     */
    @PostMapping("rollback")
    public ResultResponse rollback(HttpServletResponse response, @RequestBody PagesDto dto) {
        return getUpdateResponse(
                pagesService.updateById(Builder.of(Pages::new)
                        .with(Pages::setId, dto.getPage_id())
                        .with(Pages::setStg_publish_id, "stg".equals(dto.getEnv()) ? dto.getLast_publish_id() : null)
                        .with(Pages::setStg_state, "stg".equals(dto.getEnv()) ? 3 : null)
                        .with(Pages::setPre_publish_id, "pre".equals(dto.getEnv()) ? dto.getLast_publish_id() : null)
                        .with(Pages::setPre_state, "pre".equals(dto.getEnv()) ? 3 : null)
                        .with(Pages::setPrd_publish_id, "prd".equals(dto.getEnv()) ? dto.getLast_publish_id() : null)
                        .with(Pages::setPrd_state, "prd".equals(dto.getEnv()) ? 3 : null).build()) ? 1 : 0, "操作失败");
    }

    /**
     * 获取页面模板列表
     */
    @GetMapping("getPageTemplateList")
    public ResultResponse getPageTemplateList(int pageNum, int pageSize, String keyword) {
        QueryWrapper<Pages> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_public", 3);
        if (StringUtils.hasText(keyword)){
            queryWrapper.like("name", keyword);
        }

        Page<Pages> page = new Page<>(pageNum, pageSize);
        IPage<Pages> pageInfo = pagesService.page(page, queryWrapper);
        List<Pages> records = pageInfo.getRecords();
        List<PagesDto> pagesDtos = new ArrayList<>(records.size());
        for (Pages record : records) {
            pagesDtos.add(ConvertEntityUtil.ConvertToDto(record, PagesDto.class));
        }
        return Builder.of(ResultResponse::new)
                .with(ResultResponse::setData, Map.of(
                        "list", pagesDtos,
                        "pageNum", pageInfo.getCurrent(),
                        "pageSize", pageInfo.getSize(),
                        "total", pageInfo.getTotal()
                ))
                .build();
    }

}
