package com.example.newonemannager.Models;

public class FoodDetail {
     int ID ;
     int IDFood ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDFood() {
        return IDFood;
    }

    public void setIDFood(int IDFood) {
        this.IDFood = IDFood;
    }

    public String getSize() {
        return Size;
    }

    public void setSize(String size) {
        Size = size;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getPoint() {
        return Point;
    }

    public void setPoint(int point) {
        Point = point;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
        Status = status;
    }

    String Size ;
     int Cost ;
     String Image ;
     int Point;
     byte Status ;

    public FoodDetail(int ID, int IDFood, String size, int cost, String image, int point, byte status) {
        this.ID = ID;
        this.IDFood = IDFood;
        Size = size;
        Cost = cost;
        Image = image;
        Point = point;
        Status = status;
    }
}
