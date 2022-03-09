/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 ThongCT               Second Implement
 */
package interfaceDAO;

import java.util.List;
import model.FeedBack;

/**
 *
 * @author Thongchu
 */
public interface IFeedBackDAO {
    public List<FeedBack> getAllFeedBack() throws Exception;
    public List<FeedBack> getAllFeedBackByQuerry(String customerPara,String productPara,String rattingPara) throws Exception;
    public List<FeedBack> getFeedBackBYProductID(String productID) throws Exception;
    public void insertFeeback(FeedBack feedBack) throws Exception;
}
