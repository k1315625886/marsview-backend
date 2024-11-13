package com.marsview.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marsview.mapper.RolesMapper;
import com.marsview.domain.Roles;
@Service
public class RolesService extends ServiceImpl<RolesMapper, Roles> {

}
