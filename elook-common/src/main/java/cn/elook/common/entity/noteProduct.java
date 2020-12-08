package cn.elook.common.entity;

public class noteProduct {
    Integer npid;
    Integer nid;
    Integer pid;
    String categoryName;

    @Override
    public String toString() {
        return "noteProduct{" +
                "npid=" + npid +
                ", nid=" + nid +
                ", pid=" + pid +
                ", categoryName='" + categoryName + '\'' +
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

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public noteProduct() {

    }

    public noteProduct(Integer npid, Integer nid, Integer pid, String categoryName) {
        this.npid = npid;
        this.nid = nid;
        this.pid = pid;
        this.categoryName = categoryName;
    }
}
