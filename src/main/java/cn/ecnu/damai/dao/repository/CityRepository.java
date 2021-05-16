package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CityRepository extends JpaRepository<City, Integer>, JpaSpecificationExecutor<City> {
    City findByName(String name);
}
