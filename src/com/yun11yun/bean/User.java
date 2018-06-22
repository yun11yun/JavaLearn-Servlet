package com.yun11yun.bean;

import java.util.Map;

public class User {

    private static final String UID_KEY = "cid";
    private static final String UNAME_KEY = "cname";
    private static final String MONEY_KEY = "money";
    private static final String PASSWORD_KEY = "password";

    private int uid;
    private String name;
    private float money;
    private String password;

    public User(Map<String, Object> map) {
        this.uid = (Integer)map.get(UID_KEY);
        this.name = (String)map.get(UNAME_KEY);
        this.money = (Float)map.get(MONEY_KEY);
        this.password = (String)map.get(PASSWORD_KEY);
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public User(int uid, String name, float money, String password) {
        this.uid = uid;
        this.name = name;
        this.money = money;
        this.password = password;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
