<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/board.css">
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/guide.css">
<style type="text/css">
.btn-group-lg>.btn, .btn-lg {
	padding: 10px 16px;
	font-size: 18px;
	line-height: 1.3333333;
	border-radius: 10px;
}

#selDiv {
	text-align: center;
	background-color: #fafafa;
	border: 1px solid #efefef;
	padding: 20px;
	margin-top: 20px;
	margin-bottom: 20px;
}
</style>
</head>
<body>
	<!-- 전체-->
	<div class="col-sm-12">

		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>

		<!-- 내용 -->
		<div class="col-sm-8" id="selDiv">
			<img src="/Team_Sprout/images/logo_big.png" style="width: 400px;">
			<p>
			<h3>
				<b>마음 속 프로젝트 아이디어, 스프라우트에서 현실로.</b>
			</h3>
			</p>
			<p>
			<h5>
				<b>크라우드펀딩으로 프로젝트를 위한 자금도 모으고, 든든한 후원자 네트워크도 확보할 수 있습니다.</b>
			</h5>
			</p>
			<br>
			<button type="button" class="btn btn-success btn-lg"
				onclick="location.href='/Team_Sprout/html/board/guide.jsp'">
				메이커 가이드</button>
			<button type="button" id="prjInsertBtn"
				class="btn btn-success btn-lg" onclick="moveRegPage()">프로젝트
				올리기</button>
			<br>
			<br>
		</div>

		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>
		<form id="fm">
			<input type="hidden" name="flag" id="flag">
		</form>
	</div>
</body>
<script type="text/javascript">



function moveRegPage(){
	<%if (session.getAttribute("userVO") == null) {%>
	alert("회원만 프로젝트를 등록할 수 있습니다.");	
	location.href = "/Team_Sprout/user/signIn.do";
<%} else {%>
		document.getElementById("flag").value = "C";
		
		var fm = document.getElementById("fm");
		fm.method = "get";
		fm.action = "/Team_Sprout/project/projectBoard.do";
		fm.submit();
<%}%>		
	};
	
	
// function moveRegPage(){
// 		document.getElementById("flag").value = "C";
		
// 		var fm = document.getElementById("fm");
// 		fm.method = "get";
// 		fm.action = "/Team_Sprout/project/projectBoard.do";
// 		fm.submit();
// 	}

</script>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>
