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


                    <table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
			
			<tbody>
				<tr>
					<th scope="row" class="point">제목</th>
					<td colspan="3" class="subject">${nto.boardTitle}</td>
				</tr>
				<tr>
					<th scope="row">작성자</th>
					<td>${nto.boardWriter}</td>
					<th scope="row">작성일</th>
					<td>${nto.boardDate}</td>
				</tr>
				<tr>
					<th scope="row">조회수</th>
					<td colspan="3">${nto.boardHit}
						
					</td>
				</tr>
				<tr>
					
					<td colspan="4">${nto.boardContents}</td>
				</tr>
			</tbody>
			</table>    
					
                      
                      
                      <div class="col-sm-12 col-md-5">
										<div class="dataTables_info" id="dataTable_info" role="status"
											aria-live="polite" style="display: flex">
											<a href="update?boardNo=${nto.boardNo}" class="btn btn-primary btn-icon-split"> <span
												class="icon text-white-50"> <i class="fas fa-flag"></i>
											</span> <span class="text">수정</span>
											</a>
											<form action="delete" method="post">
											<input type="hidden" name="boardNo" value="${nto.boardNo}">
											<button class="btn btn-primary btn-icon-split"> <span
												class="icon text-white-50"> <i class="fas fa-flag"></i>
											</span> <span class="text">삭제</span>
											</a>
											</form>
										</div>
									</div>
				</div>
				 		
									
				

			</div>
			<c:import url="/WEB-INF/views/layout/footer.jsp"></c:import>
		</div>

	</div>


	<c:import url="/WEB-INF/views/layout/footjs.jsp"></c:import>
</body>
</html>