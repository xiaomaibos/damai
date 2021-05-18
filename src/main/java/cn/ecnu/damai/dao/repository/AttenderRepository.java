package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.Attender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AttenderRepository extends JpaRepository<Attender, Integer>, JpaSpecificationExecutor<Attender> {
    List<Attender> findByUserId(Integer userId);
}
