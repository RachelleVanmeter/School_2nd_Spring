<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<style type="text/css">
		.fileDrop {
			width: 100%;
			height: 200px;
			border:  1px solid blue;
		}
	</style>
</head>
<body>
	<h1>UPLOAD AJAX</h1>
	<div class="fileDrop">
		
	</div>
	<div class="uploadList">
		
	</div>
	<script type="text/javascript">
		$('.fileDrop').on('dragenter dragover', function(e) {
			e.preventDefault();
		});
		
		$('.fileDrop').on('drop', function(e) {
			e.preventDefault();
			
			var files = e.originalEvent.dataTransfer.files;
			var file = files[0];
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
							+ "<a href='/displayFile?fileName=" + getImageLink(data) + "' target='_blank'>"
							+ "<img src='/displayFile?fileName=" + data + "'/>"
							+ "</a>"
							+ "<small data-src='" + data + "'>X</small>"
							+ "</div>";
					} else {
						str = "<div>"
							+ "<a href='/displayFile?fileName=" + data + "'>"
							+ getOriginalName(data)
							+ "</a>"
							+ "<small data-src='" + data + "'>X</small>"
							+ "</div>";
					}
					$(".uploadList").append(str);
				}
			});
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
		
		$('.uploadedList').on('click', 'small', function(e) {
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
	</script>
</body>
</html>