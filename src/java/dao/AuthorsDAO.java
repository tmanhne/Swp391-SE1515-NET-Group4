/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-07         1.0               VUDMHE140017      First Implement
 */
package dao;

import dal.DBConnection;
import interfaceDAO.IAuthorsDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;

/**
 * The class contain method to get authors from database
 * @author vudm
 */
public class AuthorsDAO extends DBConnection implements IAuthorsDAO {

    /**
     *  The method is used to get author by bookId from database
     *
     * @param bookId is a <code>String</code>
     * @return authors
     * @throws java.sql.SQLException
     */
    @Override
    public ArrayList<String> getAuthorsByBookId(String bookId) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<String> authors = new ArrayList();

        String sql = "SELECT *\n"
                + "from ProAu,Authors\n"
                + " where ProAu.AuthorID = Authors.AuthorID\n"
                + " and ProAu.ProductID = ?";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, bookId);
            rs = ps.executeQuery();
            //assign data to authors
            while (rs.next()) {
                String author = rs.getString("AuthorName");
                authors.add(author);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return authors;
    }
}
