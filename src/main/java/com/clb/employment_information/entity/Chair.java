package com.clb.employment_information.entity;

public class Chair {
    private String chairId;

    private String chairTime;

    private String chairSite;

    private Integer chairSum;

    private Integer nowSum;

    private String chairName;

    public String getChairId() {
        return chairId;
    }

    public void setChairId(String chairId) {
        this.chairId = chairId == null ? null : chairId.trim();
    }

    public String getChairTime() {
        return chairTime;
    }

    public void setChairTime(String chairTime) {
        this.chairTime = chairTime == null ? null : chairTime.trim();
    }

    public String getChairSite() {
        return chairSite;
    }

    public void setChairSite(String chairSite) {
        this.chairSite = chairSite == null ? null : chairSite.trim();
    }

    public Integer getChairSum() {
        return chairSum;
    }

    public void setChairSum(Integer chairSum) {
        this.chairSum = chairSum;
    }

    public Integer getNowSum() {
        return nowSum;
    }

    public void setNowSum(Integer nowSum) {
        this.nowSum = nowSum;
    }

    public String getChairName() {
        return chairName;
    }

    public void setChairName(String chairName) {
        this.chairName = chairName == null ? null : chairName.trim();
    }

    @Override
    public String toString() {
        return "Chair{" +
                "chairId='" + chairId + '\'' +
                ", chairTime='" + chairTime + '\'' +
                ", chairSite='" + chairSite + '\'' +
                ", chairSum=" + chairSum +
                ", nowSum=" + nowSum +
                ", chairName='" + chairName + '\'' +
                '}';
    }
}