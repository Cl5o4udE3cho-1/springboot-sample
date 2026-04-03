package top.zrwang.week05.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import top.zrwang.week05.entity.User;
import top.zrwang.week05.service.UserService;
import top.zrwang.week05.common.Result;

import java.util.List;

/**
 * @author Lenovo
 */
@RestController
@RequestMapping("/api/user")
@Tag(name = "user-controller", description = "用户管理接口（MyBatis纯注解CRUD）")
public class UserController {

    // 注入Service
    @Resource
    private UserService userService;

    /**
     * 测试接口（保留，用于Swagger展示User实体）
     */
    @GetMapping("/demo")
    @Operation(summary = "测试接口", description = "返回模拟的测试用户数据")
    public User demo() {
        User user = new User();
        user.setId(1L);
        user.setUsername("wangzhirong");
        user.setPassword("123456");
        user.setAge(20);
        user.setEmail("1017404853@qq.com");
        return user;
    }

    /**
     * 新增用户
     */
    @PostMapping
    @Operation(summary = "新增用户", description = "传入User实体，插入数据库")
    public int add(@RequestBody User user) {
        return userService.add(user);
    }

    /**
     * 根据ID查询用户
     */
    @GetMapping("/{id}")
    @Operation(summary = "根据ID查询用户", description = "路径参数id")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    /**
     * 查询所有用户
     */
    @GetMapping
    @Operation(summary = "查询所有用户", description = "返回用户列表")
    public List<User> list() {
        return userService.list();
    }

    /**
     * 更新用户
     */
    @PutMapping
    @Operation(summary = "更新用户", description = "传入带ID的User实体，更新数据库")
    public int update(@RequestBody User user) {
        return userService.update(user);
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "删除用户", description = "路径参数id，根据ID删除")
    public int delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    /**
     * 条件查询用户（动态SQL）
     * @param username 用户名（模糊查询）
     * @param minAge 最小年龄
     * @return 符合条件的用户列表
     */
    // 类上已经有 @RequestMapping("/api/user")，方法上只需要写 /search
    @GetMapping("/search")
    @Operation(summary = "条件查询用户", description = "根据用户名模糊查询、最小年龄筛选")
    public Result<List<User>> search(
            @RequestParam(required = false) String username,
            @RequestParam(required = false) Integer minAge
    ) {
        return Result.success(userService.search(username, minAge));
    }
}