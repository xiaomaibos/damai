package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:27
 */
@Data
public class Level {
    private Integer levelId;
    private String name;
    private String price;
    private Integer totalCount;
    private Integer leftCount;
    private Integer limitCount;
    private String seat;
    private Integer showId;

    @Transient
    private Show show;

    @Transient
    private Set<Ticket> tickets;
}
