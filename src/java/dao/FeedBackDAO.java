/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 ThongCT               Second Implement
 */
package dao;

import dal.DBConnection;
import interfaceDAO.IAccountDAO;
import interfaceDAO.IFeedBackDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.FeedBack;
import model.Product;

/**
 *
 * @author Thongchu
 */
public class FeedBackDAO extends DBConnection implements IFeedBackDAO{
    
     /**
     *
     * @param NO 
     * @return return all FeedBack of member  
     * @throws java.lang.Exception  
     */
     @Override
     public List<FeedBack> getAllFeedBack() throws Exception  {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FeedBack> feedBacks = new ArrayList<>();
        try {
            String sql = "select f.CustomerID ,c.CustomerName, f.FeedbackDate, f.Description, f.ProductID, p.ProductName, f.ratting\n" +
"from \n" +
"	Feedback f join Customer c on f.CustomerID = c.CustomerID\n" +
"			   join Products p on f.ProductID = p.ProductID";
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // IF database have feedback of customer            
            while (rs.next()) {
                FeedBack feedBack = new FeedBack();
                feedBack.setCustomerID(rs.getString(1));
                feedBack.setCustomerName(rs.getString(2));
                feedBack.setFeedbackDate(rs.getDate(3));
                feedBack.setDescription(rs.getString(4));
                feedBack.setProductID(rs.getString(5));
                feedBack.setProductName(rs.getString(6));
                feedBack.setRatting(rs.getInt(7));
                feedBacks.add(feedBack);
            }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        finally{
            super.close(con, ps, rs);
        }
        return feedBacks;
    }
    
     @Override
     public List<FeedBack> getAllFeedBackByQuerry (String customerPara,String productPara,String rattingPara)throws Exception{
         Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FeedBack> feedBacks = new ArrayList<>();
        try {
            String sql = "select f.CustomerID ,c.CustomerName, f.FeedbackDate, f.Description, f.ProductID, p.ProductName, f.ratting\n" +
                            "from \n" +
                            "	Feedback f join Customer c on f.CustomerID = c.CustomerID\n" +
                            "			   join Products p on f.ProductID = p.ProductID";
            if(!customerPara.equals("all")) {
                sql=sql + " where f.CustomerID = "+customerPara+" ";
                if(!productPara.equals("all")) {
                    sql=sql +" and f.ProductID = "+productPara+" " ;
                }
                if(!rattingPara.equals("all")) {
                    sql=sql +" and f.Ratting = "+rattingPara+" " ;
                }
            }
            else {
                if(!productPara.equals("all")) {
                    sql.concat(" where f.ProductID = "+productPara+" ");
                    if(!rattingPara.equals("all")) {
                        sql=sql +" and f.Ratting = "+rattingPara+" " ;
                    }
                }
                else if(!rattingPara.equals("all")) {
                    sql=sql +" where f.Ratting = "+rattingPara+" " ;
                }
            } 
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // IF database have feedback of customer            
            while (rs.next()) {
                FeedBack feedBack = new FeedBack();
                feedBack.setCustomerID(rs.getString(1));
                feedBack.setCustomerName(rs.getString(2));
                feedBack.setFeedbackDate(rs.getDate(3));
                feedBack.setDescription(rs.getString(4));
                feedBack.setProductID(rs.getString(5));
                feedBack.setProductName(rs.getString(6));
                feedBack.setRatting(rs.getInt(7));
                feedBacks.add(feedBack);
            }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        finally{
            super.close(con, ps, rs);
        }
        return feedBacks;
     }
     
     /**
     *
     * @param NO 
     * @return return all FeedBack of member  
     * @throws java.lang.Exception  
     */
     @Override
     public List<FeedBack> getFeedBackBYProductID(String productID) throws Exception  {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FeedBack> feedBacks = new ArrayList<>();
        try {
            String sql = "select f.CustomerID ,c.CustomerName, f.FeedbackDate, f.Description, f.ProductID, p.ProductName, f.ratting\n" +
                        "from \n" +
                        "Feedback f join Customer c on f.CustomerID = c.CustomerID\n" +
                        "join Products p on f.ProductID = p.ProductID\n" +
                        "where f.ProductID = "+productID;
            con = super.open();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            // IF database have feedback of customer            
            while (rs.next()) {
                FeedBack feedBack = new FeedBack();
                feedBack.setCustomerID(rs.getString(1));
                feedBack.setCustomerName(rs.getString(2));
                feedBack.setFeedbackDate(rs.getDate(3));
                feedBack.setDescription(rs.getString(4));
                feedBack.setProductID(rs.getString(5));
                feedBack.setProductName(rs.getString(6));
                feedBack.setRatting(rs.getInt(7));
                feedBacks.add(feedBack);
            }
        } 
        catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        finally{
            super.close(con, ps, rs);
        }
        return feedBacks;
    }
     
     /**
     *
     * @param NO 
     * @return return all FeedBack of member  
     * @throws java.lang.Exception  
     */
     @Override
     public void insertFeeback(FeedBack p) throws Exception  {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO [dbo].[Feedback]\n" +
                        "           ([CustomerID]\n" +
                        "           ,[FeedbackDate]\n" +
                        "           ,[Description]\n" +
                        "           ,[ProductID]\n" +
                        "           ,[Ratting])\n" +
                        "     VALUES\n" +
                        "           (?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?\n" +
                        "           ,?)";
            con = super.open();
            ps = con.prepareStatement(sql);
            ps.setString(1, p.getCustomerID());
            ps.setDate(2, new java.sql.Date(p.getFeedbackDate().getTime()));
            ps.setString(3, p.getDescription());
            ps.setString(4, p.getProductID());
            ps.setInt(5, p.getRatting());
            ps.executeUpdate();
        } 
        catch (Exception ex) {
            System.out.println("errror"+ex);
            ex.printStackTrace();
            throw ex;
        }
        finally{
            super.close(con, ps, rs);
        }
    }
}
