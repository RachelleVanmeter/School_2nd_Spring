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
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
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
		
		$(function() {
			$("#u_id").focus();
			
			var boolUid = false;
			var boolUPassword = false;
			var boolUPasswordCheck = false;
			var boolUPhone = false;
			var boolUName = false;
			var boolUBirth = false;
			var boolUAddress = false;
			var boolUInfo = false;
			
			var regexEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
			var regexPass = /^.*(?=.{6,20})(?=.*[0-9])(?=.*[a-zA-Z]).*$/;
			var regexMobile = /^[0-9]{2,3}?[0-9]{3,4}?[0-9]{4}$/;
			var regexBirth = /^[0-9]{4}[0-9]{2}[0-9]{2}$/;
			var regexName = /^[\uac00-\ud7a3]{2,6}$/;
			
			// 유효성 검사
			function checkRegex(elP, valP, regexP, messageP, ajaxP) {
				if (regexP.test(valP) === false) {
					showErrorMessage(elP, messageP, false);
					return false;
				} else if (regexP.test(valP) !== false && ajaxP === null) {
					showErrorMessage(elP, '사용 가능 합니다.', true);
					return true;
				} else {
					if (ajaxP !== null) {
						ajaxP(elP);
					}
				}
			}
			
			// 메시지를 보여줄 요소, 보여줄 error message, 성공/실패 여부
			function showErrorMessage(elP, messageP, isChecked) {
				// true
				// <span style="margin-left:5px;font-size:12px;color:green;>사용가능 합니다.</span>
				// false
				// <span style="margin-left:5px;font-size:12px;color:red;>messageP</span>
				var html = '<span style="margin-left:5px;font-size:12px;';
					html += isChecked ? 'color:green;' : 'color:red;';
					html += '">';
					html += isChecked ? '사용 가능 합니다.' : messageP;
					html += '</span>';
				$(elP).html(html);
			}
			
			/* u_id START */
			$('#u_id').on('input', function() {
				var tempVal = $(this).val();
				console.log(tempVal);
				var elP = $(this).parent().find('.result');
				//elP.html(tempVal);
				var message = '올바른 이메일 형식이 아닙니다.';
				boolUid = checkRegex(elP, tempVal, regexEmail, message, checkUidAjax);
			});
			
			function checkUidAjax(elP) {
				$.ajax({
					type: 'post',
					url: '/user/uIdCheck',
					dataType: 'json',
					data: {
						u_id : $('#u_id').val(),
						'${_csrf.parameterName}': '${_csrf.token}'
					},
					success: function(data) {
						console.log('isChecked : ' + data);
						
						if (data) {
							showErrorMessage(elP, '사용 가능 합니다.', true);
							boolUid = true;
						} else {
							showErrorMessage(elP, '이미 존재하는 아이디 입니다.', false);
							boolUid = false;
						}
					}
				});
			}
			/* u_id END */
			
			/* u_pw START */
			$("#u_pw").on("input",function(){
				var tempVal = $(this).val();
				var elP = $(this).parent().find(".result");
				var message = "영문/숫자 조합하여 6~20자 이내 작성";
				boolUPassword = checkRegex(elP, tempVal, regexPass, message, null);
			});
			/* u_pw END */
			
			/* u_repw START */
			$("#u_repw").on("input",function(){
				var tempVal = $(this).val();
				var originVal = $("#u_pw").val();
				var elP = $(this).parent().find(".result");
				var message = "";
				
				if (boolUPassword) {
					if(tempVal == originVal) {
						boolUPasswordCheck = true;
						message = "비밀번호가 일치 합니다.";
					} else {
						boolUPasswordCheck = false;
						message = "비밀번호가 일치 하지 않습니다.";
					}
				} else {
					boolUPasswordCheck = false;
					message ="비밀번호를 확인해주세요";
				}
				showErrorMessage(elP, message, boolUPasswordCheck);
			});
			/* u_repw END */
			
			/* u_name START */
			$("#u_name").on("input", function() {
				var tempVal = $(this).val();
				var elP = $(this).parent().find(".result");
				var message = "한글 2~6자 이내 작성";
				boolUName = checkRegex(elP, tempVal, regexName, message, null);
			});
			/* u_name END */
			
			/* u_phone START */
			$("#u_phone").on("input", function() {
				var tempVal = $(this).val();
				var elP = $(this).parent().find(".result");
				var message = "한글 2~6자 이내 작성";
				boolUPhone = checkRegex(elP, tempVal, regexMobile, message, null);
			});
			/* u_phone END */
			
			/* u_birth START */
			$("#u_birth").on("input", function() {
				var tempVal = $(this).val();
				var elP = $(this).parent().find(".result");
				var message = "숫자만 입력 ex) 19990101";
				boolUBirth = checkRegex(elP, tempVal, regexBirth, message, null);
			});
			/* u_birth END */
			
			/* u_addr START */
			function checkAddr() {
				if (($('#u_addr_post').val() === null || $('#u_addr_post').val() === '') && 
					($('#u_addr').val() === null || $('#u_addr').val() === '') && 
					($('#u_addr_detail').val() === null || $('#u_addr_detail').val() === '')) {
					boolUAddress = false;
				} else {
					boolUAddress = true;
				}
			}
			/* u_addr END */
			
			/* u_info START */
			$('#u_info').on('change', function() {
				var isChecked = $(this).is(':checked');
				if (isChecked) {
					boolUInfo = true;
				} else {
					boolUInfo = false;
				}
			});
			/* u_info END */
			
			/* 회원 가입 버튼 클릭시 발생 */
			$("#joinBtn").click(function() {
				checkAddr();
				if (!boolUid) {
					alert("아이디를 확인해 주세요");
					$("#u_id").focus();
				} else if (!boolUPassword) {
					alert("비밀번호를 확인해주세요!");
					$("#u_pw").focus();
				} else if (!boolUPasswordCheck) {
					alert("비밀번호가 일치하지 않습니다!");
					$("#u_repw").focus();
				} else if (!boolUName) {
					alert("이름을 확인해주세요!");
					$("#u_name").focus();
				} else if (!boolUPhone) {
					alert("전화번호를 확인해주세요!");
					$("#u_phone").focus();
				} else if (!boolUBirth) {
					alert("생년월일을 확인해주세요!");
					$("#u_birth").focus();
				} else if (!boolUAddress) {
					alert('주소를 기입 해주세요');
					$("#u_addr_post").focus();
				} else if (!boolUInfo) {
					alert('개인정보 이용약관에 동의 해주세요.');
					$("#u_info").focus();
				} else {
					$("#joinForm").submit();
				}
			});
		});
	</script>
</body>
</html>