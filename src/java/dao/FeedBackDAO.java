/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 ThongCT               Second Implement
 */
package dao;

import dal.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Category;
import model.FeedBack;

/**
 *
 * @author Thongchu
 */
public class FeedBackDAO extends DBConnection {
    
     /**
     *
     * @param NO 
     * @return return all FeedBack of member  
     */
     public List<FeedBack> getAllFeedBack() throws Exception {
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
    
     public List<FeedBack> getAllFeedBackByQuerry (String customerPara,String productPara)throws Exception{
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
            }
            else {
                if(!productPara.equals("all")) {
                    sql.concat(" where f.ProductID = "+productPara+" ");
                }    
            } 
            System.out.println(sql);
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
}
