/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-16      1.0                 VUDM               First Implement
 */
package controller.authen;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 *
 * @author vudm
 */
@WebServlet(name = "LoginController", urlPatterns = {"/Login"})
public class LoginController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/Login.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");

        Pattern pattern = Pattern.compile("^[A-Z]|[0-9]|[@. #%&*|]$");
        Pattern pattern1 = Pattern.compile("^[@. #%&*|]$");
        Matcher matcher = pattern.matcher(username);
        Matcher matcher1 = pattern1.matcher(password);
        if (matcher.find()) {
            request.setAttribute("Message", "Don't use special character in Username!!! ");
            request.getRequestDispatcher("view/Login.jsp").forward(request, response);
        } else if (matcher1.find()) {
            request.setAttribute("Message", "Don't use special character in Password!!! ");
            request.getRequestDispatcher("view/Login.jsp").forward(request, response);
        }
        AccountDAO accountDAO = new AccountDAO();
        Account account = new Account(username, password);

        account = accountDAO.checkAccountByUsernameAndPassword(username, password);

        if (account != null) { // check account null or not
            request.getSession().setAttribute("account", account);
            if (remember != null) {// check user clicked remember account
                Cookie user = new Cookie("Username", account.getUserName());
                Cookie pass = new Cookie("Password", account.getPassword());
                user.setMaxAge(60 * 60);
                pass.setMaxAge(60 * 60);
                response.addCookie(user);
                response.addCookie(pass);
            }
            response.sendRedirect("../Swp391-SE1515-NET-Group4/home");
        } else {
            // if account null
            request.setAttribute("Message", "Please check your username or password!!! ");
            request.getRequestDispatcher("view/Login.jsp").forward(request, response);
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
