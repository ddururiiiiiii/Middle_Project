<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@page import="kr.or.ddit.project.vo.ProjectOptionVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" type="text/css" href="/Team_Sprout/css/main/prjDona.css">
</head>
<%
	ProjectVO pv = (ProjectVO) request.getAttribute("pv");

	List<ProjectOptionVO> optionList = (List<ProjectOptionVO>) request.getAttribute("optionList");
	
	 uv = (UserVO)session.getAttribute("userVO");
%>
<body>
	<!-- 상단 전체   -->
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>

		<!-- 후원하기 메인 -->
		<div class="col-sm-8">
			<!-- 후원 프로젝트 정보 -->
			<br>
			<h3>프로젝트 정보</h3>
			<div id="divReult">
				<h4>후원할 프로젝트</h4>
				<p><%=pv.getPjName() %></p>
				<br>
				<h4>후원 금액</h4>
				<p id="money">0원</p>
				<br>
				<h4>선택할 옵션</h4>
				<select id="selectMoney" class="selectpicker" data-style="btn-success" onchange="setMoney()">
					<option selected="selected">옵션을 선택해주세요.</option>
				<%for(int i = 0; i < optionList.size(); i++){ %>
					<option value="<%=optionList.get(i).getPoAddPrice() %>/<%=optionList.get(i).getPoContent() %>">
						옵션<%=i+1 %>. <%=optionList.get(i).getPoContent() %>, <%=optionList.get(i).getPoAddPrice() %>원
					</option>
				<%} %>
				</select>
			</div>

			<!-- 후원 입력 정보 -->
			<div>
				<br>
<!-- 				<h3>배송지 정보</h3> -->
<!-- 				<form action=""> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="">배송지</label> <input type="text" class="form-control"> -->
<!-- 					</div> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="">받는사람</label> <input type="text" class="form-control"> -->
<!-- 					</div> -->
<!-- 					<div class="form-group"> -->
<!-- 						<label for="">연락처</label> <input type="text" class="form-control"> -->
<!-- 					</div> -->
<!-- 				</form> -->
				<div id="btn">
					<button type="button" class="btn btn-success" onclick="donation()">후원하기</button>
				</div>
			</div>
		</div>
		<form id="fm">
			<input type="hidden" id="userId" name="userId">
			<input type="hidden" id="pjNm" name="pjNm">
			<input type="hidden" id="pjName" name="pjName">
			<input type="hidden" id="orderPrice" name="orderPrice">
			<input type="hidden" id="poName" name="poName">
			<input type="hidden" id="atchFileId" name="atchFileId">
		</form>
		<!-- 오른쪽 공백 2 -->
		<div class="col-sm-2"></div>
	</div>
</body>
<script type="text/javascript">
	function setMoney(){
		$("#money").html($("#selectMoney option:selected").val().split("/")[0] + "원");
	}
	
	function donation(){
		if(!confirm("후원 하시겠습니까?")){
			return;
		}
		var userMoney = <%=uv.getUserMoney() %>;
		if(userMoney < $("#selectMoney option:selected").val().split("/")[0]) {
			alert("잔액이 부족합니다.");
		}else{
			alert("후원이 완료 되었습니다.");
			$("#userId").val("<%=uv.getUserId() %>");
			$("#pjNm").val("<%=pv.getPjNm() %>");
			$("#pjName").val("<%=pv.getPjName() %>");
			$("#orderPrice").val($("#selectMoney option:selected").val().split("/")[0]);
			$("#poName").val($("#selectMoney option:selected").val().split("/")[1]);
			$("#atchFileId").val(<%=pv.getAtchFileId() %>);
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "/Team_Sprout/order/order.do";
			fm.submit();
		}
	}
</script>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>