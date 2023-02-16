<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
	<div>
		<c:choose>
			<c:when test="${empty lgnss }">
				<button type="button" class="btn login">로그인</button>	
			</c:when>
			<c:otherwise>
				<button type="button" class="btn logout">로그아웃</button>			
			</c:otherwise>
		</c:choose>
	</div>
	<div>
		<% if(session.getAttribute("lgnss") == null) { %>
		<button type="button" class="btn login">로그인</button>				
		<% } else { %>
		<button type="button" class="btn logout">로그아웃</button>
		<% } %>
	</div>
	<hr>
	<script>
		$(".btn.login").on("click", handlerClickBtnLogin);
		$(".btn.logout").on("click", handlerClickBtnLogout);
		$(".btn.myinfo").on("click", handlerClickBtnMyinfo);
		
		function handlerClickBtnLogin(){
			console.log("LoginBtn Click");
			location.href="<%=request.getContextPath()%>/login";
		}
		function handlerClickBtnLogout(){ 
			console.log("LogoutBtn Click");
			location.href="<%=request.getContextPath()%>/logout"
		}
		function handlerClickBtnMyinfo(){
			location.href="<%=request.getContextPath()%>/myinfo";
		}
	</script>
</header>