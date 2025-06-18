package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.ShowTable;

@WebServlet("/RegShiire")
public class RegShiire extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegShiire() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    request.setCharacterEncoding("UTF-8");
	    String shiireid = request.getParameter("shiireid");
	    String shiiremei = request.getParameter("shiiremei");
	    String shiireaddress = request.getParameter("shiireaddress");
	    String shiiretel = request.getParameter("shiiretel");
	    int shihonkin = Integer.parseInt(request.getParameter("shihonkin"));
	    int nouki = Integer.parseInt(request.getParameter("nouki"));
	    
	    ShowTable st = new ShowTable();
	    st.execute(shiireid,shiiremei,shiireaddress,shiiretel,shihonkin,nouki);
        
	    
	    
	    
	    
	}

}
