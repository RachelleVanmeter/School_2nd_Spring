<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="${path}/resources/bootstrap/css/bootstrap.css" rel="stylesheet"/>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${path}/resources/bootstrap/js/bootstrap.js"></script>
<script src="${path}/resources/js/jquery.validate.js"></script>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css" type="text/css" />  
<script src="http://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>  
</head>
<body>
	<header class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-hedaer">
				<button type="button" class="navbar-toggle" 
						data-toggle="collapse" 
						data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle Navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/">
					<span class="glyphicon glyphicon-leaf"></span>
				</a>
			</div>
			<div class="collapse navbar-collapse navbar-right navbar-ex1-collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">
							게시물
						</a>
						<ul class="dropdown-menu dropdown-menu-left">
							<li><a href="#">공지사항</a></li>
							<li><a href="#">질문답변</a></li>
							<li><a href="#">문의사항</a></li>
						</ul>
					</li>
					<sec:authorize access="isAuthenticated()">
						<sec:authentication var="member" property="principal.member"/>
						<li><a href="#">${member.u_name}</a></li>
						<li><a href="/mngt/main">MANAGEMENT</a></li>
						<li><a href="/user/logout">logout</a></li>
						<li><a href="#bs-example-modal-sm" data-toggle="modal">chat</a></li>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
						<li><a href="${path}/user/login">로그인</a></li>
						<li><a href="${path}/user/join">회원가입</a></li>
						<li><a href="${path}/user/joinVal">회원가입(validation)</a></li>
					</sec:authorize>
					<!-- <li><a href="/chat">chat</a></li> -->
					
				</ul>			
			</div>
		</nav>	
	</header>
	<div class="modal fade" id="bs-example-modal-sm" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-sm">
     <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
        <h4 class="modal-title" id="mySmallModalLabel">CHAT PAGE </h4>
      </div>
      <div class="modal-body">
		<textarea id="data" class="form-control" rows="4" cols="50" readonly></textarea>
		<br/>
		<div class="row">
			<div class="col-md-8">
				<input type="text" id="message" class="form-control"/>
			</div>
			<div class="col-md-4">
				<input type="button" id="sendBtn" 
				class="form-control btn btn-primary" value="SEND"/>
			</div>
		</div>
      </div>
       <div class="modal-footer">
        <button type="button" class="btn btn-default form-control" data-dismiss="modal">닫기</button>
      </div>
    </div>
  </div>
</div>
	<script>
		$(function(){
			$("#sendBtn").click(function(){
				// 메세지 전송
				sendMessage();
				$("#message").val('');
			});
			
			$("#message").keydown(function(key){
				// 인풋에 들어온 키 값이 enter 일때
				if(key.keyCode == 13){
					// 메세지 전송
					sendMessage();
					$(this).val('');
				}
			});
		});
		
		function changeEscape(text){
			var result = "";
			result = text.replaceAll("<","&lt;");
			result = result.replaceAll(">","&gt;");
			result = result.replaceAll("\"","'");
			return result;
		}
		
		var sock = new SockJS("/echo");
		sock.onmessage = onmessage;
		sock.onclose = onclose;
		
		String.prototype.replaceAll = function(old , dest){
			return this.split(old).join(dest);
		}
		
		function sendMessage(){
			var userName = "${member.u_name}";
			var message = $("#message").val();
			console.log(message);
			if(message != ''){
				console.log(message);
				message = changeEscape($("#message").val());
				sock.send(userName+","+message);
			}else{
				alert('message를 입력해주세요');
				 $("#message").focus();
			}
		}
		
		function onmessage(message){
			var data = message.data;
			$("#data").append(data+"\r\n");
			$("#data").focus();
			$("#message").focus();
		}
		
		function onclose(){
			$("#data").append("연결 끊김");
		}
		
	</script>	
	
	