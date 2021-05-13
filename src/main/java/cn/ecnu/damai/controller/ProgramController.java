package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.service.ProgramService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

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

    @RequestMapping("/getProgram")
    @ResponseBody
    public Program findProgramById(Integer programId) {
        return programService.findProgramById(programId);
    }

    @RequestMapping("/findProgramWithFilters")
    @ResponseBody
    public PageInfo<Program> findProgramWithFilters(String keyWord, Integer city, Integer category,
                                                    @RequestParam(defaultValue = "10") int pageSize,
                                                    @RequestParam(defaultValue = "1") int currPage,
                                                    String startTime, String endTime) {
        return programService.findProgramWithFilters(keyWord, city, category, pageSize, currPage, startTime, endTime);
    }
}
