package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Program;
import com.github.pagehelper.PageInfo;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:52
 */
public interface ProgramService {
    Program findProgramById(Integer programId);

    PageInfo<Program> findProgramWithFilters(String keyWord, Integer city, Integer category, int pageSize, int currPage, String startTime, String endTime);

    int addProgram(Program program);
}
