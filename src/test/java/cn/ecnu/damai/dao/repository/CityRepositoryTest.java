package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.City;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CityRepositoryTest {

    @Resource
    private CityRepository cityRepository;

    @Test
    public void testGetCityList() {
        List<City> cities = cityRepository.findAll();
        System.out.println(JSON.toJSONString(cities));
    }

    @Test
    public void testFindByName() {
        City city = cityRepository.findByName("上海shi");
        System.out.println(JSON.toJSONString(city));
    }

}
