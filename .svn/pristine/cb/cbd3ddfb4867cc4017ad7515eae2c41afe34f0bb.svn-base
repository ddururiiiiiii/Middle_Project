<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVO uv = (UserVO) request.getSession().getAttribute("userVO");

	String chk = (String) request.getAttribute("chk");
%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<meta charset="UTF-8">
    <meta charset="utf-8">
   <!----<title>Login Form Design | CodeLab</title>---->
    <link rel="stylesheet" href="/Team_Sprout/css/login/login.css">
	<script type="text/javascript">
		$(document).ready(function(){
			<%
			if("T".equals(chk)){
			%>
			alert("\'<%=uv.getUserName()%>\' 님 환영합니다");
			location.href = "/Team_Sprout/html/main/main.jsp";
			<%
			} else if ("F".equals(chk)){
			%>
			alert("아이디 혹은 비밀번호가 잘못되었습니다.");
			$("#userId").focus();
			<%
			}
			%>
		});
	</script>
</head>
<body>
    <div class="wrapper">
	    <div class="title">
		<a href="/Team_Sprout/html/main/main.jsp"><img src="/Team_Sprout/images/logo.png" width="100px"></a>
	</div>
		<form action="signIn.do" method="post">
	      	<div class="field">
				<input type="text" required name="userId" id="userId">
				<label>아이디를 입력해주세요.</label>
			</div>
			<div class="field">
				<input type="password" required name="userPw" id="userPw">
				<label>비밀번호를 입력해주세요.</label>
			</div>
			<div class="content">
				<div class="checkbox">
			    	<input type="checkbox" id="remember-me">
			    	<label for="remember-me">ID 저장</label>
			  	</div>
				<div class="pass-link"><a href="#">아이디를 잊어버리셨나요?</a></div>
			</div>
			<div class="field">
			  <input type="submit" value="Login">
			</div>
			<div class="signup-link">회원이 아니신가요? <a href="register.do">회원가입</a></div>
		</form>
    </div>
</body>
</html>
