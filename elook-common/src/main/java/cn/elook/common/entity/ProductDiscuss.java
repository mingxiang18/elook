package cn.elook.common.entity;

import java.util.Date;

public class ProductDiscuss {
    private Long pdid;

    private Long pid;

    private String pdDiscuss;

    private Date pdCreateTime;

    private Long uid;

    public Long getPdid() {
        return pdid;
    }

    public void setPdid(Long pdid) {
        this.pdid = pdid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPdDiscuss() {
        return pdDiscuss;
    }

    public void setPdDiscuss(String pdDiscuss) {
        this.pdDiscuss = pdDiscuss == null ? null : pdDiscuss.trim();
    }

    public Date getPdCreateTime() {
        return pdCreateTime;
    }

    public void setPdCreateTime(Date pdCreateTime) {
        this.pdCreateTime = pdCreateTime;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }
}