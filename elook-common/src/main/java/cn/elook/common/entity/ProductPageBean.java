package cn.elook.common.entity;

import java.util.List;

public class ProductPageBean {
    private int currentPage;
    private int currentCount;
    private int totalPage;
    private int totalCount;

    List<Product> products;

    @Override
    public String toString() {
        return "ProductPageBean{" +
                "currentPage=" + currentPage +
                ", currentCount=" + currentCount +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", products=" + products +
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductPageBean(int currentPage, int currentCount, int totalPage, int totalCount, List<Product> products) {

        this.currentPage = currentPage;
        this.currentCount = currentCount;
        this.totalPage = totalPage;
        this.totalCount = totalCount;
        this.products = products;
    }

    public ProductPageBean() {

    }
}
