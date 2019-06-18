/**
 * comment  
 * 
 * 
 */

var bno = 1;
var commentPage = 1;

$("#commentAddBtn").click(function(){
	var commentText = $("#newCommentText").val();
	var commentAuth = $("#newCommentAuth").val();
	alert(commentText +"  /  "+commentAuth);
	
	$.ajax({
		type : "post",
		url : "comments",
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "POST"
		},
		dataType : "text",
		data : JSON.stringify({
			bno : bno,
			commentText : commentText,
			commentAuth : commentAuth
		}),
		success : function(data){
			//getAllList();
			getPageList(1);
			
		},
		error : function(res,error){
			alert(error);
		}
	});
});

function getAllList(){
	$.getJSON("comments/all/"+bno,function(data){
		// 화면 출력
		console.log(data);
		var str = "";
		
		$(data).each(function(){
			str += "<li data-cno='"+this.cno+"' data-text='"+this.commentText+"' class='commentLi'>"+this.cno+" : "+this.commentText+"<button>MODIFY</button></li>"
		});
		$("#comments").html(str);	
		
	});
}

$("#commentListBtn").click(function(){
	getAllList();
});

$("#comments").on("click",".commentLi button",function(){
	var comment = $(this).parent();
	var cno = comment.attr("data-cno");
	var commentText = comment.attr("data-text");
	$(".mod-title").html(cno);
	$("#commentText").val(commentText);
	
	//alert(cno +" / "+ commentText);
	$("#modDiv").show("slow");
});

$("#closeBtn").click(function(){
	$("#modDiv").hide("slow");
});


$("#commentModBtn").click(function(){
	var cno = $(".mod-title").html();
	var commentText = $("#commentText").val();
	console.log(cno +"  /  " + commentText);
	
	$.ajax({
		type : "patch",
		url : "comments/"+cno,
		headers : {
			"Content-type" : "application/json",
			"X-HTTP-Method-Override" : "PATCH"
		},
		data : JSON.stringify({commentText : commentText}),
		dataType : "text",
		success : function(data){
			if(data == "SUCCESS"){
				alert("수정이 완료되었습니다.");
				$("#modDiv").hide("slow");
				//getAllList();
				getPageList(commentPage);
			}
		}
	});			
});

$("#commentDelBtn").click(function(){
	var cno = $(".mod-title").html();
	
	$.ajax({
		type : "delete",
		url : "comments/"+cno,
		headers : {
			"X-HTTP-Method-Override" : "DELETE"
		},
		dataType : "text",
		success : function(data){
			alert(data);
			$("#modDiv").hide("slow");
			//getAllList();
			getPageList(commentPage);
		}
	});
});

getPageList(1);

function getPageList(page){
	commentPage = page;
	$.getJSON("comments/"+bno+"/"+page, function(data){
		console.log(data);
		console.log("data 길이 : " + data.length);
		console.log("data.list comment 항목의 길이 : " + data.list.length);
		// map 
		// pageMaker  // list
		// data.list.length
		var str = "";
		for(var i=0; i<data.list.length; i++){
			str += "<li class='commentLi' ";
			str += "data-text='"+data.list[i].commentText+"' "; 
			str += "data-cno='"+data.list[i].cno+"'>";
			str += data.list[i].cno+" : " + data.list[i].commentText;
			str += "<button>MODIFY</button>";
			str +="</li>";
		}
		
		$("#comments").html(str);
		printPage(data.pageMaker);
		/*
		$(data.list).each(function(){
			str += "<li class='commentLi' ";
			str += "data-text='"+this.commentText+"' "; 
			str += "data-cno='"+this.cno+"'>";
			str += this.cno+" : " + this.commentText
			str += "<button>MODIFY</button>";
			str +="</li>";
		});
		*/
	});
}

function printPage(pageMaker){
	var str ="";
	if(pageMaker.prev){
		str += "<li><a href='"+(pageMaker.startPage-1)+"'> << </a></li>";
	}
	for(var i=pageMaker.startPage; i<=pageMaker.endPage; i++){
		var strClass = pageMaker.cri.page == i ? " class='active'" : "";
		str += "<li "+strClass+"><a href='"+i+"'>"+i+"</a></li>"; 
	}
	if(pageMaker.next){
		str += "<li><a href='"+(pageMaker.endPage+1)+"'> >> </a></li>";
	}	
	$("#pagination").html(str);
}

$("#pagination").on("click","li a",function(event){
	event.preventDefault();
	var commentPage = $(this).attr("href");
	console.log(commentPage);
	getPageList(commentPage);			
});		
