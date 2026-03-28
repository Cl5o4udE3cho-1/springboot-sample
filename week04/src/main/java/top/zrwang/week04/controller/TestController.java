package top.zrwang.week04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zrwang.week04.entity.Student;

/**
 * @author Lenovo
 */
@RestController
public class TestController {

    @Autowired
    private Student student;

    @GetMapping("/test")
    public Student test() {
        return student;
    }
}