package com.example.myapplication;

public class plan {

    public String pstudentnumber;
    public String course;
    public String coursenumber;
    public String day;
    public String location;
    public String starttime;
    public String endtime;

    public plan()
    {
        this.pstudentnumber = null;
        this.course = null;
        this.coursenumber = null;
        this.day = null;
        this.location = null;
        this.starttime = null;
        this.endtime = null;
    }

    public plan(plan p)
    {
        this.pstudentnumber = p.pstudentnumber;
        this.course = p.course;
        this.coursenumber = p.coursenumber;
        this.day = p.day;
        this.location = p.location;
        this.starttime = p.starttime;
        this.endtime = p.endtime;
    }

    public plan(String ps, String c, String cn, String d, String lo, String st, String en)
    {
        this.pstudentnumber = ps;
        this.course = c;
        this.coursenumber = cn;
        this.day = d;
        this.location = lo;
        this.starttime = st;
        this.endtime = en;
    }
}
