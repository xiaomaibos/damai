package cn.ecnu.damai.service;

import cn.ecnu.damai.dao.repository.CategoryRepository;
import cn.ecnu.damai.entity.Category;
import cn.ecnu.damai.entity.City;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Test
    public void testGetCategoryList() {
        List<Category> categories = categoryService.getCategoryList();
        System.out.println(JSON.toJSONString(categories));
    }
}
