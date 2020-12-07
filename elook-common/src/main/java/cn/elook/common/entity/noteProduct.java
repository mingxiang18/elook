package cn.elook.common.entity;

public class noteProduct {
    Integer npid;
    Integer nid;
    String productSrc;

    @Override
    public String toString() {
        return "noteProduct{" +
                "npid=" + npid +
                ", nid=" + nid +
                ", productSrc='" + productSrc + '\'' +
                '}';
    }

    public Integer getNpid() {
        return npid;
    }

    public void setNpid(Integer npid) {
        this.npid = npid;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getProductSrc() {
        return productSrc;
    }

    public void setProductSrc(String productSrc) {
        this.productSrc = productSrc;
    }

    public noteProduct() {

    }

    public noteProduct(Integer npid, Integer nid, String productSrc) {
        this.npid = npid;
        this.nid = nid;
        this.productSrc = productSrc;
    }
}
