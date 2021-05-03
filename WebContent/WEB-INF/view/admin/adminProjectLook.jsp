<%@page import="kr.or.ddit.project.vo.ProjectOptionVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ProjectVO pv = (ProjectVO) request.getAttribute("pv");

    List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");

    List<ProjectOptionVO> listOption = (List<ProjectOptionVO>)request.getAttribute("optionList");
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
				<!-- 프로젝트 제목 -->
				<div class="col-sm-12">
			
					<!-- 왼쪽 공백 2 -->
					<div class="col-sm-2"></div>
			
					<!-- 제목 -->
					<div class="col-sm-8" id="divCategory">
						<br>
						<h4><%=pv.getPjNm() %></h4>
						<br> 
						<span id="pjCategory"><%=pv.getPjCategory() %></span>
						<br>
						<h2><%=pv.getPjName() %></h2>
					</div>
			
					<!-- 오른쪽 공백 2 -->
					<div class="col-sm-2"></div>
			
				</div>
			
				<!-- 프로젝트 사진 / 설명 -->
				<div class="col-sm-12">
					<!-- 왼쪽 공백 2 -->
					<div class="col-sm-2"></div>
			
					<!-- 썸네일 -->
					<div class="col-sm-5">
										<%
								if (atchFileList != null) {
									for (AtchFileVO atchFileVO : atchFileList) {
							%>
							<img src='<%=atchFileVO.getImgUrl()%>' >
							<%
								}
								}
							%>
					</div>
					<!-- 설명 -->
					<div class="col-sm-3">
						<p>목표금액</p>
						<h3>
							<p><%=pv.getPjPriceAmount() %>원</p>
						</h3>
						<p>모인금액</p>
						<h3>
							<p><%=pv.getPjPrice() %>원</p>
						</h3>
						<br>
						<p>프로젝트 마감일</p>
						<h3>
							<p><%=pv.getPjDday() %></p>
						</h3>
						<br>
						<p>후원자</p>
						<h3>
							<p><%=pv.getPjFan() %>명</p>
						</h3>
					</div>
			
					<!-- 오른쪽 공백 2 -->
					<div class="col-sm-2"></div>
				</div>
			
				<!-- 프로젝트 옵션 / 상세 설명 -->
				<div class="col-sm-12">
					<!-- 왼쪽 공백 2 -->
					<div class="col-sm-2"></div>
			
					<!-- 옵션 -->
					<div class="col-sm-2">
					<% for(int i = 0; i < listOption.size(); i++){%>
						<div id="divOption">
							<p>옵션<%=i+1 %></p><br><br>
							<p><%=listOption.get(i).getPoName() %><br>
							<h4><%=listOption.get(i).getPoAddPrice() %></h4><br>
							<span><%=listOption.get(i).getPoContent() %></span>
						</div>
						<%
					}
						%>
						<br>
					</div>
					<!-- 상세 설명 -->
					<div class="col-sm-6">
						<h3>프로젝트 소개</h3>
						<p><%=pv.getPjContent() %></p>
					</div>
					<button type="button" class="btn btn-default btn-lg">심사 통과</button>
					<button type="button" class="btn btn-default btn-lg" onclick="goList()">목록</button>
					<!-- 오른쪽 공백 2 -->
					<div class="col-sm-2"></div>
				</div>
			</div>
		</div>
</body>
<script type="text/javascript">
	
</script>
</html>
