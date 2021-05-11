package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.mapper.ProgramMapper;
import cn.ecnu.damai.service.ProgramService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
        return programMapper.findProgramById(programId);
    }
}
