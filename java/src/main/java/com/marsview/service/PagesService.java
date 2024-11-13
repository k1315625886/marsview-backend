package com.marsview.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marsview.mapper.PagesMapper;
import com.marsview.domain.Pages;
@Service
public class PagesService extends ServiceImpl<PagesMapper, Pages> {

}
