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
                <div id="user-detail">
                    <h2>유저 상세 정보</h2>
                    <form action="${pageContext.request.contextPath}/admin/updateUser" method="post">
                    	<input type="hidden" name="userNo" value="${userVo.userNo}">
    					<div class="detail-item">
                            <label for="user-name">이름:</label>
                            <input type="text" id="user-name" name="user-name" value="${userVo.userName}">
                        </div>
                        <div class="detail-item">
                            <label for="user-email">아이디:</label>
                            <input type="id" id="user-email" name="user-email" value="${userVo.userId}">
                        </div>
                        <div class="detail-item">
                            <label for="user-password">비밀번호:</label>
                            <input type="password" id="user-password" name="user-password" value="${userVo.userPw}">
                        </div>
                        <div class="detail-item">
                            <label for="user-address">주소:</label>
                            <input type="text" id="user-address" name="user-address" value="${userVo.userAddress}">
                        </div>
                        <div class="button-group">
                            <button type="submit" class="save-btn">저장</button>
                        </div>
					</form>
					<form action="${pageContext.request.contextPath}/admin/deleteUser" method="post">
        				<input type="hidden" name="userNo" value="${userVo.userNo}">

        				<!-- Delete Button -->
        				<div class="button-group">
            				<button type="submit" class="delete-btn">삭제</button>
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
