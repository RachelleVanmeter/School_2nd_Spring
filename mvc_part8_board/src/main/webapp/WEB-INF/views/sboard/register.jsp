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
	.uploadList {
		width: 100%;
		margin: 0 5px;
		background-color: gray;
	}
</style>
<script src="//code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="/resources/editer/js/service/HuskyEZCreator.js"></script>
</head>
<body>
	<h1>REGISTER BOARD</h1>
	<form id="registForm" action="/sboard/register" method="post">
		<input type="hidden" name="uno" value="${userInfo.uno}"/>
		<table style="width:100%;">
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" required/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" value="${userInfo.uname}" name="writer" readonly/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea name="content" id="content" rows="3" required></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<label>FILE DROP HERE</label>
					<div class="fileDrop"></div>
				</td>
			</tr>
		</table>
		<div id="uploadList">
			<button id="deleteAll">전체 삭제</button>
			<button id="deleteSelect">선택 삭제</button>
		</div>
	</form>
	<script type="text/javascript">
		$('.fileDrop').on('dragenter dragover', function(e) {
			e.preventDefault();
		});
		
		$('.fileDrop').on('drop', function(e) {
			e.preventDefault();
			
			var files = e.originalEvent.dataTransfer.files;
			for (var i = 0; i < files.length; i++) {
				var file = files[i];
				console.log(file);
				
				var maxSize = 10485760;
				
				if (file.size > maxSize) {
					alert('파일 크기가 너무 큽니다 : ' + file.size);
					return;
				}
				
				var formData = new FormData();
				formData.append('file', file);
				
				$.ajax({
					type : "post",
					url : "/uploadAjax",
					data : formData,
					dataType : "text",
					contentType : false,
					processData : false,
					success : function(data) {
						console.log(data);
						var str = '';
	
						if(checkImageType(data)) {
							str = "<div>"
								+ "<input type='checkbox' id='select' data-src='" + data + "'>"
								+ "<a href='/displayFile?fileName=" + getImageLink(data) + "' target='_blank'>"
								+ "<img src='/displayFile?fileName=" + data + "'/>"
								+ "</a>"
								+ "<small data-src='" + data + "'> X </small>"
								+ "</div>";
						} else {
							str = "<div>"
								+ "<input type='checkbox' id='select' data-src='" + data + "'>"
								+ "<a href='/displayFile?fileName=" + data + "'>"
								+ getOriginalName(data)
								+ "</a>"
								+ "<small data-src='" + data + "'> X </small>"
								+ "</div>";
						}
						$(".uploadList").append(str);
					}
				});
			}
		});
		
		function checkImageType(fileName) {
			var pattern = /jpg|gif|png|jpeg/i
			return fileName.match(pattern);
		}
		
		function getOriginalName(fileName) {
			if(checkImageType(fileName)) return;
			var idx = fileName.indexOf("_") + 1;
			return fileName.substr(idx);
		}
		
		function getImageLink(fileName) {
			if(!checkImageType(fileName)) return;
			
			var front = fileName.substr(0, 12);
			var end = fileName.substr(14);
			
			console.log(fileName);
			console.log(front + end);
			
			return front + end;
		}
		
		$('.uploadList').on('click', 'small', function(e) {
			var target = $(this);

			$.ajax({
				type : "post",
				url : "/deleteFile",
				dataType : "text",
				data : {
					fileName : $(this).attr("data-src")
				},
				success : function(result) {
					if(result == 'deleted') {
						alert('작업 성공');
						target.parent("div").remove();
					}
				}
			});
		});
		
		$('#deleteAll').click(function() {
			var target = $('.uploadList > div > small');
			for (var i = 0; i < target.length; i++) {
				$.ajax({
					type : "post",
					url : "/deleteFile",
					dataType : "text",
					data : {
						fileName : $(target).attr("data-src")
					},
					success : function(result) {
						if(result == 'deleted') {
							target.parent("div").remove();
						}
					}
				});
			}
			alert('작업 성공');
		});
		
		$('#deleteSelect').click(function() {
			var target = $('.uploadList > div > #select:checked');
			for (var i = 0; i < target.length; i++) {
				$.ajax({
					type : "post",
					url : "/deleteFile",
					dataType : "text",
					data : {
						fileName : $(target).attr("data-src")
					},
					success : function(result) {
						if(result == 'deleted') {
							target.parent("div").remove();
						}
					}
				});
			}
			alert('작업 성공');
		});
		
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