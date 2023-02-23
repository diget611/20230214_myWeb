<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<section>
	<h1>게시글 목록</h1>
	<table>
		<tr>
			<td>글번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성시간</td>
			<td>조회수</td>
		</tr>
		<c:forEach items="${boardList }" var="vo" varStatus="s">
			<%-- <c:set target="${vo }" property="boardTitle" value="aaa"/> --%>
			<tr>
				<td>${vo.boardNum } : ${s.count } : ${s.index }</td>
				<td>${vo.boardTitle }</td>
				<td>${vo.boardWriter }</td>
				<td>${vo.boardDate }</td>
				<td>${vo.boardReadcount }</td>
			</tr>
		</c:forEach>
	</table>
	
	<div>
		<h3>페이지 처리</h3>
		<c:if test="${startPageNum > 1}">
			<span>이전</span>
		</c:if>
		<div>
			<c:forEach begin="${startPageNum }" end="${endPageNum }" step="1" var="page">
				<c:choose>
					<c:when test="${page == currentPage }">
						<span><b>&nbsp;${page }&nbsp;&nbsp;</b></span>
					</c:when>
					<c:otherwise>
						<span><a href="<%=request.getContextPath()%>/?aaa=${page}">&nbsp;${page }&nbsp;&nbsp;</a></span>
					</c:otherwise>
				</c:choose>
				
			</c:forEach>
		</div>
		<c:if test="${endPageNum < pageCnt }">
			<span>다음</span>
		</c:if>
	</div>
	<hr>
</section>