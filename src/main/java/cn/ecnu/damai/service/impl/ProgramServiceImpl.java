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
    public PageInfo<Program> findProgramWithFilters(String keyWord, Integer city, Integer category, int pageSize, int currPage, String startTime, String endTime, Integer order) {
        PageHelper.startPage(currPage, pageSize);
        ProgramFilter programFilter = new ProgramFilter();
        programFilter.setKeyWord(keyWord);
        programFilter.setCity(city);
        programFilter.setCategory(category);
        programFilter.setStartTime(startTime);
        programFilter.setEndTime(endTime);
        programFilter.setOrder(order);
        List<Program> programs = programMapper.findProgramWithFilters(programFilter);
        for (Program program : programs) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            program.setShowStartTime(format.format(program.getStartTime()));
            program.setShowEndTime(format.format(program.getEndTime()));
        }
        programs.sort((p1, p2) -> {
            if (order == null || order == 1) {
                return p1.getTitle().compareTo(p2.getTitle());
            } else if (order == 2) {
                return p1.getShows().size() - p2.getShows().size();
            } else if (order == 3) {
                return p1.getStartTime().compareTo(p2.getStartTime());
            } else {
                double v = Double.parseDouble(p1.getLowPrice()) - Double.parseDouble(p2.getLowPrice());
                if (v > 0) {
                    return 1;
                } else if (v < 0) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
        return new PageInfo<>(programs);
    }

    @Override
    public int addProgram(Program program) {
        return programMapper.addProgram(program);
    }
}
