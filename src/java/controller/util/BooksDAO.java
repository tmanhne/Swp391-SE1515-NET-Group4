/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;
import model.DBConnection;

/**
 *
 * @author Hfyl
 */
public class BooksDAO {

    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private AuthorsDAO au;

    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT *\n "
                + "FROM\n "
                + "Products\n ";
        
        try {
            con = DBConnection.open();
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBestSellerBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select top 5 *\n"
                + "from Products\n"
                + "order by UnitInStock desc";

        try {
            con = DBConnection.open();
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBookByStory() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=1";

        try {
            con = DBConnection.open();
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBookByBook() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=2";

        try {
            con = DBConnection.open();
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBookByNovel() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=3";

        try {
            con = DBConnection.open();
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            DBConnection.close(con, ps, rs);
        }

        return books;
    }

}
