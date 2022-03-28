/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-21         1.0               manhtthe140619      First Implement
 */
package controller;

import Validate.Validate;
import dao.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLDataException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 ** The class contains method respond for initialize add new attribute get
 * value form jsp insert to database. validate value after insert. table in
 * database. The method will throw an object of <code>java.lang.Exception</code>
 * class if there is any error occurring when
 *
 * @author t.manh
 */
@WebServlet(name = "AdminAddCategoryController", urlPatterns = {"/AdminAddCategory"})
public class AdminAddCategoryController extends HttpServlet {

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
            out.println("<title>Servlet AdminAddCategoryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AdminAddCategoryController at " + request.getContextPath() + "</h1>");
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
            request.getRequestDispatcher("adminview/adminAddCategory.jsp").forward(request, response);
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
        try {
            String cateId = request.getParameter("categoryId");
            String cateName = request.getParameter("categoryName");
            Validate v = new Validate();
            boolean checkValidate = false;
            //validate nameCategory
            if (!v.checkName(cateName)) {
                request.setAttribute("cateName", "name is wrong");
                checkValidate = true;
            }
            if (!v.checkLengthComment(cateName)) {
                request.setAttribute("cateName", "name is length");
                checkValidate = true;
            }
            //if all paremeters is true
            if (!checkValidate) {
                //add all atribute to class
                Category cate = new Category(cateId, cateName);
                //update Sql
                CategoryDAO cateDao = new CategoryDAO();
                cateDao.insertCategory(cate);
                request.setAttribute("mess", "insert success");
            } else {
                Category category = new Category(cateId, cateName);
                CategoryDAO db = new CategoryDAO();
                request.setAttribute("category", category);
                //if one variable false => return page and variable false
                request.setAttribute("mess", "insert fail");
                request.getRequestDispatcher("adminview/adminAddCategory.jsp").forward(request, response);
            }
            request.getRequestDispatcher("adminview/adminAddCategory.jsp").forward(request, response);
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
