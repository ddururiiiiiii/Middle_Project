<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.ReportBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<%
	ReportBoardVO rbv = (ReportBoardVO) request.getAttribute("rbv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");

	uv = (UserVO) session.getAttribute("userVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/boardDetail.css">
</head>
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
.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
    width: 10px;
}
</style>
</head>
<body>
	<!-- 헤더 이미지 및 문구 -->
	<div class="col-sm-12">
		<div id="menu_title">
			<p>
			
			<br><br><br>
				<h3><b>신고 게시판</b></h3>
				<br>
				* 이용 중 불편을 주는 회원에 대한 신고 게시판입니다.
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
			<table class="table">
				<thead>
					<tr id="head">
						<th>번호</th>
						<td><%=rbv.getReportNm()%></td>
						<th>작성일</th>
						<td><%=rbv.getReportDate()%></td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th>작성자</th>
						<td colspan="3"><%=rbv.getReportWriter()%></td>
					</tr>
					<tr>
						<th>제목</th>
						<td colspan="3"><%=rbv.getReportTitle()%></td>
					</tr>
					<tr>
						<th>내용</th>
						<td colspan="3"><%=rbv.getReportContent()%></td>
					</tr>
					<tr>
					<th>첨부파일</th>
					<td colspan="3">
						<%
					if(atchFileList != null){
						for(AtchFileVO atchFileVO : atchFileList){
					%>
						<div>
							<a
							href="<%=request.getContextPath() %>/filedownload.do?fileId=<%=atchFileVO.getAtchFileId() %>&fileSn=<%=atchFileVO.getFileSn()%>">
							<%=atchFileVO.getOrignlFileNm() %></a>
						</div>
						<%	
						}
					}
					%>
				</td>
					</tr>
				</tbody>
			</table>
			<form id="fm" enctype="multipart/form-data">
				<input type="hidden" name="reportNm" id="reportNm">
				<input type="hidden" name="flag" id="flag">
			</form>
			<hr>
			<!-- 등록 수정 삭제 버튼  -->
			<div id="btn" align="right">
				<button type="button" class="btn btn-success" onclick="goList()">목록</button>
				<button type="button" id="updateWrite" class="btn btn-success"
					onclick="updateBoard()">수정</button>
				<button type="button" id="deleteWrite" class="btn btn-success"
					onclick="deleteBoard()">삭제</button>
			</div>
			<hr>
		</div>
		
		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>
		
	</div>
</body>
	<script type="text/javascript">
	$(document).ready(function(){
		$("#updateWrite").css("display", "none");
		$("#deleteWrite").css("display", "none");
		<%
		if(uv != null){
			if(uv.getUserNickName().equals(rbv.getReportWriter())){
			%>
				$("#updateWrite").css("display", "inline");
				$("#deleteWrite").css("display", "inline");
			<%
			}
		}
		%>
	});
	
	function goList(){
		location.href = "reportBoard.do";
	}
	
	function updateBoard(){
		document.getElementById("reportNm").value = "<%=rbv.getReportNm() %>";
		document.getElementById("flag").value = "UPD";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "reportBoard.do";
		fm.submit();
	}
	
	function deleteBoard(){
		if(confirm("정말로 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			document.getElementById("reportNm").value = "<%=rbv.getReportNm() %>";
			document.getElementById("flag").value = "D";
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "reportBoard.do";
			fm.submit();
		} else {
			return;
		}
	}
	</script>

<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>