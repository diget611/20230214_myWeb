<%@page import="kh.member.model.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<jsp:include page="/WEB-INF/view/header.jsp"/>
	<%	
		Object obj = request.getAttribute("myinfo");
		MemberVo vo = null;
		if(obj == null) {
 	%>
 		<h4>로그인 되지 않았습니다.</h4>
		<a href="<%=request.getContextPath()%>/login">로그인 페이지 이동</a>
 	<%
		} else {
			if(obj instanceof MemberVo) {
				vo = (MemberVo)obj;
			}
			if(vo == null) {
				
	%>
			<h4>로그인 되지 않았습니다.</h4>
			<a href="<%=request.getContextPath()%>/login">로그인 페이지 이동</a>	
	<%
			} else {
	%>
				id: <%=vo.getId() %>
				name: <%=vo.getName() %>
				email: <%=vo.getEmail() %>
	<%
			}
		}
	%>
</body>
</html>