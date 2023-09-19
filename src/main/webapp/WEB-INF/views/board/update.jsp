<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<h1>Update Page</h1>
					<div class="row">
					<form action="update" method="post">
					<input type="hidden" name="boardNo" value="${nto.boardNo}"> 
						<div class="mb-3">
							<label for="boardTitle" class="form-label">Title
								</label> <input type="text" class="form-control"
								id="boardTitle" placeholder="제목을 입력하세요" value="${nto.boardTitle}" name="boardTitle">
						</div>
						<div class="mb-3">
							<label for="boardWriter" class="form-label">Writer
								</label> <input type="text" class="form-control"
								id="boardWriter" placeholder="작성자를 입력하세요" value="${nto.boardWriter}" name="boardWriter">
						</div>
						<div class="mb-3">
							<label for="boardContents" class="form-label">Contents
								</label>
							<textarea class="form-control" id="boardContents" name="boardContents"
								rows="3">${nto.boardContents}</textarea>
						</div>
						   <button class="btn btn-danger">수정</button>
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