package cn.ecnu.damai.mapper;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.entity.ProgramFilter;

import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:59
 */
public interface ProgramMapper {
    Program findProgramById(Integer programId);

    List<Program> findProgramWithFilters(ProgramFilter programFilter);
}
