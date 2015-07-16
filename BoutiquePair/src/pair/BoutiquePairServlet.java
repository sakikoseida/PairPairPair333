package pair;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;
import java.util.*;
import javax.jdo.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class BoutiquePairServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		resp.setContentType("text/plain");
		resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        req.setCharacterEncoding("utf-8");
		
		UserService userService = UserServiceFactory.getUserService();

        String thisURL = req.getRequestURI();

        resp.setContentType("text/html");

        if (req.getUserPrincipal() != null) {
        	resp.getWriter().println("");
            resp.getWriter().println("<p>Welcome, " +
                                     req.getUserPrincipal().getName() +
                                     "!<br>  You can <a href=\"" +
                                     userService.createLogoutURL("/cart.do") +
                                     "\">go site</a>.</p>");
        } else {
        	resp.getWriter().println("<p>Welcome to chocolate shop!</p>");
        	resp.getWriter().println("<p>Googleアカウントでログインしてください</p>");
            resp.getWriter().println("<p>Please <a href=\"" +
                                     userService.createLoginURL(thisURL) +
                                     "\">Login</a>.</p>");
        }
	}
}