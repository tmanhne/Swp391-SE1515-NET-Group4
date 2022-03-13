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
import model.OrderOnAdmin;
import model.Orders;

/**
 *
 * @author Hfyl
 */
public class OrderDAO extends DBConnection {

    public OrderDAO() {
    }

    public int setFlagStatus(String orderId, String status) throws SQLException {
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " UPDATE [dbo].[Orders] "
                + "   SET [Status] = ? "
                + " WHERE [OrderID] = ? ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setString(2, orderId);
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return result;
    }

    public ArrayList<OrderOnAdmin> getOrdersAdmin() throws SQLException {
        ArrayList<OrderOnAdmin> lst = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT o.OrderID, c.CustomerName, o.OrderDate, o.Ship, o.PaymentMethod FROM "
                + " (SELECT * FROM Orders) AS o "
                + " INNER JOIN "
                + " (SELECT * FROM Customer) AS c "
                + " ON o.CustomerID = c.CustomerID "
                + " WHERE o.Status = 'Waitting' ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(new OrderOnAdmin(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5)));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return lst;
    }

    public String insertOrder(String customerId, String oddate) throws Exception {
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
            while (rs.next()) {
                orderId = rs.getString(1);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return orderId;
    }

    public ArrayList<Orders> getOrderByCustomerID(String customerId) throws SQLException {
        ArrayList<Orders> lst = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [dbo].[Orders] WHERE [CustomerID] = ? ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, customerId);
            rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(new Orders(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6)));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return lst;
    }

    public Orders getOrderByOrderID(String orderId) throws SQLException {
        Orders order = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [dbo].[Orders] WHERE [OrderID] = ? ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, orderId);
            rs = ps.executeQuery();
            if (rs.next()) {
                order = new Orders(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return order;
    }

    public int cancelOrder(String orderId) throws SQLException {
        int result = 0;
        Orders order = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM [dbo].[Orders] WHERE OrderID = ? ";
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
