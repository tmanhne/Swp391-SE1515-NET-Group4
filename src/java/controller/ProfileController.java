/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-18         1.0               ThiPTHE130333      First Implement
 */
package controller;

import Validate.Validate;
import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author phamthithi
 */
@WebServlet(name = "ProfileController", urlPatterns = {"/profile"})
public class ProfileController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ProfileController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ProfileController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        try {
            Account accountSession = (Account) request.getSession().getAttribute("account");
            AccountDAO db = new AccountDAO();
            Account accounts = db.getAccount(accountSession.getUserName());
            request.setAttribute("account", accounts);
            request.getRequestDispatcher("view/profile.jsp").forward(request, response);
        } catch (IOException | SQLException | ServletException e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
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
        try {
            Account accountSession = (Account) request.getSession().getAttribute("account");
            AccountDAO db = new AccountDAO();
            Account account = db.getAccount(accountSession.getUserName());
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String phone = request.getParameter("phone");
            // update Account and save in database
            account.setPassword(password);
            account.setEmail(email);
            account.setPhone(phone);
            // validate email
            if (!Validate.isValid(email)) {
                request.setAttribute("account", account);
                request.setAttribute("messResponse", "Your Email is not correct !!!");
                request.getRequestDispatcher("./view/profile.jsp").forward(request, response);
            }
            // validate phoneNumber
            if (!Validate.checkPhoneNumber(phone)) {
                request.setAttribute("account", account);
                request.setAttribute("messResponse", "Your Phone is not correct !!!");
                request.getRequestDispatcher("./view/profile.jsp").forward(request, response);
            }
            db.updateProfile(account);
            request.setAttribute("messResponse", "Update profile success");
            request.getRequestDispatcher("./view/profile.jsp").forward(request, response);

        } catch (IOException | SQLException | ServletException e) {
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
