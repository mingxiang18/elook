package cn.elook.common.entity;

public class notePhoto {
    Integer npid;
    Integer nid;
    String photoSrc;

    public notePhoto(Integer npid, Integer nid, String photoSrc) {
        this.npid = npid;
        this.nid = nid;
        this.photoSrc = photoSrc;
    }

    public notePhoto() {

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

    public String getPhotoSrc() {
        return photoSrc;
    }

    public void setPhotoSrc(String photoSrc) {
        this.photoSrc = photoSrc;
    }


    @Override
    public String toString() {
        return "notePhote{" +
                "npid=" + npid +
                ", nid=" + nid +
                ", photoSrc='" + photoSrc + '\'' +
                '}';
    }
}



