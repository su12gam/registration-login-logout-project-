package com.servlet.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.servlet.implementation.DaoImplementation;
import com.servlet.model.Student;

@WebServlet("/Reg")
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoImplementation studDao = new DaoImplementation();

	public Reg() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
//		rs.forward(request, response);
		response.getOutputStream().write("abc".getBytes());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String emailId = request.getParameter("emailId");
		String contactNo = request.getParameter("contactNo");
		
		Student st = new Student();

		st.setUserName(userName);
		st.setPassword(password);
		st.setAddress(address);
		st.setEmailId(emailId);
		st.setContactNo(contactNo);
		
		try {
			studDao.registerUser(st);
			response.sendRedirect("home.jsp");
		} catch (Exception e) {
			System.out.println("Error while Registering user :"+e.getMessage());
		}
		
//		if() {
//			HttpSession session=request.getSession();
//			session.setAttribute("RegisterError", "User Already exists");
//			response.sendRedirect("register.jsp");
//		}else {
//			
//		}
}

	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Map<String, String> data=null;
		BufferedReader buff=new BufferedReader(new InputStreamReader(req.getInputStream()));
		String line =buff.readLine();
		String[] specialSign1=line.split("&");
		for (String string : specialSign1) {
			String[] specialSign= string.split("=");
			System.out.println(specialSign[0]+" - "+ specialSign[1]);
		}
		data.put(specialSign1[0], specialSign1[1]);
		
		System.out.println(data);
	}
	
}