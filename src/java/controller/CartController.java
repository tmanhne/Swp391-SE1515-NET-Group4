/*
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-20      1.0                 DULT               Second Implement
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
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
 * @author dult
 */
@WebServlet(name = "CartController", urlPatterns = {"/cart"})
public class CartController extends HttpServlet {

    private final String CART_NAME_COOKIE = "Carts";
        /**
     * Processes requests for both HTTP <code>GET</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie cartCookie = getCartCookie(request.getCookies());

        if (null != cartCookie && !cartCookie.getValue().isEmpty()) {
            //encode books cookie
            ArrayList<BookOnCart> booklst = decodeCart(cartCookie);
            request.setAttribute("books", booklst);
        }
        request.getRequestDispatcher("view/Cart.jsp").forward(request, response);
    }
        /**
     * Processes requests for both HTTP <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sub = request.getParameter("decrease");
        String add = request.getParameter("increase");
        String delete = request.getParameter("delete");
        Cookie cartCookie = getCartCookie(request.getCookies());

        if (null != cartCookie && !cartCookie.getValue().isEmpty()) {
            ArrayList<BookOnCart> booklst = decodeCart(cartCookie);

            //case decrease quantity
            if (null != sub) {
                booklst = updateCartValue(booklst, sub, -1);
            }
            //case increase quantity
            if (null != add) {
                booklst = updateCartValue(booklst, add, 1);
            }
            //case remove book from cart
            if (null != delete) {
                booklst = updateCartValue(booklst, delete, 0);
            }

            /*update cartCookie*/
            //if booklst is not empty
            if (!booklst.isEmpty()) {
                String cartValue = encodeCart(booklst);
                cartCookie.setValue(cartValue);
                cartCookie.setMaxAge(60 * 60 * 24 * 7);
            } else {
                cartCookie.setValue("");
                cartCookie.setMaxAge(0);
            }
            response.addCookie(cartCookie);
            request.setAttribute("books", booklst);
        }
        request.getRequestDispatcher("view/Cart.jsp").forward(request, response);
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

    private ArrayList<BookOnCart> decodeCart(Cookie cartCookie) {
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

    private String encodeCart(ArrayList<BookOnCart> booklst) {
        String regex1 = "%&%";
        String regex2 = "%";
        StringBuilder sb = new StringBuilder();

        for (BookOnCart bookOnCart : booklst) {
            //rebuild [bookid]%[quantity]%&%
            sb.append(bookOnCart.getProductID())
                    .append(regex2)
                    .append(bookOnCart.getQuantity())
                    .append(regex1);
        }

        return sb.toString();
    }

    private ArrayList<BookOnCart> updateCartValue(ArrayList<BookOnCart> booklst, String productID, int type) {
        for (int i = 0; i < booklst.size(); i++) {
            if (booklst.get(i).getProductID().equals(productID)) {
                //case remove book from cart
                if (type == 0) {
                    booklst.remove(i);
                    break;
                }
                //case decrease and quantity > 1
                if (type == -1 && booklst.get(i).getQuantity() > 1) {
                    int temp = booklst.get(i).getQuantity() - 1;
                    booklst.get(i).setQuantity(temp);
                    break;
                }
                //case increase quantity
                if (type == 1) {
                    int temp = booklst.get(i).getQuantity() + 1;
                    booklst.get(i).setQuantity(temp);
                }
                break;
            }
        }
        return booklst;
    }
}
