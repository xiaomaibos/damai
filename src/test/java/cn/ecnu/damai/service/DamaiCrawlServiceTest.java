package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Program;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DamaiCrawlServiceTest {

    @Autowired
    private DamaiCrawlService damaiCrawlService;

    @Test
    public void crawl() {
        Program program = new Program();
        String errStatus = damaiCrawlService.crawlProblemByCode("644431227376", program);
        if (errStatus == null) {
            System.out.println(JSON.toJSONString(program));
        } else {
            System.out.println(errStatus);
        }
    }
}
