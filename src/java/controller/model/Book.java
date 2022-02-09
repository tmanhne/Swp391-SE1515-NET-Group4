/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class Book {
    private  int ProductID;
    private String ProductName;
    private String PathImage;
    private String CreateDate;
    private String Description;
    private float UnitPrice;
    private ArrayList<String> authors;

    public Book() {
    }

    public Book(int ProductID, String ProductName, String PathImage, String CreateDate, String Description, float UnitPrice, ArrayList<String> authors) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.PathImage = PathImage;
        this.CreateDate = CreateDate;
        this.Description = Description;
        this.UnitPrice = UnitPrice;
        this.authors = authors;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getPathImage() {
        return PathImage;
    }

    public void setPathImage(String PathImage) {
        this.PathImage =PathImage;
    }

    public String getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(String CreateDate) {
        this.CreateDate = CreateDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
    

}
