package com.marsview.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marsview.domain.Workflows;
import com.marsview.mapper.WorkflowsMapper;
@Service
public class WorkflowsService extends ServiceImpl<WorkflowsMapper, Workflows> {

}
