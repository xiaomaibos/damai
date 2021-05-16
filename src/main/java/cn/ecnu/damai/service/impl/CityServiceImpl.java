package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.entity.City;
import cn.ecnu.damai.dao.mapper.CityMapper;
import cn.ecnu.damai.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:18
 */
@Service("cityService")
public class CityServiceImpl implements CityService {

    @Resource
    private CityMapper cityMapper;

    @Override
    public List<City> getCityList() {
        return cityMapper.getCityList();
    }
}
