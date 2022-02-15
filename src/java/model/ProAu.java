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
public class ProAu {
    private String productID ; 
    private String authorID ; 

    public ProAu() {
    }

    public ProAu(String productID, String authorID) {
        this.productID = productID;
        this.authorID = authorID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    
}
