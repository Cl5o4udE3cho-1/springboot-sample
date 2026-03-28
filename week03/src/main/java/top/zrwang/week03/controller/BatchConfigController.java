package top.zrwang.week03.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zrwang.week03.config.AppConfig;
import jakarta.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/batch")
public class BatchConfigController {

    @Resource
    private AppConfig appConfig;

    @Value("${server.port}")
    private Integer serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @GetMapping("/info")
    public Map<String, Object> getBatchConfigInfo() {
        Map<String, Object> result = new HashMap<>();
        result.put("activeProfile", activeProfile);
        result.put("serverPort", serverPort);
        result.put("applicationName", applicationName);
        result.put("appName", appConfig.getName());
        result.put("appVersion", appConfig.getVersion());
        result.put("appDescription", appConfig.getDescription());
        return result;
    }
}