<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>SHOP | KREAM</title>

<link rel="stylesheet" href="http://localhost:8888/kream/assets/css/MainPage.css" />
<link rel="stylesheet" href="http://localhost:8888/kream/assets/css/reset.css" />
</head>

<body>
	<div class="layout_main_container">
		<div class="menu_container">
			<div class="shop_name">
				<!-- 헤더 -->
				<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
				<!-- //헤더 -->
				<h1 class="shop_title">SHOP</h1>
			</div>
		</div>

		<div class="popular_shoes_list_container" id="shoeList">
			<c:forEach items="${popularProductList}" var="product">
				<a href="${pageContext.request.contextPath}/product/detail?prodNo=${product.prodNo}" class="popular_item"> <img
					src="${pageContext.request.contextPath}/Kream_products_imgs/${product.saveName}" alt="${product.engName}" />
					<div class="popular_item_name">${product.engName}</div>
				</a>
			</c:forEach>
		</div>


		<div class="sidebar">
			<div class="sidebar_container">
				<div class="filter-section">
					<h2>필터</h2>
				</div>

				<form action="${pageContext.request.contextPath}/main/mainpageFiltered" method="get">
					<h4>브랜드</h4>
					<div class="filter-section">
						<br>
						<ul>
							<c:forEach items="${requestScope.pMap.brandList}" var="brand">
								<li><input type="checkbox" name="brandNo" value="${brand.brandNo}" /> ${brand.brandName}</li>
							</c:forEach>
						</ul>
					</div>

					<h4>색상</h4>
					<div class="filter-section">
						<br>
						<div class="color-grid">
							<c:forEach items="${requestScope.pMap.colorList}" var="color">
								<div>
									<button class="color-circle" style="background-color: ${color.colorCode};"></button>
									<p>${color.colorName}</p>
								</div>
							</c:forEach>
						</div>
					</div>

					<button type="submit" id = "filter">필터 적용</button>
				</form>
			</div>
		</div>

		<div class="products_container">
			<div class="products">
				<c:forEach items="${pMap.productList}" var="product">
					<a href="${pageContext.request.contextPath}/product/detail?prodNo=${product.prodNo}" class="products_selling_items"> <img
						src="${pageContext.request.contextPath}/Kream_products_imgs/${product.saveName}" alt="${product.engName}" />
						<div class="products_selling_items_name">${product.engName}</div>
						<div class="products_selling_items_price">${product.prodPrice}원</div>
					</a>
				</c:forEach>
			</div>




		</div>
		<!-- Pagination -->
		<div id="paging">
			<ul>
				<!-- Previous button -->
				<c:if test="${requestScope.pMap.prev}">
					<li><a href="${pageContext.request.contextPath}/main/mainpage?crtpage=${requestScope.pMap.startPageBtnNo}">◀</a></li>
				</c:if>

				<!-- Page number buttons -->
				<c:forEach begin="${requestScope.pMap.startPageBtnNo}" end="${requestScope.pMap.endPageBtnNo}" var="page">
					<li><a href="${pageContext.request.contextPath}/main/mainpage?crtpage=${page}">${page}</a></li>
				</c:forEach>

				<!-- Next button -->
				<c:if test="${requestScope.pMap.next}">
					<li><a href="${pageContext.request.contextPath}/main/mainpage?crtpage=${requestScope.pMap.endPageBtnNo}">▶</a></li>
				</c:if>
			</ul>
		</div>
	</div>


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
					운영시간 평일 10:00 - 18:00 (토∙일, 공휴일 휴무) <br> 점심시간 평일 13:00 - 14:00
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
				<a href="https://www.instagram.com/" target="_blank"><img src="../imgs/instagram.jpg" /></a> <a href="https://www.facebook.com/?locale=ko_KR"
					target="_blank"><img src="../imgs/facebook.jpg" /></a> <a href="https://www.kakaocorp.com/page/service/service/KakaoTalk" target="_blank"><img
					src="../imgs/kakaotalk.jpg" /></a>
			</div>
			<div id="business-title">
				크림 주식회사 · 대표 김창욱 &emsp; 사업자등록번호 : 570-88-01618 <a href="#">사업자정보확인</a> &emsp; 통신판매업 : 제 2021-성남분당C-0093호<br> 사업장소재지 : 경기도 성남시 분당구 분당내곡로 131 판교테크원 타워1,
				8 &emsp; 층호스팅 서비스 : 네이버 클라우드 ㈜
			</div>
		</div>
		<div id="notice-guarantee">
			<p class="bank">신한은행 채무지급보증 안내</p>
			<p>
				당사는 고객님의 현금 결제 금액에 대해 신한은행과 채무지급보증 계약을 체결하여 안전거래를 보장하고 있습니다. <a href="#">서비스가입 사실 확인</a>
			</p>
			<br>
			<p>
				크림(주)는 통신판매 중개자로서 통신판매의 당사자가 아닙니다. 본 상품은 개별판매자가 등록한 상품으로 상품, 상품정보, 거래에 관한<br> 의무와 책임은 각 판매자에게 있습니다. 단, 이용약관 및 정책, 기타 거래 체결 과정에서 고지하는 내용 등에 따라 검수하고 보증하는<br>
				내용에 대한 책임은 크림(주)에 있습니다.
			</p>

		</div>
		<div class="corp">&#169; KREAM Corp.</div>
	</div>
	<!-- //푸터 -->

</body>
</html>
