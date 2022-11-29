package io.github.human0722.springbootmybatisplusdemo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.human0722.springbootmybatisplusdemo.dao.UserMapper;
import io.github.human0722.springbootmybatisplusdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * @author human0722
 * @date 2022-11-29 14:39
 **/
@SpringBootTest
public class MyBatisPlusQueryWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryWrapperSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void testQueryInSelect() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // where id in [1,2]
        queryWrapper.inSql("id", "select id from t_user where id <= 3");
        List<User> list = userMapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }
}
