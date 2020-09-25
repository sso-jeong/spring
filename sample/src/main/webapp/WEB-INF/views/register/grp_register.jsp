<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<body>
   <!-- logo inc -->
	<%@ include file="/WEB-INF/views/include/logo.jsp"%>
	<!-- logo inc -->
    <div class="login-wrap">
        <div class="login-box">
            <form method="post" action="grp_member_insert.html" autocomplete="off">
                <select name="buseo">
                </select>
                <select name="grade">
                </select>
                <input type="text" name="userid" id="userid" placeholder="사원번호를 입력하세요." required tabindex="3" />
                <input type="text" name="username" id="username" placeholder="사원명을 입력하세요." required tabindex="4" />
                <input type="password" name="passwd" id="passwd" placeholder="비밀번호를 입력하세요." required tabindex="5" />
                <input type="password" name="repasswd" id="repasswd" placeholder="비밀번호 확인을 입력하세요." required tabindex="6" />
                <div class="">
                    <button type="submit" class="btn roboto">Registration</button>
                </div>
                <div class="register-wrap">
                    <a href="${pageContext.request.contextPath}/login/grp_login" class="">로그인</a>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
	function loadGrade() {
		$.ajax({
			url			: "${pageContext.request.contextPath}/register/grp_grade",
			type		: "POST",
			dataType	: "json",
			contentType : "application/x-www-form-urlencoded; charset=UTF-8",
			success 	: function(resData) {
				alert("성공");
			},
			error 		: function() {
				alert("등록된 직급이 없습니다.");
			}
		});
	}
	
	$(function(){
		loadGrade();
	});
</script>
</html>