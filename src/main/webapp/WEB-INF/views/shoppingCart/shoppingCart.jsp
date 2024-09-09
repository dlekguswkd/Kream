<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link href="${pageContext.request.contextPath}/assets/css/reset3.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/shoppingCart.css" rel="stylesheet" type="text/css">

<!-- Axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>

<body>
	<div id="wrap">

		<!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- ---------------------------------------------  내용 시작 ------------------------------------------------------- -->

		<div id="cart-content" class="clearfix">
			<!-- aside 없음 -->
			<div id="full-content">

				<h1>장바구니</h1>
				<c:forEach items="${requestScope.shoppingList}" var="ShoppingcartVo">
					<div>
						<!-- 고른상품 반복 -->
						<div class="selectProduct">

							<div class="product-info">

								<img class="product-img" src="../imgs/Adidas Original Gazelle Auburn Clear Pink.webp">

								<div class="content">
									<p class="product-nameE">${ShoppingcartVo.engName}</p>
									<p class="product-nameK">${ShoppingcartVo.korName}</p>
									<p class="modelNum">${ShoppingcartVo.modelNo}</p>
									<p class="size">${ShoppingcartVo.prodSize}</p>
								</div>
								<!-- //content -->

								<div class="clear"></div>

							</div>
							<!-- //product-info -->


							<!-- 버튼 두개 (옵션, 삭제) -->
							<div class="btn2">
								<button class="btnOption" type="button" name="prodSize">사이즈 변경</button>
								<form action="${pageContext.request.contextPath}/shoppingcart/delete" method="get">
									<button class="btnDelete" type=submit>장바구니에서 삭제</button>
									<input type="hidden" name="cartNo" value="${ShoppingcartVo.cartNo}" />
								</form>
							</div>
							<!--모달창 -->
							<div id="buy-modal">
								<div class="purchase-modal" id="purchaseModal">
									<div class="modal-header">
										<h1>사이즈 변경</h1>
										<button class="close-btn" type="button">&times;</button>
									</div>

									<div class="product-info">
										<img src="../imgs/Adidas Original Gazelle Auburn Clear Pink.webp" alt="" />
										<div>
											<h2>Adidas Original Gazelle Auburn Clear Pink</h2>
											<p class="product-id">아디다스 오리지널스 가젤 어번 클리어 핑크</p>
											<p class="product-id">JH5666</p>
										</div>
									</div>

									<div class="size-grid">
										<!-- 사이즈 버튼들 -->
										<button id="size230" class="size-box" data-size="230">230</button>
										<button id="size235" class="size-box" data-size="235">235</button>
										<button id="size240" class="size-box" data-size="240">240</button>
										<button id="size245" class="size-box" data-size="245">245</button>
										<button id="size250" class="size-box" data-size="250">250</button>
										<button id="size255" class="size-box" data-size="255">255</button>
										<button id="size260" class="size-box" data-size="260">260</button>
										<button id="size265" class="size-box" data-size="265">265</button>
										<button id="size270" class="size-box" data-size="270">270</button>
										<button id="size275" class="size-box" data-size="275">275</button>
										<button id="size280" class="size-box" data-size="280">280</button>
									</div>
								</div>
							</div>
							<!--//모달창-->
							<!-- //btn2 -->

							<div class="expect-price clearfix">
								<div class="expect-priceL">
									<p>예상 결제금액</p>
								</div>
								<div class="expect-priceR">
									<p>${ShoppingcartVo.prodPrice}</p>
								</div>
							</div>
							<!-- //expect-price -->

						</div>
					</div>
				</c:forEach>
				<!-- //selectProduct -->

				<!-- 선택주문정보 -->
				<div id="selectInfo">
					<div class="total-text">
						<p>선택 주문정보</p>
					</div>
					<div class="clear"></div>

					<div class="totalExpect-price">
						<div class="totalExpect-priceL">
							<p>총 예상 결제금액</p>
						</div>
						<div class="totalExpect-priceR">
							<p>${shoppingList[0].totalPrice}원</p>
						</div>
					</div>

				</div>
				<!-- //selectInfo -->

				<div id="orderDescription">
					<ol>
						<li>배송 방법 및 쿠폰/포인트 적용 여부는 결제 시 선택할 수 있습니다.</li>
						<li>총 결제금액은 배송 방법 및 쿠폰/포인트 적용 여부에 따라 달라질 수 있습니다.</li>
						<li>예상 결제금액은 기본 배송 방법 및 일반 결제로 주문했을 때의 가격입니다.</li>
						<li>장바구니에는 KREAM 배송 상품과 브랜드 배송 상품을 각각 최대 30개까지 담을 수 있으며, 상품은 최대 30일까지 보관됩니다.</li>
					</ol>
				</div>

				<button class="btnOrder" type="button" name="">${shoppingList[0].totalPrice}원·총${totalCnt}건주문하기</button>

			</div>
			<!-- //full-content -->


		</div>
		<!-- //cart-content -->

		<!-- ---------------------------------------------  내용 끝 ------------------------------------------------------- -->
		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

	</div>
	<!-- //wrap -->

	<script>
	document.addEventListener("DOMContentLoaded", fuction() {
		
		// 사이즈 변경 모달창 띄우기 이벤트 등록
		let listArea = document.querySelector("#buy-modal");
    	listArea.addEventListener('click', callModal);
	});
	
	// 모달창 띄우기
	function callModal() {
		let modal230 = document.querySelector('#size230');
		let modal235 = document.querySelector('#size235');
		let modal240 = document.querySelector('#size240');
		let modal245 = document.querySelector('#size245');
		let modal250 = document.querySelector('#size250');
		let modal255 = document.querySelector('#size255');
		let modal260 = document.querySelector('#size260');
		let modal265 = document.querySelector('#size265');
		let modal270 = document.querySelector('#size270');
		let modal275 = document.querySelector('#size275');
		let modal280 = document.querySelector('#size280');
		
		let size230 = modal230.value;
		let size235 = modal235.value;
		let size240 = modal240.value;
		let size245 = modal245.value;
		let size250 = modal250.value;
		let size255 = modal255.value;
		let size260 = modal260.value;
		let size265 = modal265.value;
		let size270 = modal270.value;
		let size275 = modal275.value;
		let size280 = modal280.value;
		
	}
	
	
	
	
	
	
	
	</script>

</body>

</html>