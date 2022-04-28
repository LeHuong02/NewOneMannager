package com.example.newonemannager.Models;

public class Order {
     int ID ;
     int IDCustomer ;
     int IDEmployee ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDCustomer() {
        return IDCustomer;
    }

    public void setIDCustomer(int IDCustomer) {
        this.IDCustomer = IDCustomer;
    }

    public int getIDEmployee() {
        return IDEmployee;
    }

    public void setIDEmployee(int IDEmployee) {
        this.IDEmployee = IDEmployee;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public byte getType() {
        return Type;
    }

    public void setType(byte type) {
        Type = type;
    }

    public byte getStatus() {
        return Status;
    }

    public void setStatus(byte status) {
        Status = status;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    String OrderDate ;
     byte Type ;
     byte Status ;
     String Position ;

    public Order(int ID, int IDCustomer, int IDEmployee, String orderDate, byte type, byte status, String position) {
        this.ID = ID;
        this.IDCustomer = IDCustomer;
        this.IDEmployee = IDEmployee;
        OrderDate = orderDate;
        Type = type;
        Status = status;
        Position = position;
    }
}
