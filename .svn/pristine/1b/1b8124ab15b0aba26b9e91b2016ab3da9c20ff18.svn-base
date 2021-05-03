<%@page import="kr.or.ddit.comm.vo.PagingVO"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.board.vo.QnaBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnA 게시판</title>
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
	if (session != null && session.getAttribute("userVO") != null) {
		uv = (UserVO) session.getAttribute("userVO");
	}

	PagingVO pv = (PagingVO)request.getAttribute("pv");
%>
<body>
<!-- 헤더 이미지 및 문구 -->
	<div class="col-sm-12">
		<div id="menu_title">
			<p>
			
			<br><br><br>
				<h3><b>Q & A</b></h3>
				<br>
				* 이용 중 궁금한 사항들을 질문하는 게시판입니다.
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
						List<QnaBoardVO> list = (List<QnaBoardVO>) request.getAttribute("list");
						Integer totalCount = (Integer)request.getAttribute("totalCount");
						for (int i = 0; i < list.size(); i++) {
							String qnaNm = list.get(i).getQnaNm();
					%>
					<tr>
						<td><%=totalCount - list.get(i).getrNum() + 1 %></td>
						<td><a href="#" onclick="boardSelect('<%=qnaNm%>')"> <%=list.get(i).getQnaTitle()%>
						</a></td>
						<td><%=list.get(i).getQnaWriter()%></td>
						<td><%=list.get(i).getQnaDate()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
			<div class="text-center">
			<!-- 페이징 처리 시작 -->
				<%if(pv.getTotalCount() > 0) {%>
				<ul class="pagination">
					<%if(pv.getFirstPageNo() > pv.getPageSize()) { %>
					<li><a href="qnaBoard.do?pageNo=<%=pv.getFirstPageNo() - pv.getPageSize() %>">이전</a></li>
					<%} %>
					<%for(int pNo = pv.getFirstPageNo(); pNo <= pv.getLastPageNo(); pNo++){ %>
					<li>
						<a href="qnaBoard.do?pageNo=<%=pNo %>">
							<%=pNo %>
						</a>
					</li>
					<%} %>
					<%if(pv.getLastPageNo() < pv.getTotalPageCount()){ %>
					<li><a href="qnaBoard.do?pageNo=<%=pv.getFirstPageNo() + pv.getPageSize() %>">다음</a></li>
				</ul>
				<%}
				} %>
			</div>
		<!-- 페이징 처리 끝.. -->
			<!-- 검색 창 -->
			<div class="text-center">
				<input type="text" id="schInput" placeholder="제목 혹은 작성자">
				<button type="button" class="btn btn-success"
					onclick="searchBoard()">검색</button>
			</div>
			<hr>
			<!-- 등록 버튼  -->
			<div id="btn" style="text-align: right">
				<button type="button" class="btn btn-success" id="insertBtn"
					onclick="insertBoard()">등록</button>
			</div>
			<form id="fm">
				<input type="hidden" name="qnaNm" id="qnaNm"> <input
					type="hidden" name="flag" id="flag"> <input type="hidden"
					id="schInput2" name="search">
			</form>
		</div>

		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>

	</div>
</body>
<script type="text/javascript">
	$(document).ready(function() {
<%if (session.getAttribute("userVO") == null) {%>
	$("#insertBtn").hide();
<%} else {%>
	$("#insertBtn").show();
<%}%>
	});
	function boardSelect(qnaNm) {
		document.getElementById("qnaNm").value = qnaNm;
		document.getElementById("flag").value = "SEL";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "qnaBoard.do";
		fm.submit();
	}

	function insertBoard() {
		document.getElementById("flag").value = "INS";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "qnaBoard.do";
		fm.submit();
	}

	function searchBoard() {
		document.getElementById("flag").value = "SCH";
		document.getElementById("schInput2").value = $("#schInput").val();

		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "qnaBoard.do";
		fm.submit();
	}
</script>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>