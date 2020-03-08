package com.clb.employment_information.service.impl;

import com.clb.employment_information.dao.ChairDao;
import com.clb.employment_information.dao.JobDao;
import com.clb.employment_information.dao.UserDao;
import com.clb.employment_information.entity.User;
import com.clb.employment_information.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JobDao jobDao;
    @Autowired
    private ChairDao chairDao;

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public User getUserByUserNameAndPassword(User user) {

        return userDao.getUserByUserNameAndPassword(user);
    }

    @Override
    public void update(User user) {

        userDao.updateUser(user);
    }

    @Override
    public void updatePassword(User user) {
        userDao.updatePassword(user);
    }

    @Override
    public User getUserByUserMsg(User user) {
        return userDao.getUserByUserMsg(user);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao.getUserByUserName(userName);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUser();
    }

    @Override
    public void deleteUser(String userId) {
        jobDao.deleteJobUserByUserId(userId);
        chairDao.deleteChairUserByUserId(userId);
        userDao.deleteUser(userId);
    }
}
