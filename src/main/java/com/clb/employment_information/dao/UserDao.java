package com.clb.employment_information.dao;

import com.clb.employment_information.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public void insertUser(User user);

    User getUserByUserNameAndPassword(User user);

    void updateUser(User user);

    void updatePassword(User user);

    User getUserByUserMsg(User user);

    User getUserByUserName(String userName);

    List<User> getAllUser();

    void deleteUser(String userId);
}
