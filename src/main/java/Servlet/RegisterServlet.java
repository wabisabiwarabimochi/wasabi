package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.EmpRegisterDAO;

/**
 * Servlet implementation class Register
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		HttpSession session = request.getSession();
	    request.setCharacterEncoding("UTF-8");
	    String empid = request.getParameter("empid");
	    String emppasswd = request.getParameter("emppasswd");
	    String empfname = request.getParameter("empfname");
	    String emplname = request.getParameter("emplname");
	    String boo = request.getParameter("boo");
	    int emprole = Integer.parseInt(request.getParameter("emprole"));
	    
	    
	    session.setAttribute("empid", empid);
        session.setAttribute("empfname", empfname);
        session.setAttribute("emplname", emplname);
        session.setAttribute("emppasswd", emppasswd);
        session.setAttribute("emprole", emprole);
	    
	    EmpRegisterDAO register = new EmpRegisterDAO();
	    
	    try {
            
	        if(boo.equals("reg")) {
	            
	            RequestDispatcher rd = request.getRequestDispatcher("a/regcon.jsp");
	              rd.forward(request, response);
	              
	        }else if(boo.equals("con")){
	        	try {
	        	//従業員情報を登録
	            register.execute(empid,empfname,emplname,emppasswd,emprole);
	            //成功後、成功画面へ
	            RequestDispatcher rd = request.getRequestDispatcher("regcom.jsp");
	              rd.forward(request, response);
	        	} catch (Exception e) {
	        		RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
		              rd.forward(request, response);
	            }
	        }
	        
	        }catch(Exception e){
	            
	            RequestDispatcher rd = request.getRequestDispatcher("regerror.jsp");
	              rd.forward(request, response);
	        }
	    System.out.println(boo);
	    }
	    
	    
	    
	    

	}


