package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:34
 */
@Data
public class Order {
    private Integer orderId;
    private String code;
    private Date createTime;
    private Integer status;
    private String statusInfo;
    private Integer totalCount;
    private String totalPrice;
    private String linkman;
    private String linkNum;
    private String attender;

    private Integer userId;
    @Transient
    private User user;

    private Integer showId;
    @Transient
    private Show show;

    private Set<Ticket> tickets;
}
