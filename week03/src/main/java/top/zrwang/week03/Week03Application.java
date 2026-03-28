package top.zrwang.week03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import top.zrwang.week03.config.SmsConfig;

/**
 * @author Lenovo
 */
@SpringBootApplication
@EnableConfigurationProperties(SmsConfig.class)
public class Week03Application {

    public static void main(String[] args) {
        SpringApplication.run(Week03Application.class, args);
    }

}
