package cn.elook.common.entity;

public class ProductDetails {
    private Long pid;

    private String productName;

    private String productDes;

    private Float productPrice;

    private Long pcid;

    private Integer ifSold;

    private Long uid;

    private String username;

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
                '}';
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
}
