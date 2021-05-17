package com.example.themodernbibliothecaandroid.Repository;

import java.util.Date;

public class Activity {
    private Date date;
    private String email;
    private String description;
    private String accountType;

    public Activity() {
    }

    public Activity(Date date, String email, String description, String accountType) {
        this.date = date;
        this.email = email;
        this.description = description;
        this.accountType = accountType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "date=" + date +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", accountType='" + accountType + '\'' +
                '}';
    }


}
