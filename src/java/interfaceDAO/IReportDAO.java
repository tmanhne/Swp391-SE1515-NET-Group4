/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-03-03         1.0               VUDMHE140017      First Implement
 */
package interfaceDAO;

import java.util.ArrayList;
import java.util.List;
import model.Reports;

/**
 * This interface class used to contain some method used to implements in another
 * @author vudm
 */
public interface IReportDAO {
    
     /**
     * This method is used to insert report to database with report object are parameter input
     *
     * @param reports is an object <code>Reports</code> input
     * @throws java.lang.Exception
     */
    public void insertReport(Reports reports) throws Exception;
    
     /**
     * This method is used to get all reports by rid from database 
     * @param rid is Integer <code>int</code>
     * @return reportList is a array list <code>Reports</code>
     * @throws java.lang.Exception
     */
    public ArrayList<Reports> getReportByID(int rid) throws Exception;
    /**
     * This method is used to update reports to database 
     * @param reports is an object <code>Reports</code> input
     * @return result is <code>int</code>
     * @throws java.lang.Exception
     */
    public int updateReport(Reports reports) throws Exception;
    /**
     * This method is used to remove reports in database 
     * @param rid is Integer <code>int</code>
     * @throws java.lang.Exception
     */
    public void removeReport(int rid) throws Exception;
    
    
    /**
     * This method is used to count all reports from database 
     * @return 0
     * @throws java.lang.Exception
     */
    public int getTotalReport() throws Exception;
    
          /**
     * This method is used to get all reports follow index from database 
     * @param index is <code>int</code>
     * @return reportList is a array list <code>Reports</code>
     * @throws java.lang.Exception
     */
    public List<Reports> pagingReport(int index) throws Exception;
    
    public ArrayList<Reports> getReportByName(String title) throws Exception;
    
    public List<Reports> pagingReportByTitle(String title,int index) throws Exception;
    
    public int getTotalReportByTitle(String title) throws Exception;
}
