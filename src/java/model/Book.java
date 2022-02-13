/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-07      1.0                 VUDM               Book Class
 */
package model;

import java.util.ArrayList;

/**
 * The class contain parameter and method of book class
 *
 * @author vudm
 */
public class Book {

    private int ProductID;
    private String ProductName;
    private String PathImage;
    private String CreateDate;
    private String Description;
    private float UnitPrice;
    private int UnitInStock;

    private boolean isContinues;

    public int getUnitInStock() {
        return UnitInStock;
    }

    public void setUnitInStock(int UnitInStock) {
        this.UnitInStock = UnitInStock;
    }

    public boolean isIsContinues() {
        return isContinues;
    }

    public void setIsContinues(boolean isContinues) {
        this.isContinues = isContinues;
    }
    private ArrayList<String> authors;

    public Book() {
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
        this.PathImage = PathImage;
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

    @Override
    public String toString() {
        return ProductID+ ProductName;
    }

}
