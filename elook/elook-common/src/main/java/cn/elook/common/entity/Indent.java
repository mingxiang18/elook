package cn.elook.common.entity;

import java.io.Serializable;
import java.util.Date;

public class Indent implements Serializable {
    private String oId;
    private Integer vendorId;
    private Integer buyerId;
    private String address;
    private float indentPrice;
    private Date indentCreateTime;
    private Integer indentState;
    private Integer pId;

    public String getoId() {
        return oId;
    }

    public void setoId(String oId) {
        this.oId = oId;
    }

    public Integer getVendorId() {
        return vendorId;
    }

    public void setVendorId(Integer vendorId) {
        this.vendorId = vendorId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
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

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "Indent{" +
                "oId='" + oId + '\'' +
                ", vendorId=" + vendorId +
                ", buyerId=" + buyerId +
                ", address='" + address + '\'' +
                ", indentPrice=" + indentPrice +
                ", indentCreateTime=" + indentCreateTime +
                ", indentState=" + indentState +
                ", pId=" + pId +
                '}';
    }
}
