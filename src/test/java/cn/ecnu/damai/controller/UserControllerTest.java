package cn.ecnu.damai.controller;

import cn.ecnu.damai.controller.Response.ResultMap;
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
    public void testFindUserByUserId() {
        ResultMap result = userController.findUserByUserId(8);
        System.out.println(result);
    }

    @Test
    public void testAddAddress() {
        ResultMap result = userController.addAddress("钟小浩2", "1579083386", "上海普陀", 8);
        System.out.println(result);
    }

    @Test
    public void testDeleteAddress() {
        ResultMap result = userController.deleteAddress(4);
        System.out.println(result);
    }

    @Test
    public void testAddAttender() {
        ResultMap result = userController.addAttender("观影人1", "身份证", "360502199810030022", 8);
        System.out.println(result);
    }

    @Test
    public void testDeleteAttender() {
        ResultMap result = userController.deleteAttender(4);
        System.out.println(result);
    }

    @Test
    public void testConfirmOrder() {
        ResultMap result = userController.confirmOrder(
                8, "zhong", "15079086666",
                null,null, 1, 2);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testPayOrder() {
        ResultMap result = userController.payOrder(3);
        System.out.println(result);
    }

    @Test
    public void testGetOrderList() {
        ResultMap result = userController.getOrderList(8);
        System.out.println(result);
    }
}
