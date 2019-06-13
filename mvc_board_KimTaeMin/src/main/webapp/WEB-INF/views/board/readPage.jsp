<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<h1>READ BOARD</h1>
	<table>
		<tr>
			<td>
				<label>TITLE</label>
				<input type="text" name="title" value="${board.title}" readonly>
			</td>
		</tr>
		<tr>
			<td>
				<label>CONTENT</label>
				<textarea rows="4" name="content" readonly>${board.content}</textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label>WRITER</label>
				<input type="text" name="writer" value="${board.writer}" readonly>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" onclick="location.href='/board/modifyPage?bno=${board.bno}&page=${cri.page}&perPageNum=${cri.perPageNum}'" value="수정">
				<input type="button" onclick="location.href='/board/remove?bno=${board.bno}&page=${cri.page}&perPageNum=${cri.perPageNum}'" value="삭제">
				<input type="button" onclick="location.href='/board/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}'" value="목록">
			</td>
		</tr>
	</table>
<%@ include file="../include/footer.jsp"%>