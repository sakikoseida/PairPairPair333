package pair;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ImportOK extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
		//GetUserListLogic getUserListLogic = new GetUserListLogic();
        //List<FirstUser> userList = getUserListLogic.execute();
        //request.setAttribute("userList",userList);
        
        
        String forwardPath = null;
        String action = request.getParameter("action");
        
        if(action == null){
            forwardPath = "/NewUser.jsp";
        }
        else if(action.equals("done")){
            HttpSession session = request.getSession();
            Account account = (Account) session.getAttribute("account");
            session.removeAttribute("account");
            
            forwardPath ="/ChocoListFromDB.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request,response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    	request.setCharacterEncoding("UTF-8");
    	String name = request.getParameter("name");
    	String password = request.getParameter("password");
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ChocoListFromDB.jsp");
        dispatcher.forward(request,response);
        
    }
}
