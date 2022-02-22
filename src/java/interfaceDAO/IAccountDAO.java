/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-14      1.0                 VUDM               Second Implement
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
