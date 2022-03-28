/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-03-26         1.0               VUDMHE140017      First Implement
 */
package interfaceDAO;

import java.util.ArrayList;
import java.util.List;
import model.SalesPartner;

/**
 *This interface class used to contain some method for implements in another
 * @author vudm
 */
public interface ISalesPartnerDAO {
    
     /**
     * This method is used to insert salesPartner to database with partner object are parameter input
     * @param partner is an <code>Object</code> input
     * @throws java.lang.Exception
     */
    public void insertPartner(SalesPartner partner) throws Exception;
    
     /**
     * This method is used to get all  salesPartner to database
     * @return 0
     * @throws java.lang.Exception
     */
    public int getTotalPartner() throws Exception;
    
    /**
     * This method is used to get all salesPartner follow index from database 
     * @param index is an  <code>int</code> input
     * @return ptList
     * @throws java.lang.Exception
     */
    public List<SalesPartner> pagingSalesPartner(int index) throws Exception;
    
      /**
     * This method is used to update salesPartner  from database 
     * @param partner is an <code>Object</code> input
     * @return ptList
     * @throws java.lang.Exception
     */
    public int updateSalesPartner(SalesPartner partner) throws Exception;
    
     /**
     * This method is used to get all salesPartner by id  from database 
     * @param id is an <code>Int</code> input
     * @return ptList
     * @throws java.lang.Exception
     */
    public ArrayList<SalesPartner> getPartnerByID(int id) throws Exception;
}
