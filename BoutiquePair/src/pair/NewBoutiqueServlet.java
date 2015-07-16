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

public class NewBoutiqueServlet extends HttpServlet{
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
            forwardPath = "/ChocoListFromDB.jsp";
        }
        else if(action.equals("done")){
            HttpSession session = request.getSession();
            LinkData chocolate = (LinkData) session.getAttribute("chocolate");
            session.removeAttribute("chocolate");
            
            forwardPath ="/cartCheckBox.jsp";
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
    	LinkData data = new LinkData();
    	String choco1 = data.getChoco1();
    	String choco2 = data.getChoco2();
    	String choco3 = data.getChoco3();
    	String choco4 = data.getChoco4();
    	String choco5 = data.getChoco5();
    	String total = data.getTotal();
    	
    	

    	LinkData linkdata = new LinkData(choco1,choco2,choco3,choco4,choco5,total);
        PersistenceManagerFactory factory = PMF.get();
        PersistenceManager manager = factory.getPersistenceManager();
        try {
            manager.makePersistent(linkdata);
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