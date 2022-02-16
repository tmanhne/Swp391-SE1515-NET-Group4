/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-014      1.0                 VUDM               AuthorsDAO
 */
package interfaceDAO;

import java.util.ArrayList;
import model.Book;

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
    public ArrayList<Book> getAllBooks();
    /**
     * This method used to get all products from Products table
     * @return account is a ArrayList <code>books</code>
     */
    public ArrayList<Book> getBestSellerBooks();
    /**
     * This method used to get all products from Products table
     * @return account is a ArrayList <code>books</code>
     */
     public ArrayList<Book> getHighestPriceBooks();
     /**
     * This method used search all products by name from Products table
     * @param name is a <code>String</code>
     * @return account is a ArrayList <code>books</code>
     */
     public ArrayList<Book> getBookByName(String name);
     
}
