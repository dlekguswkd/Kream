<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/reset.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/loginForm.css">

<!-- Axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>

<body>

	<div id="wrap">
		<!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

		<!-- 로그인 페이지 -->
		<div class="login-container">
			<h2>KREAM</h2>
			<p class="tagline">KICKS RULE EVERYTHING AROUND ME</p>
			<form action="${pageContext.request.contextPath}/user/login" method="get">
				
				<label for="id">아이디</label> 
				<input type="id" id="id" name="userId" required> 
				<label for="password">비밀번호</label> 
				<input type="password" id="password" name="userPw" required>

				<button type="submit">로그인</button>
			</form>
			<div class="footer-link">
				<a href="#">이메일 가입</a> | <a href="#">이메일 찾기</a> | <a href="#">비밀번호 찾기</a>
			</div>
		</div>

		<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>
	</div>

</body>
</html>
