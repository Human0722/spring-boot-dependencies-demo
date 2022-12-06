package io.github.human0722.springbootmybatisplusdemo;

import io.github.human0722.springbootmybatisplusdemo.dao.UserDao;
import io.github.human0722.springbootmybatisplusdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author xueliang
 * @date 2022-11-28 17:15
 */
@SpringBootTest
public class MyBatisPlusTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void testSelectList() {
        userDao.selectList(null).forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        User user = new User(null, "张三", 23, "randy@sau.edu.cn", 0);
        int result = userDao.insert(user);
        System.out.println("affected rows:" + result);
        System.out.println("auto fetch id:" + user.getId());
    }

    @Test
    public void testDeleteById() {
        int result = userDao.deleteById("1597474644598751234");
        System.out.println("affected rows:" + result);
    }

    @Test
    public void testDeleteBatchIds() {
        List<Long> ids = Arrays.asList(5L);
        int i = userDao.deleteBatchIds(ids);
        System.out.println("affected rows: " + i);
    }

    @Test
    public void testDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张三");
        int i = userDao.deleteByMap(map);
        System.out.println("affected rows: " + i);
    }

    @Test
    public void testUpdateById() {
        User user = new User(4L, "Sandy Orin", 22, null,0);
        int i = userDao.updateById(user);
        System.out.println("affected rows: " + i);
    }

    @Test
    public void testSelectById() {
        User user = userDao.selectById(4L);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds() {
        List<Long> ids = Arrays.asList(1L, 2L, 3L);
        List<User> users = userDao.selectBatchIds(ids);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectAll() {
        List<User> users = userDao.selectList(null);
        users.forEach(System.out::println);
    }

}
