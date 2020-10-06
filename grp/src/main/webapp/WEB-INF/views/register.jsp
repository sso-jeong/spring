<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/include/HEADER.jsp" %>
<body>
<%@ include file = "/WEB-INF/views/include/MENU.jsp" %>
<h2>회원가입</h2>
<form id="frm" method="post" action="${pageContext.request.contextPath}/register">
	아이디 : <input placeholder="아이디는 영어+숫자 15자리로 입력" type="text" name="memID" id="memID" required maxlength="15" tabindex="1"/>
	<span id="check" class="check"></span><br />
	비밀번호 : <input type="text" name="memPwd" id="memPwd" required maxlength="12" tabindex="2"/>
	이름 : <input type="text" name="memName" id="memName" required maxlength="5" tabindex="3"/>
	이메일 : <input type="text" name="memEmail" id="memEmail" maxlength="50" tabindex="4"/>
	<!-- ajax button type="button", form -> type="submit" -->
	<button type="submit">회원가입</button>
	<button type="reset">입력취소</button>
</form>
</body>
<script>
	$(function() { // blur : 현재 위치 벗어났을 때
		$("#memID").blur(function() {

			var dataForm = {
				memID:$("#memID").val()
			};
			
			$.ajax({
				url : "${pageContext.request.contextPath}/idCheck",
				type : "POST",
				data : dataForm,
				success : function(data) {
					if(data=="Ok") {
						$("#check").html("사용할 수 있는 아이디입니다.");

					}else {
						$("#check").html("사용할 수 없는 아이디입니다.");
						$("#memID").val("");
					}
				},
				error : function() {
					alert("시스템오류");
				}
			});
		});

	});
</script>
</html>