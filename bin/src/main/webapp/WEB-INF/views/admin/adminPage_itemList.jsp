<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>관리자 페이지 | KREAM</title>
    <link rel="stylesheet" href="http://localhost:8888/kream/assets/css/reset.css">
    <link rel="stylesheet" href="http://localhost:8888/kream/assets/css/adminpage.css">
</head>
<body>
    <div id="wrap">
        
        <!-- 헤더 -->
        <div id="header" class="clearfix">
            <div class="clearfix" id="header1">
                <ul class="clearfix">
                    <li><a href="#">마이페이지</a></li>
                    <li><a href="#">관심</a></li>
                    <li><a href="#">로그인</a></li>
                    <li><a href="#">로그아웃</a></li>
                </ul>
            </div>
            <div class="clearfix" id="header2">
                <h1><a href="#">KREAM</a></h1>
                <div>
                    <ul class="clearfix">
                        <li><a href="#"><strong>HOME</strong></a></li>
                        <li><a href="#">SHOP</a></li>
                        <li><a href="#"><img id="search" src="http://localhost:8888/kream/assets/imgs/search.jpg"></a></li>
                        <li><a href="#"><img id="cart" src="http://localhost:8888/kream/assets/imgs/cart.jpg"></a></li>
                    </ul>
                </div>
            </div>
        </div>
        <!-- //헤더 -->

        <!-- 컨텐츠 -->
        <div id="contents" class="clearfix">
            <!-- aside -->
			<div id="aside">
				<h2>
					<a href="${pageContext.request.contextPath}/admin/adminPage">관리자 페이지</a>
				</h2>
				<div class="snb-list1">
					<strong>정보</strong>
					<ul>
						<li><a href="${pageContext.request.contextPath}/admin/purchaseRequest">구매 신청</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/saleshistory">판매 기록</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/editUser">유저 정보</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/itemList">상품 목록</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/addItems">상품 등록</a></li>


					</ul>
				</div>

			</div>
			<!-- //aside -->

            <!-- content-area -->
            <div id="content-area" class="clearfix"> 
                <div id="product-list">
                    <h2>상품 리스트</h2>
                    <c:forEach items="${requestScope.itemList}" var="itemList">
                    
                    <div class="product-item">
                        <img src="${pageContext.request.contextPath}/Kream_products_imgs/${itemList.saveName}" alt="Product Image" class="product-img">
                        <div class="product-info">
                            <p><strong>영문 이름:</strong>${itemList.engName}</p>
                            <p><strong>한글 이름:</strong>${itemList.korName}</p>
                            <p><strong>모델 번호:</strong>${itemList.modelNo}</p>
                            <p><strong>브랜드:</strong> ${itemList.brandName}</p>
                            <p><strong>카테고리:</strong> ${itemList.categoryName}</p>
                            <p><strong>가격:</strong> ${itemList.prodPrice}원</p>
                            <p><strong>출시일:</strong> ${itemList.releaseDate}</p>
                            <p><strong>색상:</strong> ${itemList.colorName}</p>
                        </div>
                        
                        <div class="button-group">
            
            			<form action="${pageContext.request.contextPath}/admin/deleteProduct" method="get">
                			<input type="hidden" name="prodNo" value="${itemList.prodNo}">
               				<button type="submit" class="delete-btn">삭제</button>
            			</form>
       					 </div>
                    </div>
                	</c:forEach>
                    
                </div>
                
                
            </div>
            <!-- //content-area -->
        </div>
        <!-- //컨텐츠 -->
        
        <!-- 푸터 -->
        <div id="footer">
            <div id="service-area" class="clearfix">
                <div class="menu-box1"> 
                    <p class="menu-title">이용안내</p>
                    <ul class="lists">
                        <li><a href="#">검수기준</a></li>
                        <li><a href="#">이용정책</a></li>
                        <li><a href="#">패널티정책</a></li>
                    </ul>
                </div>
                <div class="menu-box2"> 
                    <p class="menu-title">고객지원</p>
                    <ul>
                        <li><a href="#">공지사항</a></li>
                        <li><a href="#">서비스소개</a></li>
                        <li><a href="#">스토어안내</a></li>
                        <li><a href="#">판매자 방문접수</a></li>
                    </ul>
                </div>
                <div class="customer-service"> 
                    <p class="txt1">고객센터 1588-7813</p>
                    <div class="service-time">
                        운영시간 평일 10:00 - 18:00 (토∙일, 공휴일 휴무) <br>
                        점심시간 평일 13:00 - 14:00
                    </div>
                    <p class="txt2">1:1 문의하기는 앱에서만 가능합니다.</p>
                    <div class="service-btn">
                        <a href="#">자주 묻는 질문</a>
                    </div>
                </div>
            </div>

            <div id="corporation-area" class="clearfix">
                <div class="term-list" class="clearfix">
                    <ul>
                        <li><a href="#">회사소개</a></li>
                        <li><a href="#">인사채용</a></li>
                        <li><a href="#">제휴제안</a></li>
                        <li><a href="#">이용약관</a></li>
                        <li><a href="#">개인정보처리방침</a></li>
                    </ul>
                </div>
                <div id="sns-box">
                   <a href="https://www.instagram.com/" target="_blank"><img src="http://localhost:8888/kream/assets/imgs/instagram.jpg" /></a>
                    <a href="https://www.facebook.com/?locale=ko_KR" target="_blank"><img src="http://localhost:8888/kream/assets/imgs/facebook.jpg" /></a>
                    <a href="https://www.kakaocorp.com/page/service/service/KakaoTalk" target="_blank"><img src="http://localhost:8888/kream/assets/imgs/kakaotalk.jpg" /></a>
                </div>
                <div id="business-title">
                    크림 주식회사 · 대표 김창욱 &emsp; 사업자등록번호 : 570-88-01618 <a href="#">사업자정보확인</a> &emsp; 통신판매업 : 제 2021-성남분당C-0093호<br>
                    사업장소재지 : 경기도 성남시 분당구 분당내곡로 131 판교테크원 타워1, 8 &emsp;  층호스팅 서비스 : 네이버 클라우드 ㈜
                </div>
            </div>
            <div id="notice-guarantee">
                <p class="bank">신한은행 채무지급보증 안내</p>
                <p>
                    당사는 고객님의 현금 결제 금액에 대해 신한은행과 채무지급보증 계약을 체결하여 안전거래를 보장하고 있습니다. <a href="#">서비스가입 사실 확인</a>
                </p>
                <br>
                <p>
                    크림(주)는 통신판매 중개자로서 통신판매의 당사자가 아닙니다. 본 상품은 개별판매자가 등록한 상품으로 상품, 상품정보, 거래에 관한<br>
                    의무와 책임은 각 판매자에게 있습니다. 단, 이용약관 및 정책, 기타 거래 체결 과정에서 고지하는 내용 등에 따라 검수하고 보증하는<br>
                    내용에 대한 책임은 크림(주)에 있습니다.
                </p>
              
            </div>
            <div class="corp">
                &#169; KREAM Corp.
            </div>

        </div>
        <!-- //푸터 -->
    </div>
</body>
</html>
