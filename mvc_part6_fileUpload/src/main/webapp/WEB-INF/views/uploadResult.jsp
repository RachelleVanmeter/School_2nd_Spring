<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>단일 파일 업로드</h1>
	<h2>${savedName}</h2>
	<br>
	<hr>
	<h1>복수 파일 업로드</h1>
	<h2>
	<c:forEach var="savedName" items="${savedNames}">
		${savedName} <br>
	</c:forEach>
	</h2>
	<br>
	<hr>
	<h1>파일 업로드 & 데이타</h1>
	<h2>
	<c:forEach var="savedName" items="${savedNames2}">
		${savedName} <br>
	</c:forEach>
	</h2>
	<br>
	<hr>
	<h1>MIX</h1>
	<h2>AAA</h2>
	<br>
	<hr>
</body>
</html>