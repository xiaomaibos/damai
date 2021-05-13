package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.entity.Show;
import cn.ecnu.damai.service.ProgramService;
import cn.ecnu.damai.service.ShowService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:51
 */
@Controller
@RequestMapping("/program")
@CrossOrigin
public class ProgramController {
    @Resource
    private ProgramService programService;
    @Resource
    private ShowService showService;

    @RequestMapping("/getProgram")
    @ResponseBody
    public Program findProgramById(Integer programId) {
        Program program = programService.findProgramById(programId);
        Set<Show> shows = new HashSet<>(showService.getShowList(programId));
        program.setShows(shows);
        return program;
    }

    @RequestMapping("/findProgramWithFilters")
    @ResponseBody
    public PageInfo<Program> findProgramWithFilters(String keyword, Integer city, Integer category,
                                                    @RequestParam(defaultValue = "10") int pageSize,
                                                    @RequestParam(defaultValue = "1") int currPage,
                                                    String startTime, String endTime) {
        return programService.findProgramWithFilters(keyword, city, category, pageSize, currPage, startTime, endTime);
    }
}
