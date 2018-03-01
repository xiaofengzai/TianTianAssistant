package com.fa.FinanceAssistant.service;

import com.fa.FinanceAssistant.model.User;
import com.fa.FinanceAssistant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by wenfeng on 2018/2/28.
 */
@Service
@CacheConfig(cacheNames = "users")
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User  create(User param){
        return  userRepository.save(param);
    }
    public void   delete(String id){
        userRepository.delete(id);
    }

    @CachePut(key = "#p0.id")
    public User  update(User param){
        return  userRepository.save(param);
    }

    @Cacheable(key ="#p0")
    public User findById(String id){
        return userRepository.findOne(id);
    }
}
