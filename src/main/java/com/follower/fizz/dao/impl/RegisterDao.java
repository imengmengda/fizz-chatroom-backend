package com.follower.fizz.dao.impl;

import com.follower.fizz.entity.User;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by lin on 17-12-25.
 */

@Repository
public class RegisterDao {

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void registerUser(String nickname, String password) {
        hibernateTemplate.save(new User(nickname, password));
    }
}
