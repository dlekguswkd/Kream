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
                <div id="product-details">
                    <h2>상품 등록</h2>
                    <form  action="${pageContext.request.contextPath}/admin/uploadItem" method="post" id="product-detail-form" enctype="multipart/form-data">
                        <div class="detail-item">
                            <label for="color">색상:</label>
                            <select id="color" name="color">
                                <option value="">색상 선택</option>
                                <c:forEach var="color" items="${requestScope.colorName}">
                                	<option value="${color.colorName}">${color.colorName}</option>
               					 </c:forEach>
                            </select>
                        </div>
                
                        <div class="detail-item">
                            <label for="photo-upload">사진 업로드:</label>
                            <input type="file" id="photo-upload" name="photo-upload" accept="image/*">
                        </div>
                
                        <div class="detail-item">
                            <label for="english-name">영문 이름:</label>
                            <input type="text" id="english-name" name="english-name" placeholder="영문 이름 입력" required>
                        </div>
                
                        <div class="detail-item">
                            <label for="korean-name">한글 이름:</label>
                            <input type="text" id="korean-name" name="korean-name" placeholder="한글 이름 입력" required>
                        </div>
                
                        <div class="detail-item">
                            <label for="model-number">모델 번호:</label>
                            <input type="text" id="model-number" name="model-number" placeholder="모델 번호 입력" required>
                        </div>
                
                        <div class="button-group">
                        	<input type="hidden" name = "brand" value="${brand}">
                        	<input type="hidden" name = "category" value="${category}">
                        	<input type="hidden" name = "price" value="${price}">
                        	<input type="hidden" name = "releaseDate" value="${releaseDate}">
                            <button type="submit" class="confirm-btn">확인</button>
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
