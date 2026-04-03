package top.zrwang.week05.service;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.zrwang.week05.entity.User;
import top.zrwang.week05.mapper.UserMapper;
import java.util.List;

/**
 * @author Lenovo
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    // 新增
    public int add(User user) {
        return userMapper.insert(user);
    }

    // 删除
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    // 修改
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    // 根据ID查询
    public User getById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    // 查询全部
    public List<User> list() {
        return userMapper.selectList();
    }


    // ======================
    // 复杂条件查询
    // ======================
    public List<User> search(String username, Integer minAge) {
        return userMapper.selectByComplexCondition(username, minAge);
    }
}