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
 * The class contain method doGet used ReportDAO to get all report  then forward to adminViewReport.jsp
 * @author vudm
 */
@WebServlet(name = "AdminViewReportController", urlPatterns = {"/adminViewReport"})
public class AdminViewReportController extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * This method is used to get all report and display data on adminViewReport.jsp
     *  This method uses <code>ReportDAO</code> to get all report from database follow index page
     *  if connect not good system will be forward to error.jsp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
             IReportDAO reportDAO = new ReportDAO();

              String indexPage = request.getParameter("index");
              if (indexPage == null) {
                  indexPage = "1";
              }
              int index = Integer.parseInt(indexPage);
              int count = reportDAO.getTotalProduct();//7
              int endPage = count / 3;//7/3=2
              if (count % 3 != 0) {
                  endPage++;
              }
              String name = "";
            //check search parameter
            if (request.getParameter("search") != null) {
                if (!request.getParameter("search").trim().isEmpty()) {
                    name = request.getParameter("search").trim();//if parameter is not empty
                }
            }
             IProductDAO db = new ProductDAO();
            List<Product> books = new ArrayList<>();
            books = db.getProductByName(name);
            request.setAttribute("searchname", name);
              List<Reports> listPage = reportDAO.pagingReport(index);
              request.setAttribute("listPage", listPage);
//            request.setAttribute("list", books);
              request.setAttribute("endPage", endPage);
              
              
            
            request.getRequestDispatcher("adminview/adminViewReport.jsp").forward(request, response);
        }catch(Exception ex){
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
