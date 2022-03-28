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
import java.text.SimpleDateFormat;
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

    public ArrayList<Integer> getGroupYear() throws SQLException {
        ArrayList<Integer> lst = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT YEAR(OrderDate) FROM Orders WHERE [Status] = 'Waitting' GROUP BY YEAR(OrderDate) ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(rs.getInt(1));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return lst;
    }

    public ArrayList<String> getGroupDate(String year) throws SQLException {
        ArrayList<String> lst = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT OrderDate FROM Orders WHERE YEAR(OrderDate) = ? AND [Status] = 'Waitting' GROUP BY OrderDate  ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, year);
            rs = ps.executeQuery();
            SimpleDateFormat format = new SimpleDateFormat("MM/dd");
            while (rs.next()) {
                lst.add(format.format(rs.getDate(1)));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return lst;
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

    public ArrayList<OrderOnAdmin> getOrdersAdmin(String date) throws SQLException {
        ArrayList<OrderOnAdmin> lst = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT o.OrderID, c.CustomerName, o.OrderDate, od.Total, o.Ship, o.PaymentMethod "
                + "	FROM (SELECT * FROM Orders WHERE OrderDate = ?) AS o "
                + "	INNER JOIN  "
                + "	(SELECT OrderID, SUM(Quantity*UnitPrice) AS Total FROM OrderDetail GROUP BY OrderID) AS od "
                + "	ON od.OrderID = o.OrderID "
                + "	INNER JOIN dbo.Customer AS c "
                + "	ON c.CustomerID = o.CustomerID "
                + "	WHERE o.Status = 'Waitting'";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                lst.add(new OrderOnAdmin(rs.getString(1),
                        rs.getString(2),
                        rs.getDate(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
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
                + "            ('OD'+CAST((SELECT IIF(Count(*)=0,1,(SELECT TOP(1)CAST(SUBSTRING(OrderID,3,10)AS INT)+1 FROM Orders ORDER BY CAST(SUBSTRING(OrderID,3,10)AS INT) DESC)) FROM Orders) AS VARCHAR(10)), "
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
