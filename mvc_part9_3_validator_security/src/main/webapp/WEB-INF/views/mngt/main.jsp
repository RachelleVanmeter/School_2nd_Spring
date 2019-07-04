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
				<td id="userid">${members.u_id}</td>
				<td>${members.u_name}</td>
				<td>
					<c:forEach var="memberAuth" items="${members.authList}">
						<c:if test="${memberAuth.u_auth eq 'ROLE_USER'}">
							일반 사용자
						</c:if>
						<c:if test="${memberAuth.u_auth eq 'ROLE_MEMBERSHIP'}">
							매니저
						</c:if>
						<c:if test="${memberAuth.u_auth eq 'ROLE_MASTER'}">
							관리자
						</c:if>
						&nbsp;
					</c:forEach>
				</td>
				<td>
					<f:formatDate pattern="yyyy-MM-dd HH:mm" value="${members.u_date}"/>
				</td>
				<td>
					<f:formatDate pattern="yyyy-MM-dd HH:mm" value="${members.u_visit_date}"/>
				</td>
				<td>
					<select>
						<option value="n" <c:out value="${members.u_withdraw == 'n' ? 'selected' : ''}"/>>
						활성화
						</option>
						<option value="y" <c:out value="${members.u_withdraw == 'y' ? 'selected' : ''}"/>>
						비활성화
						</option>
					</select>
				</td>
				<td>
					<select class="changeAuth">
						<option disabled selected>권한선택</option>
						<option value="ROLE_USER">일반사용자</option>
						<option value="ROLE_MEMBERSHIP">매니저</option>
						<option value="ROLE_MASTER">관리자</option>
					</select>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
<script type="text/javascript">
	$('.changeAuth').on('change', function() {
		var parentTr = $(this).parent().parent();
		var uid = parentTr.find('#userid').text();
		var changeAuthVal = $(this).val();
		console.log(uid + "  //  " + changeAuthVal);
		$.post("/mngt/user/changeAuth", {u_id: uid, u_auth: changeAuthVal, '${_csrf.parameterName}': '${_csrf.token}'}, function(data) {
			console.log(data);
		});
	});
</script>
</body>
</html>