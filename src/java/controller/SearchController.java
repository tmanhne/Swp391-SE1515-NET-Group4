/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-10      1.0                 DuLT           First Implement
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
import model.Product;

/**
 * The class contain method doPost
 *
 * @author dult
 */
@WebServlet(name = "SearchController", urlPatterns = {"/search"})
public class SearchController extends HttpServlet {

    /**
     * Get keyword from search bar
     * If not empty search record of books match in database then setAttribute then forward
     *
     * @param request is HttpServletRequest
     * @param response is HttpServletResponse
     * @return none
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BooksDAO db = new BooksDAO();
        String name = "";
        //check search parameter
        if (request.getParameter("search") != null) {
            if (!request.getParameter("search").toString().trim().isEmpty()) {
                name = request.getParameter("search").toString().trim();//if parameter is not empty
            }
        }

        ArrayList<Product> books = new ArrayList<>();
        books = db.getBookByName(name);

        ArrayList<Product> bestSellerBooks = new ArrayList<>();
        bestSellerBooks = db.getBestSellerBooks();

        request.setAttribute("books", books);
        request.setAttribute("bestSellerBooks", bestSellerBooks);
        request.setAttribute("searchname", name);
        request.getRequestDispatcher("view/LandingPage.jsp").forward(request, response);
    }

}
