package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Attender;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AttenderServiceTest {

    @Autowired
    private AttenderService attenderService;

    @Test
    public void testAddAttender() {
        Attender attender = new Attender();
        attender.setName("虚伪鱼");
        attender.setIdentityType("身份证");
        attender.setIdentityNum("360502200210010033");
        attender.setUserId(10);
        System.out.println(JSON.toJSONString(attenderService.addAttender(attender)));
    }

    @Test
    public void testDeleteAttender() {
        attenderService.deleteAttender(2);
    }
}
