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
	<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	<!-- //푸터 -->

</body>
</html>
