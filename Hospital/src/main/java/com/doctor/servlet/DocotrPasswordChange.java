
package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.db.DBConnect;

@WebServlet("/doctChangePassword")
public class DocotrPasswordChange extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int uid = Integer.parseInt(req.getParameter("uid"));
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");

		DoctorDao dao = new DoctorDao(DBConnect.getConn());
		HttpSession session = req.getSession();

		if (dao.checkOldPassword(uid, oldPassword)) {

			if (dao.changePassword(uid, newPassword)) {
				session.setAttribute("succMsg", "Password Change Sucessfully");
				resp.sendRedirect("doctor/edit_profile.jsp");

			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("doctor/edit_profile.jsp");
			}

		} else {
			session.setAttribute("errorMsg", "Old Password Incorrect");
			resp.sendRedirect("doctor/edit_profile.jsp");
		}

	}
}
/**package com.doctor.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;

import com.db.DBConnect;


@WebServlet("/doctChangePassword")
public class DoctorPasswordChange extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DoctorPasswordChange() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		
		DoctorDao dao=new DoctorDao(DBConnect.getConn());
		HttpSession session=request.getSession();
		
		if(dao.checkOldPassword(uid, oldPassword)) {
			
			if(dao.changePassword(uid,newPassword)) {
				session.setAttribute("succMsg","Password Change Successfully !");
				response.sendRedirect("doctor/edit_profile.jsp");
				
			}else {
				session.setAttribute("errorMsg","Somethig Wrong Server and Fail !");
				response.sendRedirect("doctor/edit_profile.jsp");
			}
		
		}else {
			session.setAttribute("errorMsg","Old Password Incorrect !");
			response.sendRedirect("doctor/edit_profile.jsp");
		}
		
		
		
		}

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
**/
