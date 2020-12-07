package cn.elook.common.entity;

import java.util.List;

public class PageBean {
    private int currentPage;
    private int currentCount;
    private int totalPage;
    private int totalCount;

    List<note> notes;

    @Override
    public String toString() {
        return "PageBean{" +
                "currentPage=" + currentPage +
                ", currentCount=" + currentCount +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", notes=" + notes +
                '}';
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<note> getNotes() {
        return notes;
    }

    public void setNotes(List<note> notes) {
        this.notes = notes;
    }

    public PageBean() {

    }

    public PageBean(int currentPage, int currentCount, int totalPage, int totalCount, List<note> notes) {

        this.currentPage = currentPage;
        this.currentCount = currentCount;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.notes = notes;
    }
}
