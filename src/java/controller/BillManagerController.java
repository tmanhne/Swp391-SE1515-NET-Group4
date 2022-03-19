/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.OrderOnAdmin;

/**
 *
 * @author Hfyl
 */
@WebServlet(name = "BillManagerController", urlPatterns = {"/billmanager"})
public class BillManagerController extends HttpServlet {

    private final int FETCH = 1;

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
            out.println("<title>Servlet BillManagerController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet BillManagerController at " + request.getContextPath() + "</h1>");
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
            String year = null;
            String date = null;
            OrderDAO dAO = new OrderDAO();
            if ((null != request.getParameter("page")) && (!request.getParameter("page").trim().isEmpty())) {
                page = Integer.parseInt(request.getParameter("page").trim());
            }
            if ((null != request.getParameter("year")) && (!request.getParameter("year").trim().isEmpty())) {
                year = request.getParameter("year").trim();
                request.setAttribute("selyear", year);
            }
            if ((null != request.getParameter("date")) && (!request.getParameter("date").trim().isEmpty())) {
                date = request.getParameter("date").trim();
                request.setAttribute("seldate", date);
            }

            ArrayList<Integer> years = dAO.getGroupYear();
            if (!years.isEmpty()) {
                request.setAttribute("years", years);
                year = null == year ? years.get(0).toString() : year;
                ArrayList<String> dates = dAO.getGroupDate(year);
                date = null == date ? dates.get(0).toString() : date;
                request.setAttribute("dates", dates);
                String datequerry = year + '/' + date;

                ArrayList<OrderOnAdmin> lst = dAO.getOrdersAdmin(datequerry);
                int[] result = pagingnation(page, lst.size());
                int totalPage = result[0];
                int offset = result[1];
                ArrayList<OrderOnAdmin> currentlst = getData(lst, page, offset);

                request.setAttribute("page", page);
                request.setAttribute("orders", currentlst);
                request.setAttribute("totalPage", totalPage);
            }
            request.getRequestDispatcher("adminview/billManager.jsp").forward(request, response);
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
        try {
            OrderDAO dAO = new OrderDAO();

            if (null == request.getParameter("search")) {
                String orderId = null != request.getParameter("accept") ? request.getParameter("accept") : request.getParameter("deny");
                boolean accept = null != request.getParameter("accept");
                String status = accept ? "Approved" : "Denied";
                dAO.setFlagStatus(orderId, status);
                request.setAttribute("mess", status+" "+orderId+" successfully!");
            }
            String year = null;
            String date = null;
            if ((null != request.getParameter("year")) && (!request.getParameter("year").trim().isEmpty())) {
                year = request.getParameter("year").trim();
                request.setAttribute("selyear", year);
            }
            if ((null != request.getParameter("date")) && (!request.getParameter("date").trim().isEmpty())) {
                date = request.getParameter("date").trim();
                request.setAttribute("seldate", date);
            }

            ArrayList<Integer> years = dAO.getGroupYear();
            if (!years.isEmpty()) {
                request.setAttribute("years", years);
                year = null == year ? years.get(0).toString() : year;
                ArrayList<String> dates = dAO.getGroupDate(year);
                date = null == date ? dates.get(0).toString() : date;
                request.setAttribute("dates", dates);
                String datequerry = year + '/' + date;

                ArrayList<OrderOnAdmin> lst = dAO.getOrdersAdmin(datequerry);
                int[] result = pagingnation(1, lst.size());
                int totalPage = result[0];
                int offset = result[1];
                ArrayList<OrderOnAdmin> currentlst = getData(lst, 1, offset);

                request.setAttribute("page", 1);
                request.setAttribute("orders", currentlst);
                request.setAttribute("totalPage", totalPage);
            }
            request.getRequestDispatcher("adminview/billManager.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
    }

    private ArrayList<OrderOnAdmin> getData(ArrayList<OrderOnAdmin> alllst, int page, int offset) {
        ArrayList<OrderOnAdmin> lst = new ArrayList<>();
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
