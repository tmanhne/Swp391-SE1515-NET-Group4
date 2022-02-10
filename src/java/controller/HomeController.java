/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Riel
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        ProductDAO db = new ProductDAO();
//        
//        List<Product> top3Laptops = db.getTopNewestProductsByCategoryID(1, 3);
//        List<Product> top3Tablets = db.getTopNewestProductsByCategoryID(2, 3);
//        List<Product> top3Hybrids = db.getTopNewestProductsByCategoryID(3, 3);
//        
//        request.setAttribute("top3Laptops", top3Laptops);
//        request.setAttribute("top3Tablets", top3Tablets);
//        request.setAttribute("top3Hybrids", top3Hybrids);
        
        request.getRequestDispatcher("./jsp/index.jsp").forward(request, response);
    }
}
