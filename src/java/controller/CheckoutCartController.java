/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import dao.CustomerDAO;
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
import model.Account;
import model.BookOnCart;
import model.Customer;
import model.Product;
import Validate.Validate;
import dao.OrderDAO;
import dao.OrderDetailDAO;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.OrderDetail;

/**
 *
 * @author t.manh
 */
@WebServlet(name = "CheckoutCartController", urlPatterns = {"/checkoutcart"})
public class CheckoutCartController extends HttpServlet {

    private final String CART_NAME_COOKIE = "Carts";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
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
            //get current account in session
            Account account = (Account) request.getSession().getAttribute("account");

            Cookie cartCookie = getCartCookie(request.getCookies());
            //cart empty => no checkout
            if (cartCookie == null || cartCookie.getValue().isEmpty()) {
                request.setAttribute("mess", "Cart is empty!");
                request.getRequestDispatcher("view/cart.jsp").forward(request, response);
                return;
            }
            ArrayList<BookOnCart> booklst = decodeCart(cartCookie);
            //reject checkout if role = admin
            if (account.getRole().equalsIgnoreCase("admin")) {
                request = reloadCart(request, booklst);
                request.setAttribute("mess", "You can't checkout in admin role");
                request.getRequestDispatcher("view/cart.jsp").forward(request, response);
                return;
            }

            //check address
            int checkout = 0;
            String address = request.getParameter("address").trim();
            if (null == address || address.isEmpty()) {
                request.setAttribute("mess", "Address is empty!");
                checkout--;
            } else {
                checkout++;
            }
            /*checkout*/
            if (checkout == 1) {
                CustomerDAO customerdb = new CustomerDAO();
                //check customer
                Customer customer = customerdb.getCustomer(account.getAccountID());
                //customer is not exist yet -> create new cus
                if (null == customer) {
                    customer = new Customer();
                    customer.setAccountID(account.getAccountID());
                    customer.setCustomerName(account.getUserName());
                    customer.setAddress(address);
                    //checkout =2
                    String customerid = customerdb.addCustomer(customer);
                    customer.setCustomerID(customerid);
                    checkout += null != customerid ? 1 : 0;
                    //customer is exist
                } else {
                    customer.setAddress(address);
                    //checkout =2
                    checkout += customerdb.updateCustomer(customer);
                }

                //insert new order
                String orderId = null;
                if (checkout == 2) {
                    OrderDAO odDao = new OrderDAO();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                    //checkout =3
                    orderId = odDao.insertOrder(customer.getCustomerID(), format.format(new Date()));
                    checkout += null != orderId ? 1 : 0;
                }
                //insert order detail
                if (checkout == 3) {
                    OrderDetailDAO dAO = new OrderDetailDAO();
                    for (BookOnCart bookOnCart : booklst) {
                        checkout += dAO.insertODDetail(
                                new OrderDetail(orderId,
                                        bookOnCart.getProductID(),
                                        bookOnCart.getQuantity(),
                                        bookOnCart.getUnitPrice()));
                    }
                }

            }
            if (checkout == (booklst.size() + 3)) {
                request.setAttribute("mess", "Checkout successfully");
                Cookie cookie = new Cookie(CART_NAME_COOKIE, "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            } else {
                request = reloadCart(request, booklst);
                request.setAttribute("mess", "Checkout fail");
            }
            request.getRequestDispatcher("view/cart.jsp").forward(request, response);

        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
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

    private HttpServletRequest reloadCart(HttpServletRequest request, ArrayList<BookOnCart> booklst) {
        int page = 1;
        int fetch = 3;
        if (null != request.getParameter("page")) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        ArrayList<BookOnCart> lst = new ArrayList<>();
        int offset = (page - 1) * fetch;
        int totalPage = 0;
        if (offset > booklst.size()) {
            offset = booklst.size() - (booklst.size() % fetch);
        }
        int count = 0;
        for (int i = offset; i < booklst.size(); i++) {
            lst.add(booklst.get(i));
            count++;
            if (count == fetch) {
                break;
            }
        }
        totalPage = Math.floorDiv(booklst.size(), fetch) + (booklst.size() % fetch > 0 ? 1 : 0);

        float subtotal = getSubTotal(booklst);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("books", lst);
        request.setAttribute("totalAmount", subtotal);
        request.setAttribute("ship", 0);

        request.setAttribute("page", page);

        return request;
    }

    private float getSubTotal(ArrayList<BookOnCart> lst) {
        float total = 0F;
        for (BookOnCart bookOnCart : lst) {
            total += (bookOnCart.getQuantity() * bookOnCart.getUnitPrice());
        }
        return total;
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
