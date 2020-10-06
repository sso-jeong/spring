<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file = "/WEB-INF/views/include/HEADER.jsp" %>
<body>
<%@ include file = "/WEB-INF/views/include/MENU.jsp" %>
<h2>회원목록</h2>
<table border="1">
	<tr>
		<td>번호</td>
		<td>회원아이디</td>
		<td>회원비밀번호</td>
		<td>회원이름</td>
		<td>회원이메일</td>
		<td>회원가입일</td>
		<td>회원등급</td>
		<td>회원인증여부</td>
		<td>비고</td>
	</tr>
	
	<c:forEach items="${list}" var="member">
		<tr>
			<td>${member.memNum}</td>
			<td>${member.memID}</td>
			<td>${member.memPwd}</td>
			<td>${member.memName}</td>
			<td>${member.memEmail}</td>
			<td>${member.memRegdate}</td>
			<td>${member.memLevel}</td>
			<td>${member.memConfirm}</td>
			<td>수정 삭제</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>