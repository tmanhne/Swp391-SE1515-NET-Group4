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
import model.OrderDetail;

/**
 *
 * @author Hfyl
 */
public class OrderDetailDAO extends DBConnection {

    public OrderDetailDAO() {
    }

    public int insertODDetail(OrderDetail od) throws Exception{
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[OrderDetail] "
                + "           ([OrderID] "
                + "           ,[ProductID] "
                + "           ,[Quantity] "
                + "           ,[UnitPrice]) "
                + "     VALUES\n"
                + "           ( ? , ? , ? , ? )";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, od.getOrderID());
            ps.setString(2, od.getProductID());
            ps.setInt(3, od.getQuantity());
            ps.setDouble(4, od.getUnitPrice());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return result;
    }
}
