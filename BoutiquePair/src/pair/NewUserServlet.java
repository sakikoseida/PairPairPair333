package pair;

import java.io.IOException;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pair.LinkData;
import pair.PMF;

public class NewUserServlet extends HttpServlet{
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
            NewUser newuser = (NewUser) session.getAttribute("newuser");
            session.removeAttribute("newuser");
            
            forwardPath ="/NewUserOK.jsp";
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
    	String url = request.getParameter("url");
    	

    	//LinkData data = new LinkData(name,password);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
          //  manager.makePersistent(data);
        } finally {
            manager.close();
        }
        response.sendRedirect("/index.html");
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.html");
        dispatcher.forward(request,response);
 
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
