<%@page import="kr.or.ddit.project.vo.ProjectOptionVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	List<ProjectVO> projectList = (List<ProjectVO>)request.getAttribute("projectList");
%>
<!DOCTYPE html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>SPROUT 관리자 페이지 - 프로젝트 검수</title>

</head>
<body class="sb-nav-fixed">

	<!-- 상단 헤더 -->
	<%@include file="/WEB-INF/view/include/adminHead.jsp"%>

	<!-- 레이아웃 -->
	<div id="layoutSidenav">

		<!-- 좌측 네비 -->
		<div id="layoutSidenav_nav">
			<%@include file="/WEB-INF/view/include/adminNav.jsp"%>
			
			<!-- 본문  -->
			<div id="layoutSidenav_content">
				<div>
					<br><br>
					<table>
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
						for(int i = 0; i < projectList.size(); i++){
							if(projectList.get(i).getPjCondition().equals("심사중")){
						%>
							<tr>
								<td><%=projectList.get(i).getPjNm() %></td>
								<td><a href="/Team_Sprout/admin/adminProjectSelect.do?pjNm=<%=projectList.get(i).getPjNm() %>"><%=projectList.get(i).getPjName() %></a></td>
								<td><%=projectList.get(i).getUserId() %></td>
								<td><%=projectList.get(i).getPjOpenday() %></td>
							</tr>
						<%	}
						}
						%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
</body>
</html>
