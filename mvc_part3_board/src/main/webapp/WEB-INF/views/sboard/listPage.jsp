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
					<li><a href="#">Search Board</a></li>
					<li class="active">List Page</li>
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
							<div class="col-lg-2">
								<select id="searchType" name="searchType" class="form-control">
									<option ${cri.searchType == null ? 'selected' : ''} value="n">--------------------</option>
									<option ${cri.searchType == 't' ? 'selected' : ''} value="t">TITLE</option>
									<option ${cri.searchType == 'c' ? 'selected' : ''} value="c">CONTENT</option>
									<option ${cri.searchType == 'w' ? 'selected' : ''} value="w">WRITER</option>
									<option ${cri.searchType == 'tc' ? 'selected' : ''} value="tc">TITLE & CONTENT</option>
									<option ${cri.searchType == 'cw' ? 'selected' : ''} value="cw">CONTENT & WRITER</option>
									<option ${cri.searchType == 'tcw' ? 'selected' : ''} value="tcw">TITLE & CONTENT & WRITER</option>
								</select>
							</div>
							<div class="col-lg-3">
								<input id="keyword" type="text" name="keyword" class="form-control" value="${cri.keyword}">
							</div>
							<div>
								<input id="searchBtn" type="button" class="btn btn-warning" value="SEARCH"/>
								<input id="newBtn" type="button" class="btn btn-primary" value="NEW BOARD"/>
								<script type="text/javascript">
									$(function() {
										$('#searchBtn').click(function() {
											var searchTypeVal = $('#searchType').val();
											var keywordVal = $('#keyword').val();
											location.href = '/sboard/list?searchType=' + searchTypeVal + '&keyword=' + keywordVal;
										});
										
										$('#newBtn').click(function() {
											location.href = '/sboard/register';
										});
									});
								</script>
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
												<td><a href="/sboard/readPage${pageMaker.makeSearch(pageMaker.cri.page)}&bno=${board.bno}">${board.title}</a></td>
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
							<div class="box-footer">
								<div class="text-center">
									<ul class="pagination">
									<c:if test="${pageMaker.prev}">
										<li><a href="/sboard/list${pageMaker.makeSearch(pageMaker.cri.page - 1)}">&laquo;</a></li>
									</c:if>
									<c:forEach var="i" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
										<li ${pageMaker.cri.page == i ? 'class=active' : ''}>
											<a href="/sboard/list${pageMaker.makeSearch(i)}">${i}</a>
										</li>
									</c:forEach>
									<c:if test="${pageMaker.next}">
										<li><a href="/sboard/list${pageMaker.makeSearch(pageMaker.cri.page + 1)}">&raquo;</a></li>
									</c:if>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->
<%@ include file="../include/footer.jsp" %>