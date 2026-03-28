package top.zrwang.week02.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Lenovo
 * @data
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Phone {
    private String band;
    private Double price;
    private String color;
}
