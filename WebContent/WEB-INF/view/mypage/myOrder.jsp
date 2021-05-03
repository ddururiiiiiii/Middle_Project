<%@page import="kr.or.ddit.user.vo.OrderVO"%>
<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>나의 후원 내역</title>
</head>
<body>
<%
	if(session != null && session.getAttribute("userVO") != null){
		uv = (UserVO)session.getAttribute("userVO");
	}
	
	List<OrderVO> orderList = (List<OrderVO>)request.getAttribute("orderList");
%>
	
		<!-- 상단 전체   -->
		<div class="col-sm-12">
		
			<!-- 왼쪽 공백 2 -->
			<div class="col-sm-2"></div>

		<!-- 검색창 10 -->
		<div class="col-sm-8">
		<br><br>
			<h3 style="font-weight: bold">후원현황</h3>
				
			<br>
			<h4 style="font-weight: bold">총 <%=orderList.size() %>개의 프로젝트</h4>
		</div>

		<!-- 오른쪽 공백 2 -->
			<div class="col-sm-2"></div>
		</div>

		<!-- 펀딩 리스트 12 -->	
	<div class="col-sm-12">
	
		<!-- 왼쪽 공백 2 -->
			<div class="col-sm-2"></div>
			
		<%
		if(orderList.size() == 0){
		%>
			<br><br><br><br><br>
			<h2 align="center">후원 내역이 없습니다.</h2>			
			<br><br><br><br><br><br><br><br><br><br><br><br>
		<%
		} else {
			for(int i = 0; i < orderList.size(); i++){
				if(i % 4 == 0){
			%>
			<!-- 왼쪽 공백 2 -->
			<div class="col-sm-2"></div>
			<div class="col-sm-12">
			<!-- 왼쪽 공백 2 -->
			<div class="col-sm-2"></div>
			<%} %>
			<!-- 항목들 -->
			<div class="col-sm-2">
				<p>후원일 <%=orderList.get(i).getOrderTime() %></p>
				<img
				src="<%=request.getContextPath()%>/filedownload.do?fileId=<%=orderList.get(i).getAtchFileId()%>&fileSn=1"
				class="img-rounded" style="width: 100%; alt="Image">
				<h4>
					<a href="/Team_Sprout/project/projectBoard.do?flag=SEL&pjNm=<%=orderList.get(i).getPjNm() %>">
						<%=orderList.get(i).getPjName() %>
					</a>
				</h4>
				<div id="divReult">
					<h4>후원 금액</h4>
					<p><%=orderList.get(i).getOrderPrice() %>원</p>
					<h4>선택 옵션</h4>
					<p><%=orderList.get(i).getPoName() %></p>
					<h4>주문상태</h4>
					<p><%=orderList.get(i).getOrderState() %></p>
				</div>
				<div align="center">
					<button type="button" class="btn btn-success btn-lg" onclick="review('<%=orderList.get(i).getPjNm() %>')" id="payBtn">리뷰작성</button>
				</div>
			</div>
			<%	
			}
		} %>

		
	<!-- 여백 2-->	
	<div class="col-sm-2"></div>
	</div>
<script type="text/javascript">
	function review(pjNm){
		location.href = "/Team_Sprout/board/communityBoard.do?pjNm=" + pjNm;
	}
</script>
</body>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>

