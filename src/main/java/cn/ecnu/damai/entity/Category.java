package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 13:56
 */
@Data
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer cid;
    private String name;
    private Integer count;

    @Transient
    private Set<Program> programs;
}
