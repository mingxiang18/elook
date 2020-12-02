package cn.elook.common.entity;

//分页查询请求封装类
public class PageRequest {
    //当前页码
    private int currentPage;
    //每一页的数量
    private int pageSize;

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
