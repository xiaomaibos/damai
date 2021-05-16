package cn.ecnu.damai.dao.mapper;

import cn.ecnu.damai.entity.User;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 10:51
 */
public interface UserMapper {
    /**
     * 登录时 根据用户名账号和密码 查询用户
     *
     * @param user 用户的账户名和密码信息
     * @return 查询结果用户的id 如果没有查询到则返回null
     */
    Integer findUserByUsernameAndPassword(User user);

    User findUserByUsername(String username);

    int addUser(User user);

    User findUserByUserId(Integer userId);

    int updateUser(User user);
}
