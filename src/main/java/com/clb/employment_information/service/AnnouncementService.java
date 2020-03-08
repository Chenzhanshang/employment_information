package com.clb.employment_information.service;

import com.clb.employment_information.entity.Announcement;

import java.util.List;

public interface AnnouncementService {

    void insertAnnouncement(Announcement announcement);

    List<Announcement> getAllAnnouncement();

    void updateAnnouncement(Announcement announcement);

    void deleteAnnouncement(String announcementId);
}
