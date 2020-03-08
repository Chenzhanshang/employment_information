package com.clb.employment_information.dao;

import com.clb.employment_information.entity.Chair;
import com.clb.employment_information.entity.ChairUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ChairDao {
    void insertChair(Chair chair);

    List<Chair> getAllChair();

    ChairUser selectChairUser(String chairId, String userId);

    void insertChairUser(String chairId, String userId);

    void updateChairNowSum(String chairId);

    void updateChair(Chair chair);

    void deleteChair(String chairId);

    void deleteChairUser(String chairId);

    void deleteChairUserByUserId(String userId);
}
