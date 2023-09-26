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
				    <div>
				       <h3>${param.message}</h3>
				    </div>
					<form:form modelAttribute="memberVO" method="post">
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
<script type="text/javascript">
let m = '${param.message}';
if(m!=''){
alert('${param.message}')
}
</script>
</html>