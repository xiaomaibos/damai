package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:30
 */
@Data
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer ticketId;
    private String price;
    @Column(name = "seat_num")
    private Integer seatNum;
    @Column(name = "seat_info")
    private String seatInfo;
    private Integer valid;
    @Column(name = "order_id")
    private Integer orderId;
    @Column(name = "level_id")
    private Integer levelId;

    @Transient
    @ManyToOne(targetEntity = Order.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id",referencedColumnName = "id")
    private Order order;

    @Transient
    @ManyToOne(targetEntity = Level.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id",referencedColumnName = "id")
    private Level level;

}
