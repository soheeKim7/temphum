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
<h1><a href="main">온도,습도 보러가기</a></h1>

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
	
    80이상~  <img src="resources/img/매우불쾌.png" width="50"; height="50">매우 높음 = 전원 불쾌감을 느낌. 높은 습도 탓에 땀이 증발하지 않아 몸이 끈적임 <br>
	75~80    <img src="resources/img/불쾌.png" width="50"; height="50">높음 = 불쾌감을 느끼기 시작하여 일부는 땀이 남 <br>
	68~75    <img src="resources/img/보통.png" width="50"; height="50">보통 = 불쾌감을 느끼기 시작하며 일부는 땀이 남 <br>
	~68미만  <img src="resources/img/낮음.png" width="50"; height="50">낮음 = 전원 쾌적함을 느낌 <br>

 --%>




</html>
