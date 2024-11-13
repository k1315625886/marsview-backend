package com.marsview.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marsview.mapper.LibMapper;
import com.marsview.domain.Lib;
@Service
public class LibService extends ServiceImpl<LibMapper, Lib> {

}
