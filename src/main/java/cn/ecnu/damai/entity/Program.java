package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:43
 */
@Data
@Entity
@Table(name = "program")
public class Program {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer pid;
    private String title;
    @Column(name = "high_price")
    private String highPrice;
    @Column(name = "low_price")
    private String lowPrice;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;

    /**
     * 这两个字段方便前端页面的显示
     */
    @Transient
    private String showStartTime;
    @Transient
    private String showEndTime;

    private String address;
    private String explain;
    private String detail;
    private String notice;
    @Column(name = "image_url")
    private String image;
    @Column(name = "city_id")
    private Integer cityId;
    @Column(name = "category_id")
    private Integer categoryId;

    @Transient
    @ManyToOne(targetEntity = City.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    private City city;
    @Transient
    @ManyToOne(targetEntity = Category.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "id")
    private Category category;

    @Transient
    @OneToMany(mappedBy = "program",cascade = CascadeType.ALL)
    private Set<Show> shows;
}
