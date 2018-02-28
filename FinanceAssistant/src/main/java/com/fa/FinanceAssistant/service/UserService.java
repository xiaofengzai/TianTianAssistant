package com.fa.FinanceAssistant.service;

import com.fa.FinanceAssistant.model.User;
import com.fa.FinanceAssistant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wenfeng on 2018/2/28.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User  create(User param){
        return  userRepository.save(param);
    }
    public void   delete(Integer id){
        userRepository.delete(id);
    }
}
