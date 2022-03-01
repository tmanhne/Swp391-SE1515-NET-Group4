/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-14        1.0               manhtthe140619      First Implement
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
import dao.ProductDAO;
import java.util.ArrayList;
import model.Product;
import model.Product;

/**
 ** The class contains method respond for initialize update new attribute
 * get value form jsp insert to database.
 * validate value after update.
 * table in database. The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error occurring when
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
        try {
            processRequest(request, response);
            String pid = request.getParameter("pid");
            ProductDAO db = new ProductDAO();
            Product b = db.getProductById(pid);
            request.setAttribute("book", b);
            request.getRequestDispatcher("adminview/adminEditProduct.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
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
            //if all parametter is true 
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
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
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
