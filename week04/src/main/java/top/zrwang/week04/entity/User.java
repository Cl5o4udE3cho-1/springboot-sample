package top.zrwang.week04.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Lenovo
 */
@Setter
@Getter
public class User {
    // getter 和 setter
    private Long id;
    private String username;
    private LocalDateTime createTime;

    // 无参构造
    public User() {}

    //getter和setter
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}