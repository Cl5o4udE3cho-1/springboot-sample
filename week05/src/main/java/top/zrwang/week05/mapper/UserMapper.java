package top.zrwang.week05.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.zrwang.week05.entity.User;
import java.util.List;

/**
 * @author Lenovo
 */
@Mapper
public interface UserMapper {

    // 增
    int insert(User user);

    // 删
    int deleteByPrimaryKey(Long id);

    // 改
    int updateByPrimaryKey(User user);

    // 查单个
    User selectByPrimaryKey(Long id);

    // 查全部
    List<User> selectList();

    // ======================
    // 复杂条件查询（XML动态SQL）
    // ======================
    List<User> selectByComplexCondition(
            @Param("username") String username,
            @Param("minAge") Integer minAge
    );
}