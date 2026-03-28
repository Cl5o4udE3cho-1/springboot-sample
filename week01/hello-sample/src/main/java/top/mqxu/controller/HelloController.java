package top.mqxu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.mqxu.vo.ResultVO;

@RestController
@RequestMapping("/api")

public class HelloController {
    @GetMapping("/hello")
    public ResultVO<String> hello() {  // 添加泛型
        return ResultVO.success("Hello, Spring Boot!");  // 使用静态方法
    }
}
