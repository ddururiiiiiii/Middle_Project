<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<!DOCTYPE html>
<head>
<title>회원정보 수정</title>
<%
 uv = (UserVO)session.getAttribute("userVO");

%>
<link rel="stylesheet" type="text/css" href="/Team_Sprout/css/main/main.css">
<style type="text/css">
.col-sm-2 {
    padding: 10px;
}
#side {
    display: block;
	width: 100%;
    border-radius: 0px;
}
input#userId.form-control {
	width: 300px;
}
input#userPw.form-control {
	width: 300px;
}
input#userPw2.form-control {
	width: 300px;
}
input#userName.form-control {
	width: 300px;
}
input#userNickName.form-control {
	display: inline;
	width: 300px;
}
input#userBir.form-control {
	width: 300px;
}
input#sample6_postcode.form-control {
	display: inline;
	width: 300px;
}
input#userMoney.form-control {
	width: 300px;
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
			<form id="regiForm">
					<h3>회원정보조회</h3>
					<br>
				<!-- 아이디 -->
				<div class="form-group">
					<label for="userId">아이디 </label>
					<input type="text" class="form-control"  id="userId" name="userId" readonly="readonly" value="<%=uv.getUserId() %>">
				</div>

				<!-- 이름 -->
				<div class="form-group">
					<label>이름</label>
					<input type="text" id="userName" class="form-control" value="<%=uv.getUserName() %>" readonly="readonly" name="userName" required>
				</div>
				
				<!-- 닉네임 -->
				<div class="form-group" >
					<label for="userNickName">닉네임 </label><br>
					<input type="text" id="userNickName" name="userNickName" class="form-control" value="<%=uv.getUserNickName() %>" readonly="readonly">
				</div>
			
				<!-- 생년월일 -->
				<div class="form-group">
					<label for="userBir">생년월일 </label>
					<input type="text" id="userBir" name="userBir" readonly="readonly" class="form-control" value="<%=uv.getUserBir().split(" ")[0] %>"> 
				</div>

				<!-- 주소 -->
				<div>
					<br>
					<h3>주소</h3>
					<!-- 우편번호 -->
					<div class="form-group">
						<label for="sample6_postcode">우편번호 </label><br>
						<input type="text"
							class="form-control" id="sample6_postcode" name="userZip" value="<%=uv.getUserZip() %>"
							readonly="readonly">
					</div>

					<div class="form-group">
						<label for="sample6_address">주소 </label><br>
							<input type="text" class="form-control" id="sample6_address" name="userAdd1" value="<%=uv.getUserAdd1() %>" readonly="readonly">
					</div>
					<!-- 상세주소  -->
					<div class="form-group">
						<label for="sample6_detailAddress">상세주소</label>
						<input type="text"
							class="form-control" id="sample6_detailAddress" name="userAdd2" value="<%=uv.getUserAdd2() %>" readonly="readonly">
					</div>
				</div>
				<!-- 보유 포인트 -->
				<div class="form-group">
					<label for="userMoney">보유 포인트 </label>
					<input type="text" id="userMoney" name="userMoney" readonly="readonly" class="form-control" value="<%=uv.getUserMoney() %>">
				</div>
			</form>
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
</body>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>