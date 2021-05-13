package cn.ecnu.damai;

import cn.ecnu.damai.util.DamaiCrawler;
import cn.ecnu.damai.entity.Program;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DamaiCrawlerTest {

    private DamaiCrawler damaiCrawler = new DamaiCrawler();

    @Test
    public void crawl() {
        Program program = new Program();
        String errStatus = damaiCrawler.synCrawl("644431227376", program);
        if (errStatus == null) {
            System.out.println(JSON.toJSONString(program));
        } else {
            System.out.println(errStatus);
        }
    }
}
