/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.util.BooksDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

/**
 *
 * @author Hfyl
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BooksDAO db = new BooksDAO();
        
        ArrayList<Book> books = new ArrayList<>();
         books = db.getAllBooks();
        
        ArrayList<Book> bestSellerBooks = new ArrayList<>();
        bestSellerBooks = db.getBestSellerBooks();
        
        request.setAttribute("books", books);
        request.setAttribute("bestSellerBooks", bestSellerBooks);
        request.getRequestDispatcher("view/LandingPage.jsp").forward(request, response);
    }
}
