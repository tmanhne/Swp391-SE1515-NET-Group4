/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Riel
 */
public class Account {
    
    private String AccountID ;
    private String Username ;
    private String Password ;
    private String Email ;
    private String Phone ;
    private String Role ;

    public Account() {
    }

    public Account(String AccountID, String Username, String Password, String Email, String Phone, String Role) {
        this.AccountID = AccountID;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Phone = Phone;
        this.Role = Role;
    }

    public String getAccountID() {
        return AccountID;
    }

    public void setAccountID(String AccountID) {
        this.AccountID = AccountID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }
    
    
    
    
}
