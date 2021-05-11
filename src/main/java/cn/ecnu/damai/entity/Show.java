package cn.ecnu.damai.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:48
 */
@Data
public class Show {

    private Integer showId;
    private String name;
    private Date time;

    private Integer programId;
}
