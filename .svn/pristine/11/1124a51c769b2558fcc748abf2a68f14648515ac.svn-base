<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<!DOCTYPE html>
<head>
<title>회원정보 수정</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="/Team_Sprout/js/common/myUtil.js"></script>
<script src="/Team_Sprout/js/jquery-3.6.0.js"></script>
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
					<h3>회원 정보 수정</h3>
					<br>
				<!-- 아이디 -->
				<div class="form-group">
					<label for="userId">아이디 </label>
					<input type="text" class="form-control"  id="userId" name="userId" readonly="readonly" value="<%=uv.getUserId() %>">
				</div>

				<!-- 비밀번호 -->
				<div class="form-group">
					<label for="userPw">수정할 비밀번호 </label>
					<input type="password" id="userPw" name="userPw" class="form-control">
				</div>
				
				<div class="span">
					<span id="spUserPassReq" style="display: none; color: red">
						영문 소문자, 영문 대문자, 숫자, 특수문자가 각각 1개 이상씩 포함된 8~12 글자 </span>
				</div>


				<!-- 비밀번호 확인 -->
				<div class="form-group" >
					<label for="userPw2">비밀번호 확인 </label>
					<input type="password" id="userPw2" class="form-control">
				</div>

				<!-- 이름 -->
				<div class="form-group">
					<label>이름</label>
					<input type="text" id="userName" class="form-control" value="<%=uv.getUserName() %>" readonly="readonly" name="userName" required>
				</div>
				
				<!-- 닉네임 -->
				<div class="form-group" >
					<label for="userNickName">닉네임 </label><br>
					<input type="text" id="userNickName" name="userNickName" class="form-control" value="<%=uv.getUserNickName() %>">
					<input type="button" class="btn btn-success"
								onclick="chkNickName()" value="중복검사">
				</div>
				<div class="span">
					<span id="spNickNameReq"
						style="display: none; color: red"> 숫자, 영어, 한국어와 언더스코어, 공백을
						허용하며 최소 2자 이상 </span>
					<span id="spNickNameCk" style="display: none; color: red">중복된 닉네임 입니다</span>
					<span id="spNickNameUse" style="display: none; color: green"></span>
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
						<input type="button" class="btn btn-success"
							onclick="sample6_execDaumPostcode()" value="우편번호 찾기">
					</div>

					<!-- 시, 도 -->
					<div class="form-group">
						<label for="sample6_address">주소 </label><br>
							<input type="text" class="form-control" id="sample6_address" name="userAdd1" value="<%=uv.getUserAdd1() %>" readonly="readonly">
						<input type="text" class="form-control" id="sample6_extraAddress" readonly="readonly">
					</div>
					<!-- 상세주소  -->
					<div class="form-group">
						<label for="sample6_detailAddress">상세주소</label>
						<input type="text"
							class="form-control" id="sample6_detailAddress" name="userAdd2" value="<%=uv.getUserAdd2() %>">
					</div>
				</div>
				<br>
				<div class="form-group">
					<input type="hidden" name="userId" id="userId" value="<%=uv.getUserId() %>">
					<input type="hidden" name="flag" id="flag" value="U">
					<input type="button" class="btn btn-success" onclick="save()" value="수정">
				</div>
			</form>
		</div>
		<!-- 여백 2-->
		<div class="col-sm-2"></div>
	</div>
</body>
<script type="text/javascript">
function updateInfo(){
	location.href = "/Team_Sprout/mypage/userUpdatePwChk.do";
}

function deleteInfo(){
	location.href = "/Team_Sprout/mypage/userInfoDelete.do";
}


function chkNickName(){
	var userNickName = $("#userNickName").val();
	
	// 닉네임 빈값 확인
	if(!isEmpty(userNickName)){
		alert("닉네임이 입력되지 않았습니다.");
		$("#userNickName").focus();
		return;
	}
	
	// 닉네임 정규식
	if(!chkRegExp($("#userNickName").val())) {
		alert("닉네임 형식이 맞지 않습니다.");
		$("#spUserNickNameReq").show();
		$("#userNickName").focus();
		return;
		}
		$("#spUserNickNameReq").hide();
		
		// 닉네임 중복검사
		$.ajax({
			url : "/Team_Sprout/user/register.do"
			, type : "post"
			, data : {
				"userNickName" : userNickName
				, "flag" : "CHKNICK"
			}
			, dataType : "json"
			, success : function(data){
				if(data.cnt == 0){
					$("#spNickNameCk").hide();
					$("#spNickNameReq").hide();
					$("#spNickNameUse").text("\'" + userNickName + "\' 사용 가능");
					$("#spNickNameUse").show();
					nickName = userNickName;
				} else if(data.cnt > 1) {
					$("#spNickNameCk").show();
					$("#spNickNameReq").hide();
					$("#spNickNameUse").hide();
					$("#userNickName").focus();
				}
			}
			, error : function(xhr){
				console.log(xhr);
			}
		});
}
//주소 API
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
                document.getElementById("sample6_extraAddress").value = extraAddr;
            
            } else {
                document.getElementById("sample6_extraAddress").value = '';
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('sample6_postcode').value = data.zonecode;
            document.getElementById("sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("sample6_detailAddress").focus();
        }
    }).open();
}

function save(){
	// 비밀번호 빈값 and 정규식
	if(!isEmpty($("#userPw").val())){
		alert("비밀번호를 입력해주세요.");
		$("#userPw").focus();
		return;
	}
	if(!chkRegExp($("#userPw").val(), "password")){
		alert("비밀번호 형식이 맞지 않습니다.");
		$("#userPw").focus();
		$("#spUserPassReq").show();
		return;
	}
	$("#spUserPassReq").hide();
	
	// 비밀번호 & 비밀번호 확인이 일치하지 않을때
	if($("#userPw").val() != $("#userPw2").val()){
		alert("비밀번호가 일치하지 않습니다.");
		$("#userPw").focus();
		return;
	}
	
	// 닉네임을 바꾸고 다시 중복검사를 하지 않았을때
	if($("#userNickName").val() == '<%=uv.getUserNickName()%>') {
		alert("닉네임 중복검사를 해주세요.");
		$("#spUserNickNameReq").show();
		$("#spNickNameUse").hide();
		$("#userNickName").focus();
		return;
	}
	// 주소 입력 안했을때
	if(!isEmpty($("#sample6_postcode").val())){
		alert("주소를 입력해주세요.");
		$("#sample6_postcode").focus();
		return;
	}
	if(!isEmpty($("#sample6_detailAddress").val())){
		alert("상세 주소를 입력해주세요.");
		$("#sample6_detailAddress").focus();
		return;
	}
	
	if(!confirm("저장하시겠습니까?")){
		return;
	}
	alert("수정이 완료되었습니다.");
	
	var fm = document.getElementById("regiForm");
	fm.method = "post";
	fm.action = "/Team_Sprout/user/register.do";
	fm.submit();
// 	$.ajax({
// 		url : "/user/register.do"
// 		, type : "post"
// 		, data : $("#regiForm").serialize()
// 		, dataType : "json"
// 		, success : function(data){
// 			console.log(data);
// 			alert("회원정보 수정 완료!");
// 		}
// 		, error : function(xhr) {
// 			alert("정보 수정에 실패했습니다. 관리자에게 문의해주세요.\n오류코드 : " + xhr.status)
// 		}
// 	});
}
</script>
</html>

