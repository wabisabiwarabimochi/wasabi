package Servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class RegPat
 */
@WebServlet("/RegPat")
public class RegPat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegPat() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
	    request.setCharacterEncoding("UTF-8");
	    String patid = request.getParameter("shiireid");
	    String patlname = request.getParameter("shiiremei");
	    String patfname = request.getParameter("shiireaddress");
	    String hokenmeil = request.getParameter("shiiretel");
	    String hokenxp = request.getParameter("shiiretel");
	    
	}

}
