<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/Team_Sprout/dist/css/styles.css" rel="stylesheet" />
<link
	href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css"
	rel="stylesheet" crossorigin="anonymous" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/js/all.min.js"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">

	<div class="sb-sidenav-menu">

		<div class="nav">
			<div class="sb-sidenav-menu-heading">Core</div>

			<!-- 메인 대쉬보드 -->
			<a class="nav-link" href="index.html">
				<div class="sb-nav-link-icon">
					<i class="fas fa-chart-area"></i>
				</div> CHARTS
			</a>

			<!-- ADMIN -->
			<div class="sb-sidenav-menu-heading">ADMIN</div>

			<!-- MEMBER -->
			<a class="nav-link collapsed" href="#" data-toggle="collapse"
				data-target="#collapseLayouts" aria-expanded="false"
				aria-controls="collapseLayouts">
				<div class="sb-nav-link-icon">
					<i class="fas fa-columns"></i>
				</div> MEMBER
				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div>
			</a>
			<div class="collapse" id="collapseLayouts"
				aria-labelledby="headingOne" data-parent="#sidenavAccordion">
				<nav class="sb-sidenav-menu-nested nav"> <a class="nav-link"
					href="#">회원 관리</a> <a class="nav-link" href="#">블랙리스트 관리</a> <a
					class="nav-link" href="#">메세지 관리</a> </nav>
			</div>

			<!-- BOARD -->
			<a class="nav-link collapsed" href="#" data-toggle="collapse"
				data-target="#collapseBoards" aria-expanded="false"
				aria-controls="collapseBoards">
				<div class="sb-nav-link-icon">
					<i class="fas fa-book-open"></i>
				</div> BOARD
				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div>
			</a>
			<div class="collapse" id="collapseBoards"
				aria-labelledby="headingOne" data-parent="#sidenavAccordion">
				<nav class="sb-sidenav-menu-nested nav"> 
				<a class="nav-link" href="/Team_Sprout/admin/adminNoticeBoard.do">공지사항</a>
				<a class="nav-link" href="/Team_Sprout/admin/adminfreeBoard.do">커뮤니티</a>
				<a class="nav-link" href="/Team_Sprout/admin/adminCommunityBoard.do">후기</a>
				<a class="nav-link" href="/Team_Sprout/admin/adminQnaBoard.do">Q&A</a>
				<a class="nav-link" href="/Team_Sprout/admin/adminFaqBoard.do">F&Q</a>
				<a class="nav-link" href="/Team_Sprout/admin/adminReportBoard.do">신고</a>
				</nav>
			</div>

			<!-- PROJECT -->
			<a class="nav-link collapsed" href="#" data-toggle="collapse"
				data-target="#collapseProjects" aria-expanded="false"
				aria-controls="collapseProjects">
				<div class="sb-nav-link-icon">
					<i class="fas fa-table"></i>
				</div> PROJECT
				<div class="sb-sidenav-collapse-arrow">
					<i class="fas fa-angle-down"></i>
				</div>
			</a>
			<div class="collapse" id="collapseProjects"
				aria-labelledby="headingOne" data-parent="#sidenavAccordion">
				<nav class="sb-sidenav-menu-nested nav"> <a class="nav-link"
					href="/Team_Sprout/admin/adminProject.do">프로젝트 승인</a> <a class="nav-link" href="#">카테고리</a> <a
					class="nav-link" href="#">추천프로젝트</a> </nav>
			</div>
		</div>
	</div>
	</nav>

</body>
</html>