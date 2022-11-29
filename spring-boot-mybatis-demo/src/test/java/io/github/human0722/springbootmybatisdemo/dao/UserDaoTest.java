package io.github.human0722.springbootmybatisdemo.dao;

import io.github.human0722.springbootmybatisdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author human0722
 * @date 2022-11-29 17:41
 **/
@SpringBootTest
public class UserDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectAll(){
        List<User> allUser = userDao.getAllUser();
        allUser.forEach(System.out::println);
    }

    @Test
    public void testSelectById() {
        User user = userDao.getUserById(2);
        System.out.println(user);
    }
}
