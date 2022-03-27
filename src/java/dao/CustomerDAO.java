/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 ThongCT               Second Implement
 */
package dao;

import dal.DBConnection;
import interfaceDAO.IAccountDAO;
import interfaceDAO.ICustomerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Customer;
import model.FeedBack;

/**
 *
 * @author Thongchu
 */
public class CustomerDAO extends DBConnection implements ICustomerDAO {

    /**
     *
     * @param NO
     * @return return all FeedBack of member
     */
    public List<Customer> getAllCustomer() throws Exception  {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Customer> customers = new ArrayList<>();
        try {
            String sql = "select * from Customer";
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // IF database have feedback of customer            
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomerID(rs.getString(1));
                customer.setAccountID(rs.getString(2));
                customer.setCustomerName(rs.getString(3));
                customer.setDob(rs.getDate(4));
                customer.setAddress(rs.getString(5));
                customers.add(customer);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
        return customers;
    }

    public String addCustomer(Customer customer) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String customerId = null;
        String sql = "INSERT INTO [dbo].[Customer] "
                + "           ([CustomerID] "
                + "           ,[AccountID] "
                + "           ,[CustomerName] "
                + "           ,[Address]) "
                + "           OUTPUT INSERTED.[CustomerID] "
                + "     VALUES "
                + "           ('CUS'+CAST((SELECT COUNT(*)+1 FROM Customer) AS VARCHAR(10)) "
                + "           , ? "
                + "           , ? "
                + "           , ? )";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, customer.getAccountID());
            ps.setString(2, customer.getCustomerName());
            ps.setString(3, customer.getAddress());
            rs = ps.executeQuery();
            while(rs.next()){
                customerId = rs.getString(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
        return customerId;
    }

    public int updateCustomer(Customer customer) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "UPDATE [dbo].[Customer]\n"
                + "   SET [Address] = ? "
                + " WHERE CustomerID = ? ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, customer.getAddress());
            ps.setString(2, customer.getCustomerID());
            result = ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
        return result;
    }

    public Customer getCustomer(String accountId) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;
        try {
            String sql = " SELECT * FROM Customer WHERE [AccountID] = ? ";
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, accountId);
            rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                customer.setCustomerID(rs.getString(1));
                customer.setAccountID(rs.getString(2));
                customer.setCustomerName(rs.getString(3));
                customer.setDob(rs.getDate(4));
                customer.setAddress(rs.getString(5));
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
        return customer;
    }

    @Override
    public Customer getAccountByEmail(String email) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Customer customer = null;
        try {
            String sql = " SELECT * FROM Customer WHERE [EMAIL] = ? ";
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();

            while (rs.next()) {
                customer = new Customer();
                customer.setCustomerID(rs.getString(1));
                customer.setAccountID(rs.getString(2));
                customer.setCustomerName(rs.getString(3));
                customer.setDob(rs.getDate(4));
                customer.setAddress(rs.getString(5));
                break;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
        return customer;
    }

    @Override
    public void updatePasswordCustomerByEmail(String email, String abc123) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
