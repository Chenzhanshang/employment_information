package com.clb.employment_information.entity;


public class ChairUser {
    private String chairId;

    private String userId;

    public String getChairId() {
        return chairId;
    }

    @Override
    public String toString() {
        return "ChairUser{" +
                "chairId='" + chairId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public void setChairId(String chairId) {
        this.chairId = chairId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
