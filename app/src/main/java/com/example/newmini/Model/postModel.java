package com.example.newmini.Model;

public class postModel {
    private String postId;
    private String postImg;
    private String postedBy;
    private String postDescr;

    public postModel() {
    }

    public postModel(String postId, String postImg, String postedBy, String postDescr) {
        this.postId = postId;
        this.postImg = postImg;
        this.postedBy = postedBy;
        this.postDescr = postDescr;
    }


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostImg() {
        return postImg;
    }

    public void setPostImg(String postImg) {
        this.postImg = postImg;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

    public String getPostDescr() {
        return postDescr;
    }

    public void setPostDescr(String postDescr) {
        this.postDescr = postDescr;
    }
}
