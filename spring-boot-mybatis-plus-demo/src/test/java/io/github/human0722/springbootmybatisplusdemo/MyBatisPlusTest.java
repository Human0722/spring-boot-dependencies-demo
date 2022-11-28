package io.github.human0722.springbootmybatisplusdemo;

import io.github.human0722.springbootmybatisplusdemo.dao.UserMapper;
import io.github.human0722.springbootmybatisplusdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xueliang
 * @date 2022-11-28 17:15
 */
@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList() {
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "张三", 23, "randy@sau.edu.cn");
        int result = userMapper.insert(user);
        System.out.println("affected rows:" + result);
        System.out.println("auto fetch id:" + user.getId());
    }

    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById("1597163018234298369");
        System.out.println("affected rows:" + result);
    }
}
