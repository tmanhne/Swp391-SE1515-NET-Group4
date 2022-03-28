/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-14        1.0               manhtthe140619      First Implement
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ProductDAO;
import java.io.File;
import java.util.List;
import model.Product;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import model.Constants;

/**
 * <<<<<<< HEAD * The class contains method respond for initialize update new
 * attribute get value form jsp insert to database. validate value after update.
 * table in database. The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error occurring when
 * ======= * The class contains method respond for initialize update new
 * attribute get value form jsp insert to database. validate value after update.
 * table in database. The method will throw an object of
 * <code>java.lang.Exception</code> class if there is any error occurring when
 * >>>>>>> 534a726ca39784dcca20c722f405e9e8723f74e1
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
            String productId = null;
            String pName = null;
            String pDes = null;
            String uPrice = null;
            String uInStock = null;
            boolean isContinues = true;
            String ratting = null;
            String imagePath = null;

            //get param
            if (ServletFileUpload.isMultipartContent(request)) {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : multiparts) {
                    if (item.isFormField()) {
                        String paramname = item.getFieldName();
                        switch (paramname) {
                            case "productId": {
                                productId = item.getString();
                                break;
                            }
                            case "productName": {
                                pName = item.getString();
                                break;
                            }
                            case "description": {
                                pDes = item.getString();
                                break;
                            }
                            case "unitPrice": {
                                uPrice = item.getString();
                                break;
                            }
                            case "unitInStock": {
                                uInStock = item.getString();
                                break;
                            }
                            case "isContinues": {
                                isContinues = item.getString().contains("Yes");
                                break;
                            }
                            case "ratting": {
                                ratting = item.getString().trim();
                                break;
                            }
                        }
                    } else {
                        if (item.getSize() != 0) {
                            imagePath = uploadImage(item);
                        }
                    }
                }
            }

            // Check here
            // if all parameters is true 
            double unitInPrice = Double.parseDouble(uPrice);
            int unitInStock = Integer.parseInt(uInStock);
            int uratting = Integer.parseInt(ratting);

            Product b;
            if (imagePath != null) {
                b = new Product(productId, pName, imagePath, pDes, unitInPrice, unitInStock, isContinues, uratting);
            } else {
                b = new Product(productId, pName, pDes, unitInPrice, unitInStock, isContinues, uratting);
            }
            // update to database
            ProductDAO db = new ProductDAO();
            request.setAttribute("book", b);
            //if all parametter is true 
//            if (!checkValidate) {
//                request.getRequestDispatcher("adminview/adminEditProduct.jsp").forward(request, response);
//                return;
//            }
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

    private String uploadImage(FileItem item) throws Exception {
        String relativePath = null;
        try {
            String name = new File(item.getName()).getName();
            item.write(new File(Constants.UPLOAD_DIRECTORY + File.separator + name));
            relativePath = "./public/image/" + name;
        } catch (Exception ex) {
            throw ex;
        }
        return relativePath;
    }
}
