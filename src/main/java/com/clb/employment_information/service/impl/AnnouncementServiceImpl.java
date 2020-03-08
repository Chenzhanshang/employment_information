package com.clb.employment_information.service.impl;


import com.clb.employment_information.dao.AnnouncementDao;
import com.clb.employment_information.entity.Announcement;
import com.clb.employment_information.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService {
    @Autowired
    private AnnouncementDao announcementDao;

    @Override
    public void insertAnnouncement(Announcement announcement) {
        announcementDao.insertAnnouncement(announcement);
    }

    @Override
    public List<Announcement> getAllAnnouncement() {
        return announcementDao.getAllAnnouncement();
    }

    @Override
    public void updateAnnouncement(Announcement announcement) {
        announcementDao.updateAnnouncement(announcement);
    }

    @Override
    public void deleteAnnouncement(String announcementId) {
        announcementDao.deleteAnnouncement(announcementId);
    }
}
