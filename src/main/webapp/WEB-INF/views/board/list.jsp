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
					<h1>List Page</h1>

					<div class="card shadow mb-4">
						<div class="card-body">
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th>No</th>
											<th>Title</th>
											<th>Writer</th>
											<th>Date</th>
											<th>Hit</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="vo">
											<tr>
												<td>${vo.boardNo}</td>
												<td><a href="detail?boardNo=${vo.boardNo}">${vo.boardTitle}</a></td>
												<td>${vo.boardWriter}</td>
												<td>${vo.boardDate}</td>
												<td>${vo.boardHit}</td>
											</tr>
										</c:forEach>
									</tbody>


								</table>

								<div class="row">
									<div class="col-sm-12 col-md-5">
										<div class="dataTables_info" id="dataTable_info" role="status"
											aria-live="polite">
											<a href="/notice/add" class="btn btn-primary btn-icon-split"> <span
												class="icon text-white-50"> <i class="fas fa-flag"></i>
											</span> <span class="text">글 작성</span>
											</a>
										</div>
									</div>
									<div class="col-sm-12 col-md-7">

										<div class="dataTables_paginate paging_simple_numbers"
											id="dataTable_paginate">
											<ul class="pagination float-right">
												<li class="paginate_button page-item previous disabled"
													id="dataTable_previous"><a href="list?page=${pager.pre}"
													aria-controls="dataTable" data-dt-idx="0" tabindex="0"
													class="page-link">Previous</a></li>
												<li class="paginate_button page-item active"><a
													href="list" aria-controls="dataTable" data-dt-idx="1"
													tabindex="0" class="page-link">${pager.totalPage}</a></li>

												<li class="paginate_button page-item next"
													id="dataTable_next"><a href="#"
													aria-controls="dataTable" data-dt-idx="7" tabindex="0"
													class="page-link">Next</a></li>
											</ul>
										</div>

									</div>
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