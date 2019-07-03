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
		<form action="/user/joinPost" id="joinForm" method="post">
			<table class="container table table-bordered maxWidth">
				<tr>
					<th colspan="2" class="text-center"><h1>JOIN PAGE</h1></th>
				</tr>
				<tr>
					<td>아이디(email)</td>
					<td>
						<input type="text" class="form-control" name="u_id" id="u_id" />
						<div class="result"></div>
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" class="form-control" name="u_pw" id="u_pw" />
						<div class="result"></div>
					</td>
				</tr>
				<tr>
					<td>비밀번호 확인</td>
					<td><input type="password" class="form-control" name="u_repw" id="u_repw" />
						<div class="result"></div>
					</td>
				</tr>
				<tr>
					<td>이름(2~6자이내)</td>
					<td>
						<input type="text" class="form-control" name="u_name" id="u_name"/>
						<div class="result"></div>
					</td>
				</tr>
				<tr>
					<td>전화번호(-제외 숫자만)</td>
					<td><input type="text" class="form-control" name="u_phone" id="u_phone" />
						<div class="result"></div>
					</td>
				</tr>
				<tr>
					<td>생년월일(ex-19820607)</td>
					<td><input type="text" class="form-control" name="u_birth" id="u_birth" />
						<div class="result"></div>
					</td>
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
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                }
	                
	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                $('#u_addr_post').val(data.zonecode);
	                $('#u_addr').val(addr + extraAddr);
	                // 커서를 상세주소 필드로 이동한다.
	                $("#u_addr_detail").focus();
	            }
	        }).open();
	    }
		
		// mobile -표시 없이 숫자만
		var regexMobile = /^[0-9]{2,3}?[0-9]{3,4}?[0-9]{4}$/;
		
		$.validator.setDefaults({
			submitHandler : function() {
				$("#joinForm").submit();
			}
		});
		
		$.validator.addMethod("regx", function(value, element, regexpr) {
			return regexpr.test(value);
		});
		
		$("#joinForm").validate({
			rules: {
				u_id: {
					required: true,
					email: true,
					remote: {type: "post", url: "/user/uIdCheck"}
				}, u_pw: {
					required: true,
					minlength: 6,
					maxlength: 20
				}, u_repw: {
					required: true,
					minlength: 6,
					maxlengt : 20,
					equalTo: "#u_pw"
				}, u_name: {
					required: true,
					rangelength: [2, 6]
				},  u_phone: {
					required: true,
					regx: regexMobile
				}, u_birth: {
					required: true
				}, u_addr_post: {
					required: true
				}, u_addr: {
					required: true
				}, u_addr_detail: {
					required: true
				}, u_info: {
					required: true
				}
			}, messages: {
				u_id: {
					required: "이메일(아이디)를 작성해주세요",
					email: "올바른 이메일 형식이 아닙니다.",
					remote: "이미 존재하는 ID입니다."
				}, u_pw: {
					required: "비밀번호를 확인해주세요",
					minlength: "비밀번호는 최소 6자리 이상입니다.",
					maxlength: "비밀번호는 최대 20자리만 가능합니다."
				}, u_repw: {
					required: "비밀번호 확인을 작성해주세요",
					minlength: "비밀번호는 최소 6자리 이상입니다.",
					maxlength: "비밀번호는 최대 20자리만 가능합니다.",
					equalTo: "비밀번호가 일치 하지 않습니다."
				}, u_name: {
					required: "이름을 확인해주세요",
					rangelength: $.validator.format("문자 길이가 {0} 에서 {1} 사이의 값을 입력하세요")
				}, u_phone: {
					required: "전화번호를 입력해주세요",
					regx: "올바른 전화번호 형식이 아닙니다."
				}, u_birth: {
					required: "생년월일을 입력해주세요"
				}, u_addr_post: {
					required: "우편번호를 확인해주세요"
				}, u_addr: {
					required: "주소를 확인해 주세요"
				}, u_addr_detail: {
					required: "상세주소를 입력해 주세요"
				}, u_info: {
					required: "개인정보이용동의를 확인해주세요"
				}
			}
		});
		$(function() {
			$("#u_birth").datepicker({
				changeYear: true,
				changeMonth: true,
				dateFormat: "yymmdd",
				dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
				dayNamesMin: ['월', '화', '수', '목', '금',' 토', '일'],
				monthNames : ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
				monthNamesShort : ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
			});
		});
	</script>
</body>
</html>