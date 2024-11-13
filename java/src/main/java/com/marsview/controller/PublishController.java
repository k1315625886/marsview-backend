package com.marsview.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.marsview.controller.basic.BasicController;
import com.marsview.controller.basic.Builder;
import com.marsview.controller.basic.ResultResponse;
import com.marsview.domain.Pages;
import com.marsview.domain.PagesPublish;
import com.marsview.dto.PagesPublishDto;
import com.marsview.dto.UsersDto;
import com.marsview.service.PagesPublishService;
import com.marsview.service.PagesService;
import com.marsview.util.ConvertEntityUtil;
import com.marsview.util.SessionUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>说明</p>
 *
 * @author yangshare simayifeng@gmail.com
 * createTime: 2024/9/28 18:59
 */
@RestController
@RequestMapping("api/publish")
public class PublishController extends BasicController {

    @Autowired
    private PagesPublishService pagesPublishService;

    @Autowired
    private PagesService pagesService;

    /**
     * 创建发布
     *
     * @param request
     * @param publishDto
     */
    @PostMapping("create")
    public ResultResponse create(HttpServletRequest request, @RequestBody PagesPublishDto publishDto) {
        UsersDto users = SessionUtils.getUser(request);
        Pages pages = pagesService.getById(publishDto.getPage_id());
        if (pages == null) {
            return getErrorResponse("页面不存在");
        } else {
            QueryWrapper<PagesPublish> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("page_id", publishDto.getPage_id());
            long count = pagesPublishService.count(queryWrapper);
            PagesPublish publish = new PagesPublish();
            publish.setPage_id(pages.getId());
            publish.setPage_name(pages.getName());
            publish.setUser_id(users.getId());
            publish.setUser_name(users.getUserName());
            publish.setCreated_at(new Date());
            publish.setUpdated_at(new Date());
            publish.setVersion((count + 1) + "");
            publish.setPage_data(pages.getPage_data());
            boolean result = pagesPublishService.save(publish);
            if (result) {
                //更新页面信息
                Pages pagesNew = new Pages();
                BeanUtils.copyProperties(pages, pagesNew);
                pagesNew.setStg_publish_id(StringUtils.equals("stg", publishDto.getEnv()) ? publish.getId() : null);
                pagesNew.setStg_state(StringUtils.equals("stg", publishDto.getEnv()) ? 3 : null);
                pagesNew.setPre_publish_id(StringUtils.equals("pre", publishDto.getEnv()) ? publish.getId() : null);
                pagesNew.setPre_state(StringUtils.equals("pre", publishDto.getEnv()) ? 3 : null);
                pagesNew.setPrd_publish_id(StringUtils.equals("prd", publishDto.getEnv()) ? publish.getId() : null);
                pagesNew.setPrd_state(StringUtils.equals("prd", publishDto.getEnv()) ? 3 : null);
                pagesNew.setPreview_img(publishDto.getPreview_img());
                pagesService.updateById(pagesNew);

            }
            return getUpdateResponse(result, "发布失败");
        }
    }

    /**
     * 分页获取发布记录
     */
    @PostMapping("list")
    public ResultResponse list(@RequestBody PagesPublishDto publishDto) {

        String env = publishDto.getEnv();// 环境
        Long page_id = publishDto.getPage_id();// 页面ID
        String userName = publishDto.getPublish_user_id();// 发布人名称 TODO

        if (page_id == null || page_id == 0) {
            return getErrorResponse("页面ID不能为空");
        }
        if (StringUtils.isEmpty(env)) {
            return getErrorResponse("环境不能为空");
        }
        QueryWrapper<PagesPublish> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("env", env);
        queryWrapper.eq("page_id", page_id);
        if (publishDto.getStart() != null && publishDto.getEnd() != null) {
            queryWrapper.between("created_at", publishDto.getStart(), publishDto.getEnd());
        }
        if (!StringUtils.isEmpty(userName)) {
            queryWrapper.like("user_name", userName);
        }

        Page<PagesPublish> page = new Page<>(publishDto.getPageNum(), publishDto.getPageSize());
        IPage<PagesPublish> pageInfo = pagesPublishService.page(page, queryWrapper);
        List<PagesPublish> records = pageInfo.getRecords();
        List<PagesPublishDto> pagesPublishDtos = new ArrayList<>(records.size());
        for (PagesPublish record : records) {
            pagesPublishDtos.add(ConvertEntityUtil.ConvertToDto(record, PagesPublishDto.class));
        }
        return Builder.of(ResultResponse::new)
                .with(ResultResponse::setData, Map.of(
                        "list", pagesPublishDtos,
                        "pageNum", pageInfo.getCurrent(),
                        "pageSize", pageInfo.getSize(),
                        "total", pageInfo.getTotal()
                ))
                .build();
    }
}
