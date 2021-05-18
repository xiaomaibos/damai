package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer>, JpaSpecificationExecutor<Address> {
    List<Address> findByUserId(Integer userId);
}
