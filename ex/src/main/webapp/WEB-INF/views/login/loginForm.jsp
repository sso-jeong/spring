<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그룹웨어 로그인 화면</title>
<style>
	.box {
		background-color: #eee;
		width: 400px;
		height: 300px;
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%, -50%);
	}
</style>
</head>
<body>
	<div class="box">
		<form id="frm" method="post" action="loginDo">
			<input type="text" name="userid" id="userid" /><br />
			<input type="password" name="passwd" id="passwd" />
			<button type="submit">로그인 전송</button>
		</form>
	</div>
</body>
</html>