/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 ThongCT               Second Implement
 */
package dao;

import dal.DBConnection;
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
public class CustomerDAO extends DBConnection {
    /**
     *
     * @param NO 
     * @return return all FeedBack of member  
     */
     public List<Customer> getAllCustomer() throws Exception {
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
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        finally{
            super.close(con, ps, rs);
        }
        return customers;
    }
}
