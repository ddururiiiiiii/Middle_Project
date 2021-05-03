<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.boardComment.vo.NoticeCmVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.NoticeBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
    
<%
/* UserVO uv = (UserVO)session.getAttribute("userVO");
String userNick = "";
if(uv == null) {
	
} else {
userNick = uv.getUserNickName();

}
 */
//NoticeBoard
NoticeBoardVO noticeVO = (NoticeBoardVO) request.getAttribute("nv");
List<AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
List<NoticeCmVO> noticeCmList = (List<NoticeCmVO>)request.getAttribute("noticeCmList");
if(noticeCmList == null){
	noticeCmList = new ArrayList<NoticeCmVO>();
}
 uv = (UserVO)session.getAttribute("userVO");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 상세조회</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/boardDetail.css">
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
<body>
<!-- 헤더 이미지 및 문구 -->
	<div class="col-sm-12">
		<div id="menu_title">
			<p>
			<br><br><br>
				<h3><b>공지</b></h3>
				<br>
				* 메이커/서포터에게 전하는 안내
			</p>
		</div>
	</div>  
	<!-- 전체-->
	<div class="col-sm-12">

		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>

		<!-- 게시판 -->
		<div class="col-sm-8">
			<table class="table">
			<thead>
				<tr id="head">
					<th>번호</th>
					<td><%=noticeVO.getNoticeNm()%></td>
					<th>작성일</th>
					<td><%=noticeVO.getNoticeDate()%></td>
				</tr>
			</thead>
				<tr>
					<th>작성자</th>
					<td colspan="3"><%=noticeVO.getNoticeWriter()%></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><%=noticeVO.getNoticeTitle()%></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><%=noticeVO.getNoticeContent()%></td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"><%
				if(atchFileList != null){
					for(AtchFileVO atchFileVO : atchFileList){
				%>
				<div>
					<a
						href="<%=request.getContextPath() %>/filedownload.do?fileId=<%=atchFileVO.getAtchFileId() %>&fileSn=<%=atchFileVO.getFileSn()%>">
						<%=atchFileVO.getOrignlFileNm() %></a>
				</div> <%	
					}
				}
				%></td>
				</tr>
			<tbody>
			</table>
			
			<form id="fm" enctype="multipart/form-data">
				<input type="hidden" name="noticeNm" id="noticeNm">
				<input type="hidden" name="noticeTitle" id="noticeTitle">
				<input type="hidden" name="noticeContent" id="noticeContent">
			</form>
		<hr>
			<!-- 등록 수정 삭제 버튼  -->
		<div id="btn" align="right">
			<button type="button" class="btn btn-success" onclick="goList()">목록</button>
			<button type="button" id="updateWrite" class="btn btn-success" onclick="updateBoard()">수정</button>
			<button type="button" id="deleteWrite" class="btn btn-success" onclick="deleteBoard()">삭제</button>
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
			if(!uv.getUserNickName().equals(noticeVO.getNoticeWriter())){
			%>
			$("#updateWrite").css("display", "inline");
			$("#deleteWrite").css("display", "inline");
			<%
			}
		}
		%>
	});
	
	function goList(){
		location.href = "noticeBoard.do";
	}
	
	function updateBoard(){
		document.getElementById("noticeNm").value = "<%=noticeVO.getNoticeNm() %>";
		document.getElementById("flag").value = "UPD";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "noticeBoard.do";
		fm.submit();
	}
	
	function deleteBoard(){
		if(confirm("정말로 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			document.getElementById("noticeNm").value = "<%=noticeVO.getNoticeNm() %>";
			document.getElementById("flag").value = "D";
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "noticeBoard.do";
			fm.submit();
		} else {
			return;
		}
	}
	
</script>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>