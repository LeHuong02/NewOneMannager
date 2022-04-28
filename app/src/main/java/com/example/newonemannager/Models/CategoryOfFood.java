package com.example.newonemannager.Models;

public class CategoryOfFood {
     int ID ;
    String Name ;
    String Image ;
    byte Status ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
        Status = status;
    }

    public CategoryOfFood(int ID, String name, String image, byte status) {
        this.ID = ID;
        Name = name;
        Image = image;
        Status = status;
    }
}
