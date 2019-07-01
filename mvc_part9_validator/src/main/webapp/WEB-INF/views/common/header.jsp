<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="/resources/bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript" src="/resources/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
</head>
<body>
	<header class="cantainer">
		<nav class="navbar navbar-default" role="navigation">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
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
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">게시물</a>
						<ul class="dropdown-menu dropdown-menu-left">
							<li><a href="#">공지사항</a></li>
							<li><a href="#">질문과답변</a></li>
							<li><a href="#">문의사항</a></li>
						</ul>
					</li>
					<li><a href="/user/login">로그인</a></li>
					<li><a href="/user/join">회원가입</a></li>
					<li><a href="/user/joinVal">회원가입(validation)</a></li>
				</ul>
			</div>
		</nav>
	</header>