/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.BookOnCart;
import model.Product;

/**
 *
 * @author t.manh
 */
@WebServlet(name = "CheckoutCartController", urlPatterns = {"/CheckoutCart"})
public class CheckoutCartController extends HttpServlet {

    private final String CART_NAME_COOKIE = "Carts";

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
            out.println("<title>Servlet CheckoutCartController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckoutCartController at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
            Cookie cartCookie = getCartCookie(request.getCookies());
            ArrayList<BookOnCart> lst = decodeCart(cartCookie);
            
            
        } catch (Exception e) {

        }

    }

    private ArrayList<BookOnCart> decodeCart(Cookie cartCookie) throws Exception {

        ArrayList<BookOnCart> lst = new ArrayList<>();
        String regex1 = "%&%";
        String regex2 = "%";
        ProductDAO db = new ProductDAO();

        //split [bookid]%[quantity]
        String[] arrCart = cartCookie.getValue().split(regex1);

        for (int i = 0; i < arrCart.length; i++) {
            //split sring to get [bookid] and [quantity]
            String[] temp = arrCart[i].split(regex2);
            //parse quantity
            String bookId = temp[0];
            int quantity = Integer.parseInt(temp[1]);
            lst.add(new BookOnCart(bookId, quantity));
        }

        //get books in4 form database
        for (int i = 0; i < lst.size(); i++) {
            Product product = db.getProductById(lst.get(i).getProductID());
            //if book is not exist
            if (null == product) {
                lst.remove(i);
                continue;
            }

            lst.get(i).setProductName(product.getProductName());
            lst.get(i).setUnitPrice(product.getUnitPrice());
            lst.get(i).setPathImage(product.getImagePath());
        }
        return lst;
    }

    private Cookie getCartCookie(Cookie[] cookies) {
        Cookie cartCookie = null;
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                //if cart cookie exist
                if (cookie.getName().equals(CART_NAME_COOKIE)) {
                    cartCookie = cookie;
                    break;
                }
            }
        }
        return cartCookie;
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
