<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
	<h1>REGISTER BOARD</h1>
	<form method="post">
		<table>
			<tr>
				<td>
					<label>TITLE</label>
					<input type="text" name="title">
				</td>
			</tr>
			<tr>
				<td>
					<label>CONTENT</label>
					<textarea rows="4" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td>
					<label>WRITER</label>
					<input type="text" name="writer">
				</td>
			</tr>
			<tr>
				<td>
					<input type="reset" value="다시 작성">
					<input type="submit" value="작성 완료">
				</td>
			</tr>
		</table>
	</form>
<%@ include file="../include/footer.jsp"%>