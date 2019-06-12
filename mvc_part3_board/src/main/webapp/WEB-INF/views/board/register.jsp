<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>KOREATE PROJECTS <small>홈페이지에 오시걸 환영합니다.</small></h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
					<li><a href="#">Board</a></li>
					<li class="active">REGISTER</li>
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
							<form method="post" autocomplete="off">
								<div class="box-body">
									<div class="form-group">
										<label>TITLE</label>
										<input type="text" name="title" class="form-control" placeholder="Enter Title..." required>
									</div>
									<div class="form-group">
										<label>CONTENT</label>
										<textarea name="content" class="form-control" rows="3" placeholder="Enter Content..."></textarea>
									</div>
									<div class="form-group">
										<label>WRITER</label>
										<input type="text" name="writer" class="form-control" placeholder="Enter Writer..." required>
									</div>
								</div>
								<div class="box-footer">
									<input type="submit" value="등록" class="btn btn-warning">
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
<%@ include file="../include/footer.jsp" %>