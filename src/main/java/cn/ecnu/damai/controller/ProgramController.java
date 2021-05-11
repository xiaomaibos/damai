package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.service.ProgramService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 14:51
 */
@Controller
@RequestMapping("/program")
public class ProgramController {
    @Resource
    private ProgramService programService;

    @RequestMapping("/getProgram")
    @ResponseBody
    public Program findProgramById(Integer programId) {
        return programService.findProgramById(programId);
    }
}
