package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:27
 */
@Data
@Entity
@Table(name = "level")
public class Level {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer levelId;
    private String name;
    private String price;
    @Column(name = "total_count")
    private Integer totalCount;
    @Column(name = "left_count")
    private Integer leftCount;
    @Column(name = "limit_count")
    private Integer limitCount;
    private String seat;
    @Column(name = "show_id")
    private Integer showId;

    @Transient
    @ManyToOne(targetEntity = Show.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id",referencedColumnName = "id")
    private Show show;

    @Transient
    @OneToMany(mappedBy = "level",cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}
