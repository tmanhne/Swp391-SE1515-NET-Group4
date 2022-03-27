/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.CustomerDAO;
import interfaceDAO.IAccountDAO;
import interfaceDAO.ICustomerDAO;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Customer;
import model.SendEmail;

/**
 *
 * @author Riel
 */
@WebServlet(name = "ForgotPasswordController", urlPatterns = {"/forgotpassword"})
public class ForgotPasswordController extends HttpServlet {

    private String host;
    private String port;
    private String user;
    private String pass;

    /**
     * ThongCTHE140606
     *
     * @return take the user to the html page so that the user can manipulate
     * the functions
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./view/forgotpassword.jsp").forward(request, response);

    }

    /**
     * ThongCTHE140606
     *
     * @return take the user to the html page so that the user can manipulate
     * the functions
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String submit = request.getParameter("submit");
            if (null != submit) {
                String email = request.getParameter("email");

                IAccountDAO icustomerDAO = (IAccountDAO) new AccountDAO();
                Account customer = icustomerDAO.getAccountByEmail(email);

                if (null == customer) {
                    request.setAttribute("mess", "This account does not exist");
                } else {
                   
                    
                    // encryptPassword
                    byte[] salts = getSalt();
                    String password = encryptPassword("123", salts);
                    
                    String saltsString =  Base64.getEncoder().encodeToString(salts);
                    AccountDAO db = new AccountDAO();
                    db.updateAccount(email,password,saltsString);
                    
                     // send email
                    SendEmail send = new SendEmail();
                    send.sendEmail("123", email);
                    request.setAttribute("mess", "Your new password has been emailed");
                }
                
            }
            request.getRequestDispatcher("./view/forgotpassword.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("e" + e);
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }

    }
    
    //Get random salt
    private byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
        //Always use a SecureRandom generator
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG", "SUN");
        //Create array for salt
        byte[] salt = new byte[16];
        //Get a random salt
        sr.nextBytes(salt);
        //return salt
        return salt;
    }

    //Encrypt password with Java SHA1 Hashing by password and salt
    private String encryptPassword(String password, byte[] salt) {
        String encryptedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(salt);
            //Get the hash's bytes 
            byte[] bytes = md.digest(password.getBytes());
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            encryptedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptedPassword;
    }

}
