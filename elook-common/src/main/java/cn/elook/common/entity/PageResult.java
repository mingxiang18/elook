package cn.elook.common.entity;

import java.util.List;
//分页查询结果的封装类
public class PageResult {
    //当前页码
    private int currentPage;
    //每页数量
    private int pageSiez;
    //记录总数
    private long totalNum;
    //页码总数
    private int totalPages;
    //当前页的数据
    private List<?> content;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSiez() {
        return pageSiez;
    }

    public void setPageSiez(int pageSiez) {
        this.pageSiez = pageSiez;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public List<?> getContent() {
        return content;
    }

    public void setContent(List<?> content) {
        this.content = content;
    }
}
