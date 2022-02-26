/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import model.Product;

/**
 *
 * @author Thongchu
 */
public interface IProductDAO {

    public void insertProduct(Product p) throws Exception;

    public int updateBook(Product product) throws Exception;

    public Product getProductById(String pid) throws Exception;
    
    /**
     *
     * @param pid
     */
    public void removeProduct(String pid) throws Exception;

}
