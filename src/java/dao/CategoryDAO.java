
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import dal.DBConnection;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Product;

/**
 *
 * @author phamthithi
 */
public class CategoryDAO extends DBConnection {

    public List<Category> getAllCategories() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Category> categories = new ArrayList<>();
        try {
            String sql = "select * from Category";
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setCategoryID(rs.getString("CategoryID"));
                category.setCategoryName(rs.getString("CategoryName"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categories;
    }

    public List<Category> getCategoryByPage(List<Category> fullList, int start, int end) {
        List<Category> pageList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            pageList.add(fullList.get(i));
        }
        return pageList;
    }

    public Category getCategoryById(String categoryID) {
        Category cate = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT * FROM dbo.Category WHERE CategoryID = ? ";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, categoryID);
            rs = ps.executeQuery();
            while (rs.next()) {
//                String categoryID = rs.getString("ProductName");
                String categoryName = rs.getString("CategoryName");
                cate = new Category(categoryID, categoryName);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return cate;
    }

    public int updateCategory(Category cate) {
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE dbo.Category "
                + "SET CategoryName = ? "
                + "WHERE CategoryID = ? ";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(2, cate.getCategoryID());
            ps.setString(1, cate.getCategoryName());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return result;
    }

    public void insertCategory(Category cate) {
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO dbo.Category "
                + "( CategoryID, CategoryName ) "
                + "VALUES  ( ?, ?)";
        try {
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cate.getCategoryID());
            stm.setString(2, cate.getCategoryName());
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con, ps, rs);
        }
    }
}
