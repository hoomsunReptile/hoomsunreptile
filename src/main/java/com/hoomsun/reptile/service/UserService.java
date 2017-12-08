package com.hoomsun.reptile.service;

import com.hoomsun.reptile.dao.UserDao;
import com.hoomsun.reptile.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bigyoung on 2017/12/1
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public String show() {
        return "Hello World!";
    }

    public List<User> showDao(int age) {
        return userDao.get(age);
    }

    public String insert(String name, int age) {
        User user = new User();
        userDao.insert(user);
        return "Insert ( \""+name+"\", age"+age+") OK!";
    }


}
