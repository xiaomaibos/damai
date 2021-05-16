package cn.ecnu.damai.dao.repository;

import cn.ecnu.damai.entity.City;
import cn.ecnu.damai.entity.Program;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramRepositoryTest {

    @Resource
    private ProgramRepository programRepository;

    @Test
    public void testFindAll() {
        List<Program> programs = programRepository.findAll();
        System.out.println(JSON.toJSONString(programs));
    }

    @Test
    public void testFindById() {
        Optional<Program> program = programRepository.findById(1);
        System.out.println(JSON.toJSONString(program));
    }

}
