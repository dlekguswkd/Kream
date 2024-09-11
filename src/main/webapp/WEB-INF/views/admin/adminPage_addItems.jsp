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
                <div id="product-registration">
                    <h2>상품 등록</h2>
                    <form action="${pageContext.request.contextPath}/admin/addItems2" method="post" id="product-form">
                        <div class="detail-item">
                            <label for="brand">브랜드:</label>
                            <select id="brand" name="brand">
                                <option value="">브랜드 선택</option>
                                <c:forEach var="brand" items="${requestScope.brandName}">
                    				<option value="${brand.brandName}">${brand.brandName}</option>
               					 </c:forEach>
                            </select>
                        </div>
                
                        <div class="detail-item">
                            <label for="category">카테고리:</label>
                            <input type="text" id="category" name="category" placeholder="카테고리 입력" required>
                        </div>
                
                        <div class="detail-item">
                            <label for="price">가격:</label>
                            <input type="text" id="price" name="price" placeholder="가격 입력" required>
                        </div>
                
                        <div class="detail-item">
                            <label for="release-date">출시일:</label>
                            <input type="date" id="release-date" name="release-date" required>
                        </div>
                
                        <div class="button-group">
                            <button type="submit" class="next-btn">다음</button>
                        </div>
                    </form>
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
