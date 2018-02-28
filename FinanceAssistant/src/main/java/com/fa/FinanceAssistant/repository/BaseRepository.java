package com.fa.FinanceAssistant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Created by wenfeng on 2018/2/28.
 */
@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T,Integer>{
}
