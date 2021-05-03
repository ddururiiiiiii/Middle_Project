<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="/js/jquery-3.6.0.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/js/login/register.js"></script>
<script src="/js/common/myUtil.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<link rel="stylesheet" href="/Team_Sprout/css/login/register.css">
<script src="https://www.google.com/recaptcha/api.js" async defer></script>
</head>
<body>
	<br>
	<br>
	<div class="wrapper">
		<div class="title">
			<img src="/Team_Sprout/images/logo.png" width="100px">
		</div>
		<form id="regiForm">

			<!-- 아이디 -->
			<div class="field">
				<input type="text" id="userId" name="userId" required> <label>아이디</label>
			</div>

			<div class="span" align="center">		
				<span id="spUserIdCk" style="display: none; color: red">중복된 ID 입니다</span>
				<span id="spUserIdUse" style="display: none; color: green"></span>
				<span id="spUserIdReq" style="display: none; color: red"> 영문 소문자는 반드시 포함하고, 영문 소문자와 숫자의 조합으로 4~12 글자 </span>
				<span id="spUserIdDntUse" style="display: none; color: red"> 중복된 ID입니다. </span>
			</div>

			<div class="field">
				<input type="button" value="ID 중복검사" id="btnUserId">
			</div>

			<!-- 비밀번호 -->
			<div class="field">
				<input type="password" id="userPw" name="userPw" required> <label>비밀번호</label>
			</div>

			<div class="span">
				<span id="spUserPassReq" style="display: none; color: red">
					영문 소문자, 영문 대문자, 숫자, 특수문자가 각각 1개 이상씩 포함된 8~12 글자 </span>
			</div>


			<!-- 비밀번호 확인 -->
			<div class="field">
				<input type="password" id="userPw2" required> <label>비밀번호
					확인</label>
			</div>

			<!-- 이름 -->
			<div class="field">
				<input type="text" id="userName" name="userkName" required>
				<label>이름</label>
			</div>
			
			<!-- 닉네임 -->
			<div class="field">
				<input type="text" id="userNickName" name="userNickName" required>
				<label>닉네임</label>
			</div>

			<div class="span">
				<span id="spUserNickNameReq"
					style="display: none; color: red"> 숫자, 영어, 한국어와 언더스코어, 공백을
					허용하며 최소 2자 이상 </span>
			</div>


			<!-- 생년월일 -->
			<div id="birth">
				<br>
				<h3>생년월일</h3>
				<div class="field">
					<input type="text" id="year" required> <label>년</label>
				</div>
				<div class="field">
					<select id="month"></select>
				</div>
				<div class="field">
					<input type="text" id="day" required> <label>일 </label> <input
						type="hidden" id="userBir" name="userBir">
				</div>
			</div>

			<!-- 성별 -->
			<div>
				<br>
				<h3>성별</h3>
				<div class="content">
					<label><input type="radio" name="gender" id="male" value="남자"
						checked="checked"> 남자</label> 
					<label><input type="radio" value="여자"
						name="gender" id="female"> 여자</label>
				</div>
			</div>

			<!-- 관심분야  -->
			<h3>관심분야</h3>
			<div id="likey"></div>

			<!-- 주소 -->
			<div>
				<br>
				<h3>주소</h3>
				<div class="field">
					<input type="text" id="sample6_postcode" name="userZip"
						placeholder="우편번호를 검색하세요." readonly="readonly">
				</div>

				<div class="field">
					<input type="button" onclick="sample6_execDaumPostcode()"
						value="우편번호 찾기">
				</div>

				<div class="field">
					<input type="text" id="sample6_address" name="userAdd1"
						placeholder="도, 시 " readonly="readonly">
				</div>

				<div class="field">
					<input type="text" id="sample6_extraAddress" placeholder="구, 군"
						readonly="readonly">
				</div>

				<div class="field">
					<input type="text" id="sample6_detailAddress" name="userAdd2"
						required> <label>상세주소를 입력하세요.</label>
				</div>
			</div>
			<br>

			<!-- 구글 리캡챠(로봇이 아닙니다) -->
			<div class="g-recaptcha"
				data-sitekey="6LeODLMaAAAAADZ6qbdrcHwUvZ-_ZvwfJZhTk28l"
				align="center" id="capcha"></div>

			<!-- 저장 , 초기화 버튼  -->
			<div class="field">
				<button type="reset" id="resetbtn">초기화</button>
			</div>

			<div class="field">
				<input type="text" style="display: none" id="flag" value="C">
				<input type="button" onclick="save()" value="회원가입">
			</div>
		</form>
	</div>
	<br>
	<br>
</body>
</html>