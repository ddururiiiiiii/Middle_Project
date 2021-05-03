<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Sprout</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Lato"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat"
	rel="stylesheet" type="text/css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="../../css/main/main.css">
<style type="text/css">
</style>
<script type="text/javascript">
	function LogOut(){
		if(confirm("로그아웃 하시겠습니까?")){
			alert("로그아웃 되었습니다.");
			location.href = "/Team_Sprout/user/logOut.do";
		}
		return;
	}
</script>
</head>
<body>
<%
	UserVO uv = null;
	if(session != null && session.getAttribute("userVO") != null){
		uv = (UserVO)session.getAttribute("userVO");
	}
%>
	<nav class="navbar">
		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>
		<!-- nav바 -->
		<div class="col-sm-8" id="a_head">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img src="../../images/logo.png" width="100px"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="#" class="a_title">인기펀딩</a></li>
					<li><a href="#" class="a_title">마감임박펀딩</a></li>
					<li><a href="#" class="a_title">어쩌구펀딩</a></li>
					<li><a href="#" class="a_title">저쩌구펀딩</a></li>
				</ul>				
				<ul class="nav navbar-nav navbar-right">
					<%
					if(uv == null) {
					%>
					<li><a href="#" class="btn-lg"><span
							class="glyphicon glyphicon-search"></span></a></li>
					<li id="notlog"><a href="../login/login.jsp" class="btn-lg"><span
							class="glyphicon glyphicon-user"></span></a></li>
					<%
					} else {
					%>
					<li id="userInfo"><a href="#" class="btn-lg"><span
							class="glyphicon" id="mypage"><%=uv.getUserNickName() %></span></a></li>
					<li id="yeslog"><a href="#" onclick="LogOut()" class="btn-lg"><span
							class="glyphicon">LOGOUT</span></a></li>
					<%	
					}
					%>
				</ul>
			</div>
		</div>
	<!-- 오른쪽 여백 -->
	<div class="col-sm-2"></div>
	</nav>
	
	<!-- 상단 이미지 12 -->
	<div class="container-fluid bg-3 text-center" id="bodymargin">
		<!-- top -->
		<div class="col-sm-12" id="main_Image">
			<p id="main_Slogan">
				개인부터 스타트업 까지!<br> 미래를 자라나게 하는 가장 손쉬운 방법, 스프라우트<br>
				당신의 펀딩을 응원합니다.
			</p>
		</div>	
	</div>	
		<!-- main 12-->
		<div class="col-sm-12">
			<div class="col-sm-2"></div>
			<div class="col-sm-8">
			<h3 style="text-align:left; font-weight: bold">진행중인 펀딩</h3><br>
			</div>
			<div class="col-sm-2"></div>
		</div>

	<!-- 펀딩 리스트 12 -->	
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>
		
		<!-- 1번 항목 2-->
		<div class="col-sm-2">
			<img src="../../images/img1.jpg" class="img-rounded" style="width: 100%"
				alt="Image">
			<h4><a href="#">세상에 오직 하나, 한국의 판타지 아이템 도감</a></h4>
			<p>
				<a href="#">아트북</a> | <a href="#">도감화화</a>
			</p>
			<div class="thumText">
				<p>300여종의 찬란하고 신비한 한국의 판타지 아이템/도구들을 기록한 도감입니다</p>
			</div>	
			<span class="gold">120% 달성</span>
			<progress value="100" max="100"></progress>
			<div class="time">
				<span class="glyphicon glyphicon-time"></span>
				<span>4일 남음</span>
			</div>
		</div>

		<!-- 2번 항목 2-->		
		<div class="col-sm-2">
			<img src="../../images/img2.jpg" class="img-rounded" style="width: 100%"
				alt="Image">
			<h4><a href="#">같이 먹어요! 바스크 치즈 케이크와 딸기 라떼 베이스</a></h4>
			<p>
				<a href="#">베이킹 · 디저트</a> | <a href="#">글라소디</a>
			</p>
			<div class="thumText">
				<p>자급자족 간식에서 프로젝트 메뉴로! 바스크 치즈 케이크 2종과 딸기 라떼 베이스 제작기</a></p>
			</div>	
			<span class="gold">234% 달성</span>
			<progress value="100" max="100"></progress>
			<div class="time">
				<span class="glyphicon glyphicon-time"></span>
				<span>12일 남음</span>
			</div>
		</div>
		
		<!-- 3번 항목 2-->	
		<div class="col-sm-2">
			<img src="../../images/img3.png" class="img-rounded" style="width: 100%"
				alt="Image">
			<h4><a href="#">제대로 즐기게 해 주는 MoMA 미술관 도슨트 북</a></h4>
			<p>
				<a href="#">실용 · 취미</a> | <a href="#">SUN</a>
			</p>
			<div class="thumText">
				<p>뉴욕 모마 미술관 MoMA 작품 해설 가이드 북, 유명한 작품에서 감동을 주는 작품으로!</p>
			</div>	
			<span class="gold">78% 달성</span>
			<progress value="78" max="100"></progress>
			<div class="time">
				<span class="glyphicon glyphicon-time"></span>
				<span>7일 남음</span>
			</div>
		</div>
		
		<!-- 4번 항목 2-->		
		<div class="col-sm-2">
			<img src="../../images/img4.jpg" class="img-rounded" style="width: 100%"
				alt="Image">
			<h4><a href="#">코디 걱정 없이 편하게, '나봄 저고리 셔츠 허리치마'</h4>
			<p>
				<a href="#">의류 </a> | <a href="#">charim(차림)</a>
			</p>
			<div class="thumText">
				<p>내가 가지고 있는 일상복과도 매치하기 쉬운 한복, 나봄 저고리 셔츠&허리치마</p>
			</div>	
			<span class="gold">65% 달성</span>
			<progress value="65" max="100"></progress>
			<div class="time">
				<span class="glyphicon glyphicon-time"></span>
				<span>1일 남음</span>
			</div>
		</div>
		
	<!-- 여백 2-->	
	<div class="col-sm-2"></div>
	</div>
	
	<!-- top -->
	<a style="display: scroll; position: fixed; bottom: 40px; right: 40px;"
		href="#" title="top"><img src="../../images/topbutton.png" width="40px"></a>

	<!-- footer -->
	<footer class="container-fluid text-center">
		<br><br>
		<p>Design By Seul-gi</p>
		<p>
			스프라우트는 플랫폼 제공자로서 프로젝트의 당사자가 아니며, 직접적인 통신판매를 진행하지 않습니다.<br> 프로젝트의
			완수 및 선물제공의 책임은 해당 프로젝트의 창작자에게 있으며,<br> 프로젝트와 관련하여 후원자와 발생하는 법적
			분쟁에 대한 책임은 해당 창작자가 부담합니다.
		</p>
		<p>스프라우트(주) | 스프라우트 123-45-67890 | 대전광역시 중구, 영민빌딩 4층 ddit 403호 |
			통신판매업 2021-1234-1234-123 | 대표전화 042) 000-1234</p>
	</footer>
</body>
</html>

