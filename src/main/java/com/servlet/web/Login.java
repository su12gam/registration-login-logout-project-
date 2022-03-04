package com.servlet.web;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.servlet.exceptions.LoginException;
import com.servlet.implementation.DaoImplementation;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoImplementation impl = new DaoImplementation();

	public Login() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
		rs.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		try {
			impl.login(userName, password);
			HttpSession session = request.getSession();
			session.setAttribute("username", userName);
			response.sendRedirect("home.jsp");		
		}catch (SQLException | LoginException e) {
			System.out.println(e.getMessage());
			request.setAttribute("errorMessage", "User name & password does not match...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}		
	}
}
