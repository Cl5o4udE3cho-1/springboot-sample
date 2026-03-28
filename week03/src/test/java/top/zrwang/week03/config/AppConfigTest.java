package top.zrwang.week03.config;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import jakarta.annotation.Resource;

@SpringBootTest // 启动Spring容器进行测试
@Slf4j // 注入日志对象
public class AppConfigTest {

    @Resource // 注入配置类实例
    private AppConfig appConfig;

    @Test
    void getAppName() {
        log.info("应用名称: {}", appConfig.getName());
    }

    @Test
    void getVersion() {
        log.info("版本号: {}", appConfig.getVersion());
    }

    @Test
    void getDescription() {
        log.info("应用描述: {}", appConfig.getDescription());
    }
}