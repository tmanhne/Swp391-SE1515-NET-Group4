/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-08         1.0               VUDMHE140017      First Implement
 */

package dao;

import interfaceDAO.IProductDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;
import java.util.List;

/**
 * The class contain method to contact with database
 *
 * @author vudm
 */
public class ProductDAO extends dal.DBConnection implements IProductDAO {
    
    /**
     * The method is used get all products from database
     *
     * @return ArrayList products
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Product> getAllProducts() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT *\n "
                + "FROM\n "
                + "Products\n ";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //initialize AuthorsDAO object
            au = new AuthorsDAO();

            //assign data to books
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setImagePath(rs.getString("ImagePath"));
                product.setDescription(rs.getString("Description"));
                product.setUnitPrice(rs.getFloat("UnitPrice"));
                product.setUnitInStock(rs.getInt("UnitInStock"));
                // get book authors follow ProductID
                product.setAuthors(au.getAuthorsByBookId(product.getProductID()));
                products.add(product);
            }

        }  catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return products;
    }

    /**
     * Get top 3 best seller products from database
     *  @return ArrayList products
     *  @throws java.sql.SQLException
     */
    @Override
    public ArrayList<Product> getBestSellerProducts() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Product> products = new ArrayList<>();
        String sql = "select top 3 *\n"
                + "from Products\n"
                + "order by UnitInStock desc";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //initialize AuthorsDAO object
            au = new AuthorsDAO();

            //assign data to books
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setImagePath(rs.getString("ImagePath"));
                product.setDescription(rs.getString("Description"));
                product.setUnitPrice(rs.getFloat("UnitPrice"));

                // get book authors follow ProductID
                product.setAuthors(au.getAuthorsByBookId(product.getProductID()));
                products.add(product);
            }

        }  catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return products;
    }

    /**
     * Get top 2 highest price products from database
     * @return ArrayList products
     * @throws java.sql.SQLException
     * 
     */
    @Override
    public ArrayList<Product> getHighestPriceProducts() throws SQLException{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Product> products = new ArrayList<>();
        String sql = "select top 2 *\n"
                + "from Products\n"
                + "order by UnitPrice desc";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //initialize AuthorsDAO object
            au = new AuthorsDAO();

            //assign data to books
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getString("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setImagePath(rs.getString("ImagePath"));
                product.setDescription(rs.getString("Description"));
                product.setUnitPrice(rs.getFloat("UnitPrice"));

                // get book authors follow ProductID
                product.setAuthors(au.getAuthorsByBookId(product.getProductID()));
                products.add(product);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return products;
    }

    /**
     * Get all products by name from database
     *
     * @param name was searching name
     * @return ArrayList books
     */
    @Override
    public ArrayList<Product> getProductByName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Product> books = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE ProductName LIKE ? ";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + name + "%");
            rs = ps.executeQuery();

            //initialize AuthorsDAO object
            au = new AuthorsDAO();

            //assign data to books
            while (rs.next()) {
                Product book = new Product();
                book.setProductID(rs.getString("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setImagePath(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));

                // get book authors follow ProductID
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return books;
    }

    public List<Product> getBookByPage(List<Product> fullList, int start, int end) {
        List<Product> pageList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            pageList.add(fullList.get(i));
        }
        return pageList;
    }

     /**
     * Get top 2 highest price products from database
     * @param pid is a <code>String</code>
     * @return ArrayList products
     * @throws java.sql.SQLException
     * 
     */
    @Override
    public Product getProductById(String pid) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        Product product = new Product();
        String sql = "SELECT * FROM dbo.Products WHERE ProductID = ?";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, pid);
            rs = ps.executeQuery();
            //initialize AuthorsDAO object
            au = new AuthorsDAO();
            //assign data to books
            while (rs.next()) {
                product.setProductID(rs.getString("ProductID"));
                product.setProductName(rs.getString("ProductName"));
                product.setImagePath(rs.getString("ImagePath"));
                product.setCreateDate(rs.getDate("CreatedDate"));
                product.setDescription(rs.getString("Description"));
                product.setUnitPrice(rs.getFloat("UnitPrice"));
                product.setUnitInStock(rs.getInt("UnitInStock"));
                product.setIsContinue(rs.getBoolean("IsContinue"));
                product.setRatting(rs.getInt("Ratting"));
                // get book authors follow ProductID
                product.setAuthors(au.getAuthorsByBookId(product.getProductID()));
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return product;
    }

    @Override
    public int getTotalProduct() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Product book = new Product();
        String sql = "SELECT COUNT(*)FROM Products";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return 0;
    }

    @Override
    public List<Product> pagingProduct(int index) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Product> books = new ArrayList<>();
        String sql = "SELECT * FROM Products\n"
                + "ORDer by ProductID\n"
                + "offset ? rows fetch next 3 rows only;";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            rs = ps.executeQuery();

            while (rs.next()) {
                Product book = new Product();
                book.setProductID(rs.getString("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setImagePath(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));
                book.setUnitInStock(rs.getInt("UnitInStock"));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return books;
    }

    @Override
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
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return result;
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

}

