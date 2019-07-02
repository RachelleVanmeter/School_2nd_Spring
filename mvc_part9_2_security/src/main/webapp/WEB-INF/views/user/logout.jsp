<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그아웃</h1>
	<form id="logoutForm" action="/logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<script type="text/javascript">
			window.onload = function() {
				document.getElementById('logoutForm').submit();
			}
		</script>
	</form>
</body>
</html>