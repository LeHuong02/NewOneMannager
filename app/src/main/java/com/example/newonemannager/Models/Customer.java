package com.example.newonemannager.Models;

public class Customer {
     int ID ;
     String FullName ;
     String Address ;
     String PhoneNumber ;
     int Point ;
     String Avatar ;
     String Username ;

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

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
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

    public Customer(int ID, String fullName, String address, String phoneNumber, int point, String avatar, String username) {
        this.ID = ID;
        FullName = fullName;
        Address = address;
        PhoneNumber = phoneNumber;
        Point = point;
        Avatar = avatar;
        Username = username;
    }

    public Customer(String fullName, int point, String username) {
        FullName = fullName;
        Point = point;
        Username = username;
    }
}
