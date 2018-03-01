package com.fa.FinanceAssistant.repository;

import com.fa.FinanceAssistant.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wenfeng on 2018/2/28.
 */
public interface UserRepository extends JpaRepository<User,String> {
}
