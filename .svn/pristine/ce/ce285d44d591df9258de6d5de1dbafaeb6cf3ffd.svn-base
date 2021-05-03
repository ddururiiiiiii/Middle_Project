<%@page import="kr.or.ddit.board.vo.CommunityBoardVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
	<%@include file="/WEB-INF/view/include/adminHead.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CommunityBoardVO cbv = (CommunityBoardVO)request.getAttribute("cbv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Q&A 수정</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="../../css/main/boardWrite.css">

</head>
<body>
	<!-- 테이블 -->
	<div class="container">
		<h4><b><span>Q&A 수정</span></b></h4>
		<table class="table">
			<thead>
			</thead>
			<tbody>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" class="form-control" id="title" placeholder="제목을 입력해주세요."
							value="<%=cbv.getCbTitle() %>">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea class="form-control" id="content" rows="20"
							placeholder="내용을 입력해주세요."><%=cbv.getCbContent() %></textarea></td>
				</tr>
				<%
				if (atchFileList != null) {
				%>
				<tr>
					<td>기존 첨부파일 :</td>
					<td>
				<%
					for (AtchFileVO atchFileVO : atchFileList) {
				%>
						<div>
							<a
							href="<%=request.getContextPath()%>/filedownload.do?fileId=<%=atchFileVO.getAtchFileId()%>
	                        &filesn=<%=atchFileVO.getFileSn()%>">
							<%=atchFileVO.getOrignlFileNm()%>
							</a>
						</div> 
				<%
 					}
				%>
					</td>
				</tr>
				<%
 				}
				 %>
				<tr>
					<td>새로운 첨부파일</td>
					<td>
						<form id="fm" enctype="multipart/form-data">
							<input type="hidden" id="fmNm" name="cbNm">
							<input type="hidden" id="fmTitle" name="cbTitle">
							<input type="hidden" id="fmContent" name="cbContent">
							<input type="file" multiple="multiple" id="attachFile" name="atchFileId" onchange="setThumbnail()" 
									value="<%=cbv.getAtchFileId() %>">
							<input type="hidden" name="flag" id="flag">
						</form>	
					</td>
				</tr>
			</tbody>
		</table>
		<hr>
		<!-- 등록 수정 삭제 버튼  -->
		<div id="btn" align="right">
			<button type="button" class="btn btn-success" onclick="cancel()">취소</button>
			<button type="button" class="btn btn-success" onclick="upload()">수정</button>
		</div>
		
	</div>
</body>
<script type="text/javascript">
	function upload(){
		if(confirm("게시글을 수정 하시겠습니까?")){
			alert("게시글 수정이 완료되었습니다.");
			document.getElementById("fmNm").value = "<%=cbv.getCbNm() %>";
			document.getElementById("fmTitle").value = $("#title").val();
			document.getElementById("fmContent").value = $("#content").val();
			document.getElementById("flag").value = "U";
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "adminCommunityBoard.do";
			fm.submit();
		} else {
			return;
		}
	}
	
	function cancel(){
		if(confirm("글 수정을 취소하시겠습니까?")){
			alert("취소하였습니다.");
			history.back();
		} else {
			return;
		}
	}
</script>
</html>