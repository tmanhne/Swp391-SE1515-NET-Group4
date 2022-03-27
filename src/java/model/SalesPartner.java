/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author vudm
 */
public class SalesPartner {
    private int partnerID;
    private String partnerName;
    private String address;
    private String product;
    private String email;
    private String phone;
    private String description;
    private String status;

    public SalesPartner() {
    }
    
    public SalesPartner(int partnerID, String status) {
        this.partnerID = partnerID;
        this.status = status;
    }
    
    public SalesPartner(String partnerName, String address, String product, String email, String phone, String description, String status) {
        this.partnerName = partnerName;
        this.address = address;
        this.product = product;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.status = status;
    }
    public SalesPartner(int partnerID, String partnerName, String address, String product, String email, String phone, String description, String status) {
        this.partnerID = partnerID;
        this.partnerName = partnerName;
        this.address = address;
        this.product = product;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   

    public int getPartnerID() {
        return partnerID;
    }

    public void setPartnerID(int partnerID) {
        this.partnerID = partnerID;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
