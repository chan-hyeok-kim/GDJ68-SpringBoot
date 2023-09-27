<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
					<h1>Add Page</h1>
					<div class="row">
					<form action="add" method="post" enctype="multipart/form-data">
						<sec:csrfInput/>
						<div class="mb-3">
							<label for="boardTitle" class="form-label">Title
								</label> <input type="text" class="form-control"
								id="boardTitle" placeholder="제목을 입력하세요" name="boardTitle">
						</div>
						<div class="mb-3">
							<label for="boardWriter" class="form-label">Writer
								</label> <input type="text" class="form-control"
								id="boardWriter" placeholder="작성자를 입력하세요" name="boardWriter">
						</div>
						<div class="mb-3">
							<label for="boardContents" class="form-label">Contents
								</label>
							<textarea class="form-control" id="boardContents" name="boardContents"
								rows="3"></textarea>
						</div>
						
						<div class="mb-3">
							<label for="boardContents" class="form-label">
								</label>
							<input type="file" class="form-control"  name="files"
								rows="3">
						</div>
						<div class="mb-3">
							<label for="boardContents" class="form-label">
								</label>
							<input type="file" class="form-control"  name="files"
								rows="3">
						</div>
						
						   <button class="btn btn-danger">Add</button>
						</form>
  
					</div>

				</div>

			</div>
			<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import>
		</div>

	</div>


	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
</body>
</html>