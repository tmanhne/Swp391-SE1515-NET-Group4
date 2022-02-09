/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Book;

/**
 *
 * @author admin
 */
public class DBContext {
    Connection connection;
    
    public DBContext() {

        try {
            String user = "sa";
            String pass = "Anhvu123";
            String url = "jdbc:sqlserver://localhost:1433;databaseName=BookShops";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Book> getAllBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "SELECT *\n "
                + "FROM\n "
                + "Products\n ";

        PreparedStatement st;
        try {
            st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));

                book.setAuthors(getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }

    public ArrayList<String> getAuthorsByBookId(int bookId) {
        ArrayList<String> authors = new ArrayList();

        String sql = "SELECT *\n"
                + "from ProAu,Authors\n"
                + " where ProAu.AuthorID = Authors.AuthorID\n"
                + " and ProAu.ProductID = ?";

        PreparedStatement st;

        try {
            st = connection.prepareStatement(sql);

            st.setInt(1, bookId);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                String author = rs.getString("AuthorName");

                authors.add(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return authors;
    }

    public ArrayList<Book> getBestSellerBooks() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select top 5 *\n"
                + "from Products\n"
                + "order by UnitInStock desc";

        PreparedStatement st;
        try {
            st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));
                book.setAuthors(getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }

    public ArrayList<Book> getBookByStory() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=1";

        PreparedStatement st;
        try {
            st = connection.prepareStatement(sql);
            
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));
                book.setAuthors(getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }
    
    public ArrayList<Book> getBookByBook() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=2";

        PreparedStatement st;
        try {
            st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));
                book.setAuthors(getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }
    
    public ArrayList<Book> getBookByNovel() {
        ArrayList<Book> books = new ArrayList<>();
        String sql = "select * \n"
                + "from Products,Category\n"
                + "where Products.CategoryID=Category.CategoryID\n"
                + "and Products.CategoryID=3";

        PreparedStatement st;
        try {
            st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setProductID(rs.getInt("ProductID"));
                book.setProductName(rs.getString("ProductName"));
                book.setPathImage(rs.getString("ImagePath"));
                book.setDescription(rs.getString("Description"));
                book.setUnitPrice(rs.getFloat("UnitPrice"));
                book.setAuthors(getAuthorsByBookId(book.getProductID()));
                books.add(book);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }
}
