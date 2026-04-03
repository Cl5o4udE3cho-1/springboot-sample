package top.zrwang.week05.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.zrwang.week05.entity.User;

/**
 * @author 你的名字
 * @date 2026/4/3
 * @description UserMPMapper：空接口，BaseMapper 已封装所有单表 CRUD 方法，无需手动编写
 */
@Mapper
public interface UserMPMapper extends BaseMapper<User> {
    // 无需编写任何方法，BaseMapper 内置全套 CRUD
}