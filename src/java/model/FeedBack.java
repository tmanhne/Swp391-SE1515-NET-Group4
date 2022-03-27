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
    private String accountID;
    private String accountName;
    private Date feedbackDate;
    private String description;
    private String productID;
    private String productName;
    private int ratting ;

    public FeedBack() {
    }

    public FeedBack(String accountID, String accountName, Date feedbackDate, String description, String productID, String productName, int ratting) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.feedbackDate = feedbackDate;
        this.description = description;
        this.productID = productID;
        this.productName = productName;
        this.ratting = ratting;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
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
