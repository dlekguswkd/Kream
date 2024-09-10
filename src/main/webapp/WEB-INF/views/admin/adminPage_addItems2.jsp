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
                <div id="product-details">
                    <h2>상품 등록</h2>
                    <form  action="${pageContext.request.contextPath}/admin/uploadItem" method="post" id="product-detail-form" enctype="multipart/form-data">
                        <div class="detail-item">
                            <label for="color">색상:</label>
                            <select id="color" name="color">
                                <option value="">색상 선택</option>
                                <c:forEach var="color" items="${requestScope.colorName}">
                                	<option value="${color.colorName}">${color.colorName}</option>
               					 </c:forEach>
                            </select>
                        </div>
                
                        <div class="detail-item">
                            <label for="photo-upload">사진 업로드:</label>
                            <input type="file" id="photo-upload" name="photo-upload" accept="image/*">
                        </div>
                
                        <div class="detail-item">
                            <label for="english-name">영문 이름:</label>
                            <input type="text" id="english-name" name="english-name" placeholder="영문 이름 입력" required>
                        </div>
                
                        <div class="detail-item">
                            <label for="korean-name">한글 이름:</label>
                            <input type="text" id="korean-name" name="korean-name" placeholder="한글 이름 입력" required>
                        </div>
                
                        <div class="detail-item">
                            <label for="model-number">모델 번호:</label>
                            <input type="text" id="model-number" name="model-number" placeholder="모델 번호 입력" required>
                        </div>
                
                        <div class="button-group">
                        	<input type="hidden" name = "brand" value="${brand}">
                        	<input type="hidden" name = "category" value="${category}">
                        	<input type="hidden" name = "price" value="${price}">
                        	<input type="hidden" name = "releaseDate" value="${releaseDate}">
                            <button type="submit" class="confirm-btn">확인</button>
                        </div>
                    </form>
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
