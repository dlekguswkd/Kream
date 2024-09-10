<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>관심 상품</title>
<link href="${pageContext.request.contextPath}/assets/css/reset2.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/assets/css/favorites.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="wrap">

		<!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- 컨텐츠 -->
		<div id="contents" class="clearfix">
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
				<div id="content-title">
					<h3>관심</h3>
				</div>

				<div id="content-button">
					<button class="btn1" type="button" name="">상품</button>
					<button type="button" name="">스타일</button>
					<button type="button" name="">브랜드</button>
					<button type="button" name="">최근 본 상품</button>
				</div>

				<div id="content-header" class="clearfix">
					<div id="total-rows">
						전체 <span>1</span>
					</div>
					<div id="sorting-filter">관심등록순↑↓</div>
				</div>

				<!-- for문 -->
				<c:forEach items="${requestScope.favoritesList}" var="FavoritesVo">
					<div id="wish-item" class="clearfix">
						<a href="#"><img
							src="${pageContext.request.contextPath}/upload/${FavoritesVo.saveName}"></a>

						<div id="product-detail" class="clearfix">
							<p class="brand-name">
								<a href="#">${FavoritesVo.brandName}</a>
							</p>
							<p class="name">
								<a href="#">${FavoritesVo.engName}</a>
							</p>
							<p class="size">${FavoritesVo.prodSize}</p>
						</div>
						<div id="btn-action">
							<a href="${pageContext.request.contextPath}/shoppingcart/add?favoriteNo=${FavoritesVo.favoriteNo}"><button
									class="clearfix" type="button">
									장바구니<br> ${FavoritesVo.prodPrice}원
								</button></a>
							<div id="delete">
								<input type="hidden" name="favoriteNo"
									value="${FavoritesVo.favoriteNo}" /> <a
									href="${pageContext.request.contextPath}/favorites/delete?favoriteNo=${FavoritesVo.favoriteNo}">삭제</a>
							</div>
						</div>
					</div>
				</c:forEach>
				<!-- //for문 -->

				<!--
				<div id="paging" class="clearfix">
					<div id="nums" class="clearfix">
						<ul>
							<li><a href="">◀</a></li>
							<li><a href="">1</a></li>
							<li><a href="">2</a></li>
							<li><a href="">3</a></li>
							<li><a href="">4</a></li>
							<li><a href="">5</a></li>
							<li><a href="">6</a></li>
							<li><a href="">7</a></li>
							<li><a href="">8</a></li>
							<li><a href="">9</a></li>
							<li><a href="">10</a></li>
							<li><a href="">▶</a></li>
						</ul>
					</div>
				</div> -->
				
			</div>
			<!-- //content-area -->

		</div>
		<!-- //컨텐츠 -->

		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>
</body>
</html>