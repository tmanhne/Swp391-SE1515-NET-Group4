/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-21         1.0               manhtthe140619      First Implement
 */
package controller;

import dao.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 ** The class contains method respond for initialize, view. 
 * Using Category value from database to get information form data base from Category
 * table in database. The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error occurring when finding
 *
 * @author t.manh
 */
@WebServlet(name = "AdminViewCategoryController", urlPatterns = {"/AdminViewCategory"})
public class AdminViewCategoryController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminViewCategoryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminViewCategoryController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
            CategoryDAO db = new CategoryDAO();
            //get value form databse
            List<Category> list = db.getAllCategories();
            request.setAttribute("list", list);
            request.getRequestDispatcher("adminview/adminCategory.jsp").forward(request, response);
        } catch (Exception e) {
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
        processRequest(request, response);
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
