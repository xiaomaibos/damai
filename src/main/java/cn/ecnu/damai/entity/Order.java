package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:34
 */
@Data
@Entity
@Table(name = "order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer orderId;
    private String code;
    @Column(name = "create_time")
    private Date createTime;
    private Integer status;
    @Column(name = "status_info")
    private String statusInfo;
    @Column(name = "total_count")
    private Integer totalCount;
    @Column(name = "total_price")
    private String totalPrice;
    private String linkman;
    @Column(name = "linknum")
    private String linkNum;
    private String attender;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "show_id")
    private Integer showId;

    @Transient
    private User user;
    @Transient
    private Show show;

    @Transient
    private Set<Ticket> tickets;
}
