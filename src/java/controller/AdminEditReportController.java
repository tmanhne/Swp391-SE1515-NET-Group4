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
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Reports;

/**
 * The class contain method <code>doGet</code> and <code>doPost</code>  to implement function
 * @author vudm
 */
@WebServlet(name = "AdminEditReportController", urlPatterns = {"/AdminEditReportController"})
public class AdminEditReportController extends HttpServlet {

   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * This method get all information by rid is <code>int</code>
     * This method contain <code>ReportDAO</code> to get information of report by rid
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
            ArrayList<Reports> reports = reportDAO.getReportByID(reportID);

            request.setAttribute("reports", reports);
            request.getRequestDispatcher("adminview/adminEditReport.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     * This method is used to update data of report by rid is a <code>int</code>
     * This method contain <code>ReportDAO</code> to update information of report again
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int reportID = Integer.parseInt(request.getParameter("reportId").trim());
            String status = request.getParameter("reportStatus").trim();
            
            Pattern pattern = Pattern.compile("^[A-Za-z]{1,20}$");
            
            
            Reports reports = new Reports(reportID, status);
            IReportDAO reportDAO = new ReportDAO();
//            int count = reportDAO.updateReport(reports);
            if(pattern.matcher(status).find()){
                reportDAO.updateReport(reports);
                request.setAttribute("mess", "Update ok!");
                response.sendRedirect("homeadmin");
            }else{
                request.setAttribute("mess", "Update Not Ok!");
            }
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
