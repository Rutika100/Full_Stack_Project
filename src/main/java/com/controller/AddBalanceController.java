package com.controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDaoImpl;
import com.model.Login;

/**
 * Servlet implementation class AddBalanceController
 */
@WebServlet("/AddBalanceController")
public class AddBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBalanceController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session = request.getSession(true);
	      List<Login> loginList = (List<Login>) session.getAttribute("login");

	        if (loginList != null && !loginList.isEmpty()) {
	            int regno = loginList.get(0).getRegno();
	            float amount = Float.parseFloat(request.getParameter("amount"));

	            LoginDaoImpl ldao = new LoginDaoImpl();
	            boolean success = ldao.addBalance(regno, amount);
	          
	            if (success) {
	                 
	            	response.sendRedirect("Dashboard.jsp");
	            	
	                
	            } else {
	                response.getWriter().println("Error adding balance");
	            }
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
