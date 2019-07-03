<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MASTER</h1>
	<sec:authorize access="isAuthenticated()">
		<p>principal : <sec:authentication property="principal"/></p>
		<p>ID : <sec:authentication property="principal.username"/></p>
		<p>MemberVo : <sec:authentication property="principal.member"/></p>
		<p>MemberVo uname : <sec:authentication property="principal.member.uname"/></p>
		<p>MemberVo authList : <sec:authentication property="principal.member.authList"/></p>
		<sec:authentication property="principal.member" var="mem"/>
		${mem.uid} <br>
		${mem.upw} <br>
		${mem.uname} <br>
		${mem.regdate} <br>
		${mem.updatedate} <br>
	</sec:authorize>
</body>
</html>