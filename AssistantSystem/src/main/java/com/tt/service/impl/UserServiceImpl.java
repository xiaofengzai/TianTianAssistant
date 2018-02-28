package com.tt.service.impl;

import com.tt.pojo.model.User;
import com.tt.repository.UserRepository;
import com.tt.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * IUserService接口实现类
 * @author Leeyom Wang
 * @date 2017年10月26日 15:15
 */
@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    UserRepository userRepository;

    /**
     * 根据用户名和密码获取用户信息
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User getUser(String userName, String password) {
        return userRepository.findByUserNameAndPassword(userName,password);
    }
}
