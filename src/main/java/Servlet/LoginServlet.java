package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.LoginLogic;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// リクエストパラメータの取得
		HttpSession session = request.getSession();
	    request.setCharacterEncoding("UTF-8");
	    String empid = request.getParameter("empid");
	    String emppasswd = request.getParameter("emppasswd");
	    session.setAttribute("id", empid);
	    
	    // ログイン処理
	    LoginLogic loginLogic = new LoginLogic();
	    int role = loginLogic.execute(empid,emppasswd);
	    
	   
	    
	    if(role==0) {//受付
	    	 RequestDispatcher dispatch = request.getRequestDispatcher("front/front.jsp");
	 	    dispatch.forward(request, response);
	    }else if(role==1) {//医者
	    	 RequestDispatcher dispatch = request.getRequestDispatcher("doctor/doctor.jsp");
	 	    dispatch.forward(request, response);
	    }else if(role==2) {//従業員
	    	 RequestDispatcher dispatch = request.getRequestDispatcher("employee/employee.jsp");
	 	    dispatch.forward(request, response);
	    }else if(role==3) {//管理者
	    	 RequestDispatcher dispatch = request.getRequestDispatcher("admin/admin.jsp");
	 	    dispatch.forward(request, response);
	    }else if(role==99) {//エラー
	    	RequestDispatcher dispatch = request.getRequestDispatcher("login/error.jsp");
	 	    dispatch.forward(request, response);
	    } 
	}
}
