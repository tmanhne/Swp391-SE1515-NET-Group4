
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
        Connection con = super.open();
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Category> categories = new ArrayList<>();
        try {
            String sql = "select * from Category";
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

    public ArrayList<Category> getCategory() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Category> category = new ArrayList<>();
        String sql = "select * from Category";

        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //assign data to books
            while (rs.next()) {
                while (rs.next()) {
                    category.add(new Category(rs.getString(1),
                            rs.getString(2)));

                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.close(con, ps, rs);
        }

        return category;
    }
}
