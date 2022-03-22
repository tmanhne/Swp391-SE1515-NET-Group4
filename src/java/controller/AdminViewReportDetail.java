/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-03-05         1.0               VUDMHE140017      First Implement
 */
package controller;

import dao.ProductDAO;
import dao.ReportDAO;
import interfaceDAO.IProductDAO;
import interfaceDAO.IReportDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;
import model.Reports;

/**
 * The class contain method doGet used ReportDAO to get all information of reports.
 * @author vudm
 */
@WebServlet(name = "AdminViewReportDetail", urlPatterns = {"/AdminViewReportDetail"})
public class AdminViewReportDetail extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *  This method is used to get all information of report by rid
     *  This method used <code>ReportDAO </code> to get all information by rid
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
              IProductDAO db = new ProductDAO();
            List<Product> books = new ArrayList<>();
            books = db.getProductByName(name);
            request.setAttribute("searchname", name);
            int reportID = Integer.parseInt(request.getParameter("rid"));
            IReportDAO reportDAO = new ReportDAO();
            ArrayList<Reports> reports = reportDAO.getReportByID(reportID);

            request.setAttribute("reports", reports);
            request.getRequestDispatcher("adminview/adminViewReportDetail.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);

        }
    }

    /**

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
