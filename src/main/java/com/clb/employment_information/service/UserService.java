package com.clb.employment_information.service;

import com.clb.employment_information.entity.User;

import java.util.List;

public interface UserService {
    public void insertUser(User user);

    User getUserByUserNameAndPassword(User user);

    void update(User user);

    void updatePassword(User user);

    User getUserByUserMsg(User user);

    User getUserByUserName(String userName);

    List<User> getAllUser();

    void deleteUser(String userId);
}
