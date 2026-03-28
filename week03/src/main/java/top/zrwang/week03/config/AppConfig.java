package top.zrwang.week03.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//import java.util.List;
//import java.util.Map;

/**
 * @author zrwang
 * @description AppConfig 用于读取自定义配置
 */
@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfig {
    private String name;
    private String version;
    private String description;
//    private List<String> envs;
//    private Map<String, String> author;
//    private Integer tokens;
//    private Boolean enabled;
}