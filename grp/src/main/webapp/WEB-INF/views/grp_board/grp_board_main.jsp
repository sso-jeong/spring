<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/grp_admin/ADMIN_HEADER.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/board.css">
<style>
	td {
		border: 1px solid #d6dce7;
	}
	
	.board-list tr:first-child {
		background-color: #6f809a;
	}
	
	.tr-even {
		background-color: #eff3f9;
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
					<div class="page-main-wrap">
						<div class="">
							<span class="btn-normal">생성된 게시판 수 10개</span>
						</div>
						<div class="title">
							<h3 class="tomato font18 noto m-t20">
								<i class="fas fa-feather-alt"></i> 게시판관리 > 1. 게시판생성
							</h3>
						</div>
						<div class="board-maker">
							<form method="post" action="">
								<table>
									<tr class="center">
										<td class="bg-gray weight700 td-10">게시판그룹</td>
										<td class="td-15 p-lr3"><select class="sel-100" name="boardGroup">
												<option value="100">관리부</option>
												<option value="200">기획부</option>
										</select></td>
										<td class="bg-gray weight700 td-10">게시판코드</td>
										<td class="td-15 p-lr3"><input required name="boardCode" type="text" class="input-100" placeholder="영어만 입력하세요."/></td>
										<td class="bg-gray weight700 td-10">게시판색상</td>
										<td class="td-15 p-lr3">
										<select class="sel-100" name="boardColor">
											<option value="#6f809a">#6f809a</option>
											<option value="#b00020">#b00020</option>
											<option value="#1a237e">#1a237e</option>
										</select> <span class="color"></span></td>
										<td class="bg-gray weight700 td-10">게시판 타입</td>
										<td class="td-15 p-lr3"><select class="sel-100" name="boardType">
												<option value="1">일반게시판</option>
												<option value="2">공지사항</option>
										</select></td>
									</tr>
									<tr class="center">
										<td class="bg-gray weight700 td-10">게시판제목</td>
										<td colspan="7" class="td-90 p-lr3"><input type="text"
											class="input-100" /></td>
									</tr>
									<tr class="center">
										<td class="bg-gray weight700 td-10">읽기권한</td>
										<td class="td-15 p-lr3"><select class="sel-100">
												<option value="">9</option>
												<option value="">8</option>
										</select></td>
										<td class="bg-gray weight700 td-10">쓰기권한</td>
										<td class="td-15 p-lr3"><select class="sel-100">
												<option value="">9</option>
												<option value="">8</option>
										</select></td>
										<td class="bg-gray weight700 td-10">댓글권한</td>
										<td class="td-15 p-lr3"><select class="sel-100">
												<option value="">9</option>
												<option value="">8</option>
										</select></td>
										<td class="bg-gray weight700 td-10">다운권한</td>
										<td class="td-15 p-lr3"><select class="sel-100">
												<option value="">9</option>
												<option value="">8</option>
										</select></td>
									</tr>
								</table>
								<div class="btn-grp center m-t10">
									<button class="btn-on">게시판생성</button>
									<button class="btn-off" type="reset">취소하기</button>
								</div>
							</form>
						</div>
						<div class="title">
							<h3 class="tomato font18 noto m-t20">
								<i class="fas fa-feather-alt"></i> 게시판관리 > 2. 게시판목록
							</h3>
						</div>
						<div class="board-list">
							<table>
								 <tr class="center under tr-color f6 weight700 font14">
                                    <td class="td-5"><input type="checkbox" /></td>
                                    <td class="td-10">게시판그룹</td>
                                    <td class="td-10">게시판코드</td>
                                    <td class="td-10">게시판색상</td>
                                    <td>게시판제목</td>
                                    <td class="td-5">읽기권한</td>
                                    <td class="td-5">쓰기권한</td>
                                    <td class="td-5">댓글권한</td>
                                    <td class="td-5">다운권한</td>
                                    <td class="td-10">게시판관리</td>
                                </tr>
                                <tr class="center font14 weight700">
                                    <td>
                                        <input type="checkbox" />
                                    </td>
                                    <td>영업1부</td>
                                    <td>
                                        <a href="grp_board_list.html" target="_blank" class="under">notice</a>
                                    </td>
                                    <td>#cccccc</td>
                                    <td>
                                        <a href="grp_board_list.html" target="_blank" class="under">그린컴퓨터학원 영업1부 공지사항</a>
                                    </td>
                                    <td>0</td>
                                    <td>0</td>
                                    <td>0</td>
                                    <td>0</td>
                                    <td>
                                        <span class="s-btn-on">수정</span>
                                        <span class="s-btn-off">삭제</span>
                                    </td>
                                </tr>
							</table>
						</div>
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
</html>