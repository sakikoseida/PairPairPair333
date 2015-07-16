package pair;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BoutiqueList extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
        //List<Mutter> mutterList = getMutterListLogic.execute();
        //request.setAttribute("mutterList",mutterList);
        
        String forwardPath = null;
        String action = request.getParameter("action");
        
        if(action == null){
            forwardPath = "/ChocoListFromDB.jsp";
        }
        else if(action.equals("done")){
            HttpSession session = request.getSession();
            Mutter ChocoListFromDB = (Mutter) session.getAttribute("ChocoListFromDB");
            session.removeAttribute("ChocoListFromDB");
            
            forwardPath ="/cartCheckBox.jsp";
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPath);
        dispatcher.forward(request,response);
    }
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");
	        
	        String choco1 = request.getParameter("choco1");
	        String choco2 = request.getParameter("choco2");
	        String choco3 = request.getParameter("choco3");
	        String choco4 = request.getParameter("choco4");
	        String choco5 = request.getParameter("choco5");
	        String total = request.getParameter("total");
	        
	         
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/cartCheckBox.jsp");
	        dispatcher.forward(request, response);
	    }

}