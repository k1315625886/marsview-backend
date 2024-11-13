package com.marsview.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marsview.mapper.ProjectsMapper;
import com.marsview.domain.Projects;
@Service
public class ProjectsService extends ServiceImpl<ProjectsMapper, Projects> {

}
