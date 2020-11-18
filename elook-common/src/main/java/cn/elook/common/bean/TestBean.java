package cn.elook.common.bean;

public class TestBean {

    private Long id;
    private String tname;
    private String content;

    @Override
    public String toString() {
        return "TestBean{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
