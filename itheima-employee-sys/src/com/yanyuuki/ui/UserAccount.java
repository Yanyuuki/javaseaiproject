package com.yanyuuki.ui;

public class UserAccount {
    private final String username;
    private final String password;
    private final String displayName;

    public UserAccount(String username, String password, String displayName) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDisplayName() {
        return displayName;
    }
}

