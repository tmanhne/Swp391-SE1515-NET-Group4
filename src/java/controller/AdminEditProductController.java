/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.BooksDAO;
import dao.ProductDAO;
import java.util.ArrayList;
import model.Product;
import model.Product;

/**
 *
 * @author t.manh
 */
@WebServlet(name = "AdminEditProductController", urlPatterns = {"/AdminEditProduct"})
public class AdminEditProductController extends HttpServlet {

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
        processRequest(request, response);
        String pid =request.getParameter("pid");
        BooksDAO db = new BooksDAO();
        Product b = db.getBookById(pid);
        request.setAttribute("book", b);
        request.getRequestDispatcher("adminview/adminEditProduct.jsp").forward(request, response);
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

        ProductDAO db = new ProductDAO();

        String productId = request.getParameter("productId").trim();
        String pName = request.getParameter("productName").trim();
        String pDes = request.getParameter("description").trim();
        float uPrice = Float.parseFloat(request.getParameter("unitPrice").trim());
        int uInStock = Integer.parseInt(request.getParameter("unitInStock").trim());
        boolean isContinues = request.getParameter("unitInStock").equals("Yes") ? true : false;
        int ratting = Integer.parseInt(request.getParameter("ratting").trim());
//        Product b = new Book(productId, pName, pDes, uPrice, uInStock, ratting, isContinues);
        Product b = new Product(productId, pName, pDes, uPrice, uInStock, isContinues, ratting);
        request.setAttribute("book", b);
        int count = db.updateBook(b);

        request.setAttribute("mess", count);
        if (count != 0) {
            request.setAttribute("mess", "Update success!!");
        } else {
            request.setAttribute("mess", "Update fail!!");
        }
        request.getRequestDispatcher("adminview/adminEditProduct.jsp").forward(request, response);

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
