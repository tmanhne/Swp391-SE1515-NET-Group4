/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Hfyl
 */
public class OrderDAO extends DBConnection{

    public OrderDAO() {
    }

    public String insertOrder(String customerId, String oddate) throws Exception{
        String sql = "INSERT INTO [dbo].[Orders] "
                + "           ([OrderID] "
                + "           ,[CustomerID] "
                + "           ,[OrderDate] "
                + "           ,[Ship] "
                + "           ,[Status] "
                + "           ,[PaymentMethod]) "
                + "           OUTPUT INSERTED.[OrderID] "
                + "     VALUES "
                + "            ('OD'+CAST((SELECT COUNT(*)+1 FROM Orders) AS VARCHAR(10)), "
                + "            ? , "
                + "            ? , "
                + "            ? , "
                + "            ? , "
                + "            ? )";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String orderId = null;
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, customerId);
            ps.setString(2, oddate);
            ps.setString(3, "0");
            ps.setString(4, "Waitting");
            ps.setString(5, "Cash");
            rs = ps.executeQuery();
            while(rs.next()){
                orderId= rs.getString(1);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return orderId;
    }
}
