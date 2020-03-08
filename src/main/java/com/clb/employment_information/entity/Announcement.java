package com.clb.employment_information.entity;

public class Announcement {
    private String announcementId;

    private User user;

    private String announcementContent;

    private String announcementTitle;

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId == null ? null : announcementId.trim();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAnnouncementTitle() {
        return announcementTitle;
    }

    public void setAnnouncementTitle(String announcementTitle) {
        this.announcementTitle = announcementTitle;
    }

    public String getAnnouncementContent() {
        return announcementContent;
    }

    public void setAnnouncementContent(String announcementContent) {
        this.announcementContent = announcementContent == null ? null : announcementContent.trim();
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId='" + announcementId + '\'' +
                ", user=" + user +
                ", announcementContent='" + announcementContent + '\'' +
                ", announcementTitle='" + announcementTitle + '\'' +
                '}';
    }
}