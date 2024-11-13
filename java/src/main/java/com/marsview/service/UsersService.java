package com.marsview.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.marsview.mapper.UsersMapper;
import com.marsview.domain.Users;
@Service
public class UsersService extends ServiceImpl<UsersMapper, Users> {

}
