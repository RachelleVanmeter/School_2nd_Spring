<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>KOREATE PROJECTS <small>홈페이지에 오시걸 환영합니다.</small></h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li class="active">KOREATE PROJECTS</li>
				</ol>
			</section>
			
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">REGISTER BOARD</h3>
							</div>
							<a href="/board/register" class="btn btn-info">글쓰기</a>
							<a href="/board/listAll" class="btn btn-info">전체 게시물 조회</a>
							<a href="/board/listCri" class="btn btn-info">전체 게시물 조회 CRI</a>
							<a href="/board/listPage" class="btn btn-info">전체 게시물 조회 Paging</a>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
<%@ include file="include/footer.jsp" %>