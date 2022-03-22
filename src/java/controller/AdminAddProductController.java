/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Validate.Validate;
import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.File;
import model.Category;
import model.Product;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Riel
 */
@WebServlet(name = "AdminAddProductController", urlPatterns = {"/adminAddProduct"})

public class AdminAddProductController extends RequiredAdminAccount {
    private final String UPLOAD_DIRECTORY = "D:\\LearnFPT\\Term6\\SWP391\\Code\\Swp391-SE1515-NET-Group4\\web\\public\\image";
    @Override
    protected void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> categories = categoryDAO.getAllCategories();

            request.setAttribute("categories", categories);
            request.getRequestDispatcher("adminview/adminaddproduct.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }

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
            String imagePara = null;

            //get param
            if (ServletFileUpload.isMultipartContent(request)) {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (item.isFormField()) {
                        String paramname = item.getFieldName();
                        switch (paramname) {
                            case "id": {
                                idPara = item.getString();
                                break;
                            }
                            case "name": {
                                namePara = item.getString();
                                break;
                            }
                            case "description": {
                                descriptionPara = item.getString();
                                break;
                            }
                            case "unitPrice": {
                                unitPricePara = item.getString();
                                break;
                            }
                            case "unitInStock": {
                                unitInStockPara = item.getString();
                                break;
                            }
                            case "isContinue": {
                                isContinue = item.getString().contains("Yes");
                                break;
                            }
                            case "categoryID": {
                                categoryID = item.getString().trim();
                                break;
                            }
                        }
                    } else {
                        imagePara = uploadImage(item);
                    }
                }
            }
            
            Validate validate = new Validate();
            boolean checkValidate = false;
            // validate name of product
            if (!validate.checkName(namePara)) {
                request.setAttribute("namePara", "Your Name product is wrong");
                checkValidate = true;
            }
            // validate description of product 
            if (!validate.checkName(descriptionPara)) {
                request.setAttribute("descriptionPara", "Your Description product is wrong");
                checkValidate = true;
            }
            // validate price of product 
            if (!validate.checkPrice(unitPricePara)) {
                request.setAttribute("unitPricePara", "Your price product is wrong");
                checkValidate = true;
            }
            // validate unit int stock of product 
            if (!validate.checkUnitInStock(unitInStockPara)) {
                request.setAttribute("unitInStockPara", "Your Unit in stock is wrong");
                checkValidate = true;
            }
            Date date = new Date();
            Product product = new Product(idPara, namePara, imagePara, date, descriptionPara, 0, 0, isContinue, 5, categoryID);
            // if all parameters is true 
            if (!checkValidate) {
                double unitInPrice = Double.parseDouble(unitPricePara);
                int unitInStock = Integer.parseInt(unitInStockPara);
                

                // add all attribute to class 
                product.setUnitPrice(unitInPrice);
                product.setUnitInStock(unitInStock);
                // update to sql 
                ProductDAO productDAO = new ProductDAO();
                productDAO.insertProduct(product);
            }
            CategoryDAO categoryDAO = new CategoryDAO();
            List<Category> categories = categoryDAO.getAllCategories();

            request.setAttribute("categories", categories);
            request.setAttribute("unitPrice", unitPricePara);
            request.setAttribute("UnitInStock", unitInStockPara);
            request.setAttribute("cateSelected", categoryID);
            request.setAttribute("book", product);
            request.getRequestDispatcher("adminview/adminaddproduct.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }

    }

    private String uploadImage(FileItem item) throws Exception {
        String relativePath = null;
        try {
            String name = new File(item.getName()).getName();
            item.write(new File(UPLOAD_DIRECTORY + File.separator + name));
            relativePath = "./public/image/" + name;
        } catch (Exception ex) {
            throw ex;
        }
        return relativePath;
    }
}
