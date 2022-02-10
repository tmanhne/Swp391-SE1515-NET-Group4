/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.Account;
import java.util.List;

/**
 *
 * @author Riel
 */
public class AccountDAO extends DBConnection.DBConnection {
    
//    public Account getAccountByEmailAndPass(String email, String password) {
//        try {
//            String sql = "SELECT * FROM Account WHERE [email] = ? AND password = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, email);
//            stm.setString(2, password);
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                Account account = new Account();
//                account.setAid(rs.getInt("aid"));
//                account.setEmail(rs.getString("email"));
//                account.setPassword(rs.getString("password"));
//                account.setIs_admin(rs.getBoolean("is_admin"));
//                account.setName(rs.getString("name"));
//                account.setPhone(rs.getString("phone"));
//                account.setAddress(rs.getString("address"));
//                return account;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    public Account getAccountByEmail(String email) {
//        try {
//            String sql = "SELECT * FROM Account WHERE [email] = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, email);
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                Account account = new Account();
//                account.setAid(rs.getInt("aid"));
//                account.setEmail(rs.getString("email"));
//                account.setPassword(rs.getString("password"));
//                account.setIs_admin(rs.getBoolean("is_admin"));
//                account.setName(rs.getString("name"));
//                account.setPhone(rs.getString("phone"));
//                account.setAddress(rs.getString("address"));
//                return account;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    
//    public boolean checkEmailExisted(String email) {
//        try {
//            String sql = "SELECT * FROM Account WHERE email = ?";
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, email);
//            ResultSet rs = stm.executeQuery();
//            if (rs.next()) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return false;
//    }
//    
//    public void addAccount(Account account) {
//        String sql = "INSERT INTO [Account] ([email], [password], [is_admin], [name])\n"
//                + " VALUES(?,?,?,?)";
//        try {
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, account.getEmail());
//            stm.setString(2, account.getPassword());
//            stm.setBoolean(3, account.isIs_admin());
//            stm.setString(4, account.getName());
//            stm.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }   
//    
    public void updateAccount(Account account) {
        String sql = "UPDATE [Account] SET [Password] = ? \n"
                + " WHERE [Email] = ? ";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, account.getPassword());
            stm.setString(2, account.getEmail());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
//    public void updateProfile(Account account) {
//        String sql = "UPDATE [Account] SET [name] = ?, [phone] = ?, [address] = ? \n"
//                + " WHERE [email] = ? ";
//        try {
//            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setString(1, account.getName());
//            stm.setString(2, account.getPhone());
//            stm.setString(3, account.getAddress());
//            stm.setString(4, account.getEmail());
//            stm.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    } 
    
    
}
