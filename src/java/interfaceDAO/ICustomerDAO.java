/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.util.List;
import model.Customer;

/**
 *
 * @author Thongchu
 */
public interface ICustomerDAO {
    public List<Customer> getAllCustomer() throws Exception;
    public Customer getCustomer(String accountId) throws Exception;
    public String addCustomer(Customer customer) throws Exception;
}
