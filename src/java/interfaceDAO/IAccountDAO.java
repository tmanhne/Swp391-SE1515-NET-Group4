/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import model.Account;

/**
 *
 * @author vudm
 */
public interface IAccountDAO {
    
    public Account checkAccountByUsernameAndPassword(String user, String pass);
    
    public byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException;
    
    public String encryptPassword(String password, byte[] salt);
}
