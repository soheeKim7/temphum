# 우리집 환경 실태 모니터링 서비스
## 1. 개요
- NodeMCU를 이용한 우리집의 온도, 습도 센서 정보 수집 
- 측정한 온도, 습도 Data를 제공하는 API 서버 구축
- 정각마다 온도, 습도를 측정하여 DB에 저장
- 실시간으로 온도, 습도, 불쾌지수를 조회하는 기능 구현
- 현재 시간을 기준으로 조회되는 온도, 습도, 불쾌지수 그래프 구현

## 2. 주요 기술 및 개발환경
- 주요 기술 : Arduino NodeMCU, Spring Framework(mybatis, Maven 등), Oracle, Ajax
- 개발 환경 : JDK 1.8, Tomcat 9.0.17, Spring Tool Suite(STS), Oracle 11g

## 3. 웹 사이트 주소 및 API 서버 주소
- 웹 사이트 주소 : http://m-it.iptime.org:4280/mini/main
- API 서버 주소 : http://59.12.4.106:7777

## 4. 메인 화면
![메인화면](https://github.com/soheeKim7/temphum/blob/main/MiniProject/etc/main.JPG)
![메인화면밑](https://github.com/soheeKim7/temphum/blob/main/MiniProject/etc/main2.png)

|기능|화면|기능 상세설명|
|:---:|:---:|:---|
|프로그램 구조 설계|![program](https://github.com/soheeKim7/temphum/blob/main/MiniProject/etc/program.png)|● Wifi를 이용해서 NodeMCU와 공유기를 연결하고, API Sever 구축 <br> ● 이때 공유기의 포트포워딩을 이용하여, API Sever를 다른 기기에서도 접속할 수 있도록 구현 <Br> ● Controller를 통해 필요할 때마다, API Sever에서 온도, 습도 Data 습득하여 DB에 저장|



