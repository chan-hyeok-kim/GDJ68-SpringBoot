
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>제목</title>
  </head>
  <body>
  	<tiles:insertAttribute name="mainHeader" />  <!--공통으로 쓸 메인헤더-->
  	<tiles:insertAttribute name="body"/>   <!--요청에의해 바뀌는 body부분-->
  </body>
</html>