package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDao;
import com.dao.LoginDaoImpl;
import com.model.Login;
import com.model.Register;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<Login> lobjlst=null;
	public void init() {
		lobjlst=new LinkedList<Login>();
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		int regno=Integer.parseInt(request.getParameter("regno"));
		String lemail=request.getParameter("lemail");
		String lpass=request.getParameter("lpass");
		
		Login lobj=new Login(regno,lemail, lpass);
		
		lobjlst.add(lobj);
		
		LoginDaoImpl ldao=new LoginDaoImpl();
		boolean b=ldao.validation(lobjlst);
		
		if (b) {
			HttpSession sess=request.getSession(true);
			sess.setAttribute("login", lobjlst);
			response.sendRedirect("Dashboard.jsp");
		}
	   
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
