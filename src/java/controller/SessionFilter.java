/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author Hfyl
 */
@WebFilter(filterName = "adminFilter", urlPatterns = {
    "/AdminAddCategory", "/adminAddProduct", "/adminDeleteReport",
    "/AdminEditProduct", "/AdminEditReportController", "/AdminViewCategory",
    "/AdminViewFeedBack", "/AdminViewProduct", "/adminViewReport",
    "/AdminViewReportDetail", "/homeadmin", "/adminEditCategory",
    "/billmanager", "/profile","/checkoutcart","/checkouthistory"
}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class SessionFilter implements Filter {

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    public SessionFilter() {
    }

    /**
     *
     * @param request The servlet request we are processing
     * @param response The servlet response we are creating
     * @param chain The filter chain we are processing
     *
     * @exception IOException if an input/output error occurs
     * @exception ServletException if a servlet error occurs
     */
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if (null == req.getSession().getAttribute("account")) {
            res.sendRedirect("Login");
            return;
        }

        try {
            Account account = (Account) req.getSession().getAttribute("account");
            if (!account.getRole().equalsIgnoreCase("admin")) {
                String sevletPath = req.getServletPath();
                if (sevletPath.equalsIgnoreCase("/profile")) {
                    chain.doFilter(request, response);
                    return;
                }
                if (sevletPath.equalsIgnoreCase("/checkoutcart")) {
                    chain.doFilter(request, response);
                    return;
                }
                if (sevletPath.equalsIgnoreCase("/checkouthistory")) {
                    chain.doFilter(request, response);
                    return;
                }
                if (sevletPath.equalsIgnoreCase("/orderdetail")) {
                    chain.doFilter(request, response);
                    return;
                }
                res.sendRedirect("Login");
                return;
            }
            chain.doFilter(request, response);
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            t.printStackTrace();
        }

    }

    /**
     * Return the filter configuration object for this filter.
     *
     *
     * /**
     * Destroy method for this filter
     */
    public void destroy() {
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {

    }

}
