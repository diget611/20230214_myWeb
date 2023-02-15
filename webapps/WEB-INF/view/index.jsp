<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>20230214_myWeb Home</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	
	<script>
		$(".btn.login").on("click", handlerClickBtnLogin);
		$(".btn.logout").on("click", handlerClickBtnLogout);
		
		function handlerClickBtnLogin(){
			console.log("LoginBtn Click");
			location.href="<%=request.getContextPath()%>/login";
		}
		function handlerClickBtnLogout(){ 
			console.log("LogoutBtn Click");
		}
	</script>
</body>
</html>