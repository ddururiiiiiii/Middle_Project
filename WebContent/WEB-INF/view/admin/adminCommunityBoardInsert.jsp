<%@page import="kr.or.ddit.board.vo.CommunityBoardVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
	<%@include file="/WEB-INF/view/include/adminHead.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후기게시판 작성</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="../../css/main/boardWrite.css">
<style type="text/css">
</style>
</head>
<body>
	<!-- 테이블 -->
	<div class="container">
		<h4><b><span>후기게시판 작성</span></b></h4>
		<table class="table">
			<thead>
			</thead>
			<tbody>
				<tr>
					<th>제목</th>
					<td colspan="3">
						<input type="text" class="form-control" id="title" placeholder="제목을 입력해주세요.">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3"><textarea class="form-control" id="content" rows="20"
							placeholder="내용을 입력해주세요."></textarea></td>
				</tr>
				<tr>
					<td>첨부파일</td>
					<td>
					<form id="fm" enctype="multipart/form-data">
						<input type="hidden" id="pjName" name="pjName">
						<input type="hidden" id="cbContent" name="cbContent">
						<input type="file" multiple="multiple" id="attachFile" name="atchFileId" onchange="setThumbnail()">
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
			<button type="button" class="btn btn-success" onclick="upload()">등록</button>
		</div>
		
	</div>
</body>
<script type="text/javascript">
	function upload(){
		if(confirm("게시글을 등록 하시겠습니까?")){
			alert("게시글 등록이 완료되었습니다.");
			document.getElementById("pjName").value = $("#title").val();
			document.getElementById("cbContent").value = $("#content").val();
			document.getElementById("flag").value = "C";
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "adminCommunityBoard.do";
			fm.submit();
		} else {
			return;
		}
	}
	
	function cancel(){
		if(confirm("글 작성을 취소하시겠습니까?")){
			alert("목록으로 돌아갑니다.");
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "adminCommunityBoard.do";
			fm.submit();
		} else {
			return;
		}
	}
	

</script>
</html>