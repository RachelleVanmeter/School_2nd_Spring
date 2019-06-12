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
					<li class="active">READ</li>
				</ol>
			</section>
			
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">READ BOARD</h3>
							</div>
							<div class="box-body">
								<div class="form-group">
									<label>TITLE</label>
									<input class="form-control" type="text" name="title" value="${board.title}" readonly>
								</div>
								<div class="form-group">
									<label>CONTENT</label>
									<textarea class="form-control" name="content" rows="4" readonly>${board.content}</textarea>
								</div>
								<div class="form-group">
									<label>WRITER</label>
									<input class="form-control" type="text" name="writer" value="${board.writer}" readonly>
								</div>
							</div>
							<div class="box-footer">
								<input type="button" class="btn btn-warning" value="MODIFY">
								<input type="button" class="btn btn-danger" value="DELETE">
								<input type="button" class="btn btn-primary" value="LIST">
								<form method="post" id="readForm">
									<input type="hidden" name="bno" value="${board.bno}">
								</form>
							</div>
							<script type="text/javascript">
								var readForm = $('.readForm');
								
								$('.btn-warning').click(function() {
									readForm.attr('action', '/board/modify');
									readForm.attr('method', 'get');
									readForm.submit();
								});
								
								$('.btn-danger').click(function() {
									readForm.attr('action', '/board/delete').submit();
								});
								
								$('.btn-primary').click(function() {
									location.href = '/board/listAll';
								});
							</script>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
<%@ include file="../include/footer.jsp" %>