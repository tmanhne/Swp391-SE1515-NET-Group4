/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.CustomerDAO;
import dao.OrderDAO;
import dao.OrderDetailDAO;
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
import model.OrderDetailHistory;
import model.Orders;

/**
 *
 * @author Hfyl
 */
@WebServlet(name = "OrderDetailController", urlPatterns = {"/orderdetail"})
public class OrderDetailController extends HttpServlet {

   

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
            String orderid = request.getParameter("id").trim();
            OrderDAO dAO = new OrderDAO();
            Orders orders = dAO.getOrderByOrderID(orderid);
            if (null == orders) {
                request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
                request.getRequestDispatcher("error/error.jsp").forward(request, response);
                return;
            }
            request.setAttribute("order", orders);
            OrderDetailDAO oddao = new OrderDetailDAO();
            ArrayList<OrderDetailHistory> lst = oddao.getOrderDetailByOrderID(orders.getOrderID());
            request.setAttribute("orderdetails", lst);
            double total = 0;
            for (OrderDetailHistory orderDetailHistory : lst) {
                total+=orderDetailHistory.getQuantity()*orderDetailHistory.getUnitPrice();
            }
            request.setAttribute("total", total);
            request.getRequestDispatcher("view/orderDetail.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
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
        try{
            String orderid = request.getParameter("cancel").trim();
            OrderDAO dAO = new OrderDAO();
            Orders orders = dAO.getOrderByOrderID(orderid);
            if (null == orders || !orders.getStatus().equals("Waitting")) {
                request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
                request.getRequestDispatcher("error/error.jsp").forward(request, response);
                return;
            }
            Account user = (Account) request.getSession().getAttribute("account");
            String accountId = user.getAccountID();
            CustomerDAO cdao = new CustomerDAO();
            Customer customer = cdao.getCustomer(accountId);
            if(!customer.getCustomerID().equals(orders.getCustomerID())){
                request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
                request.getRequestDispatcher("error/error.jsp").forward(request, response);
                return;
            }
            OrderDetailDAO oddao = new OrderDetailDAO();
            int result = 0;
            result+=oddao.cancelOrderDetail(orders.getOrderID());
            result+=dAO.cancelOrder(orders.getOrderID());
            String message = "Cancel successfully!";
            if(result==0){
                message = "Cancel not successfully!";
            }
            request.setAttribute("mess", message);
            request.getRequestDispatcher("view/orderDetail.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
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
