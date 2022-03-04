/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 ThongCT               Second Implement
 */
package dao;

import interfaceDAO.IProductDAO;
import java.sql.Connection;
import java.sql.Date;
import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Customer;

/**
 *
 * @author Riel
 */
public class ProductDAO extends dal.DBConnection implements IProductDAO {

    @Override
    public void insertProduct(Product p) throws Exception {
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
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
    }

    @Override
    public int updateBook(Product product) throws Exception {
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
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return result;
    }

    public Product getProductById(String productID) throws Exception {
        Product product = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM [dbo].[Products] WHERE [ProductID]= ? ";
        AuthorsDAO au = new AuthorsDAO();
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, productID);
            rs = ps.executeQuery();

            while (rs.next()) {
                String ProductName = rs.getString("ProductName");
                String ImagePath = rs.getString("imagePath");
                Date CreatedDate = rs.getDate("CreatedDate");
                String Description = rs.getString("Description");
                float UnitPrice = rs.getFloat("UnitPrice");
                int UnitInStock = rs.getInt("UnitInStock");
                boolean IsContinue = rs.getBoolean("IsContinue");
                int Ratting = rs.getInt("Ratting");
                String CategoryID = rs.getString("CategoryID");
                // ArrayList<String> author = au.getAuthorsByBookId(product.getProductID());
                product = new Product(productID, ProductName, ImagePath, CreatedDate, Description, UnitPrice, UnitInStock, IsContinue, Ratting, CategoryID);
                //          product = new Product(productID, ProductName, ImagePath, CreatedDate, Description, UnitPrice, UnitInStock, IsContinue, Ratting, CategoryID)
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return product;
    }

    public void removeProduct(String pid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM dbo.Products WHERE ProductID = ?";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
    }
    
    /**
     *
     * @param NO 
     * @return return all FeedBack of member  
     */
     public List<Product> getAllProduct() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> products = new ArrayList<>();
        try {
            String sql = "select * from Products";
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // IF database have feedback of customer            
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString(1));
                product.setProductName(rs.getString(2));
                product.setImagePath(rs.getString(3));
                product.setCreateDate(rs.getDate(4));
                product.setDescription(rs.getString(5));
                product.setUnitPrice(rs.getDouble(6));
                product.setUnitInStock(rs.getInt(7));
                product.setIsContinue(rs.getBoolean(8));
                product.setRatting(rs.getInt(9));
                product.setCategoryID(rs.getString(10));
                products.add(product);
            }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        finally{
            super.close(con, ps, rs);
        }
        return products;
    }

}
