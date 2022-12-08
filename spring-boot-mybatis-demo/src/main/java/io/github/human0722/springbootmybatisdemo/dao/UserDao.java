package io.github.human0722.springbootmybatisdemo.dao;

import io.github.human0722.springbootmybatisdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author human0722
 * @date 2022-11-29 17:37
 **/
@Mapper
public interface UserDao {
    @Select("select * from t_user")
    List<User> getAllUser();

    User getUserById(int id);

    int insertOne(User user);

    int insertBatch(List<User> users);

    int deleteOne(String id);

    List<User> selectPage(String name);
}
