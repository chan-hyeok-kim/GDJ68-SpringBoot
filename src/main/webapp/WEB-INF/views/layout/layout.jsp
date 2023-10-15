<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<tiles:insertAttribute name="headCSS" />
<body id="page-top">
	<div id="wrapper">

		<tiles:insertAttribute name="sidebar" />

		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<tiles:insertAttribute name="topbar" />
				<tiles:insertAttribute name="body" />

			</div>
			<tiles:insertAttribute name="footer" />
		</div>
		<tiles:insertAttribute name="footjs" />

</body>
</html>