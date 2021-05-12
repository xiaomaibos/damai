package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 13:56
 */
@Data
public class Category {
    private Integer cid;
    private String name;
    private Integer count;

    @Transient
    private Set<Program> programs;
}
