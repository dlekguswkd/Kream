<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원정보 수정</title>
    <link href="${pageContext.request.contextPath}/assets/css/reset.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/mypage_userInfo.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="wrap">
        <!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

        <!-- 컨텐츠 -->
        <div id="contents" class="clearfix">
            <!-- aside -->
            <div id="aside">
				<h2><a href="#">마이페이지</a></h2>
                <div class="snb-list1">
                    <strong>쇼핑 정보</strong>
                    <ul>
                        <li><a href="#">구매내역</a></li>
                        <li><a href="#">관심</a></li>
                    </ul>
                </div>
                <div class="snb-list2">
                    <strong>내 정보</strong>
                    <ul>
                        <li><a href="#">프로필 관리</a></li>
                        <li><a href="#">내 정보</a></li>

                    </ul>
                </div>
			</div>
            <!-- //aside -->

            <!-- content-area -->
            <div id="content-area" class="clearfix"> 
                
                <!-- Form starts here -->
                <form action="${pageContext.request.contextPath}/user/modify" method="get">

                <!-- 계정 정보 섹션 -->
                <div class="section">
                    <div class="section-title">내 계정</div>
                    <div id="content-info">
                        <div class="info-item">
                            <div>
                                <p class="info-title">아이디</p>
                                <span>${userVo.userId}</span>
                            </div>
                        </div>
                        <div class="info-item">
                            <div>
                                <p class="info-title">비밀번호</p>
                                <input type="password" name="userPw" value="${userVo.userPw}">
                            </div>
                        </div>
                    </div>
                </div>

                <!-- 개인 정보 섹션 -->
                <div class="section">
                    <div class="section-title">개인 정보</div>
                    <div id="content-info">
                        <div class="info-item">
                            <div>
                                <p class="info-title">이름</p>
                                <input type="text" name="userName" value="${userVo.userName}">
                            </div>
                        </div>
                        <div class="info-item">
                            <div class="address">
                                <p class="info-title">주소</p>
                                <input type="text" name="userAddress" value="${userVo.userAddress}">
                            </div>
                        </div> 								<!-- ${sessionScope.authUser.userNo}로 변경 필요 -->
                        <input type="hidden" name="userNo" value="${userVo.userNo}">
                        <div class="button-group">
                            <button type="submit" class="edit-btn address-btn">전송</button>
                        </div>
                    </div>
                </div>

                </form>
                <!-- Form ends here -->

            </div>
            <!-- //content-area -->
        </div>
        <!-- //컨텐츠 -->
        
        <!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
    </div>
</body>
</html>

