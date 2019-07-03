<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
	<style>
		.maxWidth {
			max-width: 500px;
		}
		.error {
			color: red;
		}
	</style>
	<div class="container">
		<form action="/user/login" id="loginForm" method="post">
			<table class="container table table-bordered maxWidth">
				<tr>
					<th colspan="2" class="text-center">
						<h1>LOGIN PAGE</h1>
						<h2>${message}</h2>
					</th>
				</tr>
				<tr>
					<td>아이디(email)</td>
					<td>
						<input type="text" class="form-control" name="u_id" id="u_id" />
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td>
						<input type="password" class="form-control" name="u_pw" id="u_pw" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" class="form-control btn btn-primary" id="loginBtn" value="로그인"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" class="form-control btn btn-primary" onclick="location.href='/user/join';" value="회원가입"/>
					</td>
				</tr>
			</table>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token }">
		</form>
	</div>
	<script type="text/javascript">
		$.validator.setDefaults({
			submitHandler : function() {
				$("#loginForm").submit();
			}
		});
		
		$.validator.addMethod("regx", function(value, element, regexpr) {
			return regexpr.test(value);
		});
		
		$("#loginForm").validate({
			rules: {
				u_id: {
					required: true,
					email: true,
				}, u_pw: {
					required: true,
					minlength: 6,
					maxlength: 20
				}
			}, messages: {
				u_id: {
					required: "이메일(아이디)를 작성해주세요",
					email: "올바른 이메일 형식이 아닙니다.",
				}, u_pw: {
					required: "비밀번호를 확인해주세요",
					minlength: "비밀번호는 최소 6자리 이상입니다.",
					maxlength: "비밀번호는 최대 20자리만 가능합니다."
				}
			}
		});
	</script>
</body>
</html>