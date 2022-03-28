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
 * The class contain method <code>doGet</code> to implement function
 * @author admin
 */
@WebServlet(name = "AdminViewSalesPartnerDetail", urlPatterns = {"/AdminViewSalesPartnerDetail"})
public class AdminViewSalesPartnerDetail extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * The method is used display detail information of SalesPartner
     * The method contain <code>SalesPartnerDAO</code> to get all SalesPartner by id
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
             String name = "";
            request.setAttribute("searchname", name);
            int partnerID = Integer.parseInt(request.getParameter("partnerID"));
            ISalesPartnerDAO partnerDAO = new SalesPartnerDAO();
            ArrayList<SalesPartner> salesPartner = partnerDAO.getPartnerByID(partnerID);

            request.setAttribute("salesPartner", salesPartner);
            request.getRequestDispatcher("adminview/adminViewSalesPartnerDetail.jsp").forward(request, response);
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
