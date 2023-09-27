<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
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
					<sec:authentication property="principal" var="member" />


					<table class="table table-bordered" id="dataTable" width="100%"
						cellspacing="0">

						<tbody>
							<tr>
								<th scope="row">아이디</th>
								<td colspan="4" width="40%">${member.username}</td>
								<th scope="row">비밀번호</th>
								<td><span id="password-text">${member.password}</span> </td>
							</tr>
							<tr>
								<th scope="row">이름</th>
								<td colspan="4">${member.name}</td>
								<th scope="row">이메일</th>
								<td >${member.email}</td>
							</tr>
							<tr>
								<th scope="row">생일</th>
								<td colspan="4">${member.birth}</td>
								<th scope="row">가입일</th>
								<td >${member.joinDate}</td>
							</tr>
							</div>
						</tbody>
					</table>
				</div>
			</div>
			<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import>
		</div>

	</div>


	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
</body>
<script type="text/javascript">
   let password= '${member.password}'
   
   if(password!=''){
	   $('#password-text').text('*******');
   }
   
</script>
</html>