package cn.ecnu.damai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author Kyrie Lee
 * @date 2021/5/10 23:39
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/doLogin")
    public Map<String, String> doLogin(String username, String password, HttpServletRequest request) {

        return null;
    }
}
