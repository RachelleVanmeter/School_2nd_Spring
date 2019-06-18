<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comment Test</title>
<link href="${pageContext.request.contextPath}/resources/comment.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div id="modDiv" style="display:none;">
		<div class="mod-title"></div>	
		<div>
			<input type="text" id="commentText"/>
		</div>
		<div>
			<button id="commentModBtn">MODIFY</button>
			<button id="commentDelBtn">DELETE</button>
			<button id="closeBtn">CLOSE</button>
		</div>
	</div>
	<h1>AJAX-REST TEST PAGE</h1>
	<div>
		<div>
			commentAuth <input type="text" id="newCommentAuth"/>
		</div>
		<div>
			commentText <input type="text" id="newCommentText"/>
		</div>
		<button id="commentAddBtn">ADD COMMENT</button>
		<button id="commentListBtn">List ALL</button>
	</div>
	<ul id="comments"></ul>
	<ul id="pagination" class="pagination">
	</ul>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/comment.js"></script>
</body>
</html>








