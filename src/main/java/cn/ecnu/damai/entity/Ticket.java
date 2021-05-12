package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:30
 */
@Data
public class Ticket {
    private Integer ticketId;
    private String price;
    private Integer seatNum;
    private String seatInfo;
    private Integer valid;
    private Integer orderId;
    @Transient
    private Order order;

    @Transient
    private Level level;
    private Integer levelId;
}
