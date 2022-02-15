/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author t.manh
 */
public class BookEdit {

    private int ProductID;
    private String ProductName;
    private String PathImage;
    private String CreateDate;
    private String Description;
    private float UnitPrice;
    private int UnitInStock;
    private int Ratting;

    private boolean IsContinue;
    private ArrayList<Author> authors;
    private Category category;

    public BookEdit() {
    }

    public BookEdit(int ProductID, String ProductName, String PathImage, String CreateDate, String Description, float UnitPrice, int UnitInStock, int Ratting, boolean IsContinue, ArrayList<Author> authors, Category category) {
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.PathImage = PathImage;
        this.CreateDate = CreateDate;
        this.Description = Description;
        this.UnitPrice = UnitPrice;
        this.UnitInStock = UnitInStock;
        this.Ratting = Ratting;
        this.IsContinue = IsContinue;
        this.authors = authors;
        this.category = category;
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

    public int getUnitInStock() {
        return UnitInStock;
    }

    public void setUnitInStock(int UnitInStock) {
        this.UnitInStock = UnitInStock;
    }

    public int getRatting() {
        return Ratting;
    }

    public void setRatting(int Ratting) {
        this.Ratting = Ratting;
    }

    public boolean isIsContinue() {
        return IsContinue;
    }

    public void setIsContinue(boolean IsContinue) {
        this.IsContinue = IsContinue;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
