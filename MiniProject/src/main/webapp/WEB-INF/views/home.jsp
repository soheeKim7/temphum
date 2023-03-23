<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
<%--
<table width="100%" cellspacing="0" style="text-align: center;">
		<thead>
			<tr>
				<th width="15%">순번 (글번호)</th>							
				<th width="35%">날짜</th>
				<th>온도</th>
				<th>습도</th>							
				<th>불쾌지수</th>	
			</tr>
		</thead>
		<tbody>
			<c:set var="no" value="0"></c:set>
			<c:forEach items="${list }" var="data">
				<tr>
					<td><c:out value="${no=no+1}" /></td>
					<td><fmt:formatDate pattern="yyyy년MM월dd일 a HH:mm:ss"	value="${data.prodate}" /></td>
					<td><c:out value="${data.temp }" /></td>
					<td><c:out value="${data.hum}" /></td>		
					<td><c:out value="${data.discom}" /></td>			
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

 --%>




</html>
