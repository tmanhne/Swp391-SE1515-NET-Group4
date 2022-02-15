/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Thongchu
 */
public class Orders {
    private String orderID;
    private String customerID;
    private Date OrderDate;
    private String Ship;
    private String status;
    private String paymentMethod;

    public Orders() {
    }

    public Orders(String orderID, String customerID, Date OrderDate, String Ship, String status, String paymentMethod) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.OrderDate = OrderDate;
        this.Ship = Ship;
        this.status = status;
        this.paymentMethod = paymentMethod;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public Date getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(Date OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getShip() {
        return Ship;
    }

    public void setShip(String Ship) {
        this.Ship = Ship;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    
    
}
