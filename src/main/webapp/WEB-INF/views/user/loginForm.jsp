<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/loginForm.css">
</head>

<!-- Axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

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
				<h1>
					<a href="#">KREAM</a>
				</h1>
				<div>
					<ul class="clearfix">
						<li><a href="#"><strong>HOME</strong></a></li>
						<li><a href="#">SHOP</a></li>
						<li><a href="#"><img id="search" src="../imgs/search.jpg"></a></li>
						<li><a href="#"><img id="cart" src="../imgs/cart.jpg"></a></li>
					</ul>
				</div>
			</div>
		</div>
		<!-- //헤더 -->

		<!-- 로그인 페이지 -->
		<div class="login-container">
			<h2>KREAM</h2>
			<p class="tagline">KICKS RULE EVERYTHING AROUND ME</p>
			<form action="/login" method="POST">
				<label for="id">아이디</label> <input type="id" id="id" name="id" required> <label for="password">비밀번호</label> <input type="password" id="password"
					name="password" required>

				<button type="submit">로그인</button>
			</form>
			<div class="footer-link">
				<a href="#">이메일 가입</a> | <a href="#">이메일 찾기</a> | <a href="#">비밀번호 찾기</a>
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
					크림(주)는 통신판매 중개자로서 통신판매의 당사자가 아닙니다. 본 상품은 개별판매자가 등록한 상품으로 상품, 상품정보, 거래에 관한<br> 의무와 책임은 각 판매자에게 있습니다. 단, 이용약관 및 정책, 기타 거래 체결 과정에서 고지하는 내용 등에 따라 검수하고
					보증하는<br> 내용에 대한 책임은 크림(주)에 있습니다.
				</p>

			</div>
			<div class="corp">&#169; KREAM Corp.</div>

		</div>
		<!-- //푸터 -->
	</div>

</body>
</html>
