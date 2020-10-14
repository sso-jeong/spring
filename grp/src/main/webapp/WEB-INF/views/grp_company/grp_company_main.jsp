<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/grp_admin/ADMIN_HEADER.jsp"%>
<style>
.page-main-left {
	width: 69.7%;
	padding: 20px;
}

.page-main-right {
	width: 29.7%;
}

.main-right-top {
	height: 260px;
}

.main-right-bottom {
	height: 220px;
}

.buseo-icon {
	width: 40px;
	height: 40px;
	margin-right: 20px;
}

.buseo-icon img {
	width: 100%;
	height: 100%;
	border-radius: 50%;
	display: inline-block;
}

.attend-btn-on {
	width: 220px;
	border: 1px solid #ccc;
	border-radius: 50px;
	background-color: transparent;
	color: #ccc;
	padding: 10px 0;
}

.attend-btn-off {
	width: 220px;
	border: 1px solid #5ebfd9;
	border-radius: 50px;
	background-color: transparent;
	color: #5ebfd9;
	padding: 10px 0;
}
</style>
<body>
	<div class="page-wrap bg-gray">
		<div class="container p10">
			<div class="page-main-wrap flex flex-justify">
				<!-- include logo -->
				<%@ include file="/WEB-INF/views/grp_admin/ADMIN_LOGO.jsp"%>
				<!-- include logo -->
				<div class="page-right bg-white height40">
					<!-- include auth -->
					<%@ include file="/WEB-INF/views/grp_admin/ADMIN_AUTH.jsp"%>
					<!-- include auth -->
				</div>
			</div>

			<div class="page-main-wrap flex flex-justify m-t10">
				<div class="page-left bg-white p10">
					<!-- include menu -->
					<%@ include file="/WEB-INF/views/grp_admin/ADMIN_MENU.jsp"%>
					<!-- include menu -->
				</div>
				<div class="page-right bg-white p10">
					<div class="title">
						<h3 class="tomato font18 noto">
							<i class="fas fa-feather-alt"></i> 회사기본정보 > 1. 회사기본정보
						</h3>
					</div>
					<div class="">
						<form id="frm" method="post" action="${pageContext.request.contextPath}/company/grp_company">
							<table>
								<tr>
									<td class="bg-gray weight700 td-10 center">로고 타이틀</td>
									<td class="p-lr3">
										<input type="text" name="comName" maxlength="100" id="comName" class="input-100" required />
									</td>
									<td class="bg-gray weight700 td-10 center">로고 서브타이틀</td>
									<td>
										<input type="text" name="comSubName" maxlength="100" id="comSubName" class="input-100" required />
									</td>
								</tr>
								<tr>
									<td class="bg-gray weight700 td-10 center">대표명</td>
									<td class="p-lr3">
										<input type="text" name="comCeo" maxlength="10" id="comCeo" class="input-100" required />
									</td>
									<td class="bg-gray weight700 td-10 center">대표전화</td>
									<td>
										<input type="text" name="comTel" maxlength="15" id="comTel" class="input-100" required />
									</td>
								</tr>
								<tr>
									<td class="bg-gray weight700 td-10 center">웹사이트 URL</td>
									<td class="p-lr3" colspan="3">
										<input type="text" name="comUrl" id="comUrl" maxlength="50" class="input-100" required />
									</td>
								</tr>
								<tr>
									<td class="bg-gray weight700 td-10 center">웹사이트 Copyright</td>
									<td class="p-lr3" colspan="3">
										<input type="text" name="comCopy" maxlength="200" id="comCopy" class="input-100" required />
									</td>
								</tr>
								<tr>
									<td class="bg-gray weight700 td-10 center">웹사이트 접근권한</td>
									<td class="p-lr3" colspan="3">
										<select name="comAuth" id="comAuth">
											<option value="1">1</option>										
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
										</select>
									</td>
								</tr>
								<tr>
									<td class="bg-gray weight700 td-10 center">웹사이트 로고 타이틀</td>
									<td class="p-lr3" colspan="3">
										<input placeholder="GREENART SYSTEM" type="text" name="comMainLogo" maxlength="200" id="comMainLogo" class="input-100" required />
									</td>
								</tr>
								<tr>
									<td class="bg-gray weight700 td-10 center">웹사이트 메뉴</td>
									<td class="p-lr3" colspan="3">
										<input placeholder="메뉴는 세미콜론(;)으로 구분하세요." type="text" name="comMenu" maxlength="200" id="comMenu" class="input-100" required />
									</td>
								</tr>
								<tr>
									<td class="bg-gray weight700 td-10 center">웹사이트 메인 텍스트 상단</td>
									<td class="p-lr3" colspan="3">
										<input type="text" name="comMainUp" maxlength="200" id="comMainUp" placeholder="새로운 플랫폼을 제시합니다." class="input-100" required />
									</td>
								</tr>
								<tr>
									<td class="bg-gray weight700 td-10 center">웹사이트 메인 텍스트 하단</td>
									<td class="p-lr3" colspan="3">
										<input type="text" name="comMainDown" maxlength="200" id="comMainDown" placeholder="TOTAL INFRASTRUCTURE PLATFORM" class="input-100" required />
									</td>
								</tr>
							</table>
							<div class="btn-grp center m-t5">
								<button type="submit" class="btn-on">정보수정</button>
								<button type="reset" class="btn-off">새로고침</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/treeview.js"></script>
<script src="${pageContext.request.contextPath}/js/tab.js"></script>
<script>
	$(function() {
		$("tr:nth-child(2n+1)").addClass("tr-even");
	})
</script>
<script>
	function comInfo() {

		$.ajax({
			url		: "${pageContext.request.contextPath}/company",
			type	: "POST",
			data	: "",
			success	: function(resData) {
				$("#comName").val(resData.comName);
				$("#comSubName").val(resData.comSubName);
				$("#comCeo").val(resData.comCeo);
				$("#comTel").val(resData.comTel);
				$("#comUrl").val(resData.comUrl);
				$("#comCopy").val(resData.comCopy);
				$("#comAuth").val(resData.comAuth);
			},
			error	: function() {
				alert("시스템 에러");
			}
		});
		
	}

	$(function() {
		comInfo();
	});
</script>
</html>








