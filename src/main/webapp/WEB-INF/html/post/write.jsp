<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />

<link href="/css/bootstrap.css" rel="stylesheet">
<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.js"></script>
<link href="/css/summernote.css" rel="stylesheet">
<script src="/js/summernote/summernote.js"></script>
 
<title>Insert title here</title>
<script type="text/javascript">

$(document).ready(function() {
	 $('#summernote').summernote({
		  callbacks: {
			  onImageUpload : function(files, editor, welEditable) {
		            sendFile(files[0], editor, welEditable);
		        }
		  }
		});
	
	$('#save').click(function(){
		save();
	});
});

function save(){
	var data = summernote.summnernote('code');
	$.ajax({
		
	});
}

function destoryNote(){
	 $('#summernote').summernote('destroy');
}

function sendFile(file, editor, welEditable) {
    data = new FormData();
    data.append("uploadFile", file);
    $.ajax({
        data : data,
        type : "POST",
        url : "/post/image",
        cache : false,
        contentType : false,
        processData : false,
        success : function(data) {
        	var url = data.url;
        	 $('#summernote').summernote('editor.insertImage', url);
        }
    });
}

</script>
</head>
<body>
	<h1>TEST</h1>
	<div id="summernote">Hello Summernote with JSP</div>
	<button id="save" class="btn btn-primary" type="button">Save 2</button>
</body>
</html>