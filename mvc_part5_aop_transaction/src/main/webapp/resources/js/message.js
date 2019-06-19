$(function() {
	messageList();
	
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
				messageList();
			},
			error : function(res, status, error) {
				alert("code : " + res.code + "\n" + "message : " + res.responseText);
			}
		});
	});
});

function readMessage(mno, uid) {
	alert(mno + " / " + uid);
	
	$.ajax({
		type : "patch",
		url : "/messages/read/" + mno + "/" + uid,
		headers : {
			"Content-Type" : "application/json",
			"X-HTTP-Method-Override" : "PATCH"
		},
		data : JSON.stringify({
			uid : uid
		}),
		dataType : "json",
		success : function(data) {
			console.log(data);
			messageList();
		}
	});
}

function messageList() {
	$.getJSON('/messages/list', function(data) {
		console.log(data);
		
		var str = "";
		
		$(data).each(function() {
			var opendate = "";
			if(this.opendate > 0) {
				var date = new Date(this.opendate);
				opendate = date.getFullYear() +  "년 "
						 + (date.getMonth() + 1) + "월 "
						 + date.getDate() + "일 "
						 + date.getHours() + "시 "
						 + date.getMinutes() + "분";
			} else {
				opendate = "미확인";
			}
			
			str += "<li onclick='readMessage(" + this.mno + ",\"" + this.target + "\")'>";
			str += this.mno + "  |  ";
			str += this.target + "  |  ";
			str += this.sender + "  |  ";
			str += this.message + "  |  ";
			str += opendate + "  |  ";
			str += new Date(this.senddate) + "  |  ";
			str += "</li>";
		});
		$("#messageList").html(str);
	});
}