/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-03-26         1.0               VUDMHE140017      First Implement
 */
package dao;

import interfaceDAO.ISalesPartnerDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SalesPartner;

/**
 *The class contain all method to contacts with SalesPartner from database
 * @author vudm
 */
public class SalesPartnerDAO extends dal.DBConnection implements ISalesPartnerDAO{
    /**
     * This method is used to insert Partner to database with report object are parameter input
     * @param partner is an object <code>Object</code> input
     * @throws java.lang.Exception
     */
    @Override
    public void insertPartner(SalesPartner partner) throws Exception {
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "INSERT INTO [SalesPartner] ([PartnerName],[Address],[Product],[Email],[Phone],[Description],[Status])\n"
                + " VALUES(?,?,?,?,?,?,?)";
        try {
            
            con = super.open();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, partner.getPartnerName());
            ps.setString(2, partner.getAddress());
            ps.setString(3, partner.getProduct());
            ps.setString(4, partner.getEmail());
            ps.setString(5, partner.getPhone());
            ps.setString(6, partner.getDescription());
            ps.setString(7, partner.getStatus() );
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw ex;
        }finally {
            //close connection
            super.close(con, ps, rs);
        }
    }
    
    
      /**
     * This method is used to count all reports from database 
     * @return 0
     * @throws java.lang.Exception
     */
    @Override
    public int getTotalPartner() throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(*)FROM SalesPartner";
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
     * This method is used to get all salesPartner follow index from database 
     * @param index is <code>int</code>
     * @return ptList is a array list <code>SalesPartner</code>
     * @throws java.lang.Exception
     */
    @Override
    public List<SalesPartner> pagingSalesPartner(int index) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<SalesPartner> ptList = new ArrayList<>();
        String sql = "SELECT * FROM SalesPartner\n"
                + "ORDer by PartnerID\n"
                + "offset ? rows fetch next 3 rows only;";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 3);
            rs = ps.executeQuery();

            while (rs.next()) {
                SalesPartner partner = new SalesPartner();
                partner.setPartnerID(rs.getInt("PartnerID"));
                partner.setPartnerName(rs.getString("PartnerName"));
                partner.setAddress(rs.getString("Address"));
                partner.setProduct(rs.getString("Product"));
                partner.setEmail(rs.getString("Email"));
                partner.setPhone(rs.getString("Phone"));
                partner.setDescription(rs.getString("Description"));
                partner.setStatus(rs.getString("Status"));
                ptList.add(partner);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return ptList;
    }
    
    /**
     * This method is used to update SalesPartner to database 
     * @param partner is an object <code>SalesPartner</code> input
     * @return result is <code>int</code>
     * @throws java.lang.Exception
     */
    @Override
    public int updateSalesPartner(SalesPartner partner) throws Exception{
        int result = 0;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " UPDATE [dbo].[SalesPartner] "
                + "   SET [Status] = ?  "
                + " WHERE [PartnerID] = ? ";
        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, partner.getStatus());
            ps.setInt(2, partner.getPartnerID());
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
     * This method is used to get all salesPartner by id  from database 
     * @param id is an <code>Int</code> input
     * @return ptList
     * @throws java.lang.Exception
     */
    @Override
    public ArrayList<SalesPartner> getPartnerByID(int id) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<SalesPartner> ptList = new ArrayList<>();
        String sql = "SELECT * FROM SalesPartner WHERE PartnerID=? ";

        try {
            //open connection
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            //assign data to books
            while (rs.next()) {
               SalesPartner partner = new SalesPartner();
                partner.setPartnerID(rs.getInt("PartnerID"));
                partner.setPartnerName(rs.getString("PartnerName"));
                partner.setAddress(rs.getString("Address"));
                partner.setProduct(rs.getString("Product"));
                partner.setEmail(rs.getString("Email"));
                partner.setPhone(rs.getString("Phone"));
                partner.setDescription(rs.getString("Description"));
                partner.setStatus(rs.getString("Status"));
                ptList.add(partner);
            }

        } catch (SQLException ex) {
            throw ex;
        } finally {
            //close connection
            super.close(con, ps, rs);
        }

        return ptList;
    }
}
