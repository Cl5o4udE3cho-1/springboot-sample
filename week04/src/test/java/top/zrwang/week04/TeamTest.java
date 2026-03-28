package top.zrwang.week04;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.zrwang.week04.entity.Team;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class TeamTest {

    @Test
    void testTeam() {
        // 手动创建 Team 对象并赋值
        Team team = new Team();
        team.setLeader("测试负责人");
        team.setAge(35);
        team.setEmail("test@example.com");
        team.setPhone("13800138000");
        team.setCreateTime(LocalDateTime.now().minusDays(1)); // 设为昨天，确保早于当前时间

        log.info("team: {}", team);

        // 校验负责人姓名长度（2-10位）
        assertTrue(team.getLeader().length() >= 2 && team.getLeader().length() <= 10);
        // 校验年龄范围（30-60岁）
        assertTrue(team.getAge() >= 30 && team.getAge() <= 60);
        // 校验邮箱格式
        assertTrue(team.getEmail().matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$"));
        // 校验手机号格式（11位数字）
        assertTrue(team.getPhone().matches("^[0-9]{11}$"));
        // 校验创建时间早于当前时间
        assertTrue(team.getCreateTime().isBefore(LocalDateTime.now()));
    }
}