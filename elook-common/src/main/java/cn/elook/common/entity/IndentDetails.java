package cn.elook.common.entity;

import java.io.Serializable;
import java.util.Date;

public class IndentDetails implements Serializable {
    private String oId;
    private Long vendorId;
    private Long buyerId;
    private String address;
    private float indentPrice;
    private Date indentCreateTime;
    private Integer indentState;
    private Long pId;
    private String buyerName;
    private String vendorName;
    private String productName;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getIndentPrice() {
        return indentPrice;
    }

    public void setIndentPrice(float indentPrice) {
        this.indentPrice = indentPrice;
    }

    public Date getIndentCreateTime() {
        return indentCreateTime;
    }

    public void setIndentCreateTime(Date indentCreateTime) {
        this.indentCreateTime = indentCreateTime;
    }

    public Integer getIndentState() {
        return indentState;
    }

    public void setIndentState(Integer indentState) {
        this.indentState = indentState;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "IndentDetails{" +
                "oId='" + oId + '\'' +
                ", vendorId=" + vendorId +
                ", buyerId=" + buyerId +
                ", address='" + address + '\'' +
                ", indentPrice=" + indentPrice +
                ", indentCreateTime=" + indentCreateTime +
                ", indentState=" + indentState +
                ", pId=" + pId +
                ", buyerName='" + buyerName + '\'' +
                ", vendorName='" + vendorName + '\'' +
                ", productName='" + productName + '\'' +
                '}';
    }
}
