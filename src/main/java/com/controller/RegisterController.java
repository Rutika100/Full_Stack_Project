package com.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.RegisterDao;
import com.dao.RegisterDaoImpl;
import com.model.Login;
import com.model.Register;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/RegisterController")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int regNo=Integer.parseInt(request.getParameter("regNo"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		Float amt=Float.parseFloat(request.getParameter("amt"));
		Register reg=new Register(regNo,fname, lname, email, pass,amt);
		List<Register> reglst=new LinkedList<Register>();
		reglst.add(reg);
	
		RegisterDao rdao=new RegisterDaoImpl();
		int i=rdao.registerHere(reglst);

		
		if(i>0) {

			HttpSession session=request.getSession();
			session.setAttribute("register", reglst);
			response.sendRedirect("LoginView.html");
		}
		else
		{
			response.sendRedirect("Error.html");
		}
	

		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
