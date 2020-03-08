package com.clb.employment_information.service;


import com.clb.employment_information.entity.Chair;
import com.clb.employment_information.entity.ChairUser;

import java.util.List;

public interface ChairService {

    void insertChair(Chair chair);

    List<Chair> getAllChair();

    ChairUser selectChairUser(String chairId, String userId);

    void apply(String chairId, String userId);

    void updateChair(Chair chair);

    void deleteChair(String chairId);
}
