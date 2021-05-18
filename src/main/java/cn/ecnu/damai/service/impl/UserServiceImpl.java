package cn.ecnu.damai.service.impl;

import cn.ecnu.damai.dao.repository.AddressRepository;
import cn.ecnu.damai.dao.repository.AttenderRepository;
import cn.ecnu.damai.entity.Address;
import cn.ecnu.damai.entity.Attender;
import cn.ecnu.damai.entity.User;
import cn.ecnu.damai.dao.mapper.UserMapper;
import cn.ecnu.damai.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;

/**
 * @author Kyrie Lee
 * @date 2021/5/11 10:44
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private AddressRepository addressRepository;
    @Resource
    private AttenderRepository attenderRepository;

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

    @Override
    public User findUserByUserId(Integer userId) {
        User user = userMapper.findUserByUserId(userId);
        user.setAddresses(new HashSet<>(addressRepository.findByUserId(userId)));
        user.setAttenders(new HashSet<>(attenderRepository.findByUserId(userId)));
        return user;
    }

    @Override
    public int editUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Address addAddress(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(Integer addressId) {
        addressRepository.deleteById(addressId);
    }

    @Override
    public Attender addAttender(Attender attender) {
        return attenderRepository.save(attender);
    }

    @Override
    public void deleteAttender(Integer attenderId) {
        attenderRepository.deleteById(attenderId);
    }

}
