package cn.ecnu.damai.controller;

import cn.ecnu.damai.controller.Response.ResultResponse;
import cn.ecnu.damai.entity.*;
import cn.ecnu.damai.service.LevelService;
import cn.ecnu.damai.service.TicketService;
import cn.ecnu.damai.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Kyrie Lee
 * @date 2021/5/10 23:39
 */
@Controller
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private LevelService levelService;
    @Resource
    private TicketService ticketService;

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
        messageMap.put("user", userService.findUserByUsername(username));
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

    @RequestMapping("/editUser")
    @ResponseBody
    public Map<String, Object> editUser(String image_url, String birthday,
                                        String nickname, String password, String identity,
                                        Integer gender, Integer uid) throws ParseException {
        Map<String, Object> messageMap = new HashMap<>(8);
        User user = new User();
        user.setUid(uid);
        user.setPassword(password);
        user.setNickname(nickname);
        user.setGender(gender);
        user.setIdentity(identity);
        user.setHeadImg(image_url);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        if (birthday != null && !"".equals(birthday)) {
            user.setBirthday(format.parse(birthday));
        }
        int num = userService.editUser(user);
        if (num == 1) {
            messageMap.put("success", true);
            messageMap.put("message", "修改成功");
            messageMap.put("user", user);
            return messageMap;
        }
        messageMap.put("success", false);
        messageMap.put("message", "修改失败!");
        return messageMap;
    }

    @RequestMapping("/addAddress")
    @ResponseBody
    public ResultResponse addAddress(String name, String phone, String detail, Integer userId) {
        Address address = new Address();
        address.setName(name);
        address.setPhone(phone);
        address.setDetail(detail);
        address.setUserId(userId);
        try {
            userService.addAddress(address);
            return ResultResponse.SUCCESS().setData(address);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.FAIL();
        }

    }

    @RequestMapping("/deleteAddress")
    @ResponseBody
    public ResultResponse deleteAddress(Integer addressId) {
        try {
            userService.deleteAddress(addressId);
            return ResultResponse.SUCCESS().setMessage("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.FAIL();
        }
    }

    @RequestMapping("/addAttender")
    @ResponseBody
    public ResultResponse addAttender(String name, String identityType, String identityNum, Integer userId) {
        Attender attender = new Attender();
        attender.setName(name);
        attender.setIdentityType(identityType);
        attender.setIdentityNum(identityNum);
        attender.setUserId(userId);

        try {
            userService.addAttender(attender);
            return ResultResponse.SUCCESS().setData(attender);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.FAIL();
        }

    }

    @RequestMapping("/deleteAttender")
    @ResponseBody
    public ResultResponse deleteAttender(Integer attenderId) {
        try {
            userService.deleteAttender(attenderId);
            return ResultResponse.SUCCESS().setMessage("删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.FAIL();
        }
    }

    @RequestMapping("/confirmTicket")
    @ResponseBody
    public ResultResponse confirmTicket(Integer levelId, Integer count) {
        try {
            Level level = levelService.getLevel(levelId);
            List<Ticket> tickets = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                Ticket ticket= new Ticket();
                ticket.setPrice(level.getPrice());
                ticket.setValid(0);
                ticket.setLevelId(levelId);
                tickets.add(ticketService.addTicket(ticket));
            }
            level.setTickets(new HashSet<>(tickets));
            return ResultResponse.SUCCESS().setData(level);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultResponse.FAIL();
        }
    }
}
