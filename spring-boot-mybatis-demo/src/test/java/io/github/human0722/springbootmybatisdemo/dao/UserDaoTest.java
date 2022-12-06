package io.github.human0722.springbootmybatisdemo.dao;

import io.github.human0722.springbootmybatisdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setName("randy");
        user.setAge(12);
        user.setEmail("btainlee@outlook.com");
        user.setIs_deleted(1);
        int result = userDao.insertOne(user);
        System.out.println(user);
        System.out.println("affected rows: " + result);
    }

    @Test
    public void testInsertBatch() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            User user = new User();
            user.setName("batchUser" + i);
            user.setAge(10 + i);
            user.setEmail("batchUser" + i + "@gmail.com");
            user.setIs_deleted(0);
            users.add(user);
        }
        int i = userDao.insertBatch(users);
        System.out.println("affected rows:" + i);
    }

    @Test
    public void testDeleteOne() {
        int i = userDao.deleteOne("1597474644598751241");
        System.out.println("affected rows: " + i);
    }

    @Test
    public void testSelectPage() {
        List<User> userList = userDao.selectPage("batch");
        userList.forEach(System.out::println);
    }
}
