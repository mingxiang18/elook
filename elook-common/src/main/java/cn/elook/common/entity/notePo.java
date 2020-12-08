package cn.elook.common.entity;

import java.util.Date;
import java.util.List;

public class notePo {
    Integer nid;
    Integer uid;
    String note_title;
    String note_content;
    Date creatTime;
    List<String> photoUrl;
    List<String> productList;

    @Override
    public String toString() {
        return "notePo{" +
                "nid=" + nid +
                ", uid=" + uid +
                ", note_title='" + note_title + '\'' +
                ", note_content='" + note_content + '\'' +
                ", creatTime=" + creatTime +
                ", photoUrl=" + photoUrl +
                ", productList=" + productList +
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

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public List<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(List<String> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<String> getProductList() {
        return productList;
    }

    public void setProductList(List<String> productList) {
        this.productList = productList;
    }

    public notePo() {

    }

    public notePo(Integer nid, Integer uid, String note_title, String note_content, Date creatTime, List<String> photoUrl, List<String> productList) {
        this.nid = nid;
        this.uid = uid;
        this.note_title = note_title;
        this.note_content = note_content;
        this.creatTime = creatTime;
        this.photoUrl = photoUrl;
        this.productList = productList;
    }
}
