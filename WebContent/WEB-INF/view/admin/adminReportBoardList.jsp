<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.comm.vo.PagingVO"%>
<%@page import="kr.or.ddit.board.vo.ReportBoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/WEB-INF/view/include/adminHead.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>신고 게시판</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/adminBoard.css">
</head>
<body>
<%
	if (session != null && session.getAttribute("userVO") != null) {
		UserVO uv = (UserVO) session.getAttribute("userVO");
	}

	ReportBoardVO rbv = (ReportBoardVO) request.getAttribute("rbv");

	PagingVO pv = (PagingVO)request.getAttribute("pv");
%>

	<!-- 전체-->
	<div class="col-sm-12">

		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>

		<!-- 게시판 -->
		<div class="col-sm-8">
					<h4>
				<b>신고 </b>
			</h4>
			<table class="table table-hover">
				<thead>
					<tr>
						<th><input type="checkbox" id="AllCheck"></th>
						<th>번호</th>
						<th>제목</th> 
						<th>작성자</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<%
						List<ReportBoardVO> list = (List<ReportBoardVO>) request.getAttribute("list");
						Integer totalCount = (Integer)request.getAttribute("totalCount");
						String reportNm ="";
						for (int i = 0; i < list.size(); i++) {
							reportNm = list.get(i).getReportNm();
					%>
					<tr>
						<td><input type="checkbox" name="reportCk" value="<%=list.get(i).getReportNm() %>"></td>
						<td><%=totalCount - list.get(i).getrNum() + 1 %></td>
						<td><a href="#" onclick="boardSelect('<%=reportNm%>')"> <%=list.get(i).getReportTitle()%>
						</a></td>
						<td><%=list.get(i).getReportWriter()%></td>
						<td><%=list.get(i).getReportDate()%></td>
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
					<li><a href="adminReportBoard.do?pageNo=<%=pv.getFirstPageNo() - pv.getPageSize() %>">이전</a></li>
					<%} %>
					<%for(int pNo = pv.getFirstPageNo(); pNo <= pv.getLastPageNo(); pNo++){ %>
					<li>
						<a href="adminReportBoard.do?pageNo=<%=pNo %>">
							<%=pNo %>
						</a>
					</li>
					<%} %>
					<%if(pv.getLastPageNo() < pv.getTotalPageCount()){ %>
					<li><a href="adminReportBoard.do?pageNo=<%=pv.getFirstPageNo() + pv.getPageSize() %>">다음</a></li>
				</ul>
				<%}
				} %>
			</div>
		<!-- 페이징 처리 끝.. -->
			<!-- 검색 창 -->
			<div class="text-center">
				<input type="text" id="schInput2" name="search" value="">
				<button type="button" class="btn btn-success"
					onclick="searchBoard()">검색</button>
			</div>
			<hr>
			<!-- 등록 버튼  -->
			<div id="btn" style="text-align: right">
				<button type="button" id="deleteWrite" class="btn btn-success" onclick="deleteBoard()">삭제</button>
				<button type="button" class="btn btn-success" id="insertBtn" onclick="insertBoard()">등록</button>
			</div>
			<form id="fm">
				<input type="hidden" name="reportNm" id="reportNm">
				 <input type="hidden" name="flag" id="flag">
				 <input type="hidden" name=search id="search">
			</form>
		</div>

		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>

	</div>

</body>
<script type="text/javascript">
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
		if($("[name=reportCk]").not(":checked").length == 0) {
			$("#AllCheck").prop("checked", true);
		} else if ($("[name=reportCk]").not(":checked").length > 0){
			$("#AllCheck").prop("checked", false);
		}
	});
});

	function boardSelect(reportNm) {
		
		document.getElementById("reportNm").value = reportNm;
		document.getElementById("flag").value = "SEL";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminReportBoard.do";
		fm.submit();
	}

	function insertBoard() {
		document.getElementById("flag").value = "INS";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminReportBoard.do";
		fm.submit();
	}

	function searchBoard() {
		document.getElementById("flag").value = "SCH";
		document.getElementById("search").value = $("#schInput2").val();
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminReportBoard.do";
		fm.submit();
	}
	
	function deleteBoard(){
		var reportNms = "";
		$("input[name=reportCk]:checked").each(function(){
			reportNms += "/" + this.value;
		})
		$("#reportNm").val(reportNms);
		$("#flag").val("D2");
		
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "/Team_Sprout/admin/adminReportBoard.do";
		fm.submit();
	}
	
</script>
</html>