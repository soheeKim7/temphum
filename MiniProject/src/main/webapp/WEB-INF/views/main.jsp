<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="resources/css/style.css">
<link rel="stylesheet" href="resources/css/style2.css">
<title>305교실 환경</title>
</head>
<body>
<script 
		src="https://code.jquery.com/jquery-3.6.3.min.js"
		integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU="
		crossorigin="anonymous"></script>

<h1>우리집 환경 실태</h1>
<ul>
	<li><h3>현재의 온도, 습도, 불쾌지수 조회 <button>조회</button></h3> <button id="test">테스트</button></li>
   	<ul>
   		<li>온도 : <span id="temp"></span> <span id="comparetemp"></span></li>
   		<li>습도 : <span id="hum"></span> <span id="comparehum"></span></li>
   		<li>불쾌지수 : <span id="discom"></span> <span id="comparediscom"></span></li>  	
   	</ul>

    <li><h3>오늘(<fmt:formatDate value="${todaydate }" pattern="yyyy년 MM월 dd일 E요일"/>)의 상황</h3> </li>
    <h3>(현재시간 <fmt:formatDate value="${todaydate }" pattern="a hh시:mm분"/> 기준)</h3>
          
    <script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>
		
	<figure class="highcharts-figure" >
	  <div id="container"></div>
	</figure>
    <h3>불쾌지수 치수</h3>
    
   <table cellspacing="0" style="text-align: center;" border="1">
		<thead>
			<tr>
				<th >불쾌지수</th>							
				<th >이모티콘</th>
				<th>상태</th>
				<th>설명</th>		
			</tr>
		</thead>
		<tbody>
				<tr>
					<td>80이상~</td>
					<td><img src="resources/img/매우불쾌.png" width="50"; height="50"></td>
					<td>매우 높음</td>
					<td>전원 불쾌감을 느낌. 높은 습도 탓에 땀이 증발하지 않아 몸이 끈적임</td>		
				</tr>
				<tr>
					<td>75~80</td>
					<td><img src="resources/img/불쾌.png" width="50"; height="50"></td>
					<td>높음</td>
					<td>불쾌감을 느끼기 시작하여 일부는 땀이 남</td>		
				</tr>
				<tr>
					<td>68~75</td>
					<td><img src="resources/img/보통.png" width="50"; height="50"></td>
					<td>보통</td>
					<td>불쾌감을 느끼기 시작하여 일부는 땀이 남</td>		
				</tr>
				<tr>
					<td>~68미만</td>
					<td><img src="resources/img/낮음.png" width="50"; height="50"></td>
					<td>낮음</td>
					<td>전원 쾌적함을 느낌</td>		
				</tr>
		</tbody>
	</table>
    
    <script src="https://cdn.amcharts.com/lib/5/index.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/xy.js"></script>
	<script src="https://cdn.amcharts.com/lib/5/themes/Animated.js"></script>
	<div id="chartdiv"></div>    
   
</ul>



