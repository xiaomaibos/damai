package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:38
 */
@Data
public class Address {
    private Integer addressId;
    private String name;
    private String phone;
    private String detail;
    private Integer userId;
    @Transient
    private User user;
}
