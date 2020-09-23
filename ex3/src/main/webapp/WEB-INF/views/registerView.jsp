<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입예제</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<div id="result">아이디 사용 여부</div>
	<form id="frm">
		<input type="text" name="userid" id="userid" /><br />
		<input type="text" name="passwd" id="passwd" /><br />
		<input type="text" name="name" id="name" /><br />
		<input type="text" name="tel" id="tel" /><br />
		<button id="btn" type="button">회원가입</button>
	</form>
</body>

<script>
	$(function() {
		$("#btn").click(function() {
			/* 유효성 검사 */
			if ($("#userid").val() == "") {
				alert("아이디를 입력하세요.");
				$("#userid").focus();
				return false;
			}

			$.ajax({
				url : "/ex3/setData",
				type : "POST",
				data : $("#frm").serialize(),
				success : function(responseData) {
					$("#result").html(responseData);
					//alert(responseData);
				},
				error : function() {
					alert("관리자에게 문의하세요.");
				}
			});
		});
	});
</script>
</html>