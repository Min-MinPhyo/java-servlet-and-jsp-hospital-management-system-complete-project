
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
import com.entity.Doctor;

@WebServlet("/doctorUpdateProfile")
public class EditProfile extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {

			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qualification = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String email = req.getParameter("email");
			String mobno = req.getParameter("mobno");

			int id = Integer.parseInt(req.getParameter("id"));

			Doctor d = new Doctor(id, fullName, dob, qualification, spec, email, mobno, "");

			DoctorDao dao = new DoctorDao(DBConnect.getConn());
			HttpSession session = req.getSession();

			if (dao.editDoctorProfile(d)) {
				Doctor updateDoctor = dao.getDoctorById(id);
				session.setAttribute("succMsgd", "Doctor Update Sucessfully..");
				session.setAttribute("doctObj", updateDoctor);
				resp.sendRedirect("doctor/edit_profile.jsp");
			} else {
				session.setAttribute("errorMsgd", "something wrong on server");
				resp.sendRedirect("doctor/edit_profile.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/**
 * package com.doctor.servlet;
 * 
 * import java.io.IOException; import java.io.PrintWriter;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession;
 * 
 * import com.dao.DoctorDao; import com.db.DBConnect; import com.entity.Doctor;
 * 
 * 
 * @WebServlet("/doctorUpdateProfile") public class EditProfile extends
 * HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * 
 * public EditProfile() { super();
 * 
 * }
 * 
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.setContentType("text/html"); PrintWriter out=response.getWriter();
 * String fullName=request.getParameter("fullName"); String
 * dob=request.getParameter("dob"); String
 * qualification=request.getParameter("qualification"); String
 * spec=request.getParameter("spec"); String
 * email=request.getParameter("email"); String
 * mobno=request.getParameter("mobno");
 * 
 * int id=Integer.parseInt(request.getParameter("id"));
 * 
 * Doctor d=new Doctor(id,fullName,dob,qualification,spec,email,mobno,"");
 * DoctorDao dao=new DoctorDao(DBConnect.getConn()); HttpSession
 * session=request.getSession();
 * 
 * 
 * if(dao.editDoctorProfile(d)) { Doctor updateDoctor=dao.getDoctorById(id);
 * session.setAttribute("succMsgd","Doctor Update Successfully");
 * response.sendRedirect("doctor/edit_profile.jsp"); /*
 * session.setAttribute("doctorObj", updateDoctor);
 *//*
	 * 
	 * }else { session.setAttribute("failMsgd","Doctor Update Fail");
	 * response.sendRedirect("doctor/edit_profile.jsp"); }
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 * 
	 * }
	 */
