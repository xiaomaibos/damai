package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.entity.Category;
import cn.ecnu.damai.mapper.CategoryMapper;
import cn.ecnu.damai.service.CategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:01
 */
@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryList() {
        return categoryMapper.getCategoryList();
    }
}
