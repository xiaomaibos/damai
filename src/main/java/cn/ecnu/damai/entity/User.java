package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 10:48
 */
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer uid;
    private String username;
    private String password;
    private String nickname;
    private Integer gender;
    private Date birthday;
    private String identity;
    @Column(name = "image_url")
    private String headImg;
    private int privilege;

    @Transient
    private Set<Order> orders;
    @Transient
    private Set<Address> addresses;
    @Transient
    private Set<Attender> attenders;
}
