package cn.ecnu.damai.dao.mapper;

import cn.ecnu.damai.entity.Category;

import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:03
 */
public interface CategoryMapper {
    List<Category> getCategoryList();
}
