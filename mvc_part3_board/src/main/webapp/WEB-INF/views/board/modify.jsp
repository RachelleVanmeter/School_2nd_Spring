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
					<li class="active">MODIFY</li>
				</ol>
			</section>
			
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">MODIFY BOARD</h3>
							</div>
							<form method="post" autocomplete="off">
								<input type="hidden" name="bno" value="${board.bno}">
								<div class="box-body">
									<div class="form-group">
										<label>TITLE</label>
										<input class="form-control" type="text" name="title" value="${board.title}">
									</div>
									<div class="form-group">
										<label>CONTENT</label>
										<textarea class="form-control" name="content" rows="4">${board.content}</textarea>
									</div>
									<div class="form-group">
										<label>WRITER</label>
										<input class="form-control" type="text" name="writer" value="${board.writer}">
									</div>
								</div>
								<div class="box-footer">
									<input type="submit" class="btn btn-warning" value="MODIFY">
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