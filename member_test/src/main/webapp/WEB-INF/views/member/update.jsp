<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/member/HEADER.jsp" %>
<style>
	.check {
		color:#f00;
	}
</style>
<body>
<div class="">
	<h1>그린컴퓨터 웹사이트 회원수정하기</h1>
	<a href="${pageContext.request.contextPath}/member">메인페이지로</a> | 
	<a href="${pageContext.request.contextPath}/member/list">회원목록</a>
</div>
<div class="box">
        <form name="frm" id="frm" action="${pageContext.request.contextPath}/member/update" method="post">
            * 아이디 : <input type="text" maxlength="15" name="userid" id="userid" required value="${update.userid}" />
            <span id="check" class="check"></span>
            <br />
            * 비밀번호 : <input type="password" maxlength="12" name="passwd" required id="passwd" /><br />
            * 비밀번호 확인 : <input type="password" name="repasswd" required id="repasswd" /><br />
            * 사용자 이름 : <input type="text" maxlength="5" name="username" required id="username" value="${update.username}" /><br />
                         이메일 : <input type="text" maxlength="50" name="email" id="email" value="${update.email}" /><br />
            <button type="submit">회원수정</button>
            <input type="text" name="id" value="${update.id}" />
        </form>
    </div>
</body>
<script>
	$(function() { //blur : 현재 위치에서 벗어났을 때
		$("#userid").blur(function() {

			var dataForm = {
					userid : $("#userid").val()
			};

			$.ajax({
				url		: "${pageContext.request.contextPath}/member/idCheck",
				type	: "POST",
				data	: dataForm,
				success : function(data) {
					if( data == "Ok" ) {
						$("#check").html("사용할 수 있는 아이디입니다.");

					}else{
						$("#check").html("사용할 수 없는 아이디입니다.");
						$("#userid").val("");
					}
				},
				error	: function() {
					alert("시스템 오류");
				}
			});
			
		});
	});
</script>

<%@ include file = "/WEB-INF/views/member/FOOTER.jsp" %>









