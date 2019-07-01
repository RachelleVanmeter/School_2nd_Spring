<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<style>
	.maxWidth {
		max-width: 500px;
	}
</style>
	<div class="container">
		<form action="/user/joinPost" id="joinForm" method="post">
			<table class="container table table-bordered maxWidth">
				<tr>
					<th colspan="2" class="text-center"><h1>JOIN PAGE</h1></th>
				</tr>
				<tr>
					<td>아이디(email)</td>
					<td><input type="text" class="form-control" name="u_id" id="u_id" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" class="form-control" name="u_pw" id="u_pw" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" class="form-control" name="u_repw" id="u_repw" /></td>
				</tr>
				<tr>
					<td>전화번호(-제외 숫자만)</td>
					<td><input type="text" class="form-control" name="u_phone" id="u_phone" /></td>
				</tr>
				<tr>
					<td>생년월일(ex-19820607)</td>
					<td><input type="text" class="form-control" name="u_birth" id="u_birth" /></td>
				</tr>
				<tr>
					<td>주소</td>
					<td>
						<div class="row">
							<div class="col-md-8">
								<input type="text" class="form-control" name="u_addr_post" id="u_addr_post" />
							</div>
							<div class="col-md-4">
								<input type="button" class="form-control btn btn-default" onclick="sample6_execDaumPostcode()" value="주소찾기" />
							</div>
						</div>
						<br>
						<input type="text" class="form-control" name="u_addr" id="u_addr" />
						<br>
						<input type="text" class="form-control" name="u_addr_detail" id="u_addr_detail" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<h4>이용약관</h4>
						<textarea class="form-control" readonly>당신의 개인정보는 언제든지 회사에서 사용할수 있으며... 10원에 팔아먹을수도 있어요... 그래도 이 사이트를 이용하시겠습니까??</textarea>
						<label><input type="checkbox" name="u_info" id="u_info" value="y" /> 개인정보 이용동의</label>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" id="joinBtn" class="form-control btn btn-primary" value="회원가입" />
					</td>
				</tr>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script type="text/javascript">
		function sample6_execDaumPostcode() {
	        new daum.Postcode({
	            oncomplete: function(data) {
	                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
	
	                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
	                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
	                var addr = ''; // 주소 변수
	                var extraAddr = ''; // 참고항목 변수
	
	                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
	                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
	                    addr = data.roadAddress;
	                } else { // 사용자가 지번 주소를 선택했을 경우(J)
	                    addr = data.jibunAddress;
	                }
	
	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if (data.userSelectedType === 'R') {
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
	                        extraAddr += data.bname;
	                    }
	                    
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if (data.buildingName !== '' && data.apartment === 'Y') {
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if (extraAddr !== '') {
	                        extraAddr += '(' + extraAddr + ')';
	                    }
	                    
	                    // 조합된 참고항목을 해당 필드에 넣는다.
	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                } else {
	                    document.getElementById("sample6_extraAddress").value = '';
	                }
	
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
	    }
	</script>
</body>
</html>