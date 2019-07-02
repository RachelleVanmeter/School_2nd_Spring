<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/login" method="post">
		<div>
			<input type="text" name="username">
		</div>
		<div>
			<input type="password" name="password">
		</div>
		<div>
			<label>
				<input type="checkbox" name="remember-me"> Remember-ME
			</label>
		</div>
		<div>
			<input type="submit">
		</div>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>
</body>
</html>