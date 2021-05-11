package cn.ecnu.damai.entity;

import lombok.Data;

import java.util.Date;

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
    private String address;
    private String explain;
    private String detail;
    private String notice;
    private String image;
    /**
     * 节目从属的城市
     */
    private Integer cityId;
    /**
     * 节目从属的类别
     */
    private Integer categoryId;
}
