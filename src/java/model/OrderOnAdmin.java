/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Hfyl
 */
public class OrderOnAdmin {

    private String orderID;
    private String customer;
    private Date orderDate;
    private double unitPrice;
    private String ship;
    private String paymentMethod;

    public OrderOnAdmin() {
    }

    public OrderOnAdmin(String orderID, String customer, Date orderDate, double unitPrice, String ship, String paymentMethod) {
        this.orderID = orderID;
        this.customer = customer;
        this.orderDate = orderDate;
        this.unitPrice = unitPrice;
        this.ship = ship;
        this.paymentMethod = paymentMethod;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getShip() {
        return ship;
    }

    public void setShip(String ship) {
        this.ship = ship;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

}
