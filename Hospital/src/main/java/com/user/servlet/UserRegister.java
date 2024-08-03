package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");

			User u = new User(fullName, email, password);

			UserDao dao = new UserDao(DBConnect.getConn());

			HttpSession session = req.getSession();

			boolean f = dao.register(u);

			if (f) {

				session.setAttribute("sucMsg", "Register Sucessfully");
				resp.sendRedirect("signup.jsp");

			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("signup.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}


/**package com.user.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBConnect;
import com.entity.User;


@WebServlet("/user_register")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserRegister() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	    response.setContentType("text/html");
	    PrintWriter out=response.getWriter();
	
		
	String fullName=request.getParameter("fullName");
	String email=request.getParameter("email");
	String password=request.getParameter("password");
	User u=new User(fullName,email,password);
	UserDao dao=new UserDao(DBConnect.getConn());
	HttpSession session=request.getSession/**
 * Servlet implementation class userServlet
 */();
	
	
	boolean f=dao.register(u);
	
	 if(f) {
			session.setAttribute("sucMsg","Successfully Regiseter");
			response.sendRedirect("user_login.jsp");
			 
			 
	  out.println("Successfully Insert Data");
	
	 }
	 else {
			session.setAttribute("failMsg","Fail Regiseter");
			response.sendRedirect("signup.jsp");
			System.out.println("Something Want Wrong In Server");
		 out.println("Fail  Insert Data");
	
			 
		 
	
	 }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
**/
