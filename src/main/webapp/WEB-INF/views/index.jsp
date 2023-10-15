<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- JSP에서 properties이 메세지를 사용할 수 있도록 하는 API -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	
				<div class="container-fluid">
				    <h1>Welcome : <spring:message code="hello"></spring:message></h1>
				    <h1><spring:message code="hi" text="기본메세지"></spring:message> </h1>
				    
				    <sec:authorize access="isAuthenticated()">
				    <sec:authentication property="name" var="user"/>
				    <h1><spring:message code="login.welcome" arguments="${user}"></spring:message> </h1>
				    </sec:authorize>
				</div>

		
</body>
</html>