package cn.ecnu.damai.entity;

import lombok.Data;

import java.util.Date;

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
    private int gender;
    private Date birthday;
    private String identity;
    private String headImg;
    private int privilege;
}
