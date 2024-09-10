<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>상품설명 페이지</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset2.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/detailList.css" />

<!-- Axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
	<div id="wrap">
		<!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
		

		<!-- 컨텐츠 -->
		<div id="contents" class="clearfix">
			<div class="clearfix">
				<!-- 상품 이미지 박스 -->
				<div id="profile">
					<div>
						<img id="img1" src="../imgs/samba.jpg" />
					</div>
					<div id="small-img">
						<img class="img2" src="../imgs/samba.jpg" /> <img class="img2" src="../imgs/samba2.jpg" /> <img class="img2" src="../imgs/samba2.jpg" /> <img
							class="img2" src="../imgs/samba2.jpg" /> <img class="img2" src="../imgs/samba2.jpg" /> <img class="img2" src="../imgs/samba2.jpg" />
					</div>
				</div>

				<!-- 상품 설명 -->
				<div id="explain-box" class="clearfix">
					<div class="price-box">
						<p class="price1">구매가</p>
						<p class="price2">149,000원</p>
					</div>

					<div class="name-box">
						<p class="title">Adidas Samba Vegan White Black</p>
						<p class="sub-title">아디다스 삼바 비건 화이트 블랙</p>
					</div>

					<!-- 사이즈 옵션 선택 -->
					<div class="form-size">
						<p>모든 사이즈</p>
						<div class="more">▼</div>
					</div>

					<!--모달창 -->
					<div id="buy-modal">
						<div class="purchase-modal" id="purchaseModal">
							<div class="modal-header">
								<h1>구매하기</h1>
								<p>(가격 단위: 원)</p>
								<button class="close-btn" type="button">&times;</button>
							</div>

							<div class="product-info">
								<img src="../imgs/samba.jpg" alt="Adidas Samba Vegan White Black" />
								<div>
									<h2>Adidas Samba Vegan White Black</h2>
									<p class="product-id">아디다스 삼바 비건 화이트 블랙</p>
									<p class="product-id">H01877</p>
								</div>
							</div>

							<div class="size-grid">
								<!-- 사이즈 버튼들 -->
								<div class="size-box">
									<p>230</p>
								</div>
								<div class="size-box">
									<p>235</p>
								</div>
								<div class="size-box">
									<p>240</p>
								</div>
								<div class="size-box">
									<p>245</p>
								</div>
								<div class="size-box">
									<p>250</p>
								</div>
								<div class="size-box">
									<p>255</p>
								</div>
								<div class="size-box">
									<p>260</p>
								</div>
								<div class="size-box">
									<p>265</p>
								</div>
								<div class="size-box">
									<p>270</p>
								</div>
								<div class="size-box">
									<p>275</p>
								</div>
								<div class="size-box">
									<p>280</p>
								</div>
							</div>
						</div>
					</div>
					<!--//모달창-->

					<!-- 부가설명 -->
					<div id="add-explain" class="clearfix">
						<div class="detail-box">
							<p class="txt-explain">모델번호</p>
							<p class="txt-explain2">H01877</p>
						</div>
						<div class="detail-box">
							<p class="txt-explain">출시일</p>
							<p class="txt-explain2">21/07/27</p>
						</div>
						<div class="detail-box">
							<p class="txt-explain">대표색상</p>
							<p class="txt-explain2">White</p>
						</div>
					</div>

					<!-- 구매버튼, 관심상품 버튼 -->
					<div id="btn-action" class="clearfix">
						<button id="btn1" class="clearfix" type="button">구매하기</button>
						<button id="btn2" type="button">관심상품</button>
					</div>

					<!-- 배송 정보 -->
					<div id="delivery" class="clearfix">
						<h1>배송정보</h1>
						<div class="delivery-info">
							<img src="${pageContext.request.contextPath}/assets/imgs/express.jpg" />
							<div class="badge-title">
								<p class="types">빠른배송</p>
								<p class="txt-badge">3일 내 도착 예정</p>
							</div>
						</div>
						<div class="delivery-info">
							<img src="${pageContext.request.contextPath}/assets/imgs/standard.jpg" />
							<div class="badge-title">
								<p class="types">일반배송</p>
								<p class="txt-badge">검수 후 배송 ・ 5-7일 내 도착 예정</p>
							</div>
						</div>
						<div class="delivery-info">
							<img src="${pageContext.request.contextPath}/assets/imgs/warehouse.jpg" />
							<div class="badge-title">
								<p class="types">창고보관</p>
								<p class="txt-badge">배송 없이 창고에 보관 ・ 빠르게 판매 가능</p>
							</div>
						</div>
					</div>
					<!-- //배송 정보 -->
				</div>
			</div>

			<!-- 테이블 -->
			<div id="size-box">
				<div>
					<h3>사이즈 정보</h3>
				</div>
				<table>
					<tr class="color">
						<td>JP</td>
						<td>230</td>
						<td>235</td>
						<td>240</td>
						<td>245</td>
						<td>250</td>
						<td>255</td>
						<td>260</td>
						<td>265</td>
						<td>270</td>
						<td>275</td>
						<td>280</td>
					</tr>
					<tr>
						<td class="color">KR</td>
						<td>230</td>
						<td>235</td>
						<td>240</td>
						<td>245</td>
						<td>250</td>
						<td>255</td>
						<td>260</td>
						<td>265</td>
						<td>270</td>
						<td>275</td>
						<td>280</td>
					</tr>
					<tr>
						<td class="color">US (M)</td>
						<td>5</td>
						<td>5.5</td>
						<td>6</td>
						<td>6.5</td>
						<td>7</td>
						<td>7.5</td>
						<td>8</td>
						<td>8.5</td>
						<td>9</td>
						<td>9.5</td>
						<td>10</td>
					</tr>
					<tr>
						<td class="color">US (W)</td>
						<td>6</td>
						<td>6.5</td>
						<td>7</td>
						<td>7.5</td>
						<td>8</td>
						<td>8.5</td>
						<td>9</td>
						<td>9.5</td>
						<td>10</td>
						<td>10.5</td>
						<td>11</td>
					</tr>
					<tr>
						<td class="color">UK</td>
						<td>4.5</td>
						<td>5</td>
						<td>5.5</td>
						<td>6</td>
						<td>6.5</td>
						<td>7</td>
						<td>7.5</td>
						<td>8</td>
						<td>8.5</td>
						<td>9</td>
						<td>9.5</td>
					</tr>
				</table>
				<p>* 해당 사이즈 정보는 고객 이해를 위한 참고용이며, 브랜드마다 또는 상품 카테고리마다 차이가 있을 수 있습니다. 정확한 내용은 실물 상품 기준으로 공식 제조사/유통사에 확인해 주시기 바랍니다.</p>
			</div>
			<!-- //테이블 -->
		</div>

		
    	<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
	<!-- //wrap-->
</body>
</html>
