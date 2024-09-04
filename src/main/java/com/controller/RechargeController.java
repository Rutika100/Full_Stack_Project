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

import com.dao.LoginDaoImpl;
import com.model.Recharge;
import com.model.Register;

/**
 * Servlet implementation class RechargeController
 */
@WebServlet("/RechargeController")
public class RechargeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechargeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int regNo=Integer.parseInt(request.getParameter("regNo"));
	String mobNo=request.getParameter("mobno");
	String ser=request.getParameter("ser");
	float ramt=Float.parseFloat(request.getParameter("ramt"));
    
	Recharge robj=new Recharge(regNo, mobNo, ser, ramt);
	List<Recharge> lstr=new LinkedList<Recharge>();
	lstr.add(robj);
	LoginDaoImpl ldao=new LoginDaoImpl();
	int a=ldao.recharge(lstr);
	if(a>0) {
		RequestDispatcher reqd=request.getRequestDispatcher("/Successful.jsp");
		request.setAttribute("success", lstr);
		reqd.include(request,response);
		
	}
	else {
		response.sendRedirect("Fail.jsp");
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
