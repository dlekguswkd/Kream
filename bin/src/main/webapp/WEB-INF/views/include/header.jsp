<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- 헤더 -->
<div id="header" class="clearfix">
	<div class="clearfix" id="header1">
		<!-- 로그인 성공시 -->
		<c:if test="${sessionScope.authUser != null}">
			<ul class="clearfix">
				<li><a href="${pageContext.request.contextPath}/user/mypage?userNo=${sessionScope.authUser.userNo}">마이페이지</a></li>
				<li><a href="${pageContext.request.contextPath}/favorites?userNo=${sessionScope.authUser.userNo}">관심</a></li>
				<li><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></li>
			</ul>
		</c:if>

		<!-- 로그인 실패시 (로그인 안 했을 때) -->
		<c:if test="${sessionScope.authUser == null}">
			<ul class="clearfix">
				<li><a href="${pageContext.request.contextPath}/user/loginform">로그인</a></li>
				<li><a href="${pageContext.request.contextPath}/user/registerForm">회원가입</a></li>
			</ul>
		</c:if>
	</div>
	<div class="clearfix" id="header2">
		<h1>
			<a href="${pageContext.request.contextPath}/main/mainform">KREAM</a>
		</h1>
		<div>
			<ul class="clearfix">
				<li><a href="${pageContext.request.contextPath}/main/mainform"><strong>HOME</strong></a></li>
				<li><a href="${pageContext.request.contextPath}/main/mainform">SHOP</a></li>
				<li><a href="#"><img id="search"
						src="${pageContext.request.contextPath}/assets/imgs/search.jpg"></a></li>
				<li><a href="${pageContext.request.contextPath}/shoppingcart?userNo=${sessionScope.authUser.userNo}"><img
						id="cart"
						src="${pageContext.request.contextPath}/assets/imgs/cart.jpg"></a></li>
			</ul>
		</div>
	</div>
</div>
<!-- //헤더 -->