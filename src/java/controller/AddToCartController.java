/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Product;

/**
 *
 * @author Hfyl
 */
@WebServlet(name = "AddToCartController", urlPatterns = {"/AddToCart"})
public class AddToCartController extends HttpServlet {

    private final String CART_NAME_COOKIE = "Carts";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO bd = new ProductDAO();
        String id = request.getParameter("Pid");
        Product product = bd.getProductById(id);
        if (null == product) {
            //response.sendRedirect(""); error page
            return;
        }
        Cookie[] cookies = request.getCookies();

        Cookie cookie = editCart(cookies, id);
        if (null != cookie) {
            response.addCookie(cookie);
        }
        request.setAttribute("bookid", id);
        request.getRequestDispatcher("").forward(request, response);
    }

    private Cookie editCart(Cookie[] cookie, String productID) {
        String cartValue = "";
        Cookie cartCookie = null;

        if (null != cookie) {
            for (Cookie cookie1 : cookie) {
                //if cart cookie exist
                if (cookie1.getName().equals(CART_NAME_COOKIE)) {
                    cartCookie = cookie1;
                    break;
                }
            }
        }

        if (null == cartCookie) {
            cartCookie = new Cookie(CART_NAME_COOKIE, cartValue);
        }
        
        cartValue = cartCookie.getValue();
        cartValue = updateCartValue(cartValue, productID);
        cartCookie.setValue(cartValue);
        cartCookie.setMaxAge(60 * 60 * 24 * 7);
        return cartCookie;
    }

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
            for (int i = 0; i < arrCart.length; i++) {
                //if product is exist on cart
                if (arrCart[i].contains(productID)) {
                    addNew = false;
                    //split sring to get [bookid] and [quantity]
                    String[] temp = arrCart[i].split(regex2);
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
                sb.append(arrCart[i])
                        .append(regex1);
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
