package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:43
 */
@Data
public class Program {
    private Integer pid;
    private String title;
    private String highPrice;
    private String lowPrice;

    private Date startTime;
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
    private String image;
    /**
     * 节目从属的城市
     */
    private Integer cityId;
    @Transient
    private City city;

    /**
     * 节目从属的类别
     */
    private Integer categoryId;
    @Transient
    private Category category;

    @Transient
    private Set<Show> shows;
}
