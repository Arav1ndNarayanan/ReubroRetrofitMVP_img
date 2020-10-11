package com.example.reubroretrofitmvp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NoticeList {

    @SerializedName("users")
    @Expose
    private List<Notice> noticeList = null;

    public List<Notice> getUsers() {
        return noticeList;
    }

    public void setUsers(List<Notice> users) {
        this.noticeList = users;
    }

}