<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>REPLY BOARD LIST</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<div>
		<select name="searchType">
			<option value="n" ${cri.searchType == null ? 'selected' : ''}>-------------------</option>
			<option value="t" ${cri.searchType == 't' ? 'selected' : ''}>TITLE</option>
			<option value="c" ${cri.searchType == 'c' ? 'selected' : ''}>CONTENT</option>
			<option value="w" ${cri.searchType == 'w' ? 'selected' : ''}>WRITER</option>
			<option value="tc" ${cri.searchType == 'tc' ? 'selected' : ''}>TITLE&CONTENT</option>
			<option value="cw" ${cri.searchType == 'cw' ? 'selected' : ''}>CONTENT&WRITER</option>
			<option value="tcw" ${cri.searchType == 'tcw' ? 'selected' : ''}>TITLE*CONTENT&WRITER</option>
		</select>
		<input type="text" name="keyword" id="keyword" value="${cri.keyword}"/>
		<input type="button" id="searchBtn" value="검색"/>
		<input type="button" id="newBtn" value="글작성"/>
	</div>
	<br/>
	<table border=1>
		<tr>
			<th>BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REGDATE</th>
			<th>VIEWCNT</th>
		</tr>
		<!-- 게시글 항목 출력 -->
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.bno}</td>
				<td><a href="/sboard/readPage?bno=${board.bno}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td><f:formatDate pattern="yyyy-MM-dd HH:mm" value="${board.regdate}"/></td>
				<td>${board.viewcnt}</td>
			</tr>
		</c:forEach>
	</table>
	<!-- paging 블럭 -->
	<c:if test="${pageMaker.prev}">
		<a href="/sboard/listReply?page=1">&laquo;&laquo;</a>
		<a href="/sboard/listReply?page=${pageMaker.startPage-1}">&laquo;</a>
	</c:if>
	<c:forEach var="i" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
		<a href="/sboard/listReply?page=${i}">${i}</a>
	</c:forEach>
	<c:if test="${pageMaker.next}">
		<a href="/sboard/listReply?page=${pageMaker.endPage+1}">&raquo;</a>
		<a href="/sboard/listReply?page=${pageMaker.maxPage}">&raquo;&raquo;</a>
	</c:if>
	
	<script>
		$("#searchBtn").click(function(){
			var searchValue = $("select option:selected").val();
			var keywordValue = $("#keyword").val();
			console.log(searchValue +"  /  " + keywordValue);
			location.href="/sboard/listReply?searchType="+searchValue+"&keyword="+keywordValue;
		});
	</script>
</body>
</html>









