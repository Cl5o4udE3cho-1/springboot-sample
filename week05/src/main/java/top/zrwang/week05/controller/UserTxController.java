package top.zrwang.week05.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import top.zrwang.week05.common.Result;
import top.zrwang.week05.entity.User;
import top.zrwang.week05.service.UserTxService;

import java.util.Map;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("/api/user/tx")
@RequiredArgsConstructor
public class UserTxController {

    private final UserTxService userTxService;

    @PostMapping("/addTwo")
    public Result<String> addTwo(@RequestBody Map<String, User> map) {
        User user1 = map.get("user1");
        User user2 = map.get("user2");
        userTxService.addTwoUsers(user1, user2);
        return Result.success("两个用户均新增成功");
    }
}