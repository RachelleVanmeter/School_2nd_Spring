$(function() {
	$("#add").click(function() {
		$.ajax({
			type : "post",
			url : "messages/add",
			dataType : "text",
			data : {
				target : $("#target").val(),
				sender : $("#sender").val(),
				message : $("#message").val()
			},
			success : function(data) {
				alert(data);
				$("#target").val("");
				$("#sender").val("");
				$("#message").val("");
			},
			error : function(res, status, error) {
				alert("code : " + res.code + "\n" + "message : " + res.responseText);
			}
		});
	});
	
	function messageList() {
		$.getJSON('/sessages/list', function(data) {
			console.log(data);
		});
	}
	
});