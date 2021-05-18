package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.Address;
import cn.ecnu.damai.entity.Attender;
import cn.ecnu.damai.entity.User;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testDoLogin() {
        boolean isLogin = userService.doLogin("zzzz76", "123456ecnu");
        System.out.println(JSON.toJSONString(isLogin));
    }

    @Test
    public void testFindUserByUsername() {
        User user = userService.findUserByUsername("111111");
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    @Transactional
    public void testAddUser() {
        int result = userService.addUser("test1", "test1");
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testFindUserByUserId() {
        User user = userService.findUserByUserId(10);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    @Transactional
    public void testEditUser() {
        User user = userService.findUserByUserId(10);
        user.setNickname("测试账户");
        user.setPassword("111");
        user.setIdentity("360502200010050033");
        user.setBirthday(new Date());
        user.setGender(1);
        int result = userService.editUser(user);
        System.out.println(JSON.toJSONString(result));
    }

    @Test
    public void testAddAddress() {
        Address address = new Address();
        address.setName("钟小浩");
        address.setPhone("15079084000");
        address.setDetail("江西省");
        address.setUserId(10);
        System.out.println(JSON.toJSONString(userService.addAddress(address)));
    }

    @Test
    public void testDeleteAddress() {
        userService.deleteAddress(2);
    }

    @Test
    public void testAddAttender() {
        Attender attender = new Attender();
        attender.setName("虚伪鱼");
        attender.setIdentityType("身份证");
        attender.setIdentityNum("360502200210010033");
        attender.setUserId(10);
        System.out.println(JSON.toJSONString(userService.addAttender(attender)));
    }
    
    @Test
    public void testDeleteAttender() {
        userService.deleteAttender(2);
    }

}
