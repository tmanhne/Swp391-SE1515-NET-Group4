/**
 * Copyright(C)2022, FPT University
 * SWP391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-27         1.0               ThongCT              First Implement
 */
package controller;

//import dao.AccountDAO;
import Validate.Validate;
import dao.AccountDAO;
import model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.util.Base64;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ThongChu
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/changePassword"})
public class ChangePasswordController extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @return redirect user to jsp to change password 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);

    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @description : handle email and new password of user and change password for user 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
        
                String email = request.getParameter("email");
                String curPassword = request.getParameter("curPassword");
                String password = request.getParameter("password");
                String rePassword = request.getParameter("rePassword");
                Validate validate= new Validate();
                AccountDAO accountDAO = new AccountDAO();
                Account accountCF = accountDAO.getAccountByEmail(email) ; 
                
                if (!validate.checkLengthComment(email)) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messEmail", "Your Email is not correct !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                else if (!validate.checkLengthComment(curPassword)) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messCurrPassword", "Your curPassword is not correct !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                else if (!validate.checkLengthComment(password)) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messPassword", "Your password is not correct !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                else if (!validate.checkLengthComment(rePassword)) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messRePassword", "Your rePassword is not correct !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                // validate email
                else if (!validate.checkEmail(email)) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messEmail", "Your Email is not correct !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                // check email contain account  
                else if (accountCF.getAccountID() == null ) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messEmail", "Your Email Dont have account in shop !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                // check validate current Password 
                else if (!validate.checkPass(curPassword) ) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messCurrPassword", "Your PassWord is not correct !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                // check current password is right 
                else if (!accountCF.getPassword().equals(curPassword) ) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messCurrPassword", "Your PassWord is not correct with your account !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                // validate passWord 
                else if (!validate.checkPass(password)) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messPassWord", "Your PassWord is not correct !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                // passWord and repassWOrd must equal 
                else if (!password.equals(rePassword)) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messRePassWord", "Your PassWord and RePassWord must equal !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                else {
                    byte[] salts = getSalt();
                    password = encryptPassword(password, salts);
                    // update Account and save in database
                    account.setPassword(password);
                    String saltsString =  Base64.getEncoder().encodeToString(salts);
                    AccountDAO db = new AccountDAO();
                    db.updateAccount(account.getEmail(),account.getPassword(),saltsString);

                    request.setAttribute("messResponse", "Update password success");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
        } catch (Exception e) {
            System.out.println("Error"+ e);
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
