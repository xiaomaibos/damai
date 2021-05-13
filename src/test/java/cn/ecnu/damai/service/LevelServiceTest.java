package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Level;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LevelServiceTest {

    @Autowired
    private LevelService levelService;

    @Test
    public void testGetLevelList() {
        List<Level> levels = levelService.getLevelList(1);
        System.out.println(JSON.toJSONString(levels));
    }
}
