package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;
import java.util.Date;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 10:48
 */
@Data
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String nickname;
    private Integer gender;
    private Date birthday;
    private String identity;
    private String headImg;
    private int privilege;

    @Transient
    private Set<Order> orders;
    @Transient
    private Set<Address> addresses;
    @Transient
    private Set<Attender> attenders;
}
