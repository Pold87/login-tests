package com.example.login2.model;

import io.realm.RealmObject;

/**
 * Created by pold on 3/24/15.
 */
public class Credential extends RealmObject {

    private String userName;
    private String password;

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {

        return this.password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
