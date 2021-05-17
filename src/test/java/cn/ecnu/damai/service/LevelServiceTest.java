package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Level;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LevelServiceTest {

    @Autowired
    private LevelService levelService;

    @Test
    @Transactional
    public void testAddLevel() {
        Level level = new Level();
        level.setName("套票69.9元（艺术馆+解压馆）");
        level.setPrice("69");
        level.setTotalCount(80);
        level.setLeftCount(80);
        level.setLimitCount(6);
        level.setShowId(1);
        int reusult = levelService.addLevel(level);
        System.out.println(JSON.toJSONString(reusult));
    }

    @Test
    public void testGetLevelList() {
        List<Level> levels = levelService.getLevelList(1);
        System.out.println(JSON.toJSONString(levels));
    }
}
