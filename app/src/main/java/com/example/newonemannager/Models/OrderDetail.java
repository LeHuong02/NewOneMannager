package com.example.newonemannager.Models;

public class OrderDetail {
    int ID ;
    int IDOrder ;
    int IDFoodDetails ;
    int Quantity ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDOrder() {
        return IDOrder;
    }

    public void setIDOrder(int IDOrder) {
        this.IDOrder = IDOrder;
    }

    public int getIDFoodDetails() {
        return IDFoodDetails;
    }

    public void setIDFoodDetails(int IDFoodDetails) {
        this.IDFoodDetails = IDFoodDetails;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public OrderDetail(int ID, int IDOrder, int IDFoodDetails, int quantity) {
        this.ID = ID;
        this.IDOrder = IDOrder;
        this.IDFoodDetails = IDFoodDetails;
        Quantity = quantity;
    }
}
