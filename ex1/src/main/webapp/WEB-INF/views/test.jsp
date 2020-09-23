<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<button id="btn">Ajax 데이터 전송 테스트</button>
	<br />
	<div id="result"></div>
</body>
<script>
	$(function() {
		$("#btn").click(function() {
			//alert("aaa");
			//json 데이터를 만듦
			var form = {
				userid : "greenart",
				passwd : "1234"
			};

			//ajax 만듦
			$.ajax({
				url : "/ex1/setData", // ajax 처리할 주소
				type : "POST", // 보내는 전송 방식 (post:숨겨서 보냄)
				data : form, // 보낼 데이터
				//contentType : "",
				//dataType : "", // 생략 가능
				success : function(data) { // 정상 실행 시
					//alert("정상실행");
					$("#result").html("<i>" + data + "</i>"); // html은 태그 가능함
					//$("#result").text(data); text는 태그가 안됨
				},
				error : function() { // 정상 실행이 아닐 시
					alert("시스템 에러");
				}
			});
		});
	});
</script>

</html>