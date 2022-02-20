/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author vudm
 */
public class AccountDAO extends DBConnection implements IAccountDAO {

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

    //Encrypt password with Java SHA1 Hashing by password and salt
    @Override
    public String encryptPassword(String password, byte[] salt) {
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

    @Override
    public Account checkAccountByUsernameAndPassword(String username, String password) {
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
            if (rs.next()) {
                String encryptedPassword = rs.getString("Password");
                String salt = rs.getString("Salt");
                String pass = encryptPassword(password, Base64.getDecoder().decode(salt));

                if (pass.equals(encryptedPassword)) {
                    account = new Account();
                    account.setAccountID(rs.getString("AccountID"));
                    account.setUserName(rs.getString("Username"));

                    account.setRole(rs.getString("Role"));
                    return account;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Get account by username
     *
     * @param username is the user account name
     * @return account
     */
    public Account getAccount(String username) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Account account = new Account();
        String sql = "SELECT * FROM Accounts WHERE Username = ?";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            //assign data to books
            while (rs.next()) {
                account.setUserName(rs.getString("userName"));
                account.setPassword(rs.getString("password"));
                account.setEmail(rs.getString("email"));
                account.setPhone(rs.getString("phone"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return account;
    }

}
