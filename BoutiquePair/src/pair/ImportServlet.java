package pair;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 
 */
public class ImportServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
         HttpSession session=request.getSession();
        boolean found = false;
        
        try{
            String password = request.getParameter("password");
            String user = request.getParameter("user");
            
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        String driverURL = "jdbc:derby://localhost:1527/shohin";
        Connection con = DriverManager.getConnection(driverURL, "db", "db");
        Statement stmt = con.createStatement();
        String sql = "select * from T_USER where USER_NAME=? and PASSWORD=?";
        PreparedStatement ps =con.prepareStatement(sql);
        ps.setString(1, user);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        
        if(rs.next()){
            found = true;
        }
        
        String nextJsp;
        if(!found){
            session.invalidate();
            nextJsp = "/importFailed.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(nextJsp);
            dispatcher.forward(request, response);
        }else{
            session.setAttribute("user", user);
            sql = "select * from T_CHOCO";
            rs = stmt.executeQuery(sql);
            List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
            while (rs.next()){
                Map<String, Object> record = new HashMap<String, Object>();
                record.put("id", new Integer(rs.getInt("CHOCO_ID")));
                record.put("co", rs.getString("CHOCO_CO"));
                record.put("name", rs.getString("CHOCO_NAME"));
                record.put("price", new Integer(rs.getInt("CHOCO_PRICE")));
                list.add(record);
            }
            rs.close();
            stmt.close();
            con.close();
            
            request.setAttribute("data", list);
            
            RequestDispatcher rd = request.getRequestDispatcher("/ChocoListFromDB.jsp");
            rd.forward(request, response);
            
                
            }
        }catch(Exception e){
            throw new ServletException(e);
        }
        }
        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
        processRequest(request, response);
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
