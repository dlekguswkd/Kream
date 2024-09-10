<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<title>상품설명 페이지</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/reset2.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/detailList.css" />

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
						<img id="img1"
							src="${pageContext.request.contextPath}/Kream_products_imgs/${product.saveName}" />
					</div>
					<div id="small-img">
						<img class="img2"
							src="${pageContext.request.contextPath}/Kream_products_imgs/${product.saveName}" />
						<!-- 여러 이미지를 넣고 싶으면 더 추가 -->
					</div>
				</div>

				<!-- 상품 설명 -->
				<div id="explain-box" class="clearfix">
					<div class="price-box">
						<p class="price1">구매가</p>
						<p class="price2">${product.prodPrice}원</p>
					</div>

					<div class="name-box">
						<p class="title">${product.engName}</p>
						<p class="sub-title">${product.korName}</p>
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
								<h1>사이즈 변경</h1>
								<button class="close-btn" type="button">&times;</button>
							</div>

							<div class="product-info">
								<img id="img2" src="" alt="shoes" />
								<div>
									<h2 id="eng-name">영문명</h2>
									<p id="kor-name" class="product-id">한글명</p>
									<p id="model-no" class="product-id">모델번호</p>
								</div>
							</div>
							<input type="hidden" id="selectCartNo" value="">
							<div class="size-grid">
								<!-- 사이즈 버튼들 -->
								<button id="size230" class="size-box" data-prodsize="230">230</button>
								<button id="size235" class="size-box" data-prodsize="235">235</button>
								<button id="size240" class="size-box" data-prodsize="240">240</button>
								<button id="size245" class="size-box" data-prodsize="245">245</button>
								<button id="size250" class="size-box" data-prodsize="250">250</button>
								<button id="size255" class="size-box" data-prodsize="255">255</button>
								<button id="size260" class="size-box" data-prodsize="260">260</button>
								<button id="size265" class="size-box" data-prodsize="265">265</button>
								<button id="size270" class="size-box" data-prodsize="270">270</button>
								<button id="size275" class="size-box" data-prodsize="275">275</button>
								<button id="size280" class="size-box" data-prodsize="280">280</button>
							</div>
						</div>
					</div>
					<!--//모달창-->

					<!-- 부가설명 -->
					<div id="add-explain" class="clearfix">
						<div class="detail-box">
							<p class="txt-explain">모델번호</p>
							<p class="txt-explain2">${product.modelNo}</p>
						</div>
						<div class="detail-box">
							<p class="txt-explain">출시일</p>
							<p class="txt-explain2">${product.releaseDate}</p>
						</div>
						<div class="detail-box">
							<p class="txt-explain">대표색상</p>
							<p class="txt-explain2">${product.colorName}</p>
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
							<img
								src="${pageContext.request.contextPath}/assets/imgs/express.jpg" />
							<div class="badge-title">
								<p class="types">빠른배송</p>
								<p class="txt-badge">3일 내 도착 예정</p>
							</div>
						</div>
						<div class="delivery-info">
							<img
								src="${pageContext.request.contextPath}/assets/imgs/standard.jpg" />
							<div class="badge-title">
								<p class="types">일반배송</p>
								<p class="txt-badge">검수 후 배송 ・ 5-7일 내 도착 예정</p>
							</div>
						</div>
						<div class="delivery-info">
							<img
								src="${pageContext.request.contextPath}/assets/imgs/warehouse.jpg" />
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
				<p>* 해당 사이즈 정보는 고객 이해를 위한 참고용이며, 브랜드마다 또는 상품 카테고리마다 차이가 있을 수
					있습니다. 정확한 내용은 실물 상품 기준으로 공식 제조사/유통사에 확인해 주시기 바랍니다.</p>
			</div>
			<!-- //테이블 -->
		</div>


		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
	<!-- //wrap-->

	<script>
	document.addEventListener("DOMContentLoaded", function() {

	    // "모든 사이즈" 버튼을 선택
	    let sizeButton = document.querySelector('.form-size');
	    
	    // 모달창과 닫기 버튼을 선택
	    let modalTag = document.querySelector('#buy-modal');
	    let closeBtn = document.querySelector('.close-btn');

	    // "모든 사이즈" 버튼 클릭 시 모달창 열기
	    sizeButton.addEventListener('click', function(event) {
	        openModal(modalTag, event); // event 객체를 전달
	    });

	    // 닫기 버튼 클릭 시 모달창 닫기
	    closeBtn.addEventListener('click', function() {
	        closeModal(modalTag);
	    });

	    // 모달창 외부를 클릭했을 때 모달창 닫기
	    window.addEventListener('click', function(event) {
	        if (event.target === modalTag) {
	            closeModal(modalTag);
	        }
	    });
	});

	// 모달창 열기 함수 (상품 정보 포함)
	function openModal(modal, event) {
	    // 여기서 event가 undefined일 경우 확인 (방어 코드)
	    if (!event || !event.target) {
	        console.error("Event 객체가 전달되지 않았습니다.");
	        return;
	    }

	    // 버튼에서 부모 요소로 이동하여 필요한 정보를 가져옴
	    let productDiv = event.target.closest('#contents'); // 상위 요소로 이동

	    if (!productDiv) {
	        console.error("상품 정보를 가져올 수 없습니다.");
	        return;
	    }

	    // 상품 정보 태그들
	    let imgTag = productDiv.querySelector('#img1'); // 상품 이미지
	    let nameTag1 = productDiv.querySelector('.title'); // 영어 이름
	    let nameTag2 = productDiv.querySelector('.sub-title'); // 한글 이름
	    let modelNoTag = productDiv.querySelector('.txt-explain2'); // 모델 번호 (대표색상 앞)

	    // 모달창 내부 요소들
	    let modaImg = document.querySelector('#img2');			
	    let name1 = document.querySelector('#eng-name');
	    let name2 = document.querySelector('#kor-name');
	    let modelNo = document.querySelector('#model-no');

	    // 상품 정보가 null인지 확인하고 모달창에 정보 넣기
	    if (imgTag && nameTag1 && nameTag2 && modelNoTag) {
	        modaImg.src = imgTag.src;
	        name1.textContent = nameTag1.textContent;
	        name2.textContent = nameTag2.textContent;
	        modelNo.textContent = modelNoTag.textContent;
	    } else {
	        console.error("필요한 상품 정보를 찾을 수 없습니다.");
	    }

	    // 모달창 보이기
	    modal.style.display = 'block';
	}

	// 모달창 닫기 함수
	function closeModal(modal) {
	    modal.style.display = 'none';
	}

	</script>
</body>
</html>