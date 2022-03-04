/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-17      1.0                 VUDM,THONGCT               First Implement
 */
package dao;

import dal.DBConnection;
import interfaceDAO.IAccountDAO;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 * The class contain method to check account for database
 *
 * @author vudm
 */
public class AccountDAO extends DBConnection implements IAccountDAO {

    /**
     * Get salt
     *
     * @return encryptedPassword
     * @throws NoSuchAlgorithmException, NoSuchProviderException
     */

    @Override
    public byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }

    /**
     * @param salt are array byte
     * @param password is string The method used encrypt password
     * @return encryptedPassword
     */
    //Encrypt password with Java SHA1 Hashing by password and salt
    @Override
    public String encryptPassword(String password, byte[] salt){
        String encryptedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes 
            byte[] bytes = md.digest(password.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            encryptedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }

    /**
     * @param username is string
     * @param password is string The method used check account user login to
     * system throw username and password
     */
    @Override
    public Account checkAccountByUsernameAndPassword(String username, String password){
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            String sql = "select * from Accounts\n"
                    + " where Username = ?";

            Account account = null;

            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {//assign data to authors
                String encryptedPassword = rs.getString("Password");
                String salt = rs.getString("Salt");
                String pass = encryptPassword(password, Base64.getDecoder().decode(salt));

                if (pass.equals(encryptedPassword)) { // check pass encrypted 
                    account = new Account();
                    account.setAccountID(rs.getString("AccountID"));
                    account.setUserName(rs.getString("Username"));

                    account.setRole(rs.getString("Role"));
                    return account;
                }
            }
        } catch (Exception ex) {
             ex.printStackTrace();
            
        }
        return null;
    }
    
    /**
     * @param email is string
     * @return the account who have email equal first parameter 
     */
    public Account getAccountByEmail(String email) {
        String sql = "SELECT * FROM Accounts WHERE [Email] = ?";
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = new Account();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                account.setAccountID(rs.getString(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setRole(rs.getString(6));
                return account;
            }
        } 
        catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            super.close(con, ps, rs);
        }
        return account;
    }
    
     /**
     * @param accpunt is account who need to update 
     */    
    public void updateAccount(Account account) {
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [dbo].[Accounts] \n" +
                    "   SET [Password] = ?\n" +
                    " WHERE [Email] = ?\n" ;
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, account.getPassword());
            stm.setString(2, account.getEmail());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            super.close(con, ps, rs);
        }
    } 
    
}
