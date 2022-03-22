/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.Customer;
import model.Orders;

/**
 *
 * @author Hfyl
 */
@WebServlet(name = "CheckOutHistoryController", urlPatterns = {"/checkouthistory"})
public class CheckOutHistoryController extends HttpServlet {

    private static final int FETCH  = 10;

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
            out.println("<title>Servlet CheckOutHistoryController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CheckOutHistoryController at " + request.getContextPath() + "</h1>");
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
        try {
            int page = 1;
            if ((null != request.getParameter("page")) && (!request.getParameter("page").trim().isEmpty())) {
                page = Integer.parseInt(request.getParameter("page").trim());
            }
            OrderDAO dAO = new OrderDAO();
            Account user = (Account) request.getSession().getAttribute("account");
            String accountId = user.getAccountID();
            CustomerDAO cdao = new CustomerDAO();
            Customer customer = cdao.getCustomer(accountId);
            if (null != customer) {
                ArrayList<Orders> lst = dAO.getOrderByCustomerID(customer.getCustomerID());
                int[] result = pagingnation(page, lst.size());
                int totalPage = result[0];
                int offset = result[1];
                ArrayList<Orders> currentlst = getData(lst, offset);
                request.setAttribute("page", page);
                request.setAttribute("orders", currentlst);
                request.setAttribute("totalPage", totalPage);
            }
            request.getRequestDispatcher("view/checkoutHistory.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
    }

    private ArrayList<Orders> getData(ArrayList<Orders> alllst, int offset) {
        ArrayList<Orders> lst = new ArrayList<>();
        int count = 0;
        for (int i = offset; i < alllst.size(); i++) {
            lst.add(alllst.get(i));
            count++;
            if (count == FETCH) {
                break;
            }
        }
        return lst;
    }

    private int[] pagingnation(int page, int size) {
        int offset = (page - 1) * FETCH;
        int totalPage = 0;
        if (offset > size) {
            offset = size - (size % FETCH);
        }
        totalPage = Math.floorDiv(size, FETCH) + (size % FETCH > 0 ? 1 : 0);
        int[] array = {totalPage, offset};
        return array;
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
