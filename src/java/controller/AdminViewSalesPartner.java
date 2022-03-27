/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-03-26         1.0               VUDMHE140017      First Implement
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.SalesPartnerDAO;
import interfaceDAO.ISalesPartnerDAO;
import java.util.List;
import model.SalesPartner;

/**
 * The class contain method <code>doGet</code> to display SalesPartern
 * @author admin
 */
@WebServlet(name = "AdminViewSalesPartner", urlPatterns = {"/AdminViewSalesPartner"})
public class AdminViewSalesPartner extends HttpServlet {

    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * The method is used to view all SalesPartern and display with paging 
     * The method contain <code>SalesPartnerDAO</code> to get all SalesPartner with paging
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try{
             ISalesPartnerDAO partnerDAO = new SalesPartnerDAO();

              String indexPage = request.getParameter("index");
              if (indexPage == null) {
                  indexPage = "1";
              }
              int index = Integer.parseInt(indexPage);
              int count = partnerDAO.getTotalPartner();//7
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
            

            request.setAttribute("searchname", name);
              List<SalesPartner> listPage = partnerDAO.pagingSalesPartner(index);
              request.setAttribute("listPage", listPage);
//            request.setAttribute("list", books);
              request.setAttribute("endPage", endPage);
              
              
            
            request.getRequestDispatcher("adminview/adminViewSalesPartner.jsp").forward(request, response);
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
