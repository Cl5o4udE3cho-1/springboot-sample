package top.zrwang.week04.entity;

import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author Lenovo
 */
@Data
public class Team {
    @NotBlank(message = "负责人姓名不能为空")
    @Size(min = 2, max = 10, message = "负责人姓名长度必须在2-10位之间")
    private String leader;

    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    @Min(value = 30, message = "年龄不能小于30")
    @Max(value = 60, message = "年龄不能大于60")
    private Integer age;

    // 新增缺失的字段
    @Email(message = "邮箱格式不正确")
    private String email;

    private LocalDateTime createTime;
}