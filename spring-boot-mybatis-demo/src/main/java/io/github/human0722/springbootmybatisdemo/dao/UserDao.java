package io.github.human0722.springbootmybatisdemo.dao;

import io.github.human0722.springbootmybatisdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author human0722
 * @date 2022-11-29 17:37
 **/
@Mapper
public interface UserDao {
    @Select("select * from t_user")
    List<User> getAllUser();

    User getUserById(int id);
}
