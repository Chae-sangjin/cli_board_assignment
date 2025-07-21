package com.ll.article;


public class Member {
    private int id;
    private String name;
    private String userid;
    private String password;
    private String regDate;

    public Member(int id, String name, String userid, String password) {
        this.id = id;
        this.name = name;
        this.userid = userid;
        this.password = password;
        this.regDate = regDate;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUserId() {
        return userid;
    }

    public String getPassword() {
        return password;
    }

    public String getRegDate() {
        return regDate;
    }

    public static Member loginMember;
}