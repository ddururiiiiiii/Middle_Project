<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.comm.vo.PagingVO"%>
<%@page import="kr.or.ddit.board.vo.FaqBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/adminHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>FAQ 게시판</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/adminBoard.css">
</head>
<%
	if (session != null && session.getAttribute("userVO") != null) {
		UserVO uv = (UserVO) session.getAttribute("userVO");
	}

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
		<b>FAQ</b>
		</h4>
		<br><br>
		<table class="table table-hover">
			<thead>
				<tr>
					<th><input type="checkbox" ></th>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>날짜</th>
				</tr>
			</thead>
			<tbody>
			<%
			List<FaqBoardVO> list = (List<FaqBoardVO>)request.getAttribute("list");
			Integer totalCount = (Integer) request.getAttribute("totalCount");
			for(int i = 0; i < list.size(); i++) {
				String faqNm = list.get(i).getFaqNm();
			%>
			<tr>
				<td><input type="checkbox"></td>
				<td><%=totalCount - list.get(i).getrNum() + 1 %></td>
				<td>
					<a href="#" onclick="boardSelect('<%=faqNm %>')">
						<%=list.get(i).getFaqTitle()%>
					</a>
				</td>
				<td><%=list.get(i).getFaqWriter()%></td>
				<td><%=list.get(i).getFaqDate() %></td>
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
			<!-- 페이징 처리 시작 -->
				<%if(pv.getTotalCount() > 0) {%>
				<ul class="pagination">
					<%if(pv.getFirstPageNo() > pv.getPageSize()) { %>
					<li><a href="adminFaqBoard.do?pageNo=<%=pv.getFirstPageNo() - pv.getPageSize() %>">이전</a></li>
					<%} %>
					<%for(int pNo = pv.getFirstPageNo(); pNo <= pv.getLastPageNo(); pNo++){ %>
					<li>
						<a href="adminFaqBoard.do?pageNo=<%=pNo %>">
							<%=pNo %>
						</a>
					</li>
					<%} %>
					<%if(pv.getLastPageNo() < pv.getTotalPageCount()){ %>
					<li><a href="adminFaqBoard.do?pageNo=<%=pv.getFirstPageNo() + pv.getPageSize() %>">다음</a></li>
				</ul>
				<%}
				} %>
			</div>
		<!-- 페이징 처리 끝.. -->
		<!-- 검색 창 -->
		<div class="text-center">
			<input type="text" id="schInput" name="search">
			<button type="button" class="btn btn-success" onclick="searchBoard()">검색</button>
		</div>
		<hr>
		<!-- 등록 버튼  -->
		<div id="btn" style="text-align: right">
			<button type="button" id="deleteWrite" class="btn btn-success" onclick="deleteBoard()">삭제</button>
			<button type="button" class="btn btn-success" id="insertBtn" onclick="insertBoard()">등록</button>
		</div>
		<form id="fm">
			<input type="hidden" name="faqNm" id="faqNm">
			<input type="hidden" name="flag" id="flag">
		</form>
		</div>

		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>

	</div>

</body>
<script type="text/javascript">
// 	$(document).ready(function(){
<%-- 		<%if(session.getAttribute("userVO") == null){ %> --%>
// 			$("#insertBtn").hide();
<%-- 		<%} else {%> --%>
// 			$("#insertBtn").show();
<%-- 		<%}%> --%>
// 	});
	function boardSelect(faqNm){
		document.getElementById("faqNm").value = faqNm;
		document.getElementById("flag").value = "SEL";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminFaqBoard.do";
		fm.submit();
	}

	function insertBoard(){
		document.getElementById("flag").value = "INS";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminFaqBoard.do";
		fm.submit();
	}
	
	function searchBoard() {
		document.getElementById("flag").value = "SCH";
		
		var searchTitle = $("#schInput").val();
		
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminFaqBoard.do?faqTitle=" + searchTitle;
		fm.submit();
	}
</script>
</html>