package com.example.newonemannager.Models;

public class Food {
    int ID;

    int IDCategory;


    String Name;


    String Image;

    byte Status;

    public Food(int ID, int IDCategory, String name, String image, byte status) {
        this.ID = ID;
        this.IDCategory = IDCategory;
        Name = name;
        Image = image;
        Status = status;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDCategory() {
        return IDCategory;
    }

    public void setIDCategory(int IDCategory) {
        this.IDCategory = IDCategory;
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
}
