

<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>
				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment</th>
							<th scope="col">Email</th>
							<th scope="col">Mob No</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>
					<tbody>
						<%
						AppointmentDao dao = new AppointmentDao(DBConnect.getConn());
						DoctorDao dao2 = new DoctorDao(DBConnect.getConn());
						List<Appointment> list = dao.getAllAppointment();
						for (Appointment ap : list) {
							Doctor d = dao2.getDoctorById(ap.getDoctorId());
						%>
						<tr>
							<th><%=ap.getFullName()%></th>
							<td><%=ap.getGender()%></td>
							<td><%=ap.getAge()%></td>
							<td><%=ap.getAppoinDate()%></td>
							<td><%=ap.getEmail()%></td>
							<td><%=ap.getPhNo()%></td>
							<td><%=ap.getDiseases()%></td>
							<td><%=d.getFullName()%></td>
							<td><%=ap.getAddress()%></td>
							<td><%=ap.getStatus()%></td>
						</tr>
						<%
						}
						%>


					</tbody>
				</table>

			</div>
		</div>
	</div>
</body>
</html>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.DoctorDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Patient Page</title>
<%@include file="../component/allcss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>
	<div class="col-md-12">

		<div class="card paint-card">
			<div class="card-body">
				<p class="text-center text-info fs-3">Admin View Of Patient</p>

				<table class="table">

					<thead>
						<tr>
							<td scope="col">Full Name</td>
							<td scope="col">Gender</td>
							<td scope="col">Age</td>
							<td scope="col">Appointment</td>
							<td scope="col">Email</td>
							<td scope="col">Mob No</td>
							<td scope="col">Diseases</td>
							<td scope="col">Doctor Name</td>
							<td scope="col">Address</td>
							<td scope="col">Status</td>

						</tr>
					</thead>


					<tbody>
						<%
						
					AppointmentDao dao=new AppointmentDao(DBConnect.getConn());
					DoctorDao dao2=new DoctorDao(DBConnect.getConn());
					List<Appointment> list=dao.getAllAppointment();
					
					for(Appointment ap:list){
						Doctor d=dao2.getDoctorById(ap.getDoctorId());
					%>
					 
					
					
					
						<tr>
						           <td><%=ap.getFullName()%></td>
									<td><%=ap.getGender()%></td>
									<td><%=ap.getAge()%></td>
									<td><%=ap.getAppoinDate()%></td>
									<td><%=ap.getEmail()%></td>
									<td><%=ap.getPhNo()%></td>
									<td><%=ap.getDiseases()%></td>
									<td><%=d.getFullName() %></td>
									<td><%=ap.getAddress() %></td>
									<td><%=ap.getStatus()%></td>
									
									 <h1>Hello World</h1>
					
						</tr>
						
						<%} %>
					
			



					</tbody>


				</table>




			</div>


		</div>

	</div>

</body>
</html> --%>