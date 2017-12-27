package com.follower.fizz.dao;

/**
 * Created by lin on 17-12-18.
 */

public interface IBaseDao<T> {

    T findById();

    void insert(T entity);

}
