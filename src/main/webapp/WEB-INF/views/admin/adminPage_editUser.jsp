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
					<div class="section-title">유저 정보</div>

					<div id="user-info">
						<!-- 유저 정보 리스트 -->
						<c:forEach items="${requestScope.pMap.userList}" var="userVo">
							<div class="info-item">
								<div class="user-info">

									<div>
										<p class="info-title">${userVo.userName}</p>
										<p class="info-detail">${userVo.userId}</p>
									</div>
								</div>
								<form action="${pageContext.request.contextPath}/admin/userInfoEdit" method="get">

									<input type="hidden" class="userNo" name="userNo" value="${userVo.userNo}">
									<button class="edit-btn" type="submit">정보 변경</button>
								</form>
							</div>
						</c:forEach>
					</div>
				</div>
				<div id="paging">
					<ul>
						<c:if test="${requestScope.pMap.prev}">
							<li><a href="${pageContext.request.contextPath}/admin/editUser?crtpage=${requestScope.pMap.startPageBtnNo - 1}">◀</a></li>
						</c:if>

						<c:forEach begin="${requestScope.pMap.startPageBtnNo}" end="${requestScope.pMap.endPageBtnNo}" var="page">
							<li><a href="${pageContext.request.contextPath}/admin/editUser?crtpage=${page}" class="${param.crtpage == page ? 'active' : ''}"> ${page} </a></li>
						</c:forEach>

						<c:if test="${requestScope.pMap.next}">
							<li><a href="${pageContext.request.contextPath}/admin/editUser?crtpage=${requestScope.pMap.endPageBtnNo + 1}">▶</a></li>
						</c:if>
					</ul>
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
