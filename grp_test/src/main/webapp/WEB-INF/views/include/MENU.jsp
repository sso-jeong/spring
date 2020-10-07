<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<span><a href="${pageContext.request.contextPath}">메인으로</a></span> | 

<c:if test="${sessionScope.memLevel ne '1'}">
<span><a href="${pageContext.request.contextPath}/memberList">회원목록</a></span> | 
</c:if>

<c:if test="${sessionScope.memID == null && sessionScope.memName == null}">
	<span><a href="${pageContext.request.contextPath}/login">로그인</a></span>
</c:if>

<c:if test="${sessionScope.memID != null}">
<span><a href="${pageContext.request.contextPath}/logout">로그아웃</a></span>
<span>${sessionScope.memID} ${sessionScope.memName} ${sessionScope.memLevel} ${sessionScope.memConfirm}</span>
</c:if>

<c:if test="${sessionScope.memID == null}">
<span><a href="${pageContext.request.contextPath}/register">회원가입</a></span>
</c:if>

