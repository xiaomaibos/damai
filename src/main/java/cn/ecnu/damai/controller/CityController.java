package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.City;
import cn.ecnu.damai.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:12
 */
@Controller
@RequestMapping("/city")
public class CityController {

    @Resource
    private CityService cityService;

    @RequestMapping("/getCityList")
    @ResponseBody
    public List<City> getCityList() {
        return cityService.getCityList();
    }
}
