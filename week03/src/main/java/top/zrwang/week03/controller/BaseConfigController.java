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
@RequestMapping("/config")
public class BaseConfigController {

    // 注入配置类
    @Resource
    private AppConfig appConfig;

    // 从配置文件读取服务器端口
    @Value("${server.port}")
    private Integer serverPort;

    // 从配置文件读取Spring应用名称
    @Value("${spring.application.name}")
    private String applicationName;

    // 原有接口：获取端口
    @GetMapping("/port")
    public String getPort() {
        return "当前服务器端口号: " + serverPort;
    }

    // 接口1：获取完整配置信息
    @GetMapping("/info")
    public Map<String, Object> getConfigInfo() {
        Map<String, Object> result = new HashMap<>();
        result.put("serverPort", serverPort);
        result.put("applicationName", applicationName);
        result.put("appName", appConfig.getName());
        result.put("appVersion", appConfig.getVersion());
        result.put("applicationDescription", appConfig.getDescription());
        return result;
    }

    // 接口2：简化版配置信息
    @GetMapping("/info2")
    public Map<String, Object> getConfigInfo2() {
        Map<String, Object> result = new HashMap<>();
        result.put("appName", appConfig.getName());
        result.put("version", appConfig.getVersion());
        result.put("description", appConfig.getDescription());
        return result;
    }
}