package cn.ecnu.damai.controller;

import cn.ecnu.damai.controller.Response.ResultResponse;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

    @Autowired
    private UserController userController;

    @Test
    public void testAddAddress() {
        ResultResponse result = userController.addAddress("钟小浩2", "1579083386", "上海普陀", 10);
        System.out.println(result);
    }

    @Test
    public void testDeleteAddress() {
        ResultResponse result = userController.deleteAddress(4);
        System.out.println(result);
    }

    @Test
    public void testAddAttender() {
        ResultResponse result = userController.addAttender("观影人1", "身份证", "360502199810030022", 10);
        System.out.println(result);
    }

    @Test
    public void testDeleteAttender() {
        ResultResponse result = userController.deleteAttender(4);
        System.out.println(result);
    }

    @Test
    public void testConfirmTicket() {
        ResultResponse result = userController.confirmTicket(1, 6);
        System.out.println(JSON.toJSONString(result));
    }
}
