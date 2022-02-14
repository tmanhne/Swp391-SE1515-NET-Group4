/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaceDAO.ICategoryDAO;
import java.sql.Connection;
import model.Category;
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
public class CategoryDAO extends dal.DBConnection implements ICategoryDAO{

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
}
