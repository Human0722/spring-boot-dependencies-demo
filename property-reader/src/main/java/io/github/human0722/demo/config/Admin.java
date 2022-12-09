package io.github.human0722.demo.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xueliang
 * @date 2022-12-09 10:09
 */
@Component
@PropertySource("classpath:myconfig.yml")
@ConfigurationProperties(prefix = "admin")
@Data
public class Admin {
    private String name;
    private String password;

    @Value("${version}")
    private String version;
    private List<Role> roleList;

    @Data
    public static class Role {
        private String roleName;
        private String description;
    }
}
