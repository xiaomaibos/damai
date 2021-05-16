package cn.ecnu.damai.dao.mapper;

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
public class CityMapperTest {

    @Resource
    private CityMapper cityMapper;

    @Test
    public void testGetCityList() {
        List<City> cities = cityMapper.getCityList();
        System.out.println(JSON.toJSONString(cities));
    }

}
