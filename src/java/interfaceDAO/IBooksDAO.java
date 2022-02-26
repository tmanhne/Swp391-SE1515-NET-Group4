/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-014      1.0                 VUDM               First Implement
 */
package interfaceDAO;

import java.util.ArrayList;
import model.Product;

/**
 *This interface class used to contain some method used to implements in another
 * class
 * @author vudm
 */
public interface IBooksDAO {
      /**
     * This method used to get all products from Products table
     * @return account is a ArrayList <code>books</code>
     */
    public ArrayList<Product> getAllBooks() throws Exception;
    /**
     * This method used to get all products from Products table
     * @return account is a ArrayList <code>books</code>
     */
    public ArrayList<Product> getBestSellerBooks() throws Exception;
    /**
     * This method used to get all products from Products table
     * @return account is a ArrayList <code>books</code>
     */
     public ArrayList<Product> getHighestPriceBooks() throws Exception;
     /**
     * This method used search all products by name from Products table
     * @param name is a <code>String</code>
     * @return account is a ArrayList <code>books</code>
     */
     public ArrayList<Product> getBookByName(String name) throws Exception;
     
}
