package cn.elook.common.entity;

import java.util.Date;

public class commentPo {
    Integer nid;
    Integer uid;
    String  ncContent;
    Date    creatTime;

    public commentPo() {
    }

    @Override
    public String toString() {
        return "commentPo{" +
                "nid=" + nid +
                ", uid=" + uid +
                ", ncContent='" + ncContent + '\'' +
                ", creatTime=" + creatTime +
                '}';
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNcContent() {
        return ncContent;
    }

    public void setNcContent(String ncContent) {
        this.ncContent = ncContent;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public commentPo(Integer nid, Integer uid, String ncContent, Date creatTime) {

        this.nid = nid;
        this.uid = uid;
        this.ncContent = ncContent;
        this.creatTime = creatTime;
    }
}
