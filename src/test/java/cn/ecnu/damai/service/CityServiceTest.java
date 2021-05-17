package cn.ecnu.damai.service;

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
public class CityServiceTest {
    @Autowired
    private CityService cityService;

    @Test
    public void testGetCityList() {
        List<City> cities = cityService.getCityList();
        System.out.println(JSON.toJSONString(cities));
    }

    @Test
    public void findCityByName() {
        City city = cityService.findCityByName("上海");
        System.out.println(JSON.toJSONString(city));
    }
}
