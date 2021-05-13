package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.entity.ProgramFilter;
import cn.ecnu.damai.mapper.ProgramMapper;
import cn.ecnu.damai.service.ProgramService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:52
 */
@Service("programService")
public class ProgramServiceImpl implements ProgramService {

    @Resource
    private ProgramMapper programMapper;

    @Override
    public Program findProgramById(Integer programId) {
        Program program = programMapper.findProgramById(programId);
        if (program != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            program.setShowStartTime(format.format(program.getStartTime()));
            program.setShowEndTime(format.format(program.getEndTime()));
        }
        return program;
    }

    @Override
    public PageInfo<Program> findProgramWithFilters(String keyWord, Integer city, Integer category, int pageSize, int currPage, String startTime, String endTime) {
        PageHelper.startPage(currPage, pageSize);
        ProgramFilter programFilter = new ProgramFilter();
        programFilter.setKeyWord(keyWord);
        programFilter.setCity(city);
        programFilter.setCategory(category);
        programFilter.setStartTime(startTime);
        programFilter.setEndTime(endTime);
        List<Program> programs = programMapper.findProgramWithFilters(programFilter);
        for (Program program : programs) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            program.setShowStartTime(format.format(program.getStartTime()));
            program.setShowEndTime(format.format(program.getEndTime()));
        }
        return new PageInfo<>(programs);
    }

    @Override
    public int addProgram(Program program) {
        return programMapper.addProgram(program);
    }
}
