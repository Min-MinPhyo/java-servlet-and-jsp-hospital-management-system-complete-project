package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.db.DBConnect;

@WebServlet("/updateStatus")
public class UpdateStatus extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			int did = Integer.parseInt(req.getParameter("did"));
			String comm = req.getParameter("comm");

			AppointmentDao dao = new AppointmentDao(DBConnect.getConn());

			HttpSession session = req.getSession();

			if (dao.updateCommentStatus(id, did, comm)) {
				session.setAttribute("succMsg", "Comment Updated");
				resp.sendRedirect("doctor/patient.jsp");
			} else {
				session.setAttribute("errorMsg", "Something wrong on server");
				resp.sendRedirect("doctor/patient.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

/*
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
 * import com.dao.AppointmentDao; import com.db.DBConnect;
 * 
 * 
 * @WebServlet("/updateStatus") public class UpdateStatus extends HttpServlet {
 * private static final long serialVersionUID = 1L;
 * 
 * 
 * public UpdateStatus() { super();
 * 
 * }
 * 
 * 
 * protected void doGet(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.setContentType("text/html"); PrintWriter out=response.getWriter();
 * 
 * String comm=request.getParameter("comm"); int
 * id=Integer.parseInt(request.getParameter("id")); int
 * did=Integer.parseInt(request.getParameter("did"));
 * 
 * 
 * AppointmentDao dao=new AppointmentDao(DBConnect.getConn()); boolean
 * i=dao.updateCommentStatus(id, did, comm); HttpSession
 * session=request.getSession();
 * 
 * if(i) { session.setAttribute("succMsg","Updated Comment Successfully!");
 * response.sendRedirect("doctor/patient.jsp");
 * 
 * } else { session.setAttribute("errorMsg","Updated Comment Fail!");
 * response.sendRedirect("doctor/patient.jsp");
 * 
 * 
 * }
 * 
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
 * 
 */