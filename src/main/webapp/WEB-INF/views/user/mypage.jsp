<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link href="${pageContext.request.contextPath}/assets/css/reset.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/mypage.css" rel="stylesheet" type="text/css">
</head>
<body>
    <div id="wrap">
        
        <!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

        <!-- 컨텐츠 -->
        <div id="contents" class="clearfix">
            <!-- aside -->
            <div id="aside">
				<h2><a href="${pageContext.request.contextPath}/user/mypage?userNo=${sessionScope.authUser.userNo}">마이페이지</a></h2>
                <div class="snb-list1">
                    <strong>쇼핑 정보</strong>
                    <ul><li><a href="${pageContext.request.contextPath}/user/purchaselist?userNo=${sessionScope.authUser.userNo}">구매내역</a></li>
						<li><a href="${pageContext.request.contextPath}/favorites?userNo=${sessionScope.authUser.userNo}">관심</a></li>
                    </ul>
                </div>
                <div class="snb-list2">
                    <strong>내 정보</strong>
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/user/userinfo?userNo=${sessionScope.authUser.userNo}">프로필 관리</a></li>
						<li><a href="${pageContext.request.contextPath}/user/mypage?userNo=${sessionScope.authUser.userNo}">내 정보</a></li>
                    </ul>
                </div>
			</div>
            <!-- //aside -->

            <!-- content-area -->
            <div id="content-area" class="clearfix"> 

                <!-- 프로필 섹션 -->
                <div class="profile-section">
                    
                    <div class="profile-info">${userVo.userName}<br>${userVo.userAddress}</div>
                    <div class="edit-image">
                        <button><a href="${pageContext.request.contextPath}/user/userinfo?userNo=${userVo.userNo}">프로필 관리</a></button>
                    </div>
                </div>


                <!-- 구매 내역 -->
                <div class="history-section">
                    <div class="history-header">
                        <h3>구매 내역</h3>
                        <a href="${pageContext.request.contextPath}/user/purchaselist?userNo=${userVo.userNo}">더보기</a>
                    </div>
                    <div class="history-status">
                        <p>전체: ${totalCnt} | 진행중: ${readyCnt} | 배송 완료: ${finishCnt}</p>
                    </div>
                </div>

                <!-- 관심 상품 -->
                <div class="favorite-section">
                    <div class="favorite-header">
                        <h3>관심 상품</h3>
                        <a href="${pageContext.request.contextPath}/favorites">더보기</a>
                    </div>
                    <div class="favorite-products">
                    <c:forEach items="${requestScope.favoritesList}" var="FavoritesVo">
                        <div class="product-card">
                            <img src="${pageContext.request.contextPath}/upload/${FavoritesVo.saveName}">
                            <div class="product-details">
                                <h4>${FavoritesVo.brandName}</h4>
                                <p>${FavoritesVo.engName}</p>
                                <p class="purchase-type">⚡ 빠른배송</p>
                                <p class="price">${FavoritesVo.prodPrice}</p>
                                <p>구매가</p>
                            </div>
                        </div>
                        </c:forEach>
                    </div>
                </div>

            </div>
            <!-- //content-area -->
        </div>
        <!-- //컨텐츠 -->
        
        <!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
    </div>
</body>
</html>
