/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-18         1.0               VUDMHE140017,THONGCTHE140606      First Implement
 */

package controller;

import dao.FeedBackDAO;
import dao.ProductDAO;
import interfaceDAO.IFeedBackDAO;
import interfaceDAO.IProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.FeedBack;
import model.Product;

/**
 * The class used <code>IProductDAO</code> to get product detail 
 * @author vudm
 */
@WebServlet(name = "ProductDetailController", urlPatterns = {"/viewDetail"})
public class ProductDetailController extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * The method is used to get detail product to forward ProductDetail.jsp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String productID = request.getParameter("id");
            IProductDAO productDAO = new ProductDAO();
            
            IFeedBackDAO feedBackDAO= new FeedBackDAO();
            Product product = productDAO.getProductById(productID);
            // get all feedback in database
            ArrayList<FeedBack> feedBacks=new ArrayList<>();
            feedBacks = (ArrayList<FeedBack>) feedBackDAO.getAllFeedBack();
            request.setAttribute("book", product);
            request.setAttribute("feedBacks", feedBacks);
            
            
            request.getRequestDispatcher("view/ProductDetail.jsp").forward(request, response);
        }catch(IOException | SQLException | ServletException   ex){
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * The method is used to get detail product to forward ProductDetail.jsp
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String productID = request.getParameter("id");
            IProductDAO productDAO = new ProductDAO();
            
            IFeedBackDAO feedBackDAO= new FeedBackDAO();
            Product product = productDAO.getProductById(productID);
            // get all feedback in database
            ArrayList<FeedBack> feedBacks=new ArrayList<>();
            feedBacks = (ArrayList<FeedBack>) feedBackDAO.getAllFeedBack();
            
            String btnSubmit = request.getParameter("btn-submit-comment");
            if(null != btnSubmit) {
                String rate = request.getParameter("rate");
                String comment = request.getParameter("text-comment");
            }
            
            request.setAttribute("book", product);
            request.setAttribute("feedBacks", feedBacks);
            
            
            request.getRequestDispatcher("view/ProductDetail.jsp").forward(request, response);
        }catch(IOException | SQLException | ServletException   ex){
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
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
