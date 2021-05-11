package cn.ecnu.damai.mapper;

import cn.ecnu.damai.entity.Program;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:59
 */
public interface ProgramMapper {
    Program findProgramById(Integer programId);
}
