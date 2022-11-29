package io.github.human0722.springbootmybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.github.human0722.springbootmybatisplusdemo.dao.UserMapper;
import io.github.human0722.springbootmybatisplusdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author human0722
 * @date 2022-11-29 15:08
 **/
@SpringBootTest
public class MyBatisPlusUpdateWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testUpdateWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", "1");
        User user = new User();
        user.setName("bush");
        int update = userMapper.update(user, updateWrapper);
        System.out.println("affected rows:" + update);
    }

    @Test
    public void testNullWrapper() {
        String name = null;
        Integer age = 28;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(name != null, "name", name);
        queryWrapper.eq(age != null, "age", age);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }
}
