package cn.ecnu.damai.service;

import cn.ecnu.damai.entity.User;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 10:43
 */
public interface UserService {
    /**
     * 登录方法
     *
     * @param username 用户输入的用户名
     * @param password 用户输入的密码
     * @return 返回结果为布尔类型 表示登录成功与否
     */
    boolean doLogin(String username, String password);

    User findUserByUsername(String username);

    int addUser(String username, String password);

    User findUserByUserId(Integer userId);

    int editUser(User user);
}
