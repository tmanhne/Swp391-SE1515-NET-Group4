/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Hfyl
 */
public class BookOnCart {

    private String productID;
    private String productName;
    private String pathImage;
    private double unitPrice;
    private int quantity;

    public BookOnCart() {
    }

    public BookOnCart(String productID, int quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public BookOnCart(String productID, String productName, String pathImage, float unitPrice, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.pathImage = pathImage;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
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

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
