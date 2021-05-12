package cn.ecnu.damai.entity;

import lombok.Data;

import javax.persistence.Transient;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 22:41
 */
@Data
public class Attender {
    private Integer id;
    private String name;
    private String identityType;
    private String identityNum;

    private Integer userId;
    @Transient
    private User user;
}
