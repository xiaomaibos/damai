package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.entity.User;
import cn.ecnu.damai.mapper.UserMapper;
import cn.ecnu.damai.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 10:44
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public boolean doLogin(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        Integer n = userMapper.findUserByUsernameAndPassword(user);

        return n != null;
    }

    @Override
    public User findUserByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }

    @Override
    public int addUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        return userMapper.addUser(user);
    }
}
