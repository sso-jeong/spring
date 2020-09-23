<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>회원가입 체크</title>
</head>
<body>
	<div id="result"></div>
	<form id="frm" action="">
		<input type="text" name="" id="userid" /><br /> <input type="text"
			name="" id="passwd" /><br />
		<button id="btn" type="button">회원가입</button>
	</form>
</body>

<script>
	$(function() {
		$("#btn").click(function() {
			//alert("aaa");
			var formData = {
				userid : $("#userid").val(),
				passwd : $("#passwd").val()
			};

			$.ajax({
				url : "/ex2/checkData",
				type : "POST", // 소문자도 허용
				data : formData,
				success : function(data) {
					$("#result").html("<b><i>" + data + "</i></b>");

					if (data == "NO") {
						$("#userid").val("");
					}

				},
				error : function() {
					alert("시스템 에러");
				}
			});
		});

	});
</script>

</html>