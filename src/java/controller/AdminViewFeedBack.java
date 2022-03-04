/**
 * Copyright(C)2022, FPT University
 * SWP391
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-27         1.0               ThongCT              First Implement
 */
package controller;

import dao.CustomerDAO;
import dao.FeedBackDAO;
import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.FeedBack;
import model.Product;

/**
 *
 * @author ThongCHu
 * @description: This Page for manager feedback of user 
 */
@WebServlet(name = "AdminViewFeedBack", urlPatterns = {"/AdminViewFeedBack"})
public class AdminViewFeedBack extends HttpServlet {


    /**
     * ThongCTHE140606
     * @return take the user to the html page so that the user can manipulate the functions 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            FeedBackDAO feedBackDAO=new FeedBackDAO();
            CustomerDAO customerDAO =new CustomerDAO();
            ProductDAO productDAO=new ProductDAO();
            ArrayList<FeedBack> feedBacks=new ArrayList<>();
            ArrayList<Customer> customers=new ArrayList<>();
            ArrayList<Product> products=new ArrayList<>();
            // get all feedback in database             
            feedBacks = (ArrayList<FeedBack>) feedBackDAO.getAllFeedBack();
            customers = (ArrayList<Customer>) customerDAO.getAllCustomer();
            products = (ArrayList<Product>) productDAO.getAllProduct();
            //set attribute for jsp 
            request.setAttribute("feedBacks", feedBacks);
            request.setAttribute("customers", customers);
            request.setAttribute("products", products);
            request.getRequestDispatcher("./adminview/adminViewFeedBack.jsp").forward(request, response);
        } 
        catch (Exception e) {
            System.out.println("Error"+ e);
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
    }

    /**
     * ThongCTHE140606
     * @return check the fields that the admin clicks if there is no error field, it will give the data that the admin is looking for
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String searchViewFeedBack = request.getParameter("searchViewFeedBack");
            CustomerDAO customerDAO =new CustomerDAO();
            ProductDAO productDAO=new ProductDAO();
            ArrayList<Customer> customers=new ArrayList<>();
            ArrayList<Product> products=new ArrayList<>();
            // get all feedback in database             
            customers = (ArrayList<Customer>) customerDAO.getAllCustomer();
            products = (ArrayList<Product>) productDAO.getAllProduct();
            // admin click search 
            if (null != searchViewFeedBack) {
                String customerPara = request.getParameter("customerID");
                String productPara = request.getParameter("productID");
                
                // check null for parameter
                if (null!=customerPara && null!=productPara) {
                    FeedBackDAO feedBackDAO=new FeedBackDAO();
                    ArrayList<FeedBack> feedBacks=new ArrayList<>();
                    feedBacks = (ArrayList<FeedBack>) feedBackDAO.getAllFeedBackByQuerry(customerPara,productPara);
                    // check contain data 
                    if(feedBacks.size() >0 ) {
                        request.setAttribute("feedBacks", feedBacks);
                        request.setAttribute("customers", customers);
                        request.setAttribute("products", products);
                        request.setAttribute("customerPara", customerPara);
                        request.setAttribute("productPara", productPara);
                        request.getRequestDispatcher("./adminview/adminViewFeedBack.jsp").forward(request, response);
                    }
                    else {
                        request.setAttribute("feedBacks", feedBacks);
                        request.setAttribute("customers", customers);
                        request.setAttribute("products", products);
                        request.setAttribute("customerPara", customerPara);
                        request.setAttribute("productPara", productPara);
                        request.setAttribute("message", "Dont have data");
                        request.getRequestDispatcher("./adminview/adminViewFeedBack.jsp").forward(request, response);
                    }
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Error"+ e);
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
