package cn.elook.common.entity;

public class ProductCategory {
    private Long pcid;

    private Long parentId;

    private String categoryName;

    public Long getPcid() {
        return pcid;
    }

    public void setPcid(Long pcid) {
        this.pcid = pcid;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName == null ? null : categoryName.trim();
    }
}