<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/WEB-INF/views/grp_board/HEADER.jsp" %>
<body>
    <div class="page-wrap bg-gray p10">
        <div class="container p10 bg-white">
            <div class="search-wrap m-b5 flex flex-justify bg-white">
                <div class="">
                    <span class="btn-normal">전체게시물 수 123 / PAGE</span>
                </div>
                <div class="">
                    <form method="post" action="${pageContext.request.contextPath}/grp_board_list.html">
                        <select class="" name="searchOpt">
                            <option value="subject">게시물제목</option>
                            <option value="writer">작성자</option>
                            <option value="all">제목+작성자</option>
                        </select>
                        <input type="text" name="words" required style="margin-left:-2px" />
                        <button type="submit" class="btn-off" style="margin-left:-2px">게시글검색</button>
                        <button type="button" class="btn-on" onClick="location.href='${pageContext.request.contextPath}/article/grp_article_insert?boardCode=${boardCode}'">게시글작성</button>
                    </form>
                </div>
            </div>
            <div class="title">
                <h3 class="tomato font18 noto m-t10">
                    <i class="fas fa-feather-alt"></i> ${boardTitle}
                </h3>
            </div>
            <div class="board-wrap bg-white">
                <table style="table-layout: fixed;">
                    <tr class="weight700 center f6 font14" style="background-color:${boardColor}">
                        <td class="td-3">
                            <input type="checkbox" />
                        </td>
                        <td class="td-5">번호</td>
                        <td class="td-5">분류</td>
                        <td>게시물제목</td>
                        <td class="td-5">작성자</td>
                        <td class="td-5">조회</td>
                        <td class="td-8">날짜</td>
                        <td class="td-7">관리</td>
                    </tr>
             <c:forEach items="${list}" var="artList">
                    <tr class="center font14">
                        <td>
                            <input type="checkbox" />
                        </td>
                        <td>10</td>
                        <td>일반</td>
                        <td class="left p-lr10">
                            <a href="grp_board_view.html" class="under weight700">${artList.subject}</a>
                        </td>
                        <td>관리자</td>
                        <td>0</td>
                        <td>2020.09.09</td>
                        <td>
                            <button type="button" class="s-btn-on" onClick="location.href='grp_board_modify.html?id=10'">수정</button>
                            <button type="button" class="s-btn-off">삭제</button>
                        </td>
                    </tr>
                 </c:forEach>   
                </table>
            </div>
            
        </div>
    </div>
</body>
<script>
    $(function () {
        $("tr:nth-child(2n+1)").addClass("tr-even");
    })
</script>

</html>