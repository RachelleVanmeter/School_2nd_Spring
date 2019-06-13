<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<h1>BOARD LIST</h1>
	<button onclick="location.href='/board/register'">New Board</button>
	<h1>LIST PAGING</h1>
	<table border="1">
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
				<td><a href="/board/readPage?bno=${board.bno}&page=${cri.page}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}" /></td>
				<td>${board.viewcnt}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<ul class="pagination">
	<c:if test="${pageMaker.prev}">
		<li><a href="/board/listPage?page=${pageMaker.startPage - 1}&perPageNum=${pageMaker.cri.perPageNum}">&laquo;</a></li>
	</c:if>
	<c:forEach var="i" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		<li ${pageMaker.cri.page == i ? 'class=active' : ''}>
			<a href="/board/listPage?page=${i}&perPageNum=${pageMaker.cri.perPageNum}">${i}</a>
		</li>
	</c:forEach>
	<c:if test="${pageMaker.next}">
		<li><a href="/board/listPage?page=${pageMaker.endPage + 1}&perPageNum=${pageMaker.cri.perPageNum}">&raquo;</a></li>
	</c:if>
	</ul>
	<script type="text/javascript">
		check('${result}');
		history.replaceState({}, null, null);
		
		function check(msg) {
			if (msg == 'SUCCESS') alert('작업 완료');
			if (msg == 'FAIL') alert('작업 실패');
		}
	</script>
<%@ include file="../include/footer.jsp"%>