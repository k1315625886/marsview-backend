package com.marsview.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marsview.mapper.MenuMapper;
import com.marsview.domain.Menu;
@Service
public class MenuService extends ServiceImpl<MenuMapper, Menu> {

}
