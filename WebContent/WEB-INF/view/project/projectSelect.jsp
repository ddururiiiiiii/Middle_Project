<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@page import="kr.or.ddit.project.vo.ProjectOptionVO"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<%
	ProjectVO pv = (ProjectVO)request.getAttribute("pv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	
	List<ProjectOptionVO> listOption = (List<ProjectOptionVO>)request.getAttribute("listOption");
		
	 uv = (UserVO)session.getAttribute("userVO");
	
	long pjNm = pv.getPjNm();

%>    
<!DOCTYPE html>
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/prjDetail.css">
	<style type="text/css">
	div.col-sm-3 {
	background-color: #fafafa;
	border: 1px solid #efefef;
	padding: 20px;
}
#thumImg {
width: 100%;
}
div.col-sm-5 {
padding-top: 0px;
padding-bottom: 0px;
}
div.col-sm-6 {
		background-color: #fafafa;
	border: 1px solid #efefef;
	padding: 20px;
}
#btnDona {
	text-align: right;
}
div#a_head.col-sm-8{
	padding: 0px;
}
div#myNavbar.collapse.navbar-collapse{
padding: 0px;
}
#pjCategory {
		background-color: #fafafa;
	border: 1px solid #efefef;
	text-align: center;
	padding: 10px;
}
.pColor {
	font-weight: bolder;
	color: #40a75f;
}
	</style>
	</head>
<body>
	<!-- 프로젝트 제목 -->
	<div class="col-sm-12">

		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>

		<!-- 제목 -->
		<div class="col-sm-8" id="divCategory">
			<br>
			<br> <span id="pjCategory" name="pjCategory"><%=pv.getPjCategory() %></span>
			<h2><%=pv.getPjName() %></h2>
		</div>

		<!-- 오른쪽 공백 2 -->
		<div class="col-sm-2"></div>

	</div>

	<!-- 프로젝트 사진 / 설명 -->
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>

		<!-- 썸네일 -->
		<div class="col-sm-5">
							<%
					if (atchFileList != null) {
						for (AtchFileVO atchFileVO : atchFileList) {
				%>
				<img src='<%=atchFileVO.getImgUrl()%>' id="thumImg">
				<%
					}
					}
				%>
		</div>
		<!-- 설명 -->
		<div class="col-sm-3">
			<p>목표금액</p>
			<h3>
				<p class="pColor"><%=pv.getPjPriceAmount() %>원</p>
			</h3>
			<p>모인금액</p>
			<h3>
				<p class="pColor"><%=pv.getPjPrice() %>원</p>
			</h3>
			<br>
			<p>프로젝트 마감일</p>
			<h3>
				<p id="Yujin" class="pColor"><%=pv.getPjDday() %></p>
			</h3>
			<br>
			<p>후원자</p>
			<h3>
				<p class="pColor"><%=pv.getPjFan() %>명</p>
			</h3>
			<br>
			<br>
			<br>
			<div id="btnDona">
			<button type="button" class="btn btn-success btn-lg" onclick="goDonation()" id="donate">후원하기</button>
			</div>
			
		</div>

		<!-- 오른쪽 공백 2 -->
		<div class="col-sm-2"></div>
	</div>



	<!-- 프로젝트 옵션 / 상세 설명 -->
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>

		<!-- 옵션 -->
		<div class="col-sm-2">
		<% for(int i = 0; i < listOption.size(); i++){%>
			<div id="divOption">
				<h3><p class="pColor">옵션<%=i+1 %></p></h3><br><br>
				<p>리워드  :<br> <h3><%=listOption.get(i).getPoName() %></h3></p><br>
				<p>리워드 금액  : <h3><%=listOption.get(i).getPoAddPrice() %></h3></p><br>
				<span>리워드 내용 :<br> <%=listOption.get(i).getPoContent() %></p><br>
			</div><br>
			<%
		}
			%>
			<br>
		</div>
		<!-- 상세 설명 -->
		<div class="col-sm-6">
			<h3><p class="pColor">프로젝트 소개</p></h3>
			<p><%=pv.getPjContent() %></p>
		</div>

		<!-- 오른쪽 공백 2 -->
		<div class="col-sm-2"></div>
	</div>

	<form id="fm">
		<input type="hidden" name="pjNm" id="pjNm">
		<input type="hidden" name="flag" id="flag">
	</form>	
<script type="text/javascript">
$(document).ready(function(){


	var yujin = $('#Yujin').text();
	console.log(yujin);

	var sdt = new Date(yujin);
	var edt = new Date();
	var dateDiff = Math.ceil((edt.getTime()-sdt.getTime())/(1000*3600*24));
	console.log("sdt = " + sdt);
	console.log(edt);
	console.log(dateDiff);
	if(dateDiff > 1){
		$("#donate").css("display", "none");
		
	}


});
function optionSelect(pjNm){
	document.getElementById("pjNm").value = pjNm;
	document.getElementById("flag").value = "OPT";
	var fm = document.getElementById("fm");
	fm.method = "post";
	fm.action = "projectBoard.do";
	fm.submit();
}

function goDonation(){
	<%if (session.getAttribute("userVO") == null) {%>
	alert("회원만 후원하실 수 있습니다.");	
	location.href = "/Team_Sprout/user/signIn.do";
<%} else {%>
	document.getElementById("pjNm").value = "<%=pv.getPjNm() %>";
	var fm = document.getElementById("fm");
	fm.method = "post";
	fm.action = "donation.do";
	fm.submit();
	<%}%>
}


<%-- 
function goDonation(){
	document.getElementById("pjNm").value = "<%=pv.getPjNm() %>";
	var fm = document.getElementById("fm");
	fm.method = "post";
	fm.action = "donation.do";
	fm.submit();
} --%>


</script>	
</body>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>