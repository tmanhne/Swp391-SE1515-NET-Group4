/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 VUDM               BooksDAO
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import dal.DBConnection;
import java.util.List;

/**
 * The class contain method to contact with database
 *
 * @author vudm
 */
public class BooksDAO extends DBConnection {

    /**
     * Get all products from database
     *
     * @param
     * @return ArrayList books
     */
    public ArrayList<Book> getAllBooks() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
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
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));
                book.setUnitInStock(rs.getInt("UnitInStock"));
                // get book authors follow ProductID
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return books;
    }

    /**
     * Get top 3 best seller products from database
     *
     * @param
     * @return ArrayList books
     */
    public ArrayList<Book> getBestSellerBooks() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
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
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));

                // get book authors follow ProductID
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return books;
    }

    /**
     * Get top 2 highest price products from database
     *
     * @return ArrayList books
     */
    public ArrayList<Book> getHighestPriceBooks() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
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
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));

                // get book authors follow ProductID
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return books;
    }

    /**
     * Get all products by name from database
     *
     * @param name was searching name
     * @return ArrayList books
     */
    public ArrayList<Book> getBookByName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
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
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));

                // get book authors follow ProductID
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return books;
    }

    public Book getBookById(int pid) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        Book book = new Book();
        String sql = "SELECT * FROM dbo.Products WHERE ProductID = ?";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setInt(1, pid);
            rs = ps.executeQuery();
            //initialize AuthorsDAO object
            au = new AuthorsDAO();
            //assign data to books
            while (rs.next()) {

                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));

                // get book authors follow ProductID
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));

            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return book;
    }

    /**
     * Get total product
     *
     * @return total product quantity
     */
    public int getTotalProduct() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Book book = new Book();
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
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return 0;
    }

    /**
     * Get product by paging
     *
     * @param index was page number
     * @return listing has 3 products on 1 page
     */
    public List<Book> pagingProduct(int index) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Book> books = new ArrayList<>();
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
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));
                book.setUnitInStock(rs.getInt("UnitInStock"));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return books;
    }

//    public static void main(String[] args) {
//        BooksDAO book = new BooksDAO();
//        List<Book> list = book.pagingProduct(2);
//        for (Book a : list) {
//            System.out.println(a);
//        }
//
//    }

}
