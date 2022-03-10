/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-14         1.0               VUDMHE140017      First Implement
 */
package interfaceDAO;

import java.sql.SQLException;
import model.Account;

/**
 * This interface class used to contain some method used to implements in another
 *
 * @author vudm
 */
public interface IAccountDAO {

    /**
     * This method used to get username and password throw database
     *
     * @param username is a <code>String</code>
     * @param password is a <code>String</code>
     * @return null
     * @throws java.sql.SQLException
     */
    public Account checkAccountByUsernameAndPassword(String username, String password) throws Exception;
    
    /**
     * This method is used to create an account to access in system 
     * @param account is an object<code>Account</code>
     * @throws java.sql.SQLException
     */
    public void registerAccount(Account account) throws Exception;
    
    /**
     * This method is used to check username  existed in database
     * @param username is <code>String</code>
     * @return true
     * @throws java.sql.SQLException
     */
    public boolean isUsernameExist(String username) throws Exception;
    
     /**
     * The method is used to get account by email 
     * @param email is string
     * @return the account who have email equal first parameter 
     * @throws java.sql.SQLException 
     */
    public Account getAccountByEmail(String email) throws SQLException;
    
     /**
     * The method is used to update account of user
     * @param account is account who need to update 
     * @throws java.sql.SQLException 
     */   
    public void updateAccount(Account account) throws SQLException;
    
    /**
     * The method is used to get account of user 
     * @param userName is <code>String</code>
     * @return Account
     * @throws java.sql.SQLException 
     */ 
    public Account getAccount(String userName) throws SQLException;
    
      /**
     * The method is used to update profile of user 
     * @param account is an object<code>Account</code>
     * @throws java.sql.SQLException 
     */ 
    public void updateProfile(Account account) throws SQLException;
}
