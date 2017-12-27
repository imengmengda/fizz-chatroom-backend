package com.follower.fizz.dao.impl;

import com.follower.fizz.entity.LoginAdapterUser;
import com.follower.fizz.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lin on 17-12-21.
 */

@Repository
public class LoginAdapterUserDao {

    /*
    @Autowired
    private LoginAdapterUser loginAdapterUser;
    */

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    public User findUserByNickname(String nickname) {
        String findByNicknameSql = "from User where nickname = ?";
        List<User> users = (List)hibernateTemplate.find(findByNicknameSql, nickname);
        if (users.size() > 0) {
            return users.get(0);
        }
        return null;
    }
}
