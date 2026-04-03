package top.zrwang.week04.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.zrwang.week04.common.Result;
import top.zrwang.week04.entity.Team;
import top.zrwang.week04.exception.BusinessException;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("/api/team")
@Slf4j
public class TeamController {

    @PostMapping("/add")
    public Result<String> addTeam(@RequestBody(required = false) Team team, HttpServletRequest request) {
        log.info("添加团队:{}", team);

        // 1. 校验token
        String token = request.getHeader("token");
        if (token == null || token.isBlank()) {
            throw new BusinessException(401, "请先登录");
        }

        // 2. 校验权限
        if (!"admin".equals(token)) {
            throw new BusinessException(403, "没有权限");
        }

        // 3. 成功返回
//        int a = 1/0;
        return Result.success("添加成功");
    }
}