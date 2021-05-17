package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Program;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgramServiceTest {

    @Autowired
    private ProgramService programService;

    @Test
    public void testFindProgramById() {
        Program program = programService.findProgramById(1);
        System.out.println(JSON.toJSONString(program));
    }

    @Test
    public void testFindProgramWithFilters() {
        PageInfo<Program> pageInfo = programService.findProgramWithFilters(
                null, null, null, 10, 1, null, null, null);
        System.out.println(JSON.toJSONString(pageInfo));
    }

    @Test
    @Transactional
    public void testAddProgram() {
        Program program = new Program();
        program.setTitle("【杭州】星空恋爱解压馆（湖滨银泰in77旗舰店）");
        program.setLowPrice("29");
        program.setHighPrice("69");
        program.setStartTime(new Date());
        program.setEndTime(new Date());
        program.setAddress("湖滨银泰in77(D区负二楼)");
        program.setExplain("");
        program.setDetail("");
        program.setNotice("");
        program.setImage("");
        program.setCityId(3);
        program.setCategoryId(3);
        int result = programService.addProgram(program);
        System.out.println(JSON.toJSONString(result));
    }

}
