package com.jun.wen.service;

import com.jun.wen.dao.UserDao;
import com.jun.wen.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public boolean login(String userName, String password){
        User user = userDao.findByUserNameAndPassword(userName, password);
        if(user == null){
            return false;
        } else {
            return true;
        }
    }
}
