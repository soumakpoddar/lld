package org.example.entity;

public class User {
    private String userName;
    private String emailId;

    public User(String userName, String emailId) {
        this.userName = userName;
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailId() {
        return emailId;
    }
}
