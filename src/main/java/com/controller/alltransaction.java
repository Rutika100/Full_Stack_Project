package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDaoImpl;
import com.model.Login;
import com.model.Recharge;

/**
 * Servlet implementation class alltransaction
 */
@WebServlet("/alltransaction")
public class alltransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public alltransaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session1=request.getSession(true);
		List<Login> lobj= (List<Login>) session1.getAttribute("login");
		Login l=lobj.get(0);
		LoginDaoImpl ldao=new LoginDaoImpl();
		List<Recharge> lst=ldao.displayAll(l.getRegno());
		HttpSession session=request.getSession(true);
		session.setAttribute("transaction", lst);
		response.sendRedirect("alltransaction.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
