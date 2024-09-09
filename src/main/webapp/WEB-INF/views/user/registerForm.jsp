<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <title>Signup</title>
  	<link href="${pageContext.request.contextPath}/assets/css/reset2.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath}/assets/css/registerForm.css" rel="stylesheet" type="text/css">
  
 <!-- Axios 라이브러리 포함 -->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
  
  
  </head>
  <body>
    <div id="wrap">
    
      	<!-- header + nav -->
		<c:import url="/WEB-INF/views/include/header.jsp"></c:import>

      <!-- 회원가입 페이지 -->
      <div class="signup-container">
        <h2>회원가입</h2>
        <form action="${pageContext.request.contextPath}/user/register" method="get">

          <label for="name">이름</label>
          <input type="text" id="name" name="userName" value="" required />

          <label for="address">주소</label>
          <input type="text" id="address" name="userAddress" value="" required/>
          

          <label for="id">아이디</label>
          <input type="text" id="id" name="userId" value="" required/>

          <label for="password">비밀번호</label>
          <input type="password" id="password" name="userPw" value="" required/>

          

          <label for="agree">
            <input type="checkbox" id="agree" name=""  value="" required/>
            개인정보 처리방침에 동의합니다.
          </label>

          <button type="submit">회원가입</button>
        </form>
      </div>

     	<!-- footer -->
		<c:import url="/WEB-INF/views/include/footer.jsp"></c:import>

    </div>
    <!-- wrap-->
  </body>
</html>
