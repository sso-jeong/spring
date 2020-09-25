<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/views/member/HEADER.jsp"%>
<body>
	<!-- ${memberList} 메모리 주소 나오면 됨 -->
	<div class="">
		<h1>그린컴퓨터 웹사이트 회원목록</h1>
		<a href="${pageContext.request.contextPath}">메인페이지로</a> | <a
			href="${pageContext.request.contextPath}/member/register">회원가입</a>
	</div>

	<div class="">
		<table border="1" width="100%">
			<tr style="background-color: #eee;text-align: center;">
				<td>회원번호</td>
				<td>회원아이디</td>
				<td>회원비밀번호</td>
				<td>회원이름</td>
				<td>회원이메일</td>
				<td>회원가입일</td>
				<td>회원등급</td>
			</tr>

			<!-- 향상된 for : <for String str : list>  -->
			<c:forEach items="${memberList}" var="m">
				<tr>
					<td>${m.id}</td>
					<td>${m.userid}</td>
					<td>${m.passwd}</td>
					<td>${m.username}</td>
					<td>${m.email}</td>
					<td>${m.regdate}</td>
					<td>
					<select name="sel" id="sel" onChange="levelChange(this.value, '${m.id}');">
							<option value="2" <c:if test ="${m.level eq '2'}">selected</c:if> >관리자</option>
							<option value="1" <c:if test ="${m.level eq '1'}">selected</c:if> >일반</option>
					</select>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>

</body>
<script>
	function levelChange(level, id) {
		//테스트용
		//alert("권한" + level);
		//alert("번호" + id);
		if (confirm("사용자 권한을 변경하시겠습니까?")) {
			
			var formData = {
					level : level,
					id : id
			};
			
			$.ajax({
				url		: "${pageContext.request.contextPath}/member/levelChange",
				type	: "POST",
				data	: formData,
				success : function(resData) {
					if( resData == "success") {
						alert("권한이 변경되었습니다.");
						window.location.reload();
					}
				},
				error	: function() {
					alert("시스템 오류입니다.");
				}
			});
		} else {
			window.location.reload();
		}
	}
</script>
<%@ include file="/WEB-INF/views/member/FOOTER.jsp"%>