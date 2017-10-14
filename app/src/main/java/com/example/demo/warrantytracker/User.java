package com.example.demo.warrantytracker;

/**
 * Created by Saim Shaikh on 06-08-2017.
 */

public class User {
    public String cname;
    public String pname;
    public int day;
    public int month;
    public int year;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String cname, String pname,int day,int month,int year) {
        this.cname = cname;
        this.pname = pname;
        this.day=day;
        this.month=month;
        this.year=year;
    }


}
