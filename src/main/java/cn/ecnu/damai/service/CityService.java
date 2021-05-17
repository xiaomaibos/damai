package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.City;

import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:18
 */
public interface CityService {
    List<City> getCityList();

    City findCityByName(String name);
}
