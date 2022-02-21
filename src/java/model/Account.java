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
public class Account {
    
    private String accountID ; 
    private String userName ; 
    private String password ; 
    private String email ; 
    private String phone ;
    private String role ;

    public Account() {
    }
    
       public Account(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public Account(String accountID, String userName, String password, String email, String phone, String role) {
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.role = role;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    public boolean isAdmin() {
        return this.role.equals("admin");
    }
    
}
