package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:38
 */
@Data
@Entity
@Table(name = "address")
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer addressId;
    private String name;
    private String phone;
    private String detail;
    @Column(name = "user_id")
    private Integer userId;

    @Transient
    @ManyToOne(targetEntity = User.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private User user;
}
