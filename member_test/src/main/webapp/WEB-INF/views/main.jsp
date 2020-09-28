<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그린컴퓨터학원 회원가입 페이지입니다.</title>
</head>
<body>
	<h1>그린컴퓨터 웹사이트 메인페이지</h1>
	<a href="${pageContext.request.contextPath}/member/list">회원목록</a> | 
	<a href="${pageContext.request.contextPath}/member/register">회원가입</a>
	
	<c:if test = "${ sessionScope.userid == null }">
		<a href="${pageContext.request.contextPath}/member/login">로그인</a>
	</c:if>
	<c:if test = "${ sessionScope.userid != null }">
		<a href="${pageContext.request.contextPath}/member/logout">로그아웃</a>
	</c:if>
</body>
</html>





