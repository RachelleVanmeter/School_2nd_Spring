<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<h1>READ BOARD</h1>
	<form method="post">
		<table>
			<tr>
				<td>
					<label>BNO</label>
					<input type="text" name="bno" value="${board.bno}" >
				</td>
			</tr>
			<tr>
				<td>
					<label>TITLE</label>
					<input type="text" name="title" value="${board.title}" >
				</td>
			</tr>
			<tr>
				<td>
					<label>CONTENT</label>
					<textarea rows="4" name="content" >${board.content}</textarea>
				</td>
			</tr>
			<tr>
				<td>
					<label>WRITER</label>
					<input type="text" name="writer" value="${board.writer}" >
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="수정 하기">
					<input type="button" onclick="history.go(-1)" value="취소">
				</td>
			</tr>
		</table>
	</form>
<%@ include file="../include/footer.jsp"%>