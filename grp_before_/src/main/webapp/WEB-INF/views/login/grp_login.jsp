<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/inc/HEADER.jsp" %>

<body>
    <div class="logo-wrap">
        <h1 class="roboto">GREEN ACADEMY</h1>
        <h2 class="roboto">Enterprise Groupware System</h2>
    </div>
    <div class="login-wrap">
        <div class="login-box">
            <form id="frm" method="post" autocomplete="off">
                <input type="text" name="userid" id="userid" placeholder="사원번호를 입력하세요." required autofocus />
                <input type="password" name="passwd" id="passwd" placeholder="비밀번호를 입력하세요." required />
                <div class="">
                    <button id="btn" type="submit" class="btn roboto">Login</button>
                </div>
                <div class="register-wrap">
                    <a href="${pageContext.request.contextPath}/grp_register" class="">사원가입</a>
                </div>
            </form>
        </div>
    </div>
</body>
<script>
function loginEmp() {
	 $.ajax({
	        url : "${pageContext.request.contextPath}/grp_loginCheck",
	        type : "POST",
	        data : $("#frm").serialize(),
	        success : function(resData){
	           if(resData == "success") {
					alert("로그인이 완료되었습니다.");
					window.location.href = "${pageContext.request.contextPath}/grp_main";
	           } else {
	        	    alert("아이디 또는 비밀번호를 확인하세요.");
					window.location.href = "${pageContext.request.contextPath}/grp_login";
			   }
	        },
	        error : function(){
	            alert("시스템 에러");
	        }

	    });
}
</script>

<script>
	$(function(){
		$("#btn").click(function(e){
			e.preventDefault();
			loginEmp();  
		});
	});
</script>
</html>