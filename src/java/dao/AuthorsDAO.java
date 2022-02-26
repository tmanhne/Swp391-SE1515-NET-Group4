/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-07      1.0                 VUDM               AuthorsDAO
 */

package dao;

import dal.DBConnection;
import interfaceDAO.IAuthorsDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;

/**
 * The class contain method to contact with database
 * @author vudm
 */
public class AuthorsDAO extends DBConnection implements IAuthorsDAO{
    
    /**
     * Get author by bookId from database
     * @param bookId is the variable passed
     * @return authors
     */
    
    @Override
    public ArrayList<String> getAuthorsByBookId(String bookId) throws Exception{
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
        } catch (Exception ex) {
             ex.printStackTrace();
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return authors;
    }
}
