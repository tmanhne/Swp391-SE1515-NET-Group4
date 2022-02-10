/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.AccountDAO;
import Model.Account;
import Validate.Validate;
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
        Account account = (Account) request.getSession().getAttribute("account");
        
        String password = request.getParameter("password");
        String rePassword = request.getParameter("rePassword");
        
        // check password and rePassword must equal 
        if (!password.equals(rePassword)) {
            request.setAttribute("message", "Password and rePassword must equals");
            // return to page change password
            request.getRequestDispatcher("./jsp/changepassword.jsp").forward(request, response);
        }
        // validate password
        else if (!Validate.checkPass(password)) {
            request.setAttribute("message", "Password and rePassword must equals");
            // return to page change password
            request.getRequestDispatcher("./jsp/changepassword.jsp").forward(request, response);
        }
        // change pass word success 
        else {
            
            account.setPassword(password);
            AccountDAO db = new AccountDAO();
            db.updateAccount(account);

            // return to page change password
            request.getRequestDispatcher("./jsp/changepassword.jsp").forward(request, response);
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("./jsp/changepassword.jsp").forward(request, response);

    }

}
