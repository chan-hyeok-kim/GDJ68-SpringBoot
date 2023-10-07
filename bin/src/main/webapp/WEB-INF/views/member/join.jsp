<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/layout/headCSS.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<!-- sidebar -->
		<c:import url="/WEB-INF/views/layout/sidebar.jsp"></c:import>

		<!-- Content Wrapper -->
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/layout/topbar.jsp"></c:import>

				<div class="container-fluid">
					<form:form modelAttribute="memberVO" method="post" enctype="multipart/form-data">
						<div class="form-group">
							<form:label path="username">Username</form:label>
							<form:input id="username" path="username" cssClass="form-control" />
							<form:errors path="username"></form:errors>
         
						</div>
						<div class="form-group">
							<form:label path="password">Password</form:label>
							<form:password path="password" cssClass="form-control" />
							<form:errors path="password"></form:errors>
						</div>


						<div class="form-group">
							<form:label path="passwordCheck">PasswordCheck</form:label>
							<form:password path="passwordCheck" cssClass="form-control"
								id="passwordCheck"  />
							<form:errors path="passwordCheck"></form:errors>
						</div>

						<div class="form-group">
							<form:label path="name">Name</form:label>
							<form:input path="name" cssClass="form-control"
								id="name" />
						    <form:errors path="name"></form:errors>
						</div>

						<div class="form-group">
							<form:label path="email">email</form:label>
							<form:input  path="email" cssClass="form-control"
								id="email" />
						    <form:errors path="email"></form:errors>
						</div>

						<div class="form-group">
							<form:label path="birth">Birth</form:label>
							<form:input path="birth" type="date"
								cssClass="form-control" id="birth"/>
						    <form:errors path="birth"></form:errors>
						</div>

						<div class="form-group">
							<label for="photo">Photo</label> <input type="file" name="photo"
								class="form-control" id="photo" aria-describedby="photoHelp">
							<small id="photoHelp" class="form-text text-muted">We'll
								never share your email with anyone else.</small>
						</div>


						<button type="submit" class="btn btn-primary">Submit</button>

					</form:form>



					<form action="" method="post" enctype="multipart/form-data">













					</form>

				</div>

			</div>
			<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import>
		</div>

	</div>


	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
</body>
</html>