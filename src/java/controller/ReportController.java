 /*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-03-05         1.0               VUDMHE140017      First Implement
 */
package controller;

import dao.ReportDAO;
import interfaceDAO.IReportDAO;
import java.io.IOException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Reports;

/**
 * The class contain method <code>doGet</code> and <code>doPost</code>  to implement function about report
 * @author vudm
 */
@WebServlet(name = "ReportController", urlPatterns = {"/ReportController"})
public class ReportController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. 
     * The method is used to link to  Report.jsp
     * This method contain <code>Account</code> object to check login of user and forward to report.jsp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null) {
                request.setAttribute("user", null);
                request.setAttribute("pass", null);
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("view/report.jsp").forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * This method contain <code>Pattern</code> to check input of user
     * This method contain <code>Account</code> object to check login of user and forward to report.jsp
     * This method contain <code>ReportDAO</code> to implement insert an report in database
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            Account account = (Account) request.getSession().getAttribute("account");
            if (account == null) {
                request.setAttribute("user", null);
                request.setAttribute("pass", null);
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            } else {
                String accountID = account.getAccountID();
                String title = request.getParameter("title").trim();
                String customerName = request.getParameter("customerName").trim();
                String email = request.getParameter("email").trim();
                String phone = request.getParameter("phone").trim();
                String insurance = request.getParameter("insurance").trim();
                String descriptions = request.getParameter("descriptions").trim();

                Pattern pTitle = Pattern.compile("^[A-Za-z][A-Za-z0-9- _]{1,150}$");
                Matcher mTitle = pTitle.matcher(title);

                Pattern pCustomerName = Pattern.compile("^[A-Za-z ]{1,50}$");
                Matcher mCustomerName = pCustomerName.matcher(customerName);

                Pattern pEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                Matcher mEmail = pEmail.matcher(email);

                Pattern pPhone = Pattern.compile("^[0-9]{10}$");
                Matcher mPhone = pPhone.matcher(phone);

                if (!mTitle.find()) {//if title is found
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please title again!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } else if (!mCustomerName.find()) {//check customer name
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please name again!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } else if (!mEmail.find()) {//check email
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please email again!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } else if (!mPhone.find()) {// check phone
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please phone again!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } else if (descriptions.length() > 250 || descriptions.length()<=0) {//check description
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please description must  largger 0 and smaller 250 characters!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } ////            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                ////            String now = formatter.format(time);
                else {
                    Date date = new Date();
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    String status = "pending";

                    IReportDAO reportDAO = new ReportDAO();
                    Reports reports = new Reports(title, customerName, email, phone, insurance, descriptions, status, accountID, sqlDate);
                    reportDAO.insertReport(reports);
                    request.setAttribute("notification", "Success.");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
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
