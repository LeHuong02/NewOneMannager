package com.example.newonemannager.Models;

public class Emphloyee {
    int ID ;
    String FullName ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getPostion() {
        return Postion;
    }

    public void setPostion(String postion) {
        Postion = postion;
    }

    public String getAvatar() {
        return Avatar;
    }

    public void setAvatar(String avatar) {
        Avatar = avatar;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    String DateOfBirth ;
    String Address;
    String PhoneNumber ;
    String Postion ;
    String Avatar ;
    String Username ;

    public Emphloyee(int ID, String fullName, String dateOfBirth, String address, String phoneNumber, String postion, String avatar, String username) {
        this.ID = ID;
        FullName = fullName;
        DateOfBirth = dateOfBirth;
        Address = address;
        PhoneNumber = phoneNumber;
        Postion = postion;
        Avatar = avatar;
        Username = username;
    }
}

