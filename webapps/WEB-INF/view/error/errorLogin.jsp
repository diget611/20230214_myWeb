<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>error</title>
</head>
<body>
	<script>
		// var errMsg = "<%=(String)request.getAttribute("errMsg") %>";
		var errMsg = '${errMsg }';
		alert(errMsg);
	</script>
	<h4>로그인 되지 않았습니다.</h4>
	<a href="<%=request.getContextPath()%>/login">로그인 페이지 이동</a>
</body>
</html>