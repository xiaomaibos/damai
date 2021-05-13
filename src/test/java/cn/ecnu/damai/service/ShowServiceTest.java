package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Show;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowServiceTest {

    @Autowired
    private ShowService showService;

    @Test
    public void testGetShowList() {
        List<Show> shows = showService.getShowList(1);
        System.out.println(JSON.toJSONString(shows));
    }

    @Test
    public void testFindShowById() {
        Show show = showService.findShowById(1);
        System.out.println(JSON.toJSONString(show));
    }
}
