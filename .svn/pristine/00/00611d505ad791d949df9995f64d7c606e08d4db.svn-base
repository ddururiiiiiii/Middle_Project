<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	String chk = (String)request.getAttribute("chk");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>비밀번호 확인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="/Team_Sprout/css/login/login.css">
<script type="text/javascript">
	$(document).ready(function(){
		<%
		if("T".equals(chk)){
		%>
		location.href = "userInfoUpdate.do";
		<%
		} else if ("F".equals(chk)){
		%>
		alert("비밀번호가 일치하지 않습니다.");
		$("#userPw").focus();
		<%
		}
		%>
	});
</script>
</head>
<body>
 	<div class="wrapper">
	    <form action="userUpdatePwChk.do" method="post">
		    <div class="title">
				<img src="/Team_Sprout/images/logo.png" width="100px">
			</div>
			<div class="field">
				<input type="password" required name="userPw" id="userPw">
				<label>비밀번호를 입력해주세요.</label>
			</div>
			<div class="field">
			  <input type="submit" value="입력">
			</div>
	    </form>
    </div>
</body>
</html>