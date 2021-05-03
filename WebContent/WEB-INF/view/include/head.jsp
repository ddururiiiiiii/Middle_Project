<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>당신을 위한 크라우드 펀딩, 스프라우트</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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

<!-- Channel Plugin Scripts -->
<script>
  (function() {
    var w = window;
    if (w.ChannelIO) {
      return (window.console.error || window.console.log || function(){})('ChannelIO script included twice.');
    }
    var ch = function() {
      ch.c(arguments);
    };
    ch.q = [];
    ch.c = function(args) {
      ch.q.push(args);
    };
    w.ChannelIO = ch;
    function l() {
      if (w.ChannelIOInitialized) {
        return;
      }
      w.ChannelIOInitialized = true;
      var s = document.createElement('script');
      s.type = 'text/javascript';
      s.async = true;
      s.src = 'https://cdn.channel.io/plugin/ch-plugin-web.js';
      s.charset = 'UTF-8';
      var x = document.getElementsByTagName('script')[0];
      x.parentNode.insertBefore(s, x);
    }
    if (document.readyState === 'complete') {
      l();
    } else if (window.attachEvent) {
      window.attachEvent('onload', l);
    } else {
      window.addEventListener('DOMContentLoaded', l, false);
      window.addEventListener('load', l, false);
    }
  })();
  ChannelIO('boot', {
    "pluginKey": "d5ea585a-53ab-49c7-8de2-140d6af4b514"
  });
  
  
</script>
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
				<a href="/Team_Sprout/main/main.do"><img
					src="/Team_Sprout/images/logo.png" id="logoImg"
					style="width: 100px; margin: 5px;"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/Team_Sprout/project/projectBoard.do">프로젝트 목록</a></li>

					<li><a href="/Team_Sprout/html/board/prjGuideOrUplode.jsp"
						class="a_title">프로젝트 올리기</a></li>
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">커뮤니티 <span
							class="glyphicon glyphicon-chevron-down"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/Team_Sprout/board/noticeBoard.do">공지사항</a></li>
							<li><a href="/Team_Sprout/board/freeBoard.do"
								class="a_title">자유커뮤니티</a></li>
<!-- 							<li><a href="/Team_Sprout/board/communityBoard.do">구매후기</a></li> -->
							<li><a href="/Team_Sprout/board/faqBoard.do">FAQ</a></li>
							<li><a href="/Team_Sprout/board/qnaBoard.do">Q&#38;A</a></li>
							<li><a href="/Team_Sprout/board/reportBoard.do">신고</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<%
					if(uv == null) {
					%>
					<li id="notlog"><a href="/Team_Sprout/user/signIn.do"
						class="btn-lg"><span class="glyphicon glyphicon-user"></span></a></li>
					<%
					} else {
					%>
					<li id="userInfo" class="dropdown"><a class="btn-lg"
						class="dropdown-toggle" data-toggle="dropdown" href="#"> <span
							id="mypage"> <%=uv.getUserNickName() %> 님 <span
								class="glyphicon glyphicon-chevron-down"></span></span>
					</a>
						<ul class="dropdown-menu">
							<%if("Y".equals(uv.getAdminCk())) {%>
							<li><a href="/Team_Sprout/html/admin/adminMain.jsp">관리자페이지</a></li>
							<%} %>
							<li><a href="/Team_Sprout/mypage/userInfo.do">회원정보</a></li>
							<li><a href="/Team_Sprout/mypage/userPointHandler.do">포인트충전/환불</a></li>
							<li><a href="/Team_Sprout/mypage/myOrder.do">후원현황</a></li>
							<li><a href="/Team_Sprout/user/selfmadeProject.do">내가 만든
									프로젝트</a></li>
						</ul></li>

					<li id="yeslog"><a href="#" onclick="LogOut()" class="btn-lg">
							<span><span class="glyphicon glyphicon-log-out"></span>
								LOGOUT</span>
					</a></li>
					<%	
					}
					%>
				</ul>
			</div>
		</div>
</body>
</html>