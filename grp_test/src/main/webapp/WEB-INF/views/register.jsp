<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/include/HEADER.jsp" %>
<body>
<%@ include file = "/WEB-INF/views/include/MENU.jsp" %>
<h2>회원가입</h2>
<form id="frm" method="post" action="${pageContext.request.contextPath}/register">
	아이디 : <input placeholder="아이디입력" type="text" name="memID" id="memID" required maxlength="15" autofocus tabindex="1" />
	<span id="checkID"></span>
	<br />	
	비밀번호 : <input type="password" name="memPwd" id="memPwd" required maxlength="12" tabindex="2" /><br />
	이름 : <input type="text" name="memName" id="memName" required maxlength="5" tabindex="3" /><br />
	이메일 : <input type="text" name="memEmail" id="memEmail" maxlength="50" tabindex="4" /><br />
	<!-- ajax button type="button", form -> type="submit" -->
	<button type="submit">회원가입</button>
	<button type="reset">입력취소</button>
</form>
</body>
<script>
	function checkID() {

		var formData = {
				memID	: $("#memID").val()
		};
		
		$.ajax({
			url		: "${pageContext.request.contextPath}/checkID",
			type	: "POST",
			data	: formData,
			success	: function(resData) {
				if( resData == "No" ) {
					$("#checkID").html("<i>사용할 수 없는 아이디입니다.</i>");
					$("#memID").val("");
					
				}else{
					$("#checkID").html("사용하셔도 좋습니다.");
				}
			},
			error	: function() {
				alert("시스템 에러");
			}
		});
	}

	$(function() {
		$("#memID").blur(function() { //id input 벗어났을 때
			checkID();
		});
	});
</script>
</html>












