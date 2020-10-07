<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<%@ include file = "/WEB-INF/views/include/HEADER.jsp" %>
<body>
<%@ include file = "/WEB-INF/views/include/MENU.jsp" %>
<%-- <c:if test = "${sessionScope.memLevel eq '1' }">
	<script>
		alert("접근 권한이 없습니다.\n관리자에게 문의하세요.");
		window.location.href:${pageContext.request.contextPath};
	</script>
</c:if> --%>
<h2>회원목록</h2>
<form id="frm" method="post" action="${pageContext.request.contextPath}/memberList">
	<select name="searchOpt">
		<option value="mem_name">회원이름</option>
		<option value="mem_id">회원아이디</option>
		<option value="all">아이디+이름</option>
	</select>
	<input type="text" name="words" required value="${words}" />
	<button type="submit">회원검색</button>
</form>

<c:if test="${words eq ''}">
	<span>전체 회원 수 : ${count}명</span>
</c:if>

<c:if test="${words ne ''}">
	<span>검색된 회원 수 : ${count}명</span>
</c:if>

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
			<td>
				<select name="memLevel" id="memLevel">
					<option value="4" <c:if test = "${ member.memLevel eq '4' }">selected</c:if> >관리자</option>
					<option value="3" <c:if test = "${ member.memLevel eq '3' }">selected</c:if> >부서장</option>
					<option value="2" <c:if test = "${ member.memLevel eq '2' }">selected</c:if> >직원</option>
					<option value="1" <c:if test = "${ member.memLevel eq '1' }">selected</c:if> >협력업체</option>
				</select>
			</td>
			<td>
				<select name="memConfirm" id="memConfirm" onChange="confirmUpdate(this.value, '${member.memNum}')">
					<option value="Y" <c:if test = "${ member.memConfirm eq 'Y' }">selected</c:if> >Y</option>
					<option value="N" <c:if test = "${ member.memConfirm eq 'N' }">selected</c:if> >N</option>
				</select>
			</td>
			<td>수정 삭제</td>
		</tr>
	</c:forEach>
</table>
</body>
<script>
	function confirmUpdate(confirm, mid) {
		var selData = {
				memConfirm 	: confirm,
				memNum		: mid
		};		
		
		$.ajax({
			url		: "${pageContext.request.contextPath}/memConfirm",
			type	: "POST",
			data	: selData,
			success	: function(resData) {
				if( resData == "success" ) {
					alert("회원 인증이 완료 되었습니다.");
					window.location.reload();
				}
			},
			error	: function() {
				alert("시스템 에러");
			}
		});
	}
</script>
</html>



















