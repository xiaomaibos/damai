package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProgramRepository extends JpaRepository<Program, Integer>, JpaSpecificationExecutor<Program> {
}
