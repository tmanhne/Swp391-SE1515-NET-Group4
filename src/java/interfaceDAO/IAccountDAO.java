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
    
    public Account getAccountByEmail(String email) throws SQLException;
    
    public void updateAccount(Account account) throws SQLException;
    
}


