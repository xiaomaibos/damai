package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.Program;
import cn.ecnu.damai.util.DamaiCrawler;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminControllerTest {

    @Autowired
    private AdminController adminController;

    @Test
    public void testCrawlProgramByCode() {
        Map<String, Object> resMap = adminController.crawlProgramByCode("644431227376");
        System.out.println(JSON.toJSONString(resMap));
    }
}
