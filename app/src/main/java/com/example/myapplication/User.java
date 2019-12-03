package com.example.myapplication;

public class User {

    public String studentnumber;
    public String name;
    public String id;
    public String pw;

    public User (User u)
    {
        this.studentnumber = u.studentnumber;
        this.name = u.name;
        this.id = u.id;
        this.pw = pw;
    }

    public User()
    {
        this.studentnumber = null;
        this.name = null;
        this.id = null;
        this.pw = null;
    }

    public User(String sn, String na, String i, String p)
    {
        this.studentnumber = sn;
        this.name = na;
        this.id = i;
        this.pw = p;
    }

}
