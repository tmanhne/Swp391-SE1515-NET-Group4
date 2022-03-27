 /*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-03-26         1.0               VUDMHE140017      First Implement
 */
package controller;

import dao.SalesPartnerDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import interfaceDAO.ISalesPartnerDAO;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.SalesPartner;

/**
 * The class contain method <code>doGet</code> and <code>doPost</code> to implement function
 * @author admin
 */
@WebServlet(name = "SalesPartnerController", urlPatterns = {"/SalesPartnerController"})
public class SalesPartnerController extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *The method is used to forward to salesPartner.jsp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("view/salesPartner.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * The method is used to send message SalesPartner to admin 
     * The method contain <code>SalesPartnerDAO</code> to implement insert data to database
     * The method contain <code>Pattern</code> to implement check input
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
                String partnerName = request.getParameter("partnerName").trim();
                String address = request.getParameter("address").trim();
                String product = request.getParameter("product").trim();
                String email = request.getParameter("email").trim();
                String phone = request.getParameter("phone").trim();
                String descriptions = request.getParameter("descriptions").trim();

                Pattern pTitle = Pattern.compile("^[A-Za-z][A-Za-z0-9- _]{1,150}$");
                Matcher mTitle = pTitle.matcher(partnerName);

                Pattern pCustomerName = Pattern.compile("^[A-Za-z ]{1,50}$");
                Matcher mCustomerName = pCustomerName.matcher(address);
                
                Pattern pProduct = Pattern.compile("^[A-Za-z][A-Za-z0-9- _]{1,150}$");
                Matcher mProduct = pTitle.matcher(product);

                Pattern pEmail = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
                Matcher mEmail = pEmail.matcher(email);

                Pattern pPhone = Pattern.compile("^[0-9]{10}$");
                Matcher mPhone = pPhone.matcher(phone);

                if (!mTitle.find()) {//if title is found
                    request.setAttribute("partnerName", partnerName);
                    request.setAttribute("address", address);
                    request.setAttribute("product", product);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please name again!");
                    request.getRequestDispatcher("view/salesPartner.jsp").forward(request, response);
                } else if (!mCustomerName.find()) {//check customer name
                    request.setAttribute("partnerName", partnerName);
                    request.setAttribute("address", address);
                    request.setAttribute("product", product);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please address again!");
                    request.getRequestDispatcher("view/salesPartner.jsp").forward(request, response);
                } else if (!mEmail.find()) {//check email
                    request.setAttribute("partnerName", partnerName);
                    request.setAttribute("address", address);
                    request.setAttribute("product", product);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please email again!");
                    request.getRequestDispatcher("view/salesPartner.jsp").forward(request, response);
                } else if (!mPhone.find()) {// check phone
                    request.setAttribute("partnerName", partnerName);
                    request.setAttribute("address", address);
                    request.setAttribute("product", product);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please phone again!");
                    request.getRequestDispatcher("view/salesPartner.jsp").forward(request, response);
                } else if (descriptions.length() > 250 || descriptions.length()<=0) {//check description
                    request.setAttribute("partnerName", partnerName);
                    request.setAttribute("address", address);
                    request.setAttribute("product", product);
                    request.setAttribute("email", email);
                    request.setAttribute("phone", phone);
                    request.setAttribute("descriptions", descriptions);
                    request.setAttribute("notification", "Please description must  largger 0 and smaller 250 characters!");
                    request.getRequestDispatcher("view/salesPartner.jsp").forward(request, response);
                } ////            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                ////            String now = formatter.format(time);
                else {
                    String status = "Pending";

                    ISalesPartnerDAO salesPartnerDAO = new SalesPartnerDAO();
                    SalesPartner salesPartner = new SalesPartner(partnerName, address,product, email, phone,descriptions, status);
                    salesPartnerDAO.insertPartner(salesPartner);
                    request.setAttribute("notification", "Success.");
                    request.getRequestDispatcher("view/salesPartner.jsp").forward(request, response);
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
