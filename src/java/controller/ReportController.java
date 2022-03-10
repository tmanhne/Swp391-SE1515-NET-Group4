/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
 *
 * @author vudm
 */
@WebServlet(name = "ReportController", urlPatterns = {"/ReportController"})
public class ReportController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method. The method is used to link to  Report.jsp
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

                Pattern pTitle = Pattern.compile("^[A-Za-z][A-Za-z0-9- _]{1,250}$");
                Matcher mTitle = pTitle.matcher(title);

                Pattern pCustomerName = Pattern.compile("^[A-Za-z ]{1,50}$");
                Matcher mCustomerName = pCustomerName.matcher(customerName);

                Pattern pEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                Matcher mEmail = pEmail.matcher(email);

                Pattern pPhone = Pattern.compile("^[0-9]{10}$");
                Matcher mPhone = pPhone.matcher(phone);

                if (!mTitle.find()) {
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please title again!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } else if (!mCustomerName.find()) {
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please name again!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } else if (!mEmail.find()) {
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please email again!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } else if (!mPhone.find()) {
                    request.setAttribute("title", title);
                    request.setAttribute("customerName", customerName);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please phone again!");
                    request.getRequestDispatcher("view/report.jsp").forward(request, response);
                } else if (descriptions.length() > 250 || descriptions.length()<=0) {
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
