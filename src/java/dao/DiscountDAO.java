/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaceDAO.IDiscount;
import interfaceDAO.IProductDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DisCount;
import model.Reports;

/**
 *
 * @author Thongchu
 */
public class DiscountDAO  extends dal.DBConnection implements IDiscount {
    
    /**
     * This method is used to insert report to database with report object are parameter input
     * @param reports is an object <code>Reports</code> input
     * @throws java.lang.Exception
     */
    @Override
    public void insertDiscount(DisCount discount) throws Exception {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "INSERT INTO [dbo].[Discount]\n" +
                    "           ([DiscountCODE]\n" +
                    "           ,[CustomerID]\n" +
                    "           ,[ProductID]\n" +
                    "           ,[IsContinue]\n" +
                    "           ,[DiscountValue])\n" +
                    "     VALUES\n" +
                    "           (?,?,?,?,?)";
        try {
            
            con = super.open();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, discount.getDiscountCODE());

            ps.setString(2, discount.getCustomerID());
            ps.setString(3, "1");
            ps.setBoolean(4, true);
            ps.setInt(5, discount.getDiscountValue());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }finally {
            //close connection
            super.close(con, ps, rs);
        }
    }
    
}
