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
					<li class="active">List All</li>
				</ol>
			</section>
			
			<!-- Main content -->
			<section class="content">
				<div class="row">
					<div class="col-md-12">
						<div class="box">
							<div class="box-header with-border">
								<h3 class="box-title">게시글 목록</h3>
							</div>
							<div class="box-body">
								<table class="table table-bordered">
									<thead>
										<tr>
											<th>BNO</th>
											<th>TITLE</th>
											<th>WRITER</th>
											<th>REGDATE</th>
											<th>VIEWCNT</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="board" items="${boardList}">
											<tr>
												<td>${board.bno}</td>
												<td><a href="/board/read?bno=${board.bno}">${board.title}</a></td>
												<td>${board.writer}</td>
												<td><fmt:formatDate pattern="yyyy-MM-dd HH:ss" value="${board.regdate}" /></td>
												<td><span class="badge bg-red">${board.viewcnt}</span></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
								<script type="text/javascript">
									check('${result}');
									history.replaceState({}, null, null);
									
									function check(msg) {
										if (msg != null || history.state) return;
										if (msg == 'SUCCESS') alert('작업 완료');
										else alert('작업 실패');
									}
								</script>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
<%@ include file="../include/footer.jsp" %>