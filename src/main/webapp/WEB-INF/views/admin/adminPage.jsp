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
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>
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
				<!-- 유저 정보 섹션 -->
				<div class="section">
					<div class="section-title">
						유저 정보 <a href="${pageContext.request.contextPath}/admin/editUser"><button class="more-btn">더보기</button></a>
					</div>

					<div id="user-info">
						<!-- 유저 정보 리스트 -->
						<c:forEach items="${requestScope.userInfoList}" var="userVo">
							<div class="info-item">
								<div class="user-info">

									<div>
										<p class="info-title">${userVo.userName}</p>
										<p class="info-detail">${userVo.userId}</p>
										<input type="hidden" class="userNo" value="${userVo.userNo}">
									</div>
								</div>
								<form action="${pageContext.request.contextPath}/admin/userInfoEdit" method="get">

									<input type="hidden" class="userNo" name="userNo" value="${userVo.userNo}">
									<button class="edit-btn" type="submit">정보 변경</button>
								</form>
							</div>
							<!-- Info-Item -->
						</c:forEach>
					</div>
					<!-- 유저 정보 리스트 -->
				</div>
				<!-- Section -->

				<!-- 판매 기록 섹션 -->
				<div class="section">
					<div class="section-title">
						판매 기록 <a href="${pageContext.request.contextPath}/admin/saleshistory"><button class="more-btn">더보기</button></a>
					</div>
					<div id="sales-info">
						<c:forEach items="${requestScope.soldProductList}" var="soldProductList">

							<div class="info-item">
								<img src="${pageContext.request.contextPath}/Kream_products_imgs/${soldProductList.saveName}" alt="판매 아이템" class="item-img" />
								<div>

									<p class="info-title">${soldProductList.engName}</p>
									<p class="info-detail">${soldProductList.korName}</p>
								</div>
								<div>
									<p class="info-title">금액</p>

									<p class="info-detail">${soldProductList.prodPrice}원</p>

								</div>
							</div>
						</c:forEach>
					</div>
				</div>

				<!-- 구매 신청 리스트 섹션 -->
				<div class="section">
					<div class="section-title">
						구매 신청 <a href="${pageContext.request.contextPath}/admin/purchaseRequest"><button class="more-btn">더보기</button></a>
					</div>
					<div id="purchase-info">
						<c:forEach items="${requestScope.purchaseReqList}" var="purchaseReqList">
							<div class="info-item">
								<img src="${pageContext.request.contextPath}/Kream_products_imgs/${purchaseReqList.saveName}" alt="구매신청 아이템" class="item-img" />
								<div>
									<p class="info-title">${purchaseReqList.engName}</p>
									<p class="info-detail">${purchaseReqList.korName}</p>
								</div>
								<div class="buyer-info">
									<p class="info-title">구매자: ${purchaseReqList.userName}</p>
									<p class="info-detail">아이디: ${purchaseReqList.userId}</p>
								</div>

								<!-- 승인 버튼을 포함한 form -->
								<form action="${pageContext.request.contextPath}/admin/approvePurchase" method="post">
									<input type="hidden" name="historyNo" value="${purchaseReqList.historyNo}" />
									<button type="submit" class="approve-btn">승인</button>
								</form>

								<!-- 거부 버튼을 포함한 form -->
								<form action="${pageContext.request.contextPath}/admin/rejectPurchase" method="post">
									<input type="hidden" name="historyNo" value="${purchaseReqList.historyNo}" />
									<button type="submit" class="reject-btn">거부</button>
								</form>
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
<!-- 자바스크립트로 정보 전달 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

</html>
