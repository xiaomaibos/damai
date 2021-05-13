package cn.ecnu.damai.entity;

import lombok.Data;

/**
 * @author Kyrie Lee
 * @date 2021/5/12 17:10
 */
@Data
public class ProgramFilter {
    private String keyWord;
    private Integer city;
    private Integer category;
    private String startTime;
    private String endTime;
    private Integer order;
}
