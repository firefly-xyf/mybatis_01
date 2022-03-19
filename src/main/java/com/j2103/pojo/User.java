package com.j2103.pojo;

import java.sql.Timestamp;

/**
 * @ClassName User
 * @Author BlackPearl
 * @Date 2021/8/27
 * @Version V1.0
 * @Description: TODO
 **/
public class User {

    private int uid;
    private String username;
    private String password;
    private Timestamp regtime;

    public User() {
    }

    public User(int uid, String username, String password, Timestamp regtime) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.regtime = regtime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getRegtime() {
        return regtime;
    }

    public void setRegtime(Timestamp regtime) {
        this.regtime = regtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", regtime=" + regtime +
                '}';
    }
}
