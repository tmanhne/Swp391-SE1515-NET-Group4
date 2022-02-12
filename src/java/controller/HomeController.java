/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-07      1.0                 VUDM               Interation1
 */

package controller;

import dao.BooksDAO;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Book;

/**
 * The class contain method doGet
 *
 * @author vudm
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home"})
public class HomeController extends HttpServlet {
    
     /**
     * Get all book,best seller and highest price of products from database
     * Then setAttribute and forward to LangdingPage
     *
     * @param request is HttpServletRequest
     * @param response is HttpServletResponse
     * @return none
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BooksDAO db = new BooksDAO();
        
        ArrayList<Book> books = new ArrayList<>();
         books = db.getAllBooks();//Get all book from database
        
        ArrayList<Book> bestSellerBooks = new ArrayList<>();
        bestSellerBooks = db.getBestSellerBooks();//get 3 most purchased products
        
        ArrayList<Book> highestPricerBooks = new ArrayList<>();
        highestPricerBooks = db.getHighestPriceBooks();//Get 2 highest price products
        
        request.setAttribute("books", books);
        request.setAttribute("bestSellerBooks", bestSellerBooks);
        request.setAttribute("highestPricerBooks", highestPricerBooks);
        request.getRequestDispatcher("view/LandingPage.jsp").forward(request, response);
    }
}
