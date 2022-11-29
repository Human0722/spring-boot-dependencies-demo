package io.github.human0722.springbootmybatisplusdemo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.human0722.springbootmybatisplusdemo.dao.UserMapper;
import io.github.human0722.springbootmybatisplusdemo.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author human0722
 * @date 2022-11-29 15:52
 **/
@SpringBootTest
public class PageTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testPage() {
        Page<User> page = new Page<>(1,5);
        userMapper.selectPage(page, null);
        List<User> records = page.getRecords();
        page.getCurrent();
        page.getSize();
        page.getTotal();
        page.getPages();
        page.hasPrevious();
        page.hasNext();
    }
}
