package com.example.newmini.Model;

public class dashboardModel {
    String name;
    int postimage;

    public dashboardModel(String name, int postimage) {
        this.name = name;
        this.postimage = postimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPostimage() {
        return postimage;
    }

    public void setPostimage(int postimage) {
        this.postimage = postimage;
    }
}
