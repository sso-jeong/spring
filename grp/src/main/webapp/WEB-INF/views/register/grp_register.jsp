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
                <select name="buseo" id="buseo">
                    <option value="">부서를 선택하세요.</option>                   
                </select>
                <select name="grade" id="grade">
                    <option value="">직책을 선택하세요.</option>
                </select>
                <input type="text" name="userid" id="userid" placeholder="사원번호를 입력하세요." required tabindex="3" />
                <input type="text" name="username" id="username" placeholder="사원명을 입력하세요." required tabindex="4" />
                <input type="password" name="passwd" id="passwd" placeholder="비밀번호를 입력하세요." required tabindex="5" />
                <input type="password" name="repasswd" id="repasswd" placeholder="비밀번호 확인을 입력하세요." required tabindex="6" />
                <div class="">
                    <button id="btn" type="submit" class="btn roboto">Registration</button>
                </div>
                <div class="register-wrap">
                    <a href="${pageContext.request.contextPath}/grp_login" class="">로그인</a>
                </div>
            </form>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script>
function saveEmp() {
    $.ajax({
        url : "${pageContext.request.contextPath}/grp_register",
        type : "POST",
        data : $("#frm").serialize(),
        success : function(resData){
           if(resData == "success") {
				alert("사원 가입이 완료되었습니다.");
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
		load();

		$("#btn").click(function(e){
			//alert("성공");
			e.preventDefault();
			saveEmp(); 
		});
	});
</script>
</html>