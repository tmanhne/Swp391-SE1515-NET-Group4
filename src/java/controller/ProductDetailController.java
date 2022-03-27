/*
 * Copyright(C)2021, FPT University
 * SWP 391
 * 
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2022-02-18         1.0               VUDMHE140017,THONGCTHE140606      First Implement
 */

package controller;

import Validate.Validate;
import dao.FeedBackDAO;
import dao.ProductDAO;
import interfaceDAO.IFeedBackDAO;
import interfaceDAO.IProductDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;
import model.FeedBack;
import model.Product;

/**
 * The class used <code>IProductDAO</code> to get product detail 
 * @author vudm
 */
@WebServlet(name = "ProductDetailController", urlPatterns = {"/viewDetail"})
public class ProductDetailController extends HttpServlet {



    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     * This method is used <code>IProductDAO</code> to implement get all information of product by id
     * This method is used <code>IFeedBackDAO</code> to implement get feedback of product
     * @param request servlet request
     * @param response servlet response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     * @description : handle email and new password of user and change password for user 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String productID = request.getParameter("id");
            IProductDAO productDAO = new ProductDAO();
            
            IFeedBackDAO feedBackDAO= new FeedBackDAO();
            Product product = productDAO.getProductById(productID);
//            request.setAttribute("book", product);
//            request.getRequestDispatcher("view/productDetail.jsp").forward(request, response);
            // get all feedback in database
            ArrayList<FeedBack> feedBacks=(ArrayList<FeedBack>) feedBackDAO.getFeedBackBYProductID(productID);
            int rate = calcRate(feedBacks);
            double[] rateForEachStar = calcRateForEachStar(feedBacks);
            
