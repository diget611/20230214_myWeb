<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20230214_myWeb Home</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<h1>서버프로그램 구현 실습</h1>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	
	<c:if test="${not empty lgnss}">
		<button type="button" class="btn myinfo">My Page</button>
	</c:if>
	<script>
		$(".btn.login").on("click", handlerClickBtnLogin);
		$(".btn.logout").on("click", handlerClickBtnLogout);
		$(".btn.myinfo").on("click", handlerClickBtnMyinfo)
		
		function handlerClickBtnLogin(){
			console.log("LoginBtn Click");
			location.href="<%=request.getContextPath()%>/login";
		}
		function handlerClickBtnLogout(){ 
			console.log("LogoutBtn Click");
		}
		function handlerClickBtnMyinf(){
			location.href="<%=request.getContextPath()%>/myinfo";
		}
	</script>
</body>
</html>