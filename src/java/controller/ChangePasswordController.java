/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

//import dao.AccountDAO;
import Validate.Validate;
import dao.AccountDAO;
import model.Account;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riel
 */
@WebServlet(name = "ChangePasswordController", urlPatterns = {"/changePassword"})
public class ChangePasswordController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                Account account = new Account("1", "thongchu", "thongchu", "thongchu@gmail.com", "1", "admin");
        
                String email = request.getParameter("email");
                String curPassword = request.getParameter("curPassword");
                String password = request.getParameter("password");
                String rePassword = request.getParameter("rePassword");
                Validate validate= new Validate();
                AccountDAO accountDAO = new AccountDAO();
                Account accountCF = accountDAO.getAccountByEmail(email) ; 
                
                // validate email
                if (!validate.checkEmail(email)) {
                    request.setAttribute("email", email);
                    request.setAttribute("password", password);
                    request.setAttribute("rePassword", rePassword);
                    request.setAttribute("messEmail", "Your Email is not correct !!!");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                // check email contain account  
                else if (accountCF.getAccountID().equals("") ) {
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
                    // update Account and save in database
                    account.setPassword(password);
        
                    AccountDAO db = new AccountDAO();
                    db.updateAccount(account);

                    request.setAttribute("messResponse", "Update password success");
                    request.getRequestDispatcher("./view/changepassword.jsp").forward(request, response);
                }
                

    }

}
