<%@page import="kr.or.ddit.board.vo.NoticeBoardVO"%>
<%@page import="kr.or.ddit.comm.vo.PagingVO"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/WEB-INF/view/include/adminHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 게시판</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/board.css">

</head>
<%
	UserVO uv = (UserVO) session.getAttribute("userVO");
	PagingVO pv = (PagingVO)request.getAttribute("pv");
%>
<body>
	<!-- 전체-->
	<div class="col-sm-12">

		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>

		<!-- 게시판 -->
		<div class="col-sm-8">
			<h4>
				<b>공지게시판</b>
			</h4>
			<table class="table table-hover">
				<thead>
					<tr>
						<th><input type="checkbox" value="" ></th>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<NoticeBoardVO> list = (List<NoticeBoardVO>) request.getAttribute("list");
						Integer totalCount = (Integer)request.getAttribute("totalCount");
						for (int i = 0; i < list.size(); i++) {
							String noticeNm = list.get(i).getNoticeNm();
					%>
					<tr>
						<td><input type="checkbox" value=""></td>
						<td style="text-align: center"><%=totalCount - list.get(i).getrNum() + 1 %></td>
						<td><a href="#" onclick="boardSelect('<%=noticeNm%>')"> <%=list.get(i).getNoticeTitle()%>
						</a></td>
						<td><%=list.get(i).getNoticeWriter()%></td>
						<td><%=list.get(i).getNoticeDate()%></td>
					</tr>
					<%
						}
						if (list.size() <= 0){
					%>
					<tr>
					<td colspan="5" style="text-align: center">게시글이 없습니다.</td>
				</tr>
				<%
				}
				%>
				</tbody>
			</table>
			<div class="text-center">
			
			<%-- <!-- 페이징 처리 시작 -->
				<%if(pv.getTotalCount() > 0) {%>
				<ul class="pagination">
					<%if(pv.getFirstPageNo() > pv.getPageSize()) { %>
					<li><a href="adminNoticeBoard.do?pageNo=<%=pv.getFirstPageNo() - pv.getPageSize() %>">이전</a></li>
					<%} %>
					<%for(int pNo = pv.getFirstPageNo(); pNo <= pv.getLastPageNo(); pNo++){ %>
					<li>
						<a href="adminNoticeBoard.do?pageNo=<%=pNo %>">
							<%=pNo %>
						</a>
					</li>
					<%} %>
					<%if(pv.getLastPageNo() < pv.getTotalPageCount()){ %>
					<li><a href="adminNoticeBoard.do?pageNo=<%=pv.getFirstPageNo() + pv.getPageSize() %>">다음</a></li>
				</ul>
				<%}
				} %>
			</div>
		<!-- 페이징 처리 끝.. --> --%>
			<!-- 검색 창 -->
			<div class="text-center">
				<input type="text" id="schInput" placeholder="제목 검색">
				<button type="button" class="btn btn-success"
					onclick="searchBoard()">검색</button>
			</div>
			<hr>
			<!-- 등록 버튼  -->
			<div id="btn" style="text-align: right">
				<button type="button" class="btn btn-success" id="insertBtn"
					onclick="insertBoard()">등록</button>
				<button type="button" class="btn btn-success" id="deleteBtn"
					onclick="deleteBoard()">삭제</button>
			</div>


			<form id="fm">
				<input type="hidden" name="noticeNm" id="noticeNm">
				<input type="hidden" name="noticeTitle" id="noticeTitle">
				<input type="hidden" name="flag" id="flag"> 
			</form>
		</div>

		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>

	</div>
</body>
<script type="text/javascript">
<%-- 	$(document).ready(function() {
	<%if (uv != null && uv.getAdminCk().equals("Y")) {%>
		$("#insertBtn").show();
	<%} else {%>
		$("#insertBtn").hide();
	<%}%>
	}); --%>
	
	 $("#AllCheck").click(function(){
	// '전체선택' 체크박스가 체크 되어 있을때
	if($(this).prop("checked")){
		$(":checkbox").prop("checked", true);
	} 
	// '전체선택' 체크박스가 체크가 되어있지 않을때
	else if($(this).prop("checked", false)){
		$(":checkbox").prop("checked", false);
	}

	// 체크박스가 전부 체크되어있으면 '전체선택' 체크
	// 체크박스에 하나라도 체크되어있지 않으면 '전체선택' 체크해제
	$(":checkbox").click(function(){
		if($("[name=num]").not(":checked").length == 0) {
			$("#AllCheck").prop("checked", true);
		} else if ($("[name=num]").not(":checked").length > 0){
			$("#AllCheck").prop("checked", false);
		}
	});
	
});

	function deleteBoard(){
		if(confirm("정말로 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			document.getElementById("noticeNm").value = noticeNm;
			document.getElementById("flag").value = "D";
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "adminNoticeBoard.do";
			fm.submit();
		} else {
			return;
		}
	}
	
	function boardSelect(noticeNm) {
		document.getElementById("noticeNm").value = noticeNm;
		document.getElementById("flag").value = "SEL";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminNoticeBoard.do";
		fm.submit();
	}

	function insertBoard() {
		document.getElementById("flag").value = "INS";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminNoticeBoard.do";
		fm.submit();
	}

	function searchBoard() {
		document.getElementById("flag").value = "SCH";
		document.getElementById("noticeTitle").value = $("#schInput").val();

		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminNoticeBoard.do";
		fm.submit();
	}
</script>
</html>