package dao;

import interfaceDAO.IProductDAO;
import java.sql.Connection;
import java.sql.Date;
import model.Category;
import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Riel
 */
public class ProductDAO extends dal.DBConnection implements IProductDAO{

    public void insertProduct(Product p) {
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[Products]\n" +
                "           ([ProductID]\n" +
                "           ,[ProductName]\n" +
                "           ,[ImagePath]\n" +
                "           ,[CreatedDate]\n" +
                "           ,[Description]\n" +
                "           ,[UnitPrice]\n" +
                "           ,[UnitInStock]\n" +
                "           ,[IsContinue]\n" +
                "           ,[Ratting]\n" +
                "           ,[CategoryID])\n" +
                "     VALUES\n" +
                "           (?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?\n" +
                "           ,?)";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, p.getProductID());
            stm.setString(2, p.getProductName());
            stm.setString(3, p.getImagePath());
            stm.setDate(4, new java.sql.Date(p.getCreateDate().getTime()) );
            stm.setString(5, p.getDescription());
            stm.setDouble(6, p.getUnitPrice());
            stm.setInt(7, p.getUnitInStock());
            stm.setBoolean(8, p.isIsContinue());
            stm.setInt(9, p.getRatting());
            stm.setString(10, p.getCategoryID());
            stm.executeUpdate();
        } 
        catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            super.close(con, ps, rs);
        }
    }
    
}
