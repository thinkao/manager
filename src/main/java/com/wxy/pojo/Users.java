package com.wxy.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "users")
public class Users {
    //用户id
    @Id
    private String uid;
    //用户头像路径
    private String avatar;

    public Users() {
    }

    public Users(String uid, String avatar) {
        this.uid = uid;
        this.avatar = avatar;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid='" + uid + '\'' +
                ", avatar='" + avatar + '\'' +
                '}';
    }
}