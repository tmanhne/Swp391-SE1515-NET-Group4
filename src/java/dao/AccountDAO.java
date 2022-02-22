/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBConnection;
import interfaceDAO.IAccountDAO;
import interfaceDAO.IAuthorsDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author Thongchu
 */
public class AccountDAO extends DBConnection implements IAccountDAO {

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
    
    public Account getAccountByEmail(String email) {
        try {
            String sql = "SELECT * FROM Account WHERE [Email] = ?";
            Connection con = super.open();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setAccountID(rs.getString(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setRole(rs.getString(6));
                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
    
}
