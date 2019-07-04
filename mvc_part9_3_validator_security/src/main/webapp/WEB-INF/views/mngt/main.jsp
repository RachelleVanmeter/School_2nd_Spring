<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="/WEB-INF/views/common/header.jsp"/>

<div class="container">
	<table class="container table tabled-bordered">
		<tr>
			<th>회원번호</th>
			<th>아이디</th>
			<th>이름</th>
			<th>권한</th>
			<th>회원가입일</th>
			<th>최종방문일</th>
			<th>탈퇴여부</th>
			<th>권한선택</th>
		</tr>
		
		<c:forEach var="members" items="${memberList}">
			<tr>
				<td>${members.u_no}</td>
				<td>${members.u_id}</td>
				<td>${members.u_name}</td>
				<td>
					<c:forEach>
					${members.u_no}
					</c:forEach>
				
				</td>
			</tr>
		</c:forEach>
	</table>

</div>

</body>
</html>