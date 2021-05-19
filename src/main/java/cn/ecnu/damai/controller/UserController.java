package cn.ecnu.damai.controller;

import cn.ecnu.damai.controller.Response.ResultMap;
import cn.ecnu.damai.controller.Response.ResultType;
import cn.ecnu.damai.entity.*;
import cn.ecnu.damai.service.*;
import cn.ecnu.damai.util.RandomString;
import cn.ecnu.damai.util.SplitString;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
    @Resource
    private OrderService orderService;
    @Resource
    private AttenderService attenderService;
    @Resource
    private AddressService addressService;

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

    @RequestMapping("/getUser")
    @ResponseBody
    public ResultMap findUserByUserId(Integer userId) {
        try {
            User user = userService.findUserByUserId(userId);
            if (user == null) {
                return new ResultMap(ResultType.INVALID_PARAM);
            }
            return new ResultMap(ResultType.SUCCESS, user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMap(ResultType.SEVER_ERROR);
        }
    }

    @RequestMapping("/addAddress")
    @ResponseBody
    public ResultMap addAddress(String name, String phone, String detail, Integer userId) {
        Address address = new Address();
        address.setName(name);
        address.setPhone(phone);
        address.setDetail(detail);
        address.setUserId(userId);
        try {
            addressService.addAddress(address);
            return new ResultMap(ResultType.SUCCESS, address);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMap(ResultType.SEVER_ERROR);
        }

    }

    @RequestMapping("/deleteAddress")
    @ResponseBody
    public ResultMap deleteAddress(Integer addressId) {
        try {
            if (addressService.deleteAddress(addressId)) {
                return new ResultMap(ResultType.SUCCESS);
            } else {
                return new ResultMap(ResultType.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMap(ResultType.SEVER_ERROR);
        }
    }

    @RequestMapping("/addAttender")
    @ResponseBody
    public ResultMap addAttender(String name, String identityType, String identityNum, Integer userId) {
        Attender attender = new Attender();
        attender.setName(name);
        attender.setIdentityType(identityType);
        attender.setIdentityNum(identityNum);
        attender.setUserId(userId);

        try {
            attenderService.addAttender(attender);
            return new ResultMap(ResultType.SUCCESS, attender);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMap(ResultType.SEVER_ERROR);
        }

    }

    @RequestMapping("/deleteAttender")
    @ResponseBody
    public ResultMap deleteAttender(Integer attenderId) {
        try {
            if (attenderService.deleteAttender(attenderId)) {
                return new ResultMap(ResultType.SUCCESS);
            } else {
                return new ResultMap(ResultType.FAIL);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMap(ResultType.SEVER_ERROR);
        }
    }

    @RequestMapping("/confirmOrder")
    @ResponseBody
    public ResultMap confirmOrder(Integer userId, String linkman, String linknum,
                                  Integer addressId, String attenderIds, Integer levelId, Integer count) {
        // 生成订单 此处可用队列单程处理
        try {
            // 票档
            Level level = levelService.getLevel(levelId);
            if (level == null) {
                return new ResultMap(ResultType.INVALID_PARAM);
            }
            int leftCount = level.getLeftCount() - count;
            if (leftCount >= 0) {
                level.setLeftCount(leftCount);
                levelService.updateLevel(level);
            } else {
                return new ResultMap(ResultType.FAIL);
            }
            // 订单
            int price = Integer.parseInt(level.getPrice()) * count;
            String code = RandomString.getRandomString(18);
            Order order = new Order();
            order.setCode(code);
            order.setCreateTime(new Date());
            order.setStatus(0);
            order.setStatusInfo("待付款");
            order.setTotalCount(count);
            order.setTotalPrice(Integer.toString(price));
            order.setLinkman(linkman);
            order.setLinkNum(linknum);
            order.setUserId(userId);
            order.setShowId(level.getShowId());
            // 收货地址
            if (addressId != null) {
                Address address = addressService.getAddress(addressId);
                if (address == null) {
                    return new ResultMap(ResultType.INVALID_PARAM);
                }
                order.setAddress(JSON.toJSONString(address));
            }

            // 观影人
            if (attenderIds != null) {
                List<String> attenderIdList = SplitString.splitString(attenderIds, ",");
                List<Attender> attenderList = new ArrayList<>();
                for (String attenderId : attenderIdList) {
                    Attender attender = attenderService.getAttender(Integer.parseInt(attenderId));
                    if (attender == null) {
                        return new ResultMap(ResultType.INVALID_PARAM);
                    }
                    attenderList.add(attender);
                }

                order.setAttender(JSON.toJSONString(attenderList));
            }
            orderService.addOrder(order);

            // 生成门票
            for (int i = 0; i < count; i++) {
                Ticket ticket = new Ticket();
                ticket.setPrice(level.getPrice());
                ticket.setValid(1);
                ticket.setOrderId(order.getOrderId());
                ticket.setLevelId(levelId);
                ticketService.addTicket(ticket);
            }
            return new ResultMap(ResultType.SUCCESS, order);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMap(ResultType.SEVER_ERROR);
        }
    }

    @RequestMapping("/payOrder")
    @ResponseBody
    public ResultMap payOrder(Integer orderId) {
        try {
            Order order = orderService.getOrder(orderId);
            if (order == null || order.getStatus() != 0) {
                return new ResultMap(ResultType.INVALID_PARAM);
            }
            order.setStatus(1);
            order.setStatusInfo("交易成功");
            orderService.addOrder(order);
            return new ResultMap(ResultType.SUCCESS, order);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMap(ResultType.SEVER_ERROR);
        }
    }

    @RequestMapping("/getOrderList")
    @ResponseBody
    public ResultMap getOrderList(Integer userId) {
        try {
            List<Order> orders = orderService.getOrderList(userId);
            return new ResultMap(ResultType.SUCCESS, orders);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResultMap(ResultType.SEVER_ERROR);
        }
    }


    /**
     * input 用户ID
     * 输出 Map    分类名称 - 票数  键值对
     * 元素代表用户在该分类下购买过得票数
     */
    @RequestMapping("/getTicketCount")
    @ResponseBody
    public Map<String, Integer> getTicketCountByUserId(Integer userId) {
        return userService.getTicketCountByUserId(userId);
    }

    /**
     * input 用户ID
     * 元素代表用户在该分类下消费的金额统计
     *
     * @return 输出 Map    分类名称 - 价格  键值对
     */
    @RequestMapping("/getAmountOfCategory")
    @ResponseBody
    public Map<String, String> getAmountOfCategoryByUserId(Integer userId) {
        return userService.getAmountOfCategoryByUserId(userId);
    }
}
