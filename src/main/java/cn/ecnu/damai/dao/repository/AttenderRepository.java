package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.Attender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AttenderRepository extends JpaRepository<Attender, Integer>, JpaSpecificationExecutor<Attender> {
}
