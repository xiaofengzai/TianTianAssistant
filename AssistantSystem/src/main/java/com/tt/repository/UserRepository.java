package com.tt.repository;

import com.tt.pojo.model.User;

public interface UserRepository extends BaseRepository<User> {
    User findByUserNameAndPassword(String username,String password);
}
