/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validate.Validate;
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
import model.Book;
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
        int pid = Integer.parseInt(request.getParameter("pid"));
        BooksDAO db = new BooksDAO();
        Book b = db.getBookById(pid);
        request.setAttribute("book", b);
        request.getRequestDispatcher("adminview/adminEditProduct.jsp").forward(request, response);
//        request.getRequestDispatcher("adminview/adminViewProduct.jsp").forward(request, response);
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
            String productId = request.getParameter("productId");
            String pName = request.getParameter("productName");
            String pDes = request.getParameter("description");
            String uPrice = request.getParameter("unitPrice");
            String uInStock = request.getParameter("unitInStock");
            boolean isContinues = Boolean.parseBoolean(request.getParameter("isContinue"));
            String ratting = request.getParameter("ratting").trim();
//        Product b = new Book(productId, pName, pDes, uPrice, uInStock, ratting, isContinues);

            Validate validate = new Validate();
            boolean checkValidate = false;
            // validate name of product
            if (!validate.checkName(pName)) {
                request.setAttribute("pName", "Name is wrong");
                checkValidate = true;
            }
            // validate description of product 
            if (!validate.checkName(pDes)) {
                request.setAttribute("pDes", "Your Description product is wrong");
                checkValidate = true;
            }
            // validate price of product
            if (!validate.checkPrice(uPrice)) {
                request.setAttribute("uPrice", "Your price product is wrong");
                checkValidate = true;
            }
            // validate unit int stock of product 
            if (!validate.checkUnitInStock(uInStock)) {
                request.setAttribute("uInStock", "Your Unit in stock is wrong");
                checkValidate = true;
            }
            // if all parameters is true 
            double unitInPrice = Double.parseDouble(uPrice);
            int unitInStock = Integer.parseInt(uInStock);
            int uratting = Integer.parseInt(ratting);
            Product b = new Product(productId, pName, pDes, unitInPrice, unitInStock, isContinues, uratting);
            // update to database
            System.out.println("product " + b.toString());
            ProductDAO db = new ProductDAO();
            request.setAttribute("book", b);
            if (!checkValidate) {
                request.getRequestDispatcher("adminview/adminEditProduct.jsp").forward(request, response);
                return;
            }
            int count = db.updateBook(b);
            request.setAttribute("mess", count);
            if (count != 0) {
                request.setAttribute("mess", "Update success!!");
            } else {
                request.setAttribute("mess", "Update fail!!");
            }
            request.getRequestDispatcher("adminview/adminEditProduct.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("error " + e);
        }
//        request.getRequestDispatcher("adminview/adminEditProduct.jsp").forward(request, response);
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
