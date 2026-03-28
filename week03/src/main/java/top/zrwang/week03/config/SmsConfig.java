package top.zrwang.week03.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 短信服务配置类，从配置文件读取短信相关参数
 * @author Lenovo
 * @date
 * @description
 */
@Component
@ConfigurationProperties(prefix = "sms")
@Data
public class SmsConfig {
    private String serverIp;
    private String port;
    private String accountSid;
    private String accountToken;
    private String appId;
    private String templateId;
}