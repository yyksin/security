package com.yyk.security.model;

import java.sql.Timestamp;

public class Aaa {
    private String username;
    private String password;
    private String email;
    private String role;
    private String provider;
    private String providerId;
    private Timestamp createDate;

    public Aaa(String username, String password, String email, String role, String provider, String providerId, Timestamp createDate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.createDate = createDate;
    }
}
