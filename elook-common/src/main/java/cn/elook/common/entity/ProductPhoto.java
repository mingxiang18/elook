package cn.elook.common.entity;

public class ProductPhoto {
    private Long ppid;

    private Long pid;

    private String productSrc;

    public Long getPpid() {
        return ppid;
    }

    public void setPpid(Long ppid) {
        this.ppid = ppid;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getProductSrc() {
        return productSrc;
    }

    public void setProductSrc(String productSrc) {
        this.productSrc = productSrc == null ? null : productSrc.trim();
    }
}