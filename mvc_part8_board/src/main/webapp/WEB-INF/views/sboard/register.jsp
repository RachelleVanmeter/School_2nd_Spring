<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.fileDrop{
		width:100%;
		height:150px;
		border:1px solid gray;
		background-color:lightslategray;
		margin:auto;
	}
</style>
<script src="/resources/editer/js/service/HuskyEZCreator.js"></script>
</head>
<body>
	<h1>REGISTER BOARD</h1>
	<table style="width:100%;">
		<tr>
			<td>제목</td>
			<td><input type="text" name="title"/></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><input type="text" name="writer"/></td>
		</tr>
		<tr>
			<td>내용</td>
			<td>
				<textarea name="content" id="content" rows=3></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<label>FILE DROP HERE</label>
				<div class="fileDrop"></div>
			</td>
		</tr>
	</table>
	<script>
		var path = "/resources/editer/SmartEditor2Skin.html";
		var oEditors = [];
		nhn.husky.EZCreator.createInIFrame(
			oEditors,
			"content",
			path,
			"createSEditor2"
		);
	</script>
</body>
</html>