/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-20         1.0               VUDMHE140017      First Implement
 */
package controller;

import dao.AccountDAO;
import interfaceDAO.IAccountDAO;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 * The class is used to implement register and account to access system throw username and password
 * The class contain method <code>doGet</code> and <code>doPost</code>
 * @author vudm
 */
@WebServlet(name = "SignUpController", urlPatterns = {"/SignUpController"})
public class SignUpController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * The method is used to link to signUp.jsp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/signUp.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * The method is used to create an account to login system access throw username and password
     * This method uses <code>AccountDAO</code> to create an account with username and password
     * This method uses <code>Random</code> to random an id number for account
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            IAccountDAO accountDAO = new AccountDAO();//implement interface
            String username = request.getParameter("username").trim();
            String password = request.getParameter("password").trim();
            String email = request.getParameter("email").trim();
            String phone = request.getParameter("phone").trim();
            String cfPassword = request.getParameter("cfPassword").trim();

            Pattern pUser = Pattern.compile("^[A-Za-z][A-Za-z0-9_]{4,50}$");
            Matcher mUser = pUser.matcher(username);

            Pattern pEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
            Matcher mEmail = pEmail.matcher(email);

            Pattern pPhone = Pattern.compile("^[0-9]{10}$");
            Matcher mPhone = pPhone.matcher(phone);

            if (!mUser.find()) { // Use regex to check username
                request.setAttribute("user", username);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("pass", password);
                request.setAttribute("cfpass", cfPassword);
                request.setAttribute("notification", "Please check user name again!");
                request.getRequestDispatcher("view/signUp.jsp").forward(request, response);
            } else if (!mEmail.find()) { // use regex to check email
                request.setAttribute("user", username);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("pass", password);
                request.setAttribute("cfpass", cfPassword);
                request.setAttribute("notification", "Please check email again!");
                request.getRequestDispatcher("view/signUp.jsp").forward(request, response);
            } else if (!mPhone.find()) {// check phone number
                request.setAttribute("user", username);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("pass", password);
                request.setAttribute("cfpass", cfPassword);
                request.setAttribute("notification", "Please check phone again!");
                request.getRequestDispatcher("view/signUp.jsp").forward(request, response);
            } else if (!password.equals(cfPassword)) { // check password
                request.setAttribute("user", username);
                request.setAttribute("email", email);
                request.setAttribute("phone", phone);
                request.setAttribute("pass", password);
                request.setAttribute("cfpass", cfPassword);
                request.setAttribute("notification", "Please check password again!");
                request.getRequestDispatcher("view/signUp.jsp").forward(request, response);
            } else {// if the inputs statisfy all above conditions
                boolean checkUsername = accountDAO.isUsernameExist(username);

                Random random = new Random();
                int accountID = random.nextInt(100000);
                if (checkUsername) {//check username is exist
                    request.setAttribute("user", username);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("pass", password);
                    request.setAttribute("cfpass", cfPassword);
                    request.setAttribute("notification", "Username already exists.");
                    request.getRequestDispatcher("view/signUp.jsp").forward(request, response);
                } else {
                    Account account = new Account("Acc" + accountID, username, password, email, phone, "user");
                    accountDAO.registerAccount(account);
                    response.sendRedirect("home");
                }
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
