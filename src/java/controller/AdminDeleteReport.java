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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  The class contain method <code>doGet</code> to implement delete report
 * @author vudm
 */
@WebServlet(name = "adminDeleteReport", urlPatterns = {"/adminDeleteReport"})
public class AdminDeleteReport extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *  The method is used to delete report by rid
     *  The method contain <code>ReportDAO</code> to implement delete report from database
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int reportID = Integer.parseInt(request.getParameter("rid"));
            IReportDAO reportDAO = new ReportDAO();
            reportDAO.removeReport(reportID);
            response.sendRedirect("adminViewReport");
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
