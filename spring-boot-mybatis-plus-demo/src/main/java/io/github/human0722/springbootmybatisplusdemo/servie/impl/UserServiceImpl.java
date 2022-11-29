package io.github.human0722.springbootmybatisplusdemo.servie.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.human0722.springbootmybatisplusdemo.dao.UserMapper;
import io.github.human0722.springbootmybatisplusdemo.domain.User;
import io.github.human0722.springbootmybatisplusdemo.servie.UserService;
import org.springframework.stereotype.Service;

/**
 * @author human0722
 * @date 2022-11-29 14:09
 **/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
