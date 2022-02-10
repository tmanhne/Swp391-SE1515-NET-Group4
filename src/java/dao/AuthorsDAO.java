/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 *
 * @author Hfyl
 */
public class AuthorsDAO extends DBConnection{

    public ArrayList<String> getAuthorsByBookId(int bookId) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> authors = new ArrayList();

        String sql = "SELECT *\n"
                + "from ProAu,Authors\n"
                + " where ProAu.AuthorID = Authors.AuthorID\n"
                + " and ProAu.ProductID = ?";

        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setInt(1, bookId);
            rs = ps.executeQuery();

            while (rs.next()) {
                String author = rs.getString("AuthorName");
                authors.add(author);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AuthorsDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            super.close(con, ps, rs);
        }

        return authors;
    }
}
