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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Hfyl
 */
@WebFilter(filterName = "cookieFilter", urlPatterns = {"/*"}, dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD})
public class cookieFilter implements Filter {

    private static final boolean debug = true;

    // The filter configuration object we are associated with.  If
    // this value is null, this filter instance is not currently
    // configured. 
    private FilterConfig filterConfig = null;

    public cookieFilter() {
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

        Throwable problem = null;
        try {
            HttpServletRequest req = (HttpServletRequest) request;
            HttpServletResponse res = (HttpServletResponse) response;
            if(null!=req.getSession().getAttribute("account")){
                chain.doFilter(request, response);
                return;
            }
            
            Cookie[] cookies = req.getCookies();
            boolean userfound = false;
            boolean passfound = false;

            if (cookies != null) { // if get cookie get value
                for (Cookie cookie1 : cookies) {
                    if (cookie1.getName().equals("Username")) {
                        userfound = true;
                        if (passfound) {
                            break;
                        }
                        continue;
                    }
                    if (cookie1.getName().equals("Password")) {
                        passfound = true;
                        if (userfound) {
                            break;
                        }
                        continue;
                    }
                }
            }

            if (passfound && userfound && passfound == true) {
                res.sendRedirect("Login");
            }else{
                chain.doFilter(request, response);
            }
        } catch (Throwable t) {
            // If an exception is thrown somewhere down the filter chain,
            // we still want to execute our after processing, and then
            // rethrow the problem after that.
            problem = t;
            t.printStackTrace();
        }
    }

    /**
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
