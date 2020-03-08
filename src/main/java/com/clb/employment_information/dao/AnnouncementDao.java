package com.clb.employment_information.dao;

import com.clb.employment_information.entity.Announcement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AnnouncementDao {
    void insertAnnouncement(Announcement announcement);

    List<Announcement> getAllAnnouncement();

    void updateAnnouncement(Announcement announcement);

    void deleteAnnouncement(String announcementId);
}
