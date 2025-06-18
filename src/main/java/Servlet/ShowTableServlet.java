package Servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.ShowTable;

/**
 * Servlet implementation class ShowTable
 */
@WebServlet("/ShowTableServlet")
public class ShowTableServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTableServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowTable ST = new ShowTable();
		HttpSession session = request.getSession();
	    request.setCharacterEncoding("UTF-8");
	    session.setAttribute("List", ST.exce());
	    RequestDispatcher rd = request.getRequestDispatcher("show_table.jsp");
        rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ShowTable ST = new ShowTable();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");
		int shihon = Integer.parseInt(request.getParameter("shihon"));
		session.setAttribute("List", ST.Result(shihon));
		RequestDispatcher rd = request.getRequestDispatcher("show_table.jsp");
        rd.forward(request, response);
	}

}
