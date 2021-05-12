package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:48
 */
@Data
public class Show {

    private Integer showId;
    private String name;
    private Date time;

    private Integer programId;
    @Transient
    private Program program;
    @Transient
    private Set<Order> orders;
    @Transient
    private Set<Level> levels;
}
