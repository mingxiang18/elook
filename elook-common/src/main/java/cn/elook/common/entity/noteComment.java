package cn.elook.common.entity;

import java.util.Date;

public class noteComment {
    Integer ncid;
    Integer nid;
    String  ncContent;
    Date   ncCreatTime;
    User user;

    @Override
    public String toString() {
        return "noteComment{" +
                "ncid=" + ncid +
                ", nid=" + nid +
                ", ncContent='" + ncContent + '\'' +
                ", ncCreatTime=" + ncCreatTime +
                ", user=" + user +
                '}';
    }

    public Integer getNcid() {
        return ncid;
    }

    public void setNcid(Integer ncid) {
        this.ncid = ncid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNcContent() {
        return ncContent;
    }

    public void setNcContent(String ncContent) {
        this.ncContent = ncContent;
    }

    public Date getNcCreatTime() {
        return ncCreatTime;
    }

    public void setNcCreatTime(Date ncCreatTime) {
        this.ncCreatTime = ncCreatTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public noteComment() {

    }

    public noteComment(Integer ncid, Integer nid, String ncContent, Date ncCreatTime, User user) {

        this.ncid = ncid;
        this.nid = nid;
        this.ncContent = ncContent;
        this.ncCreatTime = ncCreatTime;
        this.user = user;
    }
}
