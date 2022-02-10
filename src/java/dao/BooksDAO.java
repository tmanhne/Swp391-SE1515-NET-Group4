/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author Hfyl
 */
public class BooksDAO extends DBConnection {

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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBestSellerBooks() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select top 5 *\n"
                + "from Products\n"
                + "order by UnitInStock desc";

        try {
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBookByStory() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=1";

        try {
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBookByBook() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=2";

        try {

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
            super.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBookByNovel() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=3";

        try {
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.close(con, ps, rs);
        }

        return books;
    }

    public ArrayList<Book> getBookByName(String name) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Products WHERE ProductName LIKE ? ";

        try {
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

                // get book authors via AuthorsDAO
                book.setAuthors(au.getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.close(con, ps, rs);
        }

        return books;
    }
}
