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

@WebServlet("/userChangePassword")
public class changePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uid = Integer.parseInt(req.getParameter("uid"));
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");

		UserDao dao = new UserDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.checkOldPassword(uid, oldPassword)) {

			if (dao.changePassword(uid, newPassword)) {
				session.setAttribute("succMsg", "Password Change Sucessfully");
				resp.sendRedirect("change_password.jsp");

			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("change_password.jsp");
			}

		} else {
			session.setAttribute("errorMsg", "Old Password Incorrect");
			resp.sendRedirect("change_password.jsp");
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


@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public changePassword() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	
	int uid=Integer.parseInt(request.getParameter("uid"));
	String oldPassword=request.getParameter("oldPassword");
	String newPassword=request.getParameter("newPassword");
	
	UserDao dao=new UserDao(DBConnect.getConn());
	HttpSession session=request.getSession();
	
	if(dao.checkOldPassword(uid, oldPassword)) {
		
		if(dao.changePassword(uid,newPassword)) {
			session.setAttribute("succMsg","Password Change Successfully !");
			response.sendRedirect("change_password.jsp");
			
		}else {
			session.setAttribute("errorMsg","Somethig Wrong Server and Fail !");
			response.sendRedirect("change_password.jsp");
		}
	
	}else {
		session.setAttribute("errorMsg","Old Password Incorrect !");
		response.sendRedirect("change_password.jsp");
	}
	
	
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
**/
