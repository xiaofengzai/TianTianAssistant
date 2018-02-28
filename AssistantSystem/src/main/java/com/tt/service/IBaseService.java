package com.tt.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用的Service
 * @author leeyom
 */
@Service
public interface IBaseService<T> {

    void deleteByPrimaryKey(Integer id);

    T save(T record);

    T selectByPrimaryKey(Integer id);

    List<T> selectAll();
}
