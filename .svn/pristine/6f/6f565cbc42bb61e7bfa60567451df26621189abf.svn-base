<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원탈퇴 - Sprout</title>
<%
	uv = (UserVO) session.getAttribute("userVO");
%>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<style type="text/css">
.col-sm-2 {
    padding: 10px;
}
#side {
    display: block;
	width: 100%;
    border-radius: 0px;
}
#deleteInfo1 {
 width: 100%;
	background-color: #fafafa;
	border: 1px solid #efefef;
	padding: 20px;
}
#deleteInfo2 {
 width: 100%;
	background-color: #fafafa;
	border: 1px solid #efefef;
	padding: 20px;
}
#btnRight {
	text-align: right;
}
</style>
</head>
<body>
	<!-- 회원정보 수정  -->
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>

		<!-- 좌측 메뉴 -->
		<div class="col-sm-2">
			<br>
			<button type="button" class="btn" id="side" onclick="updateInfo()">회원정보수정</button>
			<button type="button" class="btn" id="side" onclick="deleteInfo()">회원탈퇴</button>
		</div>

		<!-- 회원정보 수정 -->
		<div class="col-sm-6">
			<h3><b>회원탈퇴</b></h3>
			<div id="deleteInfo1">
				<span style="color : red;"><h4><b>회원탈퇴시 개인정보 및 스프라우트에서 만들어진 모든 데이터는 삭제 됩니다. <br>(단, 아래 항목은 표기된법률에 따라 특정 기간 동안 보관됩니다.)</b></h4></span>
				<ol>
					<li>계약 또는 청약 철회 등에 관한 기록 보존 이유 : 전자상거래 등에서의 소비자 보호에 관한 법률 /
						보존기간 : 5년</li>
					<li>대금결제 및 재화 등의 공급에 관한 기록 보존 이유 : 전자상거래 등에서의 소비자 보호법에 관한 법률 /
						보존 기간 : 5년</li>
					<li>전자 금융거래에 관한 기록 보존 이유 : 전자금융거래법 / 보존 기간 : 5년</li>
					<li>소비자의 불만 또는 분쟁처리에 관한 기록 보존 이유 : 전자상거래 등에서의 소비자 보호에 관한 법률 보존
						기간 / 3년</li>
					<li>신용정보의 수집/처리 및 이용 등에 관한 기록 보존 이유 : 신용 정보의 이용 및 보호에 관한 법률 보존
						/ 3년</li>
					<li>전자(세금)계산서 시스템 구축 운영하는 사업자가 지켜야할 사항 고시 (국세청 고시 제2016-3호)
						(전자세금계산서 사용에 한함) : 5년 <br>(단, (세금)계산서 내 개인식별번호는 3년 경과 후 파기)
					</li>
				</ol>
			</div>

			<h3><b>유의사항</b></h3>
			<div id="deleteInfo2">
				<ul>
					<li>회원 탈퇴 처리 후에는 회원님의 개인 정보를 복원할 수 없으며, 회원 탈퇴진행 시 해당 아이디는
						영구적으로 삭제되어 재가입이 불가합니다.</li>
					<li>소속된 회사가 존재할 경우, 탈퇴회원으로 조회됩니다.</li>
					<li>회사가 스트라우트 내에 존재하는 경우, 회사에 귀속된 데이터에 대해서는 보관됩니다.</li>
				</ul>
			</div>
			<h3><b>탈퇴사유</b></h3>
				<select class="form-control">
					<option>아이디변경 / 재가입 목적</option>
					<option>이용이 불편하고 장애가 많음</option>
					<option>사용빈도가 낮아서</option>
					<option>콘텐츠 불만</option>
					<option>기타</option>
				</select>
			
			<br><br>
			<input type="checkbox"> 해당 내용을 모두 확인했으며, 회원 탈퇴에 동의 합니다. 
			<br><br>
			<div id="btnRight">
			<button type="button" class="btn btn-success" onclick="deleteUser()">회원탈퇴</button>
			</div>
		</div>
		
		<!-- 여백 2-->
		<div class="col-sm-2"></div>
	</div>
	<script type="text/javascript">
	function updateInfo(){
		location.href = "/Team_Sprout/mypage/userUpdatePwChk.do";
	}
	
	function deleteInfo(){
		location.href = "/Team_Sprout/mypage/userInfoDelete.do";
	}
</script>
	<script type="text/javascript">
	 function deleteUser(){
		 if(!confirm("정말로 탈퇴하시겠습니까?")){
			 return;
		 }
		 location.href = "/Team_Sprout/mypage/userDeletePwChk.do";
	 }
	</script>
</body>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>