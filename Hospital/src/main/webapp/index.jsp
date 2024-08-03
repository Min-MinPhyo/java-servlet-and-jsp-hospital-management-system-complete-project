<%@page import="com.db.DBConnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<%@include file="component/allcss.jsp"%>
</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<%-- <% Connection con=DBConnect.getConn();
	   out.println(con);
	%> --%>

	<c:if test="${not empty succMsg }">
		<p class="text-center fs-3 text-success">${succMsg}</p>
		<c:remove var="succMsg" scope="session" />
	</c:if>



	<c:if test="${not empty errorMsg }">
		<p class="text-center text-danger fs-2">${errorMsg }</p>
		<c:remove var="errorMsg" scope="session" />

	</c:if>




	<div id="carouselExampleControls" class="carousel slide"
		data-bs-ride="carousel">
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="img/one.jpg" class="d-block" alt="..." height="auto">
			</div>
			<div class="carousel-item">
				<img src="img/three.jpg" class="d-block " alt="..." height="712px">
			</div>
			<div class="carousel-item">
				<img src="img/four.jpg" class="d-block" alt="..." height="auto">
			</div>

			<div class="carousel-item">
				<img src="img/five.jpg" class="d-block" alt="..." height="auto">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleControls" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>



	<p class="text-center fs-3 text-info">Hour Hospital Management</p>

	<div class="row border border-2 border-secondary">

		<div class="col-md-4 p-5 ">
			<div>
				<div class="card point-card border border-info">
					<div class="card-body">
						<p class="fs-4">100% Safety</p>
						<p class="text-black-50 ">Safety and security in hospital To
							keep staff, patients and visitors safe, hospitals use a range of
							security measures, including the use of CCTV cameras, duress
							alarms for staff members and electronic access control systems
							for doorways. Some hospitals also employ security staff.
					</div>


				</div>
			</div>
		</div>




		<div class="col-md-4 p-5 ">
			<div>
				<div class="card point-card border border-info">
					<div class="card-body">
						<p class="fs-4">Welcome Hospital</p>
						<p class="text-black-50 ">I believe we have an outstanding
							staff – physicians, clinical and support personnel – whose
							ultimate goal is to provide you with the best care possible in a
							clinical and support personnel – whose ultimate goal is to
							provide you with the best care ultimate goal is to provide.</p>


					</div>


				</div>
			</div>
		</div>


		<div class="col-md-4 p-5">
			<div>
				<div class="card point-card border border-info">
					<div class="card-body">
						<p class="fs-4">Doctors is very Careful Our Patient</p>
						<p class="text-black-50 ">Hospitals can use CAREFUL to plan
							discharge more effectively and access a holistic view of patient
							flow to identify and address problem areas holistic view of
							patient flow to identify and address problem areas.</p>


					</div>


				</div>
			</div>
		</div>


	</div>







	<div class="container p-5">
		<p class="text-center fs-2 text-info">Our Team Of Hospital</p>
		<div class="row">

			<div class="col-md-4 border-3">

				<div class="card paint-card">
					<div class="card-body text-center">

						<img src="img/han.jpg" width="150px" height="150px">
						<p class="text-danger">Sayar Han Tun Lin</p>
						<p class="text-success fs-6">MBBS</p>


					</div>

				</div>


			</div>



			<div class="col-md-4 border-3">

				<div class="card paint-card">
					<div class="card-body text-center">

						<img src="img/min.jpg" width="150px" height="150px">
						<p class="text-danger">Min Min Phyo</p>
						<p class="text-success fs-6">Dental Technician Certification</p>


					</div>

				</div>


			</div>



			<div class="col-md-4 border-3">

				<div class="card paint-card">
					<div class="card-body text-center">

						<img src="img/chit.jpg" width="150px" height="150px">
						<p class="text-danger">Sayar Chit</p>
						<p class="text-success fs-6">X-Ray Technician Certification</p>


					</div>

				</div>


			</div>
		</div>


		<div class="container mt-3">
			<div class="row">

				<div class="col-md-4 border-3">

					<div class="card paint-card">
						<div class="card-body text-center">

							<img src="img/yimonaung.jpg" width="150px" height="150px">
							<p class="text-danger">Daw Yi Mon Aung</p>
							<p class="text-success fs-6">Certified Practical Nurse</p>


						</div>

					</div>
				</div>



				<div class="col-md-4 border-3 ">

					<div class="card paint-card">
						<div class="card-body text-center">

							<img src="img/raj.jpg" width="150px" height="150px">
							<p class="text-danger">Mr Rajai Kumar</p>
							<p class="text-success fs-6">Pharmacy Technology Certificate</p>


						</div>

					</div>

				</div>


				<div class="col-md-4 border-3 ">

					<div class="card paint-card">
						<div class="card-body text-center">

							<img src="img/min.jpg" width="150px" height="150px">
							<p class="text-danger">Min Min Phyo</p>
							<p class="text-success fs-6">Pharmacy Technology Certificate</p>


						</div>

					</div>

				</div>




			</div>
		</div>

</div>







		<%@include file="component/footer.jsp"%>
</body>
</html>