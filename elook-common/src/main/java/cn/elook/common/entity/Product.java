package cn.elook.common.entity;

import java.util.Date;

public class Product {
    private Long pid;

    private String productName;

    private String productDes;

    private Float productPrice;

    private Long pcid;

    private Integer ifSold;

    private Long uid;

    private Date productCreateTime;

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", productName='" + productName + '\'' +
                ", productDes='" + productDes + '\'' +
                ", productPrice=" + productPrice +
                ", pcid=" + pcid +
                ", ifSold=" + ifSold +
                ", uid=" + uid +
                ", productCreateTime=" + productCreateTime +
                '}';
    }

    public Date getProductCreateTime() {
        return productCreateTime;
    }

    public void setProductCreateTime(Date productCreateTime) {
        this.productCreateTime = productCreateTime;
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
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductDes() {
        return productDes;
    }

    public void setProductDes(String productDes) {
        this.productDes = productDes == null ? null : productDes.trim();
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

}