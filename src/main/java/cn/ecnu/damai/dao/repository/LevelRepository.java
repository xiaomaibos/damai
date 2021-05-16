package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface LevelRepository extends JpaRepository<Level, Integer>, JpaSpecificationExecutor<Level> {
}