            String btnSubmit = request.getParameter("btn-submit-comment");
            if(null != btnSubmit) {
//                product = request.getParameter("book");
//                productID = po
                String rateComment = request.getParameter("rateComment");
                String comment = request.getParameter("text-comment").trim();
                Validate validate= new Validate() ;
                
                //if the length of the comment is greater than the allowed number of characters
                if(!validate.checkLengthComment(comment)) {
                    request.setAttribute("book", product);
                    request.setAttribute("feedBacks", feedBacks);
                    request.setAttribute("messageComment", "Length of comment is 1024 character");
                    request.setAttribute("rate", rate);
                    request.setAttribute("rates", rateForEachStar);
                    request.setAttribute("id", productID);
                    request.getRequestDispatcher("view/productDetail.jsp").forward(request, response);
                }
                else if(!validate.checkInvalidComment(comment)) {
                    request.setAttribute("book", product);
                    request.setAttribute("feedBacks", feedBacks);
                    request.setAttribute("messageComment", "Comment content invalid word");
                    request.setAttribute("id", productID);
                    request.setAttribute("rate", rate);
                    request.setAttribute("rates", rateForEachStar);
                    request.getRequestDispatcher("/viewDetail").forward(request, response);
                }
                else {
                    Account account = (Account) request.getSession().getAttribute("account");
                    Date date = new Date();
                    feedBacks.add(new FeedBack(account.getAccountID(), account.getAccountID(), date, comment, productID, productID, Integer.parseInt(rateComment)));
                    IFeedBackDAO iFeedBackDAO = new FeedBackDAO();
                    iFeedBackDAO.insertFeeback(new FeedBack(account.getAccountID(), account.getAccountID(), date, comment, productID, productID, Integer.parseInt(rateComment)));
                    request.setAttribute("book", product);
                    request.setAttribute("feedBacks", feedBacks);
                    request.setAttribute("messageComment", "Add comment success");
                    request.setAttribute("id", productID);
                    request.setAttribute("rate", rate);
                    request.setAttribute("rates", rateForEachStar);
                    request.getRequestDispatcher("view/productDetail.jsp").forward(request, response);
                }    
                
            }
            else {
                request.setAttribute("book", product);
                request.setAttribute("feedBacks", feedBacks);
                request.setAttribute("rate", rate);
                request.setAttribute("rates", rateForEachStar);
                request.setAttribute("id", 4);           
                request.getRequestDispatcher("view/productDetail.jsp").forward(request, response);
            }
            
        }catch(IOException | SQLException | ServletException   ex){
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        } 
        catch (Exception ex) {
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>POST</code> method.
     * @author : ThongCTHE140606 
     * @param request servlet request
     * @param response servlet response
     * @description : handle email and new password of user and change password for user 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
            String productID = request.getParameter("id");
            IProductDAO productDAO = new ProductDAO();
            
            IFeedBackDAO feedBackDAO= new FeedBackDAO();
            Product product = productDAO.getProductById(productID);
            // get all feedback in database
            ArrayList<FeedBack> feedBacks=new ArrayList<>();
            feedBacks = (ArrayList<FeedBack>) feedBackDAO.getFeedBackBYProductID(productID);
            
            int rate = calcRate(feedBacks);
            double[] rateForEachStar = calcRateForEachStar(feedBacks);
            String btnSubmit = request.getParameter("btn-submit-comment");
            if(null != btnSubmit) {
//                product = request.getParameter("book");
//                productID = po
                String rateComment = request.getParameter("rateComment");
                String comment = request.getParameter("text-comment").trim();
                Validate validate= new Validate() ;
                
                //if the length of the comment is greater than the allowed number of characters
                if(!validate.checkLengthComment(comment)) {
                    request.setAttribute("book", product);
                    request.setAttribute("feedBacks", feedBacks);
                    request.setAttribute("messageComment", "Length of comment is 1024 character");
                    request.setAttribute("rate", rate);
                    request.setAttribute("rates", rateForEachStar);
                    request.setAttribute("id", productID);
                    request.getRequestDispatcher("view/ProductDetail.jsp").forward(request, response);
                }
                else if(!validate.checkInvalidComment(comment)) {
                    request.setAttribute("book", product);
                    request.setAttribute("feedBacks", feedBacks);
                    request.setAttribute("messageComment", "Comment content invalid word");
                    request.setAttribute("id", productID);
                    request.setAttribute("rate", rate);
                    request.setAttribute("rates", rateForEachStar);
                    request.getRequestDispatcher("view/ProductDetail.jsp").forward(request, response);
                }
                else {
                    Account account = (Account) request.getSession().getAttribute("account");
                    Date date = new Date();
                    IFeedBackDAO iFeedBackDAO = new FeedBackDAO();
                    iFeedBackDAO.insertFeeback(new FeedBack(account.getAccountID(), account.getAccountID(), date, comment, productID, productID, Integer.parseInt(rateComment)));
                    feedBacks = (ArrayList<FeedBack>) feedBackDAO.getFeedBackBYProductID(productID);
                    request.setAttribute("book", product);
                    request.setAttribute("feedBacks", feedBacks);
                    request.setAttribute("messageComment", "Add comment success");
                    request.setAttribute("id", productID);
                    request.setAttribute("rate", rate);
                    request.setAttribute("rates", rateForEachStar);
                    request.getRequestDispatcher("view/ProductDetail.jsp").forward(request, response);
                } 
            }
            
            
        }catch(IOException | SQLException | ServletException   ex){
            request.setAttribute("error", "Sorry! Error occurred, THAT PAGE DOESN'T EXIST OR IS UNAVABLE.");
            request.getRequestDispatcher("error/error.jsp").forward(request, response);
        } catch (Exception ex) {
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

    /**
     * @author : ThongCTHE140606 
     * @param ArrayList<FeedBack> feedBacks
     * @description : handle email and new password of user and change password for user 
     */
    private int calcRate(ArrayList<FeedBack> feedBacks) {
        int totalRate= 0 ;
        for(FeedBack feedBack : feedBacks) {
            totalRate +=feedBack.getRatting();
        }
        for(int i= 5 ; i>= 1; --i) {
            if (totalRate >= i* feedBacks.size() ) {
                return i ;
            }
        }
        return 1 ; 
    }
    /**
     * @author : ThongCTHE140606 
     * @param ArrayList<FeedBack> feedBacks
     * @description : handle email and new password of user and change password for user 
     */
    private double[] calcRateForEachStar(ArrayList<FeedBack> feedBacks) {
        int[] numbnerEachRates = {0,0,0,0,0,0};
        double[] rates = {0,0,0,0,0,0};
        for(FeedBack feedBack : feedBacks) {
            int start = feedBack.getRatting();
            ++numbnerEachRates[start];
            rates[start] = (numbnerEachRates[start] * 100) /  feedBacks.size();
        }
        return rates;
    }

}
