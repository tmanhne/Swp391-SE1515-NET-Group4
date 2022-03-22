/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validate.Validate;
import dao.CustomerDAO;
import dao.DiscountDAO;
import dao.FeedBackDAO;
import dao.ProductDAO;
import interfaceDAO.IDiscount;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Customer;
import model.DisCount;
import model.FeedBack;
import model.Product;

/**
 *
 * @author Thongchu
 */
@WebServlet(name = "AdminAddDiscount", urlPatterns = {"/AdminAddDiscount"})
public class AdminAddDiscount extends HttpServlet {

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
            CustomerDAO customerDAO = new CustomerDAO();
            ProductDAO productDAO = new ProductDAO();
            ArrayList<Customer> customers = new ArrayList<>();
            String customersSelected = "";
            ArrayList<Product> products = new ArrayList<>();
            // get all feedback in database             
            customers = (ArrayList<Customer>) customerDAO.getAllCustomer();
            products = (ArrayList<Product>) productDAO.getAllProduct();
            String discountCODE = generateDiscountCode();

            request.setAttribute("customers", customers);
            request.setAttribute("customersSelected", customersSelected);
            request.setAttribute("products", products);
            request.setAttribute("discountCODE", discountCODE);
            request.getRequestDispatcher("./adminview/adminAddDiscount.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error" + e);
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
            String idDelete = request.getParameter("deleteIDCustomer");
            String customersSelected = request.getParameter("customersSelected");
            String discountCODE = request.getParameter("discountCODE").trim();
            String customer = request.getParameter("customer");
            String add = request.getParameter("btn-add-memberDiscount");
            String deleteIDCustomer = request.getParameter("deleteIDCustomer");
            String save = request.getParameter("save");
            String discountPara = request.getParameter("discount").trim();

            CustomerDAO customerDAO = new CustomerDAO();
            ProductDAO productDAO = new ProductDAO();
            ArrayList<Customer> customers = new ArrayList<>();
            ArrayList<Product> products = new ArrayList<>();
            Validate validate = new Validate();
            IDiscount iDiscount = new DiscountDAO();

            // get all feedback in database    
            int discountValue = Integer.parseInt(discountPara);
            customers = (ArrayList<Customer>) customerDAO.getAllCustomer();
            products = (ArrayList<Product>) productDAO.getAllProduct();

            if (null != add && null != customer && customer.length() > 0) {
                if (customersSelected.equals("")) {
                    customersSelected = customer;
                } else {
                    customersSelected = customersSelected + "," + customer;
                }
                String[] customersArray = customersSelected.split(",");
                for (int i = customers.size() - 1; i >= 0; --i) {
                    for (int j = 0; j < customersArray.length; ++j) {
                        if (customers.get(i).getCustomerName().equals(customersArray[j])) {
                            customers.remove(i);
                            break;
                        }
                    }

                }
                request.setAttribute("customers", customers);
                request.setAttribute("customersSelected", customersSelected);
                request.setAttribute("products", products);
                request.setAttribute("discountCODE", discountCODE);
                request.getRequestDispatcher("./adminview/adminAddDiscount.jsp").forward(request, response);
            } else if (null != deleteIDCustomer) {
                String[] customersArr = customersSelected.split(",");
                String customersAfterRemove = "";
                for (int i = 0; i < customersArr.length; ++i) {
                    if (!customersArr[i].equals(deleteIDCustomer)) {
                        customersAfterRemove += customersArr[i] + ",";
                    }
                }
                if (customersAfterRemove.length() > 0) {
                    customersAfterRemove = customersAfterRemove.substring(0, customersAfterRemove.length() - 1);
                }
                customersSelected = customersAfterRemove;

                String[] customersArray = customersSelected.split(",");
                for (int i = customers.size() - 1; i >= 0; --i) {
                    for (int j = 0; j < customersArray.length; ++j) {
                        if (customers.get(i).getCustomerName().equals(customersArray[j])) {
                            customers.remove(i);
                            break;
                        }
                    }

                }
                request.setAttribute("customers", customers);
                request.setAttribute("customersSelected", customersSelected);
                request.setAttribute("products", products);
                request.setAttribute("discountCODE", discountCODE);
                request.getRequestDispatcher("./adminview/adminAddDiscount.jsp").forward(request, response);
            } else if (null != save) {
                if (!validate.checkNumberInRange(discountValue, 0, 100)) {
                    request.setAttribute("message", "discount invalid");
                    String[] customersArray = customersSelected.split(",");
                    for (int i = customers.size() - 1; i >= 0; --i) {
                        for (int j = 0; j < customersArray.length; ++j) {
                            if (customers.get(i).getCustomerName().equals(customersArray[j])) {
                                customers.remove(i);
                                break;
                            }
                        }

                    }
                    request.setAttribute("customers", customers);
                    request.setAttribute("customersSelected", customersSelected);
                    request.setAttribute("products", products);
                    request.setAttribute("discountCODE", discountCODE);
                    request.getRequestDispatcher("./adminview/adminAddDiscount.jsp").forward(request, response);
                } else {
                    String[] customersArr = customersSelected.split(",");
                    for (int i = customers.size() - 1; i >= 0; --i) {
                        for (int j = 0; j < customersArr.length; ++j) {
                            if (customers.get(i).getCustomerName().equals(customersArr[j])) {
                                DisCount discount = new DisCount(1, discountCODE, customers.get(i).getCustomerID(), "aaa", "aaa", "aaa", true, discountValue);
                                iDiscount.insertDiscount(discount);
                            }
                        }
                    }
                    discountCODE = generateDiscountCode();
                    request.setAttribute("message", "add discount success");
                    request.setAttribute("customers", customers);
                    request.setAttribute("customersSelected", "");
                    request.setAttribute("products", products);
                    request.setAttribute("discountCODE", discountCODE);
                    request.getRequestDispatcher("./adminview/adminAddDiscount.jsp").forward(request, response);
                }

            }

        } catch (Exception e) {
            System.out.println("Error" + e);
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

    private String generateDiscountCode() {
        String code = "";
        Random rand = new Random();
        for (int i = 1; i <= 5; ++i) {
            int ranNum = rand.nextInt(26) + 'a';
            code += (char) (ranNum);
        }
        for (int i = 1; i <= 5; ++i) {
            int ranNum = rand.nextInt(26) + 'A';
            code += (char) (ranNum);
        }
        for (int i = 1; i <= 5; ++i) {
            int ranNum = rand.nextInt(10);
            code += (char) (ranNum + '0');
        }
        return code;
    }

}
