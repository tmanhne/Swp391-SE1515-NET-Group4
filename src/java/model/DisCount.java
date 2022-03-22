/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Thongchu
 */
public class DisCount {
    
    private int discountID;
    private String discountCODE;
    private String customerID;
    private String customerName;
    private String productID;
    private String productName;
    private boolean isContinue;
    private int discountValue;

    public DisCount() {
    }

    public DisCount(int discountID, String discountCODE, String customerID, String customerName, String productID, String productName, boolean isContinue, int discountValue) {
        this.discountID = discountID;
        this.discountCODE = discountCODE;
        this.customerID = customerID;
        this.customerName = customerName;
        this.productID = productID;
        this.productName = productName;
        this.isContinue = isContinue;
        this.discountValue = discountValue;
    }

    

    

    public int getDiscountID() {
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID = discountID;
    }

    public String getDiscountCODE() {
        return discountCODE;
    }

    public void setDiscountCODE(String discountCODE) {
        this.discountCODE = discountCODE;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public boolean getIsContinue() {
        return isContinue;
    }

    public void setIsContinue(boolean isContinue) {
        this.isContinue = isContinue;
    }

    public int getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(int discountValue) {
        this.discountValue = discountValue;
    }

    
    
}
