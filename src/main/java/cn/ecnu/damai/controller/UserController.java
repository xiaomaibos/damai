package cn.ecnu.damai.controller;

import cn.ecnu.damai.entity.User;
import cn.ecnu.damai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Kyrie Lee
 * @date 2021/5/10 23:39
 */
@Controller
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Resource
    private UserService userService;


    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Map<String, Object> doLogin(String username, String password, HttpServletRequest request) {
        Map<String, Object> messageMap = new HashMap<>(8);
        if (username == null || password == null) {
            messageMap.put("message", "用户名或者密码不能为空");
            messageMap.put("code", 201);
            messageMap.put("success", false);
            return messageMap;
        }

        boolean loginSuccess = userService.doLogin(username, password);

        if (!loginSuccess) {
            messageMap.put("message", "用户名或者密码错误!");
            messageMap.put("code", 204);
            messageMap.put("success", false);
            return messageMap;
        }

        // 保存用户名信息，用于用户追踪
        request.getSession().setAttribute("username", username);
        messageMap.put("message", "登录成功!");
        messageMap.put("code", 0);
        messageMap.put("success", true);
        return messageMap;
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public Map<String, Object> doRegister(String username, String password) {
        Map<String, Object> messageMap = new HashMap<>(8);
        if (username == null || password == null) {
            messageMap.put("message", "用户名或者密码不能为空");
            messageMap.put("code", 201);
            messageMap.put("success", false);
            return messageMap;
        }
        User user = userService.findUserByUsername(username);

        if (user != null) {
            messageMap.put("message", "用户名已经存在!");
            messageMap.put("code", 211);
            messageMap.put("success", false);
            return messageMap;
        }

        int num = userService.addUser(username, password);

        if (num == 0) {
            messageMap.put("message", "系统异常，请重试!");
            messageMap.put("code", 999);
            messageMap.put("success", false);
        } else {
            messageMap.put("message", "注册成功!");
            messageMap.put("code", 0);
            messageMap.put("success", true);
        }
        return messageMap;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User findUserByUserId(Integer userId) {
        return userService.findUserByUserId(userId);
    }
}
