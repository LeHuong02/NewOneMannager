package com.example.newonemannager.Models;

public class Account {
    String Username;
    String Password;
    byte Status;

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
        Status = status;
    }

    public Account(String username, String password, byte status) {
        Username = username;
        Password = password;
        Status = status;
    }
}
