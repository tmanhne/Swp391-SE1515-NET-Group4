/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thongchu
 */
public class Product {

    private String productID;
    private String productName;
    private String imagePath;
    private Date createDate;
    private String description;
    private double unitPrice;
    private int unitInStock;
    private boolean isContinue;
    private int ratting;
    private String categoryID;
    private ArrayList<String> authors;

   
    public Product() {
    }

    public Product(String productID, String productName, String description, double unitPrice, int unitInStock, boolean isContinue, int ratting) {
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.isContinue = isContinue;
        this.ratting = ratting;
    }

    public Product(String productID, String productName, String imagePath, Date createDate, String description, double unitPrice, int unitInStock, boolean isContinue, int ratting, String categoryID) {
        this.productID = productID;
        this.productName = productName;
        this.imagePath = imagePath;
        this.createDate = createDate;
        this.description = description;
        this.unitPrice = unitPrice;
        this.unitInStock = unitInStock;
        this.isContinue = isContinue;
        this.ratting = ratting;
        this.categoryID = categoryID;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }

    public boolean isIsContinue() {
        return isContinue;
    }

    public void setIsContinue(boolean isContinue) {
        this.isContinue = isContinue;
    }

    public int getRatting() {
        return ratting;
    }

    public void setRatting(int ratting) {
        this.ratting = ratting;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }
    
    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", imagePath=" + imagePath + ", createDate=" + createDate + ", description=" + description + ", unitPrice=" + unitPrice + ", unitInStock=" + unitInStock + ", isContinue=" + isContinue + ", ratting=" + ratting + ", categoryID=" + categoryID + '}';
    }

}
