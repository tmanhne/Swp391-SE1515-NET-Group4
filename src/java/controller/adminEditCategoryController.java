/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validate.Validate;
import dao.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Category;

/**
 *
 * @author t.manh
 */
@WebServlet(name = "adminEditCategoryController", urlPatterns = {"/adminEditCategory"})
public class adminEditCategoryController extends HttpServlet {

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
            out.println("<title>Servlet adminEditCategoryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminEditCategoryController at " + request.getContextPath() + "</h1>");
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
            String cId = request.getParameter("cId");
            CategoryDAO db = new CategoryDAO();
            Category cate = db.getCategoryById(cId);
            request.setAttribute("cate", cate);
            request.getRequestDispatcher("adminview/adminEditCategory.jsp").forward(request, response);
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
            Validate v = new Validate();
            boolean checkValidate = false;

            String cateId = request.getParameter("categoryID");
            String cateName = request.getParameter("categoryName");
            //validate categoryName            
            if (!v.checkName(cateName)) {
                request.setAttribute("cateName", "name is wrong");
                checkValidate = true;
            }
            //if checkValidate true (all vadiable correct) => update
            if (!checkValidate) {
                Category category = new Category(cateId, cateName);
                CategoryDAO db = new CategoryDAO();
                request.setAttribute("cate", category);
                int count = db.updateCategory(category);
                request.setAttribute("mess", count);
                if (count != 0) {
                    request.setAttribute("mess", "Update success!!");
                } else {
                    request.setAttribute("mess", "Update fail!!");
                }
                request.getRequestDispatcher("adminview/adminEditCategory.jsp").forward(request, response);
//                return;
            } else {
                Category category = new Category(cateId, cateName);
                CategoryDAO db = new CategoryDAO();
                request.setAttribute("cate", category);
                //if one variable false => return page and variable false
                request.getRequestDispatcher("adminview/adminEditCategory.jsp").forward(request, response);
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
