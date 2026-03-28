package top.zrwang.week04.entity;

import java.time.LocalDateTime;

public class Student {
    private String name;
    private int age;
    private Long id;
    private LocalDateTime createTime;

    // 无参构造
    public Student() {}

    // 带参构造
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 全参构造（方便初始化）
    public Student(String name, int age, Long id, LocalDateTime createTime) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.createTime = createTime;
    }

    // getter 和 setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}