package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:16
 */
@Data
public class City {
    private Integer cityId;
    private String name;
    private String code;
    private Integer count;

    @Transient
    private Set<Program> programs;
}
