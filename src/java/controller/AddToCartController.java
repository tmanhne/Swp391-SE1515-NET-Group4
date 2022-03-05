/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-21         1.0               VUDMHE140017      First Implement
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 * The class contain method doPost has used to add product to cart
 *
 * @author vudm
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCart"})
public class AddToCartController extends HttpServlet {

    private final String CART_NAME_COOKIE = "Carts";

    /**
     * Processes requests for both HTTP <code>POST</code> methods.
     * The method is used to add products to cart on cookie
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try{
                  ProductDAO bd = new ProductDAO();
                  String productID = request.getParameter("id");
                  Product product = bd.getProductById(productID);
                  if (product == null) {
                        return;
                  }
                  Cookie[] cookies = request.getCookies();

                  Cookie cookie = editCart(cookies, productID);
                  if (cookie != null) {
                        response.addCookie(cookie);
                   }
                  response.sendRedirect("home");
         }catch(IOException | SQLException ex){
             request.setAttribute("message", ex.getMessage());
            request.getRequestDispatcher("view/Error.jsp").forward(request, response);
         }
    }

    /**
     * The method is used to create cart and set value,age
     * @param productID is <code>String<code>
     * @param cookie are array <code>Cookie<code>
     * @return  cartCookie
     */
    private Cookie editCart(Cookie[] cookie, String productID) {
        String cartValue = "";
        Cookie cartCookie = null;

        if (cookie != null) { // if cookie exist
            for (Cookie cookie1 : cookie) {
                //if cart cookie exist
                if (cookie1.getName().equals(CART_NAME_COOKIE)) {
                    cartCookie = cookie1;
                    break;
                }
            }
        }

        if (cartCookie == null) {//create cookie with name Cart
            cartCookie = new Cookie(CART_NAME_COOKIE, cartValue);
        }

        cartValue = cartCookie.getValue();
        cartValue = updateCartValue(cartValue, productID);
        cartCookie.setValue(cartValue);
        cartCookie.setMaxAge(60 * 60);
        return cartCookie;
    }

    /**
     * The method is used to update value
     * @param cartValue is <code>String<code>
     * @param productID is a <code>String<code>
     * @return sb.toString()
     */
    private String updateCartValue(String cartValue, String productID) {
        String regex1 = "%&%";
        String regex2 = "%";
        StringBuilder sb = new StringBuilder();
        boolean addNew = true;

        //if cart not empty
        if (!cartValue.isEmpty()) {

            //split [bookid]%[quantity]
            String[] arrCart = cartValue.split(regex1);

            //check for book
            for (String arrCart1 : arrCart) {
                //if product is exist on cart
                if (arrCart1.contains(productID)) {
                    addNew = false;
                    //split sring to get [bookid] and [quantity]
                    String[] temp = arrCart1.split(regex2);
                    //count up quantity
                    int quantity = Integer.parseInt(temp[1]) + 1;
                    //rebuild [bookid]%[quantity]%&% then continue
                    sb.append(productID)
                            .append(regex2)
                            .append(quantity)
                            .append(regex1);
                    continue;
                }
                //rebuild [bookid]%[quantity]%&%
                sb.append(arrCart1).append(regex1);
            }
        }

        //if product is not exist on cart
        if (addNew) {
            sb.append(productID)
                    .append(regex2)
                    .append(1)
                    .append(regex1);
        }

        return sb.toString();
    }
}
