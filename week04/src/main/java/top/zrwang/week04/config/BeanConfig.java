package top.zrwang.week04.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.zrwang.week04.entity.Student;
import java.time.LocalDateTime;

/**
 * @author Lenovo
 */
@Configuration
public class BeanConfig {

    @Bean
    public Student student() {
        // 正确构造方法调用
        return new Student("小明", 18, 1234567890123456789L, LocalDateTime.now());
    }
}