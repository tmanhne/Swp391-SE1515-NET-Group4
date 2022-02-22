/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-07      1.0                 ThiPT            First Implement
 */
package controller;

import dao.BooksDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author phamthithi
 */
@WebServlet(name = "HomeAdminController", urlPatterns = {"/homeadmin"})
public class HomeAdminController extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HomeAdminController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HomeAdminController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        BooksDAO db = new BooksDAO();
//        List<Book> books = new ArrayList<>();
//        books = db.getAllBooks();

        String indexPage = request.getParameter("index");
        if (indexPage == null) {
            indexPage = "1";
        }
        int index = Integer.parseInt(indexPage);
        int count = db.getTotalProduct();//7
        int endPage = count / 3;//7/3=2
        if (count % 3 != 0) {
            endPage++;
        }
        List<Product> listPage = db.pagingProduct(index);

        request.setAttribute("listPage", listPage);
//        request.setAttribute("list", books);
        request.setAttribute("endPage", endPage);
        request.getRequestDispatcher("view/landingAdmin.jsp").forward(request, response);
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
        String name = "";
        //check search parameter
        if (request.getParameter("search") != null) {
            if (!request.getParameter("search").toString().trim().isEmpty()) {
                name = request.getParameter("search").toString().trim();//if parameter is not empty
            }
        }
        BooksDAO db = new BooksDAO();
        List<Product> books = new ArrayList<>();
        books = db.getBookByName(name);

        request.setAttribute("listPage", books);
        request.setAttribute("searchname", name);
        request.getRequestDispatcher("view/landingAdmin.jsp").forward(request, response);
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
