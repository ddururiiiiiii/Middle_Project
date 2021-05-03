<%@page import="kr.or.ddit.board.vo.FaqBoardVO"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/adminHead.jsp"%>
<%
	FaqBoardVO fbv = (FaqBoardVO)request.getAttribute("fbv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	
	AtchFileVO atchVO = new AtchFileVO();
	
	UserVO uv = (UserVO)session.getAttribute("userVO");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/adminBoard.css">
</head>
<body>
	<div class="col-sm-12">

		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>

		<!-- 게시판 -->
		<div class="col-sm-8">
		<h4>
				<b>FAQ</b>
			</h4>
			<table class="table">
			<thead>
				<tr id="head">
					<th>번호</th>
					<td><%=fbv.getFaqNm() %></td>
					<th>작성일</th>
					<td><%=fbv.getFaqDate() %></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>작성자</th>
					<td colspan="3"><%=fbv.getFaqWriter() %></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><%=fbv.getFaqTitle() %></td>
				</tr>
				<tr>
					<th>내용</th>
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
			<input type="hidden" name="faqNm" id="faqNm">
			<input type="hidden" name="flag" id="flag">
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
// 	$(document).ready(function(){
// 		$("#updateWrite").css("display", "none");
// 		$("#deleteWrite").css("display", "none");
<%-- 		<% --%>
// 		if(uv != null){
// 			if(!uv.getUserNickName().equals(fbv.getFaqWriter())){
<%-- 			%> --%>
// 			$("#updateWrite").css("display", "inline");
// 			$("#deleteWrite").css("display", "inline");
<%-- 			<% --%>
// 			}
// 		}
<%-- 		%> --%>
// 	});
	
	function goList(){
		location.href = "adminFaqBoard.do";
	}
	
	function updateBoard(){
		document.getElementById("faqNm").value = "<%=fbv.getFaqNm() %>";
		document.getElementById("flag").value = "UPD";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminFaqBoard.do";
		fm.submit();
	}
	
	function deleteBoard(){
		if(confirm("정말로 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			document.getElementById("faqNm").value = "<%=fbv.getFaqNm() %>";
			document.getElementById("flag").value = "D";
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "adminFaqBoard.do";
			fm.submit();
		} else {
			return;
		}
	}
	
</script>
</html>