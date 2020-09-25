<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<body>
	<!-- logo inc -->
	<%@ include file="/WEB-INF/views/include/logo.jsp"%>
	<!-- logo inc -->
	<div class="login-wrap">
		<div class="login-box">
			<form method="post" action="grp_main.html" autocomplete="off">
				<input type="text" name="userid" id="userid"
					placeholder="사원번호를 입력하세요." required autofocus /> <input
					type="password" name="passwd" id="passwd"
					placeholder="비밀번호를 입력하세요." required />
				<div class="">
					<button type="submit" class="btn roboto">Login</button>
				</div>
				<div class="register-wrap">
					<a href="${pageContext.request.contextPath}/register/grp_register" class="">사원가입</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>