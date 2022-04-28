package com.example.newonemannager.Models;

public class UsedMaterial {
     int ID ;
     int IDFoodDetails ;
     int IDMaterial ;
     double Quantity ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDFoodDetails() {
        return IDFoodDetails;
    }

    public void setIDFoodDetails(int IDFoodDetails) {
        this.IDFoodDetails = IDFoodDetails;
    }

    public int getIDMaterial() {
        return IDMaterial;
    }

    public void setIDMaterial(int IDMaterial) {
        this.IDMaterial = IDMaterial;
    }

    public double getQuantity() {
        return Quantity;
    }

    public void setQuantity(double quantity) {
        Quantity = quantity;
    }

    public UsedMaterial(int ID, int IDFoodDetails, int IDMaterial, double quantity) {
        this.ID = ID;
        this.IDFoodDetails = IDFoodDetails;
        this.IDMaterial = IDMaterial;
        Quantity = quantity;
    }
}
