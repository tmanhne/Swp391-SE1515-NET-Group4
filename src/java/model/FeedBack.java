/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 ThongCT               Second Implement
 */
package model;

import java.util.Date;

/**
 *
 * @author Thongchu
 */
public class FeedBack {
    private String customerID;
    private String customerName;
    private Date feedbackDate;
    private String description;
    private String productID;
    private String productName;
    private int ratting ;

    public FeedBack() {
    }

    public FeedBack(String customerID, String customerName, Date feedbackDate, String description, String productID, String productName, int ratting) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.feedbackDate = feedbackDate;
        this.description = description;
        this.productID = productID;
        this.productName = productName;
        this.ratting = ratting;
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

    public Date getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(Date feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getRatting() {
        return ratting;
    }

    public void setRatting(int ratting) {
        this.ratting = ratting;
    }

    
}
