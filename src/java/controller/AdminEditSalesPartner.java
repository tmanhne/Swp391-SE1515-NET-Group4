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
import interfaceDAO.ISalesPartnerDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.SalesPartner;

/**
 *The class contain method <code>doGet</code> and <code>doPost</code>  to implement function
 * @author admin
 */
@WebServlet(name = "AdminEditSalesPartner", urlPatterns = {"/AdminEditSalesPartner"})
public class AdminEditSalesPartner extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * The method is used to get form edit to display when user click link edit
     * The method contain <code>SalesPartnerDAO</code> to get SalesPartner by id to excute edit 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            int partnerID = Integer.parseInt(request.getParameter("partnerID").trim());
            ISalesPartnerDAO partnerDAO = new SalesPartnerDAO();
            ArrayList<SalesPartner> salesPartner = partnerDAO.getPartnerByID(partnerID);
            String name = "";
            //check search parameter
            if (request.getParameter("search") != null) {
                if (!request.getParameter("search").trim().isEmpty()) {
                    name = request.getParameter("search").trim();//if parameter is not empty
                }
            }

            request.setAttribute("searchname", name);
            request.setAttribute("salesPartner", salesPartner);
            request.getRequestDispatcher("adminview/adminEditSalesPartner.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * The method is used to update data of SalesPartner need edit when people click button save in interface
     * The method contain <code>SalesPartnerDAO</code> get method update to database
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int partnerID = Integer.parseInt(request.getParameter("partnerID").trim());
            String status = request.getParameter("partnerStatus").trim();
            
            
            SalesPartner salePartner = new SalesPartner(partnerID, status);
            ISalesPartnerDAO partnerDAO = new SalesPartnerDAO();
//            int count = reportDAO.updateReport(reports);
                partnerDAO.updateSalesPartner(salePartner);
                response.sendRedirect("AdminViewSalesPartner");
        } catch (Exception e) {
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
