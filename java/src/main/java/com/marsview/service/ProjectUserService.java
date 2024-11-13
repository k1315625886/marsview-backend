package com.marsview.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marsview.domain.ProjectUser;
import com.marsview.mapper.ProjectUserMapper;
@Service
public class ProjectUserService extends ServiceImpl<ProjectUserMapper, ProjectUser> {

}
