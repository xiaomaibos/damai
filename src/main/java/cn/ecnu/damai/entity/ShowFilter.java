package cn.ecnu.damai.entity;

import lombok.Data;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 15:19
 */
@Data
public class ShowFilter {
    private String keyWord;
    private int pageSize;
    private int currentPage;
}
