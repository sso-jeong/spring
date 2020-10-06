<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>GREEN GROUPWARE SYSTEM</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/common.css">
    <link rel="stylesheet" href="css/jquery.treeview.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/board.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="js/jquery.treeview.js"></script>
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.2.0/css/all.css">
    <style>
        .page-main-left {
            width:69.7%;
            padding:20px;
        }

        .page-main-right {
            width: 29.7%;
        }

        .main-right-top {
            height:260px;
        }

        .main-right-bottom {
            height:220px;
        }

        .buseo-icon {
            width:40px;
            height:40px;
            margin-right:20px;
        }

        .buseo-icon img {
            width:100%;
            height:100%;
            border-radius: 50%;
            display: inline-block;
        }

        .attend-btn-on {
            width:220px;
            border:1px solid #ccc;
            border-radius: 50px;
            background-color:transparent;
            color:#ccc;
            padding:10px 0;
        }

        .attend-btn-off {
            width:220px;
            border:1px solid #5ebfd9;
            border-radius: 50px;
            background-color:transparent;
            color:#5ebfd9;
            padding:10px 0;
        }
    </style>
</head>

<body>
    <div class="page-wrap bg-gray">
        <div class="container p10">
            <div class="page-main-wrap flex flex-justify">
                <div class="page-left bg-white height40">
                    <h2 class="noto center font18">관리자페이지</h2>
                </div>
                <div class="page-right bg-white height40">
                    <div class="page-info flex flex-justify">
                        <div class="auth">
                            <span class="noto font16 weight700">${sessionScope.buseo} ${sessionScope.username}(${sessionScope.userid}) - 접속권한${sessionScope.level} </span>
                        </div>
                        <div class="logout">
                            <a href="grp_login.html" class="noto font16 weight700">{로그아웃}</a>
                        </div>
                    </div>
                </div>
            </div>

            <div class="page-main-wrap flex flex-justify m-t10">
                <div class="page-left bg-white p10">
                    <div class="tree-wrap">
                        <div id="sidetreecontrol" class="">
                            <a href="#" class="tab active" id="open">전체닫기</a>
                            <a href="#" class="tab" id="close">전체열기</a>
                        </div>
                        <div class="clearfix"></div>
                        <ul id="tree" class="">
                            <li>
                                <img src="images/folder-closed.gif" /> 사내조직/연락처
                                <ul>
                                    <li><img src="images/folder.gif" /> 1. <a href="grp_member_list.html">사원목록</a></li>
                                    <li><img src="images/folder.gif" /> 2. <a href="grp_member_register.html">사원등록</a>
                                    </li>
                                    <li><img src="images/folder.gif" /> 3. <a href="grp_member_chart.html">조직도</a></li>
                                    <li><img src="images/folder.gif" /> 4. <a href="grp_member_chart_register.html">조직도
                                            등록</a></li>
                                </ul>
                            </li>

                            <li>
                                <img src="images/folder-closed.gif" /> 전자결재
                                <ul>
                                    <li><img src="images/folder.gif" /> 1. <a href="grp_approval_main.html"
                                            target="_blank">전자결재
                                            문서등록</a></li>
                                </ul>
                            </li>

                            <li>
                                <img src="images/folder-closed.gif" /> 게시판관리
                                <ul>
                                    <li><img src="images/folder.gif" /> 1. <a href="grp_board_create.html">게시판 생성</a>
                                    </li>
                                </ul>
                            </li>

                            <li>
                                <img src="images/folder-closed.gif" /> 일정관리
                                <ul>
                                    <li><img src="images/folder.gif" /> 1. <a href="grp_calendar_list.html">일정목록</a>
                                    </li>
                                </ul>
                            </li>

                            <li>
                                <img src="images/folder-closed.gif" /> 근태관리
                                <ul>
                                    <li><img src="images/folder.gif" /> 1. <a href="grp_attend_info.html">내 근태현황</a></li>
                                    <li><img src="images/folder.gif" /> 2. <a href="grp_my_info.html">내 인사정보</a></li>
                                </ul>
                            </li>

                            <li>
                                <img src="images/folder-closed.gif" /> 설문조사
                                <ul>
                                    <li><img src="images/folder.gif" /> 1. <a href="grp_survey_open.html">진행중인 설문</a></li>
                                    <li><img src="images/folder.gif" /> 2. <a href="grp_survey_close.html">종료된 설문</a></li>
                                    <li><img src="images/folder.gif" /> 3. <a href="#">내가 만든 설문</a></li>
                                </ul>
                            </li>

                            <li>
                                <img src="images/folder-closed.gif" /> 자료실
                                <ul>
                                    <li><img src="images/folder.gif" /> 1. <a href="grp_file_upload.html">문서양식</a></li>
                                    <li><img src="images/folder.gif" /> 2. <a href="grp_file_upload.html">제품소개서</a></li>
                                </ul>
                            </li>

                            <li>
                                <img src="images/folder-closed.gif" /> 회사기본정보
                                <ul>
                                    <li><img src="images/folder.gif" /> 1. <a href="grp_company_info.html">회사기본정보</a>
                                    </li>
                                    <li><img src="images/folder.gif" /> 2. <a
                                            href="grp_compnay_info_register.html">회사기본정보 등록</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
                <div class="page-right">
                    <div class="page-main-wrap flex flex-justify">
                        <div class="page-main-left bg-white">
                            <div class="title">
                                <h2 class="font16 noto m-b10">최근 부서 알림글</h2>
                            </div>
                            <div class="buseo-wrap">
                                <div class="buseo-content flex flex-justify p-tb20" style="border-bottom:1px solid #e7e7e7;">
                                    <div class="content-left flex">
                                        <div class="buseo-icon">
                                            <img src="images/1.jpg" alt="" />
                                        </div>
                                        <div class="buseo-info">
                                            <p class="noto font14 weight700">[인사과 알림] 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.</p>
                                            <p class="noto font14">09-15 09:50 김그린 과장</p>
                                        </div>
                                    </div>
                                    <div class="content-right" style="width:50px;">
                                        <span style="font-size:24px;color:#555;"><i class="fas fa-angle-right"></i></span>
                                    </div>
                                </div>
                                <div class="buseo-content flex flex-justify p-tb20" style="border-bottom:1px solid #e7e7e7;">
                                    <div class="content-left flex">
                                        <div class="buseo-icon">
                                            <img src="images/1.jpg" alt="" />
                                        </div>
                                        <div class="buseo-info">
                                            <p class="noto font14 weight700">[인사과 알림] 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.</p>
                                            <p class="noto font14">09-15 09:50 김그린 과장</p>
                                        </div>
                                    </div>
                                    <div class="content-right" style="width:50px;">
                                        <span style="font-size:24px;color:#555;"><i class="fas fa-angle-right"></i></span>
                                    </div>
                                </div>
                                <div class="buseo-content flex flex-justify p-tb20" style="border-bottom:1px solid #e7e7e7;">
                                    <div class="content-left flex">
                                        <div class="buseo-icon">
                                            <img src="images/1.jpg" alt="" />
                                        </div>
                                        <div class="buseo-info">
                                            <p class="noto font14 weight700">[인사과 알림] 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.</p>
                                            <p class="noto font14">09-15 09:50 김그린 과장</p>
                                        </div>
                                    </div>
                                    <div class="content-right" style="width:50px;">
                                        <span style="font-size:24px;color:#555;"><i class="fas fa-angle-right"></i></span>
                                    </div>
                                </div>
                                <div class="buseo-content flex flex-justify p-tb20" style="border-bottom:1px solid #e7e7e7;">
                                    <div class="content-left flex">
                                        <div class="buseo-icon">
                                            <img src="images/1.jpg" alt="" />
                                        </div>
                                        <div class="buseo-info">
                                            <p class="noto font14 weight700">[인사과 알림] 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.</p>
                                            <p class="noto font14">09-15 09:50 김그린 과장</p>
                                        </div>
                                    </div>
                                    <div class="content-right" style="width:50px;">
                                        <span style="font-size:24px;color:#555;"><i class="fas fa-angle-right"></i></span>
                                    </div>
                                </div>
                                <div class="buseo-content flex flex-justify p-tb20" style="border-bottom:1px solid #e7e7e7;">
                                    <div class="content-left flex">
                                        <div class="buseo-icon">
                                            <img src="images/1.jpg" alt="" />
                                        </div>
                                        <div class="buseo-info">
                                            <p class="noto font14 weight700">[인사과 알림] 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.</p>
                                            <p class="noto font14">09-15 09:50 김그린 과장</p>
                                        </div>
                                    </div>
                                    <div class="content-right" style="width:50px;">
                                        <span style="font-size:24px;color:#555;"><i class="fas fa-angle-right"></i></span>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="page-main-right">
                            <div class="main-right-top bg-white p20" style="border:1px solid #5ebfd9;">
                                <div class="main-attend">
                                    <div class="title">
                                        <h2 class="font16 noto m-b10">근태관리</h2>
                                        <p>2020년 09월 15일 화요일</p>
                                    </div>
                                    <div class="attend flex flex-justify noto font14 weight700 m-t20">
                                        <span>출근시간</span>
                                        <span>AM 08:55</span>
                                    </div>
                                    <div class="attend flex flex-justify noto font14 weight700 m-t10">
                                        <span>퇴근시간</span>
                                        <span>PM 18:30</span>
                                    </div>
                                    <div class="attend flex flex-justify noto font14 weight700 m-t10">
                                        <span>현재상태</span>
                                        <span>
                                            <select class="sel-attend">
                                                <option value="">업무중</option>
                                                <option value="">외근중</option>
                                                <option value="">퇴근</option>
                                            </select>
                                        </span>
                                    </div>
                                    <div class="attend flex flex-justify noto font14 weight700 m-t10">
                                        <button class="noto font14 weight700 attend-btn-on">출근하기</button>
                                        <button class="noto font14 weight700 attend-btn-off">퇴근하기</button>
                                    </div>
                                </div>
                            </div>
                            <div class="main-right-bottom bg-white m-t10 p20">3</div>
                        </div>
                    </div>

                    <div class="page-main-bottom flex flex-justify m-t10">
                        <div class="main-bottom-left bg-white p20" style="width:49.7%;">
                            <div class="title">
                                <h2 class="font16 noto m-b10">결재 대기 문서</h2>
                            </div>
                            <div class="app-content m-t20">
                                <div style="border-bottom:1px solid #e7e7e7; padding-bottom:10px;" class="app-list flex flex-justify noto weight700 font14">
                                    <div class="app-date" style="width:10%;">기안일</div>
                                    <div class="app-form" style="width:10%;">문서양식</div>
                                    <div class="app-subject center" style="width:70%;">결재문서제목</div>
                                    <div class="app-file" style="width:10%;">첨부</div>
                                </div>
                                <div class="center p-tb10">
                                    <span class="noto font16 weight700">결재할 문서가 없습니다.</span>
                                </div>
                            </div>
                        </div>
                        <div class="main-bottom-right bg-white p20" style="width:49.7%;">
                            <div class="title">
                                <h2 class="font16 noto m-b10">공지사항 알림글</h2>
                            </div>
                            <div class="notice-content flex flex-justify p-tb10" style="border-bottom:1px solid #e7e7e7;">
                                <div class="notice-left">
                                    <p class="noto weight700 font14">
                                        <span style="color:#d92550; margin-right:10px;">[공지]</span> 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.
                                    </p>
                                </div>
                                <div class="notice-right">
                                    <span class="noto font14" style="color:#555;">09.15</span>
                                </div>
                            </div>

                            <div class="notice-content flex flex-justify p-tb10" style="border-bottom:1px solid #e7e7e7;">
                                <div class="notice-left">
                                    <p class="noto weight700 font14">
                                        <span style="color:#d92550; margin-right:10px;">[공지]</span> 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.
                                    </p>
                                </div>
                                <div class="notice-right">
                                    <span class="noto font14" style="color:#555;">09.15</span>
                                </div>
                            </div>
                            <div class="notice-content flex flex-justify p-tb10" style="border-bottom:1px solid #e7e7e7;">
                                <div class="notice-left">
                                    <p class="noto weight700 font14">
                                        <span style="color:#d92550; margin-right:10px;">[공지]</span> 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.
                                    </p>
                                </div>
                                <div class="notice-right">
                                    <span class="noto font14" style="color:#555;">09.15</span>
                                </div>
                            </div>
                            <div class="notice-content flex flex-justify p-tb10" style="border-bottom:1px solid #e7e7e7;">
                                <div class="notice-left">
                                    <p class="noto weight700 font14">
                                        <span style="color:#d92550; margin-right:10px;">[공지]</span> 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.
                                    </p>
                                </div>
                                <div class="notice-right">
                                    <span class="noto font14" style="color:#555;">09.15</span>
                                </div>
                            </div>
                            <div class="notice-content flex flex-justify p-tb10" style="border-bottom:1px solid #e7e7e7;">
                                <div class="notice-left">
                                    <p class="noto weight700 font14">
                                        <span style="color:#d92550; margin-right:10px;">[공지]</span> 운영자 확인이 필요한 근태 정보가 있습니다. 근태관리에서 확인하세요.
                                    </p>
                                </div>
                                <div class="notice-right">
                                    <span class="noto font14" style="color:#555;">09.15</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
<script src="js/treeview.js"></script>
<script src="js/tab.js"></script>
<script>
    $(function () {
        $("tr:nth-child(2n+1)").addClass("tr-even");
    })
</script>
</html>