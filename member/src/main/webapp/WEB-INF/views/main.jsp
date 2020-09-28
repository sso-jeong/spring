<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file = "/WEB-INF/views/member/HEADER.jsp" %>

<body>
	<h1>그린컴퓨터 웹사이트 메인페이지</h1>
	<a href="${pageContext.request.contextPath}/member/list">회원목록</a> | 
	<a href="${pageContext.request.contextPath}/member/register">회원가입</a>
	
	<c:if test = "${ sessionScope.userid == null }">
		<a href="${pageContext.request.contextPath}/member/login">로그인</a>
	</c:if>
	<c:if test = "${ sessionScope.userid != null }">
		<a href="#" id="logout">로그아웃</a><br />
		세션 아이디 : ${sessionScope.userid}<br />
		세션 이름 : ${sessionScope.username}<br />
		세션 권한 : ${sessionScope.level}
	</c:if>
</body>
<script>
	$(function(){
		$("#logout").click(function(){
			//alert("로그아웃");
			$.ajax({
				url		: "${pageContext.request.contextPath}/member/logout",
				type	: "POST",
				data	: "",
				success	: function(resData){
					alert("로그아웃 되었습니다.");
					window.location.href = "${pageContext.request.contextPath}";
				},
				error	: function(){
					alert("시스템 오류");
				}
			});
		});
	});
</script>
</html>





