/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceDAO;

import model.Account;

/**
 *
 * @author Thongchu
 */
public interface IAccountDAO {
    public void updateAccount(Account account);
    public Account getAccountByEmail(String email);
}