<script> 


	$(document).ready(function(){
		
		$("#test").on("click", function() {
			$.ajax({
				type : "get",
				url : "/mini/api/test",
				timeout: 60000, 
				success : function(data) {
					//값을 보내고 결과받아온 값! 
					console.log("test 받아온 값 : ", data);
					var temp=data.substr(0,2);
					var hum=data.substr(2);
					//var temp=data.temp;
					//var hum=data.hum;
					console.log("온도 : ",temp);
					console.log("습도 : ",hum);
					//var temp=Number(tempStr);
					//var hum=Number(humStr);
					//console.log("잘 변환 되었나?",typeof temp,typeof hum);
					var discom=(0.81*temp+0.01*hum*(0.99*temp-14.3)+46.3);
					console.log("반올림 전값 인데 어디 한번 보자~",discom);
					discom=discom.toFixed(2);
					console.log("반올림 잘되나~",discom);
					console.log("지금 값들 잘 가지고 있는 건가?? : ",temp,hum,discom);					
					comparedata(temp,hum,discom);
					$("#temp").text(temp+"°C");
					$("#hum").text(hum+"%");
					$("#discom").text(discom);					
				},
				error : function(error){
					$("#temp").text("오류");
					$("#hum").text("오류");
					$("#discom").text("오류");
				}			
			});						
		});
		
		$("button").on("click", function() {
			$.ajax({
				type : "get",
				url : "http://59.12.4.106:7777",
				timeout: 60000, 
				success : function(data) {
					//값을 보내고 결과받아온 값! 
					console.log("받아온 값 : ", data);
					var temp=data.substr(0,2);
					var hum=data.substr(2);
					//var temp=data.temp;
					//var hum=data.hum;
					console.log("온도 : ",temp);
					console.log("습도 : ",hum);
					//var temp=Number(tempStr);
					//var hum=Number(humStr);
					//console.log("잘 변환 되었나?",typeof temp,typeof hum);
					var discom=(0.81*temp+0.01*hum*(0.99*temp-14.3)+46.3);
					console.log("반올림 전값 인데 어디 한번 보자~",discom);
					discom=discom.toFixed(2);
					console.log("반올림 잘되나~",discom);
					console.log("지금 값들 잘 가지고 있는 건가?? : ",temp,hum,discom);					
					comparedata(temp,hum,discom);
					$("#temp").text(temp+"°C");
					$("#hum").text(hum+"%");
					$("#discom").text(discom);					
				},
				error : function(error){
					$("#temp").text("오류");
					$("#hum").text("오류");
					$("#discom").text("오류");
				}			
			});						
		});
		
				
		
		function comparedata(temp,hum,discom){
			$.ajax({
				type : "get",
				url : "/mini/api/compare",
				dataType : "json",
				timeout: 60000, 
				success : function(data) {
					//값을 보내고 결과받아온 값! 
					console.log("받아온 값 : ", data);
					
					var comparetemp=data.temp;
					var comparehum=data.hum;
					var comparediscom=data.discom;
					
					console.log("비교할 데이터 값들 잘 받아오나? : ",comparetemp,comparehum,comparediscom);
					console.log("이러면 값들 이어서 잘 가지고 오는건가??? : ",temp,hum,discom);
					
					if(comparetemp<temp){
						$("#comparetemp").text("("+(temp-comparetemp)+"°C ▲)");
					}else if(comparetemp==temp){
						$("#comparetemp").text("(0°C -)");
					}else{
						$("#comparetemp").text("("+(comparetemp-temp)+"°C ▼)");						
					}
					
					if(comparehum<hum){
						$("#comparehum").text("("+(hum-comparehum)+"% ▲)");						
					}else if(comparehum==hum){
						$("#comparehum").text("(0% -)");
					}else{					
						$("#comparehum").text("("+(comparehum-hum)+"°C ▼)");												
					}
					var result;
					if(comparediscom<discom){
						result=discom-comparediscom;
						console.log("값 계산 한 거 : ",result);
						result=result.toFixed(2);
						console.log("값 계산 한 거,변환 후~ : ",result);
						$("#comparediscom").text("("+result+" ▲)");								
					}else if(comparediscom==discom){
						$("#comparediscom").text("(0 -)");
					}else{			
						result=comparediscom-discom;
						console.log("값 계산 한 거 : ",result);
						result=result.toFixed(2);
						console.log("값 계산 한 거,변환 후~ : ",result);
						$("#comparediscom").text("("+result+" ▼)");								
					}				
				},
				error : function(error){
					$("#comparetemp").text("오류");
					$("#comparehum").text("오류");
					$("#comparediscom").text("오류");
				}			
			});
		};
		
	

	});


</script>

<script>	
	var myprodate;
	var mytemp;
	var myhum;
	var mydiscom;
	
	$.ajax({
		type : "get",
		url : "/mini/api/chart",
		dataType : "json", // 받아오는 데이터 생략 가능
		//contentType : 보내는거 없음
		success : function(data) {
			console.log("데이터 어떻게 가져오나 보자~",data);
			myprodate = data.myprodate;
			mytemp = data.mytemp;
			myhum = data.myhum;
			mydiscom = data.mydiscom;
			mychart();
			//mychart2();
			console.log("받아온 데이터들 : ", myprodate, mytemp, myhum,mydiscom);
		}
	});
	
	$.ajax({
		type : "get",
		url : "/mini/api/discomChart",
		dataType : "json", // 받아오는 데이터 생략 가능
		//contentType : 보내는거 없음
		success : function(data) {
			console.log("불쾌지수 데이터 어떻게 가져오나 보자~",data);
			var mydata=data;
			mychart2(mydata);
			//console.log("받아온 데이터들 : ", myprodate, mytemp, myhum,mydiscom);
		}
	});
	
	
</script>




<script  src="resources/js/script.js"></script>
<script  src="resources/js/script2.js"></script>


</body>
</html>