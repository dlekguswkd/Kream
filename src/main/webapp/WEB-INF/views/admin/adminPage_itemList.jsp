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
				<div id="product-list">
					<h2>상품 리스트</h2>
					<c:forEach items="${requestScope.pMap.productList}" var="productList">
						<div class="product-item">
							<img src="${pageContext.request.contextPath}/Kream_products_imgs/${productList.saveName}" alt="Product Image" class="product-img">
							<div class="product-info">
								<p>
									<strong>영문 이름:</strong> ${productList.engName}
								</p>
								<p>
									<strong>한글 이름:</strong> ${productList.korName}
								</p>
								<p>
									<strong>모델 번호:</strong> ${productList.modelNo}
								</p>
								<p>
									<strong>브랜드:</strong> ${productList.brandName}
								</p>
								<p>
									<strong>카테고리:</strong> ${productList.categoryName}
								</p>
								<p>
									<strong>가격:</strong> ${productList.prodPrice}원
								</p>
								<p>
									<strong>출시일:</strong> ${productList.releaseDate}
								</p>
								<p>
									<strong>색상:</strong> ${productList.colorName}
								</p>
							</div>
							<div class="button-group">
								<form action="${pageContext.request.contextPath}/admin/deleteProduct" method="get">
									<input type="hidden" name="prodNo" value="${productList.prodNo}">
									<button type="submit" class="delete-btn">삭제</button>
								</form>
							</div>
						</div>
					</c:forEach>

					<!-- Pagination controls -->
					<div id="paging">
						<ul>
							<c:if test="${requestScope.pMap.prev}">
								<li><a href="${pageContext.request.contextPath}/admin/itemList?crtpage=${requestScope.pMap.startPageBtnNo - 1}">◀</a></li>
							</c:if>

							<c:forEach begin="${requestScope.pMap.startPageBtnNo}" end="${requestScope.pMap.endPageBtnNo}" var="page">
								<li><a href="${pageContext.request.contextPath}/admin/itemList?crtpage=${page}" class="${param.crtpage == page ? 'active' : ''}">${page}</a></li>
							</c:forEach>

							<c:if test="${requestScope.pMap.next}">
								<li><a href="${pageContext.request.contextPath}/admin/itemList?crtpage=${requestScope.pMap.endPageBtnNo + 1}">▶</a></li>
							</c:if>
						</ul>
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
