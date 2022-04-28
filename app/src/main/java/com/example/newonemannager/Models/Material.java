package com.example.newonemannager.Models;

public class Material {
    int ID ;
    String Category ;
    String Name ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
        Status = status;
    }

    double Quantity ;
     String Unit ;
     int Cost ;
     byte Status ;

    public Material(int ID, String category, String name, double quantity, String unit, int cost, byte status) {
        this.ID = ID;
        Category = category;
        Name = name;
        Quantity = quantity;
        Unit = unit;
        Cost = cost;
        Status = status;
    }
}
