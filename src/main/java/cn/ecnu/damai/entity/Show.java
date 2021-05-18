package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:48
 */
@Data
@Entity
@Table(name = "`show`")
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer showId;
    private String name;
    private Date time;
    @Column(name = "program_id")
    private Integer programId;

    @Transient
    private Program program;
    @Transient
    private Set<Order> orders;
    @Transient
    private Set<Level> levels;
}
