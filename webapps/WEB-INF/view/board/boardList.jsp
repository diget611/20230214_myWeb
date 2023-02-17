<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<section>
	<h1>게시글 목록</h1>
	<table>
		<thead>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
		</thead>
		<tbody>
			<c:forEach items="${boardList }" var="vo">
				<tr>
					<td>${vo.boardNum }</td>
					<td>${vo.boardTitle }</td>
					<td>${vo.boardWriter }</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	<hr>
</section>