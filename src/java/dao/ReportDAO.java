/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-03-03         1.0               VUDMHE140017      First Implement
 */
package dao;


import interfaceDAO.IReportDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Reports;

/**
 * The class contain all method to contacts with report from database
 * @author vudm
 */
public class ReportDAO extends dal.DBConnection implements IReportDAO{
    
     /**
     * This method is used to insert report to database with report object are parameter input
     * @param reports is an object <code>Reports</code> input
     * @throws java.lang.Exception
     */
    @Override
    public void insertReport(Reports reports) throws Exception {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "INSERT INTO [Reports] ([Title],[CustomerName], [Email], [Phone], [Insurance], [Descriptions],[Status],[AccountID],[Time])\n"
                + " VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            
            con = super.open();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, reports.getTitle());

            ps.setString(2, reports.getCustomerName());
            ps.setString(3, reports.getEmail());
            ps.setString(4, reports.getPhone());
            ps.setString(5, reports.getInsurance());
            ps.setString(6, reports.getDescriptions());
            ps.setString(7, reports.getStatus() );
            ps.setString(8, reports.getAccountID());
            ps.setDate(9, new java.sql.Date(reports.getTime().getTime()));
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }finally {
            //close connection
            super.close(con, ps, rs);
        }
    }
    
 
   
    
    /**
     * This method is used to get all reports by rid from database 
     * @param rid is Integer <code>int</code>
     * @return reportList is a array list <code>Reports</code>
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<Reports> getReportByID(int rid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Reports> rptList = new ArrayList<>();
        String sql = "SELECT * FROM Reports WHERE ReportID=? ";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setInt(1,rid);
            rs = ps.executeQuery();

            //initialize AuthorsDAO object

            //assign data to books
            while (rs.next()) {
                Reports reports = new Reports();
                reports.setReportID(rs.getInt("ReportID"));
                reports.setTitle(rs.getString("Title"));
                reports.setCustomerName(rs.getString("CustomerName"));
                reports.setEmail(rs.getString("Email"));
                reports.setPhone(rs.getString("Phone"));
                reports.setInsurance(rs.getString("Insurance"));
                reports.setDescriptions(rs.getString("Descriptions"));
                reports.setStatus(rs.getString("Status"));
                reports.setAccountID(rs.getString("AccountID"));
                reports.setTime(rs.getDate("Time"));

                rptList.add(reports);
            }

        } catch (SQLException ex) {
            throw ex;
        }  finally {
            //close connection
            super.close(con, ps, rs);
        }

        return rptList;
    }
    
    /**
     * This method is used to update reports to database 
     * @param reports is an object <code>Reports</code> input
     * @return result is <code>int</code>
     * @throws java.lang.Exception
     */
    @Override
    public int updateReport(Reports reports) throws Exception{
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " UPDATE [dbo].[Reports] "
                + "   SET [Status] = ?  "
                + " WHERE [ReportID] = ? ";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, reports.getStatus());
            ps.setInt(2, reports.getReportID());
            result = ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return result;
    }
    
    /**
     * This method is used to remove reports in database 
     * @param rid is Integer <code>int</code>
     * @throws java.lang.Exception
     */
    @Override
    public void removeReport(int rid) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM Reports WHERE ReportID = ?";
        try {
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setInt(1, rid);
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        } finally {
            super.close(con, ps, rs);
        }
    }
    

        /**
     * This method is used to count all reports from database 
     * @return 0
     * @throws java.lang.Exception
     */
    @Override
    public int getTotalReport() throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reports reports = new Reports();
        String sql = "SELECT COUNT(*)FROM Reports";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return 0;
    }
    
        /**
     * This method is used to get all reports follow index from database 
     * @param index is <code>int</code>
     * @return reportList is a array list <code>Reports</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<Reports> pagingReport(int index) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Reports> rptList = new ArrayList<>();
        String sql = "SELECT * FROM Reports\n"
                + "ORDer by ReportID\n"
                + "offset ? rows fetch next 3 rows only;";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            rs = ps.executeQuery();

            while (rs.next()) {
                Reports reports = new Reports();
                reports.setReportID(rs.getInt("ReportID"));
                reports.setTitle(rs.getString("Title"));
                reports.setCustomerName(rs.getString("CustomerName"));
                reports.setEmail(rs.getString("Email"));
                reports.setPhone(rs.getString("Phone"));
                reports.setInsurance(rs.getString("Insurance"));
                reports.setDescriptions(rs.getString("Descriptions"));
                reports.setStatus(rs.getString("Status"));
                reports.setAccountID(rs.getString("AccountID"));
                reports.setTime(rs.getDate("Time"));
                rptList.add(reports);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return rptList;
    }
    
    @Override
    public ArrayList<Reports> getReportByName(String title) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        AuthorsDAO au;
        ArrayList<Reports> rptList = new ArrayList<>();
        String sql = "SELECT * FROM Reports WHERE [Title] LIKE ? ";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + title.toUpperCase() + "%");
            rs = ps.executeQuery();

            //assign data to books
            while (rs.next()) {
               Reports reports = new Reports();
                reports.setReportID(rs.getInt("ReportID"));
                reports.setTitle(rs.getString("Title"));
                reports.setCustomerName(rs.getString("CustomerName"));
                reports.setEmail(rs.getString("Email"));
                reports.setPhone(rs.getString("Phone"));
                reports.setInsurance(rs.getString("Insurance"));
                reports.setDescriptions(rs.getString("Descriptions"));
                reports.setStatus(rs.getString("Status"));
                reports.setAccountID(rs.getString("AccountID"));
                reports.setTime(rs.getDate("Time"));
                rptList.add(reports);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return rptList;
    }
    
    
    @Override
    public List<Reports> pagingReportByTitle(String title,int index) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Reports> rptList = new ArrayList<>();
        String sql = "SELECT * FROM Reports WHERE [Title] LIKE ?\n"
                + "ORDer by ReportID\n"
                + "offset ? rows fetch next 3 rows only;";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + title.toUpperCase() + "%");
            ps.setInt(2, (index - 1) * 3);
            rs = ps.executeQuery();

            while (rs.next()) {
                Reports reports = new Reports();
                reports.setReportID(rs.getInt("ReportID"));
                reports.setTitle(rs.getString("Title"));
                reports.setCustomerName(rs.getString("CustomerName"));
                reports.setEmail(rs.getString("Email"));
                reports.setPhone(rs.getString("Phone"));
                reports.setInsurance(rs.getString("Insurance"));
                reports.setDescriptions(rs.getString("Descriptions"));
                reports.setStatus(rs.getString("Status"));
                reports.setAccountID(rs.getString("AccountID"));
                reports.setTime(rs.getDate("Time"));
                rptList.add(reports);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return rptList;
    }
    
    @Override
    public int getTotalReportByTitle(String title) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Reports reports = new Reports();
        String sql = "SELECT COUNT(*)FROM Reports WHERE [Title] LIKE ?";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + title.toUpperCase() + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }
        return 0;
    }
}
