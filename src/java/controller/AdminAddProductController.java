/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validate.Validate;
import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Riel
 */
@WebServlet(name = "AdminAddProductController", urlPatterns = {"/adminAddProduct"})



public class AdminAddProductController extends RequiredAdminAccount {

    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoryDAO categoryDAO = new CategoryDAO();
        List<Category> categories = categoryDAO.getAllCategories();

        request.setAttribute("categories", categories);
        request.getRequestDispatcher("./adminview/adminaddproduct.jsp").forward(request, response);
    }

    @Override
    protected void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idPara = request.getParameter("id");
            String namePara = request.getParameter("name");
            String descriptionPara = request.getParameter("description");
            String unitPricePara = request.getParameter("unitPrice");
            String unitInStockPara = request.getParameter("unitInStock");
            boolean isContinue = Boolean.parseBoolean(request.getParameter("isContinue"));
            String categoryID = request.getParameter("categoryID");
            String imagePara = request.getParameter("image");
            
            Validate validate = new Validate();
            boolean checkValidate = false ; 
            // validate name of product
            if (!validate.checkName(namePara)) {
                request.setAttribute("namePara", "Your Name product is wrong");
                checkValidate = true ; 
            }
            // validate description of product 
            if (!validate.checkName(descriptionPara)) {
                request.setAttribute("descriptionPara", "Your Description product is wrong");
                checkValidate = true ; 
            }
            // validate price of product 
            if (!validate.checkPrice(unitPricePara)) {
                request.setAttribute("unitPricePara", "Your price product is wrong");
                checkValidate = true ; 
            }
            // validate unit int stock of product 
            if (!validate.checkUnitInStock(unitInStockPara)) {
                request.setAttribute("unitInStockPara", "Your Unit in stock is wrong");
                checkValidate = true ; 
            }
            
            // if all parameters is true 
            if (!checkValidate) {
                double unitInPrice = Double.parseDouble(unitPricePara);
                int unitInStock = Integer.parseInt(unitInStockPara);
                Date date = new Date();  
                java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                
                // add all attribute to class 
                Product product=new Product(idPara, namePara, imagePara, date, descriptionPara, unitInPrice, unitInStock, isContinue, 5, categoryID);
                System.out.println("product " + product.toString());
                
                // update to sql 
                ProductDAO productDAO = new ProductDAO();
                productDAO.insertProduct(product);
            }
            else {
                
            }
            request.getRequestDispatcher("./adminview/adminaddproduct.jsp").forward(request, response);
           
        } catch (Exception e) {
            System.out.println("error " + e);
            // return to the error page
        }


    }

}
