/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-16         1.0               VUDMHE140017      First Implement
 */
package controller.authen;

import dao.AccountDAO;
import interfaceDAO.IAccountDAO;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 * The class uses <code>AccountDAO</code> to get data of account then forward to the Login page
 * @author vudm
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * This method used to get username and password throw cookie value 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Cookie[] cookie = request.getCookies();
            String userName = "";
            String passWord = "";

            if (cookie != null) { // if get cookie get value
                for (Cookie cookie1 : cookie) {
                    if (cookie1.getName().equals("Username")) {
                        //get cookie equal username
                        userName = cookie1.getValue();
                    }
                    if (cookie1.getName().equals("Password")) {
                        //get cookie equal password
                        passWord = cookie1.getValue();
                    }
                }

                IAccountDAO accountDAO = new AccountDAO();
                Account account = accountDAO.checkAccountByUsernameAndPassword(userName, passWord);
                if (account != null) {// if get account success
                    request.getSession().setAttribute("account", account);
                    response.sendRedirect("home");
                } else {
                    request.getRequestDispatcher("view/Login.jsp").forward(request, response);
                }
            } else {
                request.getRequestDispatcher("view/Login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }

    }

    /**
     * Handles the HTTP <code>POST</code> method. 
     * This method is used to login to system and add username and password to cookie
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password");
            String remember = request.getParameter("remember");

            Pattern pattern = Pattern.compile("^[A-Z]|[0-9]|[@. #%&*|]+$");
            Pattern pattern1 = Pattern.compile("^[@. #%&*|]$");
            Matcher matcher = pattern.matcher(username);
            Matcher matcher1 = pattern1.matcher(password);
            if (matcher.find()) {//if username contain special characters
                request.setAttribute("Message", "Don't use special character in Username!!! ");
                request.getRequestDispatcher("view/Login.jsp").forward(request, response);
            } else if (matcher1.find()) {//if password contain special characters
                request.setAttribute("Message", "Don't use special character in Password!!! ");
                request.getRequestDispatcher("view/Login.jsp").forward(request, response);
            }
            IAccountDAO accountDAO = new AccountDAO();
            Account account = accountDAO.checkAccountByUsernameAndPassword(username, password);

            if (account != null) { // check account null or not
                request.getSession().setAttribute("account", account);
                if (remember != null) {// check user clicked remember account
                    Cookie user = new Cookie("Username", account.getUserName());
                    Cookie pass = new Cookie("Password", password.trim());
                    user.setMaxAge(60 * 60);
                    pass.setMaxAge(60 * 60);
                    response.addCookie(user);
                    response.addCookie(pass);
                }
                response.sendRedirect("../Swp391-SE1515-NET-Group4/home");
            } else { // if account null
                request.setAttribute("Message", "Please check your username or password!!! ");
                request.getRequestDispatcher("view/Login.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
