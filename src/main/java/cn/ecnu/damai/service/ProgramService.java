package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Program;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:52
 */
public interface ProgramService {
    Program findProgramById(Integer programId);
}
