<%@page import="kr.or.ddit.comm.vo.PagingVO"%>
<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@page import="kr.or.ddit.board.vo.CommunityBoardVO"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>

<%
String pjNm = request.getParameter("pjNm");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기게시판</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/board.css">
<style type="text/css">
#menu_title {
	text-align: center;
	background-image: url('/Team_Sprout/images/main_image.png');
	width: 100%;
	height: 250px;
	color: white;
}
div.col-sm-12 {
	margin: 0px;
	padding: 0px;
}
</style>
</head>
<%

	if(session != null && session.getAttribute("userVO") != null){
		uv = (UserVO)session.getAttribute("userVO");
	}
	ProjectVO pj = (ProjectVO) request.getAttribute("pjName");
	PagingVO pv = (PagingVO)request.getAttribute("pv");
%>
<body>
	<!-- 헤더 이미지 및 문구 -->
	<div class="col-sm-12">
		<div id="menu_title">
			<p>
			
			<br><br><br>
				<h3><b>프로젝트 리워드 후기</b></h3>
				<br>
				* 진행된 프로젝트에 대한 후기를 작성하는 곳입니다.
			</p>
		</div>
	</div>
	
	<!-- 전체-->
	<div class="col-sm-12">

		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>

		<!-- 게시판 -->
		<div class="col-sm-8">
		<br><br>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
			<%
			List<CommunityBoardVO> list = (List<CommunityBoardVO>)request.getAttribute("list");
			
			for(int i = 0; i < list.size(); i++) {
				String cbNm = list.get(i).getCbNm();
			%>
			<tr>
				<td><%=list.size() - i %></td>
				<td>
					<a href="#" onclick="boardSelect('<%=cbNm %>')">
						<%=list.get(i).getCbTitle() %>
					</a>
				</td>
				<td><%=list.get(i).getCbWriter() %></td>
				<td><%=list.get(i).getCbDate() %></td>
			</tr>
			<%
			}
			if(list.size() < 1) {
				%>
				<tr>
					<td colspan="5" style="text-align: center">게시글이 없습니다.</td>
				</tr>
				<%
			}
			%>
			</tbody>
		</table>
		<!-- 검색 창 -->
		<div class="text-center">
			<input type="text" id="schInput" placeholder="제목 혹은 작성자">
			<button type="button" class="btn btn-success" onclick="searchBoard()">검색</button>
		</div>
		<hr>
		<!-- 등록 버튼  -->
		<div id="btn" style="text-align: right">
			<button type="button" class="btn btn-success" id="insertBtn" onclick="insertBoard()">등록</button>
		</div>
		<form id="fm">
			<input type="hidden" name="cbNm" id="cbNm">
			<input type="hidden" id="schInput2" name="search">
			<input type="hidden" name="flag" id="flag">
			<input type="hidden" name="pjNm" id="pjNm" value="<%=pjNm%>">
		</form>
		</div>

		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>

	</div>

</body>
<script type="text/javascript">
	$(document).ready(function(){
		<%if(session.getAttribute("userVO") == null){ %>
			$("#insertBtn").hide();
		<%} else {%>
			$("#insertBtn").show();
		<%}%>
	});
	function boardSelect(cbNm){
		document.getElementById("cbNm").value = cbNm;
		document.getElementById("flag").value = "SEL";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "communityBoard.do";
		fm.submit();
	}

	function insertBoard(){
		document.getElementById("flag").value = "C";
		var fm = document.getElementById("fm");
		fm.method = "get";
		fm.action = "communityBoard.do";
		fm.submit();
	}
	
	function searchBoard() {
		document.getElementById("flag").value = "SCH";
		document.getElementById("schInput2").value = $("#schInput").val();
		
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "communityBoard.do";
		fm.submit();
	}
</script>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>