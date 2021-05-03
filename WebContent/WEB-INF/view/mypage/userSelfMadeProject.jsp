<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<%
	List<ProjectVO> list = (List<ProjectVO>) request.getAttribute("list");

	uv = (UserVO) session.getAttribute("userVO");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>나의 프로젝트 - Sprout</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/mypage/mpMyprj.css">
</head>
<body>
	<!-- 상단 전체   -->
	<div class="col-sm-12">

		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>

		<!-- 검색창 10 -->
		<div class="col-sm-8">
			<br> <br>
			<h3 style="font-weight: bold">내가 만든 프로젝트</h3>

			<br>
			<h4 style="font-weight: bold">
				총
				<%=list.size()%>개의 프로젝트
			</h4>
		</div>

		<!-- 오른쪽 공백 2 -->
		<div class="col-sm-2"></div>
	</div>

	<!-- 펀딩 리스트 12 -->
	<div class="col-sm-12">
	
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>
		<%
			if (list.size() == 0) {
		%>
		<br>
		<br>
		<br>
		<br>
		<br>
		<h2 align="center">게시한 프로젝트가 없습니다.</h2>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<%
			} else {
				for (int i = 0; i < list.size(); i++) {
					if (i % 4 == 0) {
		%>
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>
		<div class="col-sm-12">
			<!-- 왼쪽 공백 2 -->
			<div class="col-sm-2"></div>
			<%
				}
			%>
			<!-- 항목들 -->
			<div class="col-sm-2">
				<img
					src="<%=request.getContextPath()%>/filedownload.do?fileId=<%=list.get(i).getAtchFileId()%>&fileSn=1"
					class="img-rounded" style="width: 100%" alt="Image">
				<h4 align="center">
					<a
						href="/Team_Sprout/project/projectBoard.do?flag=SEL&pjNm=<%=list.get(i).getPjNm()%>"><%=list.get(i).getPjName()%></a>
				</h4>
				<p>
					<%=list.get(i).getPjCategory()%>
				</p>
				<span class="gold"><%=list.get(i).getPjPricePer()%>% 달성</span>
							<div class="progress">
				<%
					int per = list.get(i).getPjPricePer();
					if (per > 100){
						per = 100;
					}
					%>
				<div class="progress-bar progress-bar-success" role="progressbar"
					aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
					style="width:<%=per%>%">
				</div>
			</div>
				<div class="time">
					<span class="glyphicon glyphicon-time"></span> <span><%=list.get(i).getPjExpDate()%>일
						남음</span>
				</div>
				<div class="btn-group btn-group-justified">
					<a
						href="/Team_Sprout/board/communityBoard.do?pjNm=<%=list.get(i).getPjNm()%>"
						class="btn btn-success">구매후기게시판</a>
				</div>
			</div>
			<%
				}
				}
			%>


			<!-- 여백 2-->
			<div class="col-sm-2"></div>
		</div>
</body>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>