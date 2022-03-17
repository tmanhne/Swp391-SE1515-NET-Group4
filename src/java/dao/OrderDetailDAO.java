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
import java.util.ArrayList;
import model.OrderDetail;
import model.OrderDetailHistory;

/**
 *
 * @author Hfyl
 */
public class OrderDetailDAO extends DBConnection {

    public OrderDetailDAO() {
    }

    public int insertODDetail(OrderDetail od) throws Exception {
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

    public ArrayList<OrderDetailHistory> getOrderDetailByOrderID(String orderId) throws SQLException {
        ArrayList<OrderDetailHistory> lst = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT p.ProductID, p.ProductName, p.ImagePath, od.Quantity, od.UnitPrice FROM "
                + " Products AS p "
                + " INNER JOIN "
                + " (SELECT * FROM OrderDetail WHERE OrderID = ? ) AS od "
                + " ON p.ProductID = od.ProductID ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, orderId);
            rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(new OrderDetailHistory(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDouble(5)));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return lst;
    }

    public int cancelOrderDetail(String orderId) throws SQLException {
        int result = 0;
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " DELETE FROM [dbo].[OrderDetail] WHERE OrderID = ? ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, orderId);
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
