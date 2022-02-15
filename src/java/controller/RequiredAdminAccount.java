package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Account;

/**
 *
 * @author Riel
 */
public abstract class RequiredAdminAccount extends HttpServlet {

    private boolean isAllowedAccess(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        Account account = (Account) session.getAttribute("account");
//        if (account == null) {
//            return false;
//        }
//        return account.isAdmin();
        return true;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAllowedAccess(request)) {
            processGet(request, response);
        } else {
            response.getWriter().print("You do not have permission to access this page!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (isAllowedAccess(request)) {
            processPost(request, response);
        } else {
            response.getWriter().print("You do not have permission to access this page!");
        }
    }

    protected abstract void processGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;

    protected abstract void processPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException;
}
