/**
 * Copyright(C)2021, FPT University
 * SWP 391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-14         1.0               VUDMHE140017      First Implement
 */
package interfaceDAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Product;

/**
 *This interface class used to contain some method used to implements in another class
 * @author vudm
 */
public interface IProductDAO {
    
     /**
     * This method used to get all products from Products table
     * @return account is a ArrayList <code>Product</code>
     * @throws java.lang.Exception
     */
    public ArrayList<Product> getAllProducts()  throws Exception;
    /**
     * This method used to get all products from Products table
     * @return account is a ArrayList <code>Product</code>
     * @throws java.sql.SQLException
     */
    public ArrayList<Product> getBestSellerProducts() throws SQLException;
    /**
     * This method used to get all products from Products table
     * @return account is a ArrayList <code>Product</code>
     * @throws java.lang.Exception
     */
     public ArrayList<Product> getHighestPriceProducts() throws Exception;
     /**
     * This method used search all products by name from Products table
     * @param name is a <code>String</code>
     * @return account is a ArrayList <code>books</code>
     * @throws java.lang.Exception
     */
     public ArrayList<Product> getProductByName(String name) throws Exception;
     /**
     * This method used to get all products with ProductID from Products table
     * @param pid is a <code>String</code>
     * @return account is a  <code>Product</code>
     * @throws java.sql.SQLException
     */
     public Product getProductById(String pid) throws SQLException;
     
    /**
     * This method used search all products by name from Products table
     * @param name is a <code>String</code>
     * @return account is a ArrayList <code>books</code>
     * @throws java.lang.Exception
     */
    public void insertProduct(Product p) throws Exception;
    
    /**
     * This method used search all products by name from Products table
     * @param name is a <code>String</code>
     * @return account is a ArrayList <code>books</code>
     * @throws java.lang.Exception
     */
    public int updateBook(Product product) throws Exception;

    /**
     * This method used search all products by name from Products table
     * @param name is a <code>String</code>
     * @return account is a ArrayList <code>books</code>
     * @throws java.lang.Exception
     */
    public int getTotalProduct() throws Exception;
    
    /**
     * This method used search all products by name from Products table
     * @param name is a <code>String</code>
     * @return account is a ArrayList <code>books</code>
     * @throws java.lang.Exception
     */
    public List<Product> pagingProduct(int index) throws Exception;
    
    /**
     * This method used search all products by name from Products table
     * @param name is a <code>String</code>
     * @return account is a ArrayList <code>books</code>
     * @throws java.lang.Exception
     */
    public void removeProduct(String pid) throws Exception;
}
