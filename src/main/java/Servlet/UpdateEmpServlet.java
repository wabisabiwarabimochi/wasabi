package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.UpdateEmpDAO;


@WebServlet("/UpdateEmpServlet")
public class UpdateEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public UpdateEmpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empid = request.getParameter("empid");
        String boo = request.getParameter("boo");
        String id = request.getParameter("id");
        
        UpdateEmpDAO UED = new UpdateEmpDAO();
        
try {
            
	        if(boo.equals("name")) {
	        	String fname = request.getParameter("fname");
	            String lname = request.getParameter("lname");
	        	UED.UpdateEmpName(empid, fname, lname);
	              
	        }else if(boo.equals("pass")){
	        	String emppasswd = request.getParameter("emppasswd");
	        	UED.UpdateEmpPass(id, emppasswd);
	        }
	        
	        }catch(Exception e){
	            
	            RequestDispatcher rd = request.getRequestDispatcher("regerror.jsp");
	              rd.forward(request, response);
	        }
	}

}
