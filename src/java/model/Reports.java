/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author vudm
 */
public class Reports {
    private int reportID;
    private String title;
    private String customerName;
    private String email;
    private String phone;
    private String insurance;
    private String descriptions;
    private String status;
    private String accountID;
    private Date time;

    public Reports() {
    }
    

    public Reports(String title, String customerName, String email, String phone, String insurance, String descriptions, String status, String accountID, Date time) {
        this.title = title;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.insurance = insurance;
        this.descriptions = descriptions;
        this.status = status;
        this.accountID = accountID;
        this.time = time;
    }

    public Reports(int reportID, String title, String customerName, String email, String phone, String insurance, String descriptions, String status, String accountID, Date time) {
        this.reportID = reportID;
        this.title = title;
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
        this.insurance = insurance;
        this.descriptions = descriptions;
        this.status = status;
        this.accountID = accountID;
        this.time = time;
    }

    public Reports(int reportID, String status) {
        this.reportID = reportID;
        this.status = status;
    }

    

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    
    
}
