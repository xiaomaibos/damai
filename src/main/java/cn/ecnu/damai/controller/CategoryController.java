package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.Category;
import cn.ecnu.damai.service.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 13:54
 */
@Controller
@RequestMapping("/category")
@CrossOrigin
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/getCategoryList")
    @ResponseBody
    public List<Category> categoryList() {
        return categoryService.getCategoryList();
    }
}
