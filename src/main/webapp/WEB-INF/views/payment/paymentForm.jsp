<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
<link href="${pageContext.request.contextPath}/assets/css/reset3.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/paymentForm.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">

		<!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- ---------------------------------------------  내용 시작 ------------------------------------------------------- -->

		<div id="paymentForm" class="clearfix">
			<!-- aside 없음 -->
			<div id="full-content">

				<div id="paymentInfo">
					<p>주문완료 되었습니다.</p>
				</div>

				<div class="productInfo clearfix">
					<div class="order-text">
						<p>주문 상품</p>
					</div>
					<div class="clear"></div>

					<!-- (상품사진), 상품정보,  결제금액-->
					<div class="text2">
						<div class="product-text">
							<p>상품정보</p>
						</div>
						<div class="payment-text">
							<p>결제금액</p>
						</div>
					</div>


					<!-- 여기가 반복? -->
					<div class="order-product">
						<img class="product-img" src="../imgs/Adidas Original Gazelle Auburn Clear Pink.webp">
						<div class="content">
							<p class="product-nameE">Adidas Original Gazelle Auburn Clear Pink</p>
							<p class="product-nameK">아디다스 오리지널스 가젤 어번 클리어 핑크</p>
							<p class="size">240</p>
						</div>
						<!-- //content -->
						<div class="product-price">
							<p>160,000 원</p>
						</div>
					</div>
					<!-- 반복끝 -->
					<div class="clear"></div>

					<!-- 여기가 반복? -->
					<div class="order-product">
						<img class="product-img" src="../imgs/Nike x Peaceminusone Air Force 1 Low Para-Noise 3.0 Black and Multicolor.webp">
						<div class="content">
							<p class="product-nameE">Nike x Peaceminusone Air Force 1 Low Para-Noise 3.0 Black and Multicolor</p>
							<p class="product-nameK">나이키 x 피스마이너스원 에어포스 1 로우 파라노이즈 3.0 블랙 앤 멀티컬러</p>
							<p class="size">235</p>
						</div>
						<!-- //content -->
						<div class="product-price">
							<p>473,000 원</p>
						</div>
					</div>
					<!-- 반복끝 -->

				</div>
				<!-- //productInfo -->



				<!-- 결제정보 -->
				<div id="selectInfo">
					<div class="total-text">
						<p>결제 정보</p>
					</div>
					<div class="clear"></div>
					<div class="total-price">
						<div class="total-priceL">
							<p>총 결제 금액</p>
						</div>
						<div class="total-priceR">
							<p>653,000 원</p>
						</div>
					</div>
				</div>
				<!-- //selectInfo -->

				<!-- 주문자 정보 -->
				<div id="userInfo">
					<div class="user-text">
						<p>주문자 정보</p>
					</div>
					<div class="clear"></div>
					<div class="name">
						<div class="nameL">
							<p>이름</p>
						</div>
						<div class="nameR">
							<p>이다현</p>
						</div>
					</div>
					<div class="email">
						<div class="emailL">
							<p>ID</p>
						</div>
						<div class="emailR">
							<p>Supernova</p>
						</div>
					</div>
					<div class="address">
						<div class="addressL">
							<p>배송지(집 주소)</p>
						</div>
						<div class="addressR">
							<p>서울특별시 강남구 어디어디</p>
						</div>
					</div>
				</div>
				<!-- //userInfo -->

				<div>
					<button id="home" type="button" name="">홈으로</button>
				</div>

			</div>
			<!-- //full-content -->


		</div>
		<!-- //paymentForm -->

		<!-- ---------------------------------------------  내용 끝 ------------------------------------------------------- -->
		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

	</div>
	<!-- //wrap -->

</body>

</html>