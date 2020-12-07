package cn.elook.common.entity;

import java.util.Date;
import java.util.List;

public class note {
    Integer nid;
    String title;
    String content;
    Date creatTime;

//外健用户
    User user;

//    照片的集合
List<notePhoto> notePhotoList;
//评论的集合

    List<noteComment> noteCommentList;
    List<noteProduct> noteProductList;

    public note() {
    }

    @Override
    public String toString() {
        return "note{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", creatTime=" + creatTime +
                ", user=" + user +
                ", notePhotoListo=" + notePhotoList +
                ", noteCommentList=" + noteCommentList +
                ", noteProductList=" + noteProductList +
                '}';
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<notePhoto> getNotePhotoList() {
        return notePhotoList;
    }

    public void setNotePhotoListo(List<notePhoto> notePhotoList) {
        this.notePhotoList = notePhotoList;
    }

    public List<noteComment> getNoteCommentList() {
        return noteCommentList;
    }

    public void setNoteCommentList(List<noteComment> noteCommentList) {
        this.noteCommentList = noteCommentList;
    }

    public List<noteProduct> getNoteProductList() {
        return noteProductList;
    }

    public void setNoteProductList(List<noteProduct> noteProductList) {
        this.noteProductList = noteProductList;
    }

    public note(Integer nid, String title, String content, Date creatTime, User user, List<notePhoto> notePhotoList, List<noteComment> noteCommentList, List<noteProduct> noteProductList) {

        this.nid = nid;
        this.title = title;
        this.content = content;
        this.creatTime = creatTime;
        this.user = user;
        this.notePhotoList = notePhotoList;
        this.noteCommentList = noteCommentList;
        this.noteProductList = noteProductList;
    }
}



