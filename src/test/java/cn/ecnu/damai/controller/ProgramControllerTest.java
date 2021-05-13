package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.entity.Show;
import cn.ecnu.damai.service.ShowService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramControllerTest {

    @Autowired
    private ProgramController programController;

    @Test
    public void testFindProgramById() {
        Program program = programController.findProgramById(1);
        System.out.println(JSON.toJSONString(program));
    }
}
