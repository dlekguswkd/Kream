<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>구매내역</title>
<link href="${pageContext.request.contextPath}/assets/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/mypage_purchaseList.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">

		<!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- 컨텐츠 -->
		<div id="contents" class="clearfix">
			<!-- aside -->
			<div id="aside">
				<h2>
					<a href="#">마이페이지</a>
				</h2>
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

				<!-- 구매 내역 섹션 -->
				<div class="purchase-section">
					<h3>구매 내역</h3>

					<!-- 구매 목록 리스트 -->
					<div class="purchase-list">
						<c:forEach items="${requestScope.purchaseList}" var="PurchaseVo">
							<div class="purchase-item">
								<div class="product-info">
									<img src="https://via.placeholder.com/80" alt="상품 이미지">
									<div>
										<p class="title">${PurchaseVo.engName}</p>
										<p class="details">사이즈: ${PurchaseVo.prodSize}</p>
									</div>
								</div>
								<div class="purchase-status">
									<p class="price">${PurchaseVo.prodPrice}</p>
									<p>${PurchaseVo.shippingStatus}</p>
								</div>
								<div class="purchase-action">
									<c:choose>
										<c:when test="${PurchaseVo.shippingStatus == '준비중'}">
											<form action="${pageContext.request.contextPath}/user/purchasedelete" method="get">
												<button type="submit">취소</button>
												<input type="hidden" name="historyNo" value="${PurchaseVo.historyNo}" />
											</form>
										</c:when>
										<c:otherwise>
											<!-- '배송완료' 또는 다른 상태일 때는 아무 것도 표시하지 않음 -->
										</c:otherwise>
									</c:choose>
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
