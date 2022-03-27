/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-17         1.0               VUDMHE140017      First Implement
 */
package dao;

import dal.DBConnection;
import interfaceDAO.IAccountDAO;
import interfaceDAO.IEncryptPasswordDAO;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import model.Account;

/**
 * The class contain method to check account for database
 *
 * @author vudm
 */
public class AccountDAO extends DBConnection implements IAccountDAO {

    /**
     * The method used to check account login to system
     *
     * @param username is a <code>String</code>
     * @param password is a <code>String</code> return null
     * @throws java.sql.SQLException
     */
    @Override
    public Account checkAccountByUsernameAndPassword(String username, String password) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            String sql = "select * from Accounts\n"
                    + " where Username = ?";

            Account account = new Account();
            IEncryptPasswordDAO encryptPasswordDAO = new EncryptPasswordDAO();
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()) {//assign data to authors
                String encryptedPassword = rs.getString("Password");
                String salt = rs.getString("Salt");
                String pass = encryptPasswordDAO.encryptPassword(password, Base64.getDecoder().decode(salt));

                if (pass.equals(encryptedPassword)) { // check pass encrypted 
                    account.setAccountID(rs.getString("AccountID"));
                    account.setUserName(rs.getString("Username"));

                    account.setRole(rs.getString("Role"));
                    return account;
                }
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return null;
    }

    /**
     * This method is used to create an account to access in system
     *
     * @param account is an object<code>Account</code>
     * @throws java.sql.SQLException
     */
    @Override
    public void registerAccount(Account account) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "INSERT INTO [Accounts] ([AccountID],[Username], [Password], [Email], [Phone], [Role], [Salt])\n"
                + " VALUES(?,?,?,?,?,?,?)";
        try {

            con = super.open();
            ps = con.prepareStatement(sql);

            ps.setString(1, account.getAccountID());
            IEncryptPasswordDAO encryptPasswordDAO = new EncryptPasswordDAO();
            byte[] salt = encryptPasswordDAO.getSalt();

            String encryptedPassword = encryptPasswordDAO.encryptPassword(account.getPassword(), salt);

            ps.setString(2, account.getUserName());
            ps.setString(3, encryptedPassword);
            ps.setString(4, account.getEmail());
            ps.setString(5, account.getPhone());
            ps.setString(6, account.getRole());
            ps.setString(7, Base64.getEncoder().encodeToString(salt));
            ps.executeUpdate();
        } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
    }

    /**
     * This method is used to check username existed in database
     *
     * @param username is <code>String</code>
     * @return true
     * @throws java.sql.SQLException
     */
    @Override
    public boolean isUsernameExist(String username) throws Exception {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from Accounts where Username = ? ";

        PreparedStatement st;

        try {
            con = super.open();
            ps = con.prepareStatement(sql);

            ps.setString(1, username);

            rs = ps.executeQuery();

            if (!rs.isBeforeFirst()) {
                return false;
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return true;
    }

    /**
     * The method is used to update account of user
     *
     * @param account is account who need to update
     * @throws java.sql.SQLException
     */
    @Override
    public void updateAccount(Account account) throws SQLException {
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [dbo].[Accounts] \n"
                + "   SET [Password] = ?\n"
                + " WHERE [Email] = ?\n";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, account.getPassword());
            stm.setString(2, account.getEmail());
            stm.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
    }

    /**
     * The method is used to get account by email
     *
     * @param email is string
     * @return the account who have email equal first parameter
     * @throws java.sql.SQLException
     */
    @Override
    public Account getAccountByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM Accounts WHERE [Email] = ?";
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Account account = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                account = new Account();
                account.setAccountID(rs.getString(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setEmail(rs.getString(4));
                account.setPhone(rs.getString(5));
                account.setRole(rs.getString(6));
                return account;
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
        return account;
    }

    /**
     * The method is used to update account of user
     *
     * @param userName is <code>String</code>
     * @return Account
     * @throws java.sql.SQLException
     */
    @Override
    public Account getAccount(String userName) throws SQLException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Account account = new Account();
        String sql = "SELECT * FROM Accounts WHERE Username = ?";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, userName);
            rs = ps.executeQuery();

            //assign data to books
            while (rs.next()) {
                account.setUserName(rs.getString("userName"));
                account.setPassword(rs.getString("password"));
                account.setEmail(rs.getString("email"));
                account.setPhone(rs.getString("phone"));

            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return account;
    }

    /**
     * The method is used to update profile of user
     *
     * @param account is an object<code>Account</code>
     * @throws java.sql.SQLException
     */
    @Override
    public void updateProfile(Account account) throws SQLException {
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [dbo].[Accounts] SET [Password]=?, [Email]=?,[Phone]=? WHERE Username = ?";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, account.getPassword());
            stm.setString(2, account.getEmail());
            stm.setString(3, account.getPhone());
            stm.setString(4, account.getUserName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
    }

    /**
     * The method is used to update account of user
     *
     * @param account is account who need to update
     * @throws java.sql.SQLException
     */
    public void updateAccount(String email, String password, String saltsString) throws SQLException {
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE [dbo].[Accounts] \n"
                + "   SET [Password] = "+password+"\n"
                + "   ,[Salt] = "+saltsString+"\n"
                + " WHERE [Email] = "+email+"\n";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
//            stm.setString(1, password);
//            stm.setString(2, saltsString);
//            stm.setString(3, email);
            
            stm.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
    }

    @Override
    public void updatePasswordCustomerByEmail(String email, String abc123) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
