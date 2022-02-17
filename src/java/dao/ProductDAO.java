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
import model.Book;

/**
 *
 * @author Riel
 */
public class ProductDAO extends dal.DBConnection implements IProductDAO {

    public void insertProduct(Product p) {
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO [dbo].[Products]\n"
                + "           ([ProductID]\n"
                + "           ,[ProductName]\n"
                + "           ,[ImagePath]\n"
                + "           ,[CreatedDate]\n"
                + "           ,[Description]\n"
                + "           ,[UnitPrice]\n"
                + "           ,[UnitInStock]\n"
                + "           ,[IsContinue]\n"
                + "           ,[Ratting]\n"
                + "           ,[CategoryID])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, p.getProductID());
            stm.setString(2, p.getProductName());
            stm.setString(3, p.getImagePath());
            stm.setDate(4, new java.sql.Date(p.getCreateDate().getTime()));
            stm.setString(5, p.getDescription());
            stm.setDouble(6, p.getUnitPrice());
            stm.setInt(7, p.getUnitInStock());
            stm.setBoolean(8, p.isIsContinue());
            stm.setInt(9, p.getRatting());
            stm.setString(10, p.getCategoryID());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int updateBook(Product product) {
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " UPDATE [dbo].[Products] "
                + "   SET [ProductName] = ?  "
                + "      ,[Description] = ?  "
                + "      ,[UnitPrice] = ?  "
                + "      ,[UnitInStock] = ?  "
                + "      ,[IsContinue] = ?  "
                + "      ,[Ratting] = ?  "
                + " WHERE [ProductID] = ? ";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getUnitPrice());
            ps.setInt(4, product.getUnitInStock());
            ps.setBoolean(5, product.isIsContinue());
            ps.setInt(6, product.getRatting());
            ps.setString(7, product.getProductID());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return result;
    }

    @Override
    public Product getProductById(String productID) {
        Product product = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [dbo].[Products]";

        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.execute();

            while (rs.next()) {
                String ProductName = rs.getString("ProductName");
                String ImagePath = rs.getString("ImagePath");
                Date CreatedDate = rs.getDate("CreatedDate");
                String Description = rs.getString("Description");
                float UnitPrice = rs.getFloat("UnitPrice");
                int UnitInStock = rs.getInt("UnitInStock");
                boolean IsContinue = rs.getBoolean("IsContinue");
                int Ratting = rs.getInt("Ratting");
                String CategoryID = rs.getString("CategoryID");
                product = new Product(productID, ProductName, ImagePath, CreatedDate, Description, UnitPrice, UnitInStock, IsContinue, Ratting, CategoryID);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return product;
    }

}
