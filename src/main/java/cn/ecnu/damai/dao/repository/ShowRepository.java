package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ShowRepository extends JpaRepository<Show, Integer>, JpaSpecificationExecutor<Show> {
}
