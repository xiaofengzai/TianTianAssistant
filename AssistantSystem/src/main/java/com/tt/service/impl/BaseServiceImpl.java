package com.tt.service.impl;

import com.tt.repository.BaseRepository;
import com.tt.service.IBaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 通用的BaseService实现类
 * @author wennfeng
 * @date 2017年10月26日 12:04
 */
public abstract class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public BaseRepository<T> getRepository() {
        return repository;
    }

    public void deleteByPrimaryKey(Integer id) {
         repository.delete(id);
    }

    public T save(T record) {
        return repository.save(record);
    }

    public T selectByPrimaryKey(Integer id) {
        return repository.findOne(id);
    }

    public List<T> selectAll() {
        return repository.findAll();
    }

}
