package io.github.human0722.springbootmybatisplusdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.human0722.springbootmybatisplusdemo.domain.User;

import java.util.List;

/**
 * @author xueliang
 * @date 2022-11-28 17:14
 */
public interface UserDao extends BaseMapper<User> {
    List<User> selectAll();

}
