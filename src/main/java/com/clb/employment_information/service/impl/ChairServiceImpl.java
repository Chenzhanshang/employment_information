package com.clb.employment_information.service.impl;

import com.clb.employment_information.dao.ChairDao;
import com.clb.employment_information.entity.Chair;
import com.clb.employment_information.entity.ChairUser;
import com.clb.employment_information.service.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChairServiceImpl implements ChairService {
    @Autowired
    private ChairDao chairDao;
    @Override
    public void insertChair(Chair chair) {
        chairDao.insertChair(chair);
    }

    @Override
    public List<Chair> getAllChair() {
        return chairDao.getAllChair();
    }

    @Override
    public ChairUser selectChairUser(String chairId, String userId) {
        return chairDao.selectChairUser( chairId,  userId) ;
    }

    @Override
    public void apply(String chairId, String userId) {
        chairDao.insertChairUser( chairId,  userId);
        chairDao.updateChairNowSum(chairId);
    }

    @Override
    public void updateChair(Chair chair) {
        chairDao.updateChair(chair);
    }

    @Override
    public void deleteChair(String chairId) {

        chairDao.deleteChairUser(chairId);
        chairDao.deleteChair(chairId);
    }
}
