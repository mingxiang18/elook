package cn.elook.common.entity;

import java.util.Date;

public class ProductDetails {
    private Long pid;

    private String productName;

    private String productDes;

    private Float productPrice;

    private Long pcid;

    private Integer ifSold;

    private Long uid;

    private String username;

    private String categoryName;

    private Date productCreateTime;

    private String productPhoto;

    @Override
    public String toString() {
        return "ProductDetails{" +
                "pid=" + pid +
                ", productName='" + productName + '\'' +
                ", productDes='" + productDes + '\'' +
                ", productPrice=" + productPrice +
                ", pcid=" + pcid +
                ", ifSold=" + ifSold +
                ", uid=" + uid +
                ", username='" + username + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", productCreateTime=" + productCreateTime +
                '}';
    }

    public Date getProductCreateTime() {
        return productCreateTime;
    }

    public void setProductCreateTime(Date productCreateTime) {
        this.productCreateTime = productCreateTime;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes;
    }

    public Float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Float productPrice) {
        this.productPrice = productPrice;
    }

    public Long getPcid() {
        return pcid;
    }

    public void setPcid(Long pcid) {
        this.pcid = pcid;
    }

    public Integer getIfSold() {
        return ifSold;
    }

    public void setIfSold(Integer ifSold) {
        this.ifSold = ifSold;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProductPhoto() {
        return productPhoto;
    }

    public void setProductPhoto(String productPhoto) {
        this.productPhoto = productPhoto;
    }
}
