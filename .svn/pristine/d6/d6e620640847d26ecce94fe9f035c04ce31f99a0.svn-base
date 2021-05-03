<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>

<!DOCTYPE html>
<script type="text/javascript">
$(document).ready(function(){
	<%
	 uv = (UserVO)session.getAttribute("userVO");

	%>
});

</script>
<head>
<title>마이페이지 - 포인트 </title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<style type="text/css">
#pointDiv {
 width: 100%;
 height: 300px;
	background-color: #fafafa;
	border: 1px solid #efefef;
	padding: 30px;
	text-align: center;
}

</style>
</head>
<body>

	<!-- Modal -->
	<div id="myModal" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">포인트 충전하기</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<select id="pointSel">
							<option>금액을 선택하세요.</option>
							<option id="point1" value="1000">1,000원 (1,000 포인트)</option>
							<option id="point2" value="5000">5,000원 (5,000 포인트)</option>
							<option id="point3" value="10000">10,000원 (10,000 포인트)</option>
							<option id="point4" value="30000">30,000원 (30,000포인트)</option>
							<option id="point5" value="50000">50,000원 (50,000포인트)</option>
						</select>
						
					</div>
<!-- 						<iframe src="https://payapplite.com/l/uVNTy1" width="420" height="610" title="1000포인트" id="i1" style="display:none;"></iframe> -->
<!-- 						<iframe src="https://payapplite.com/l/UyFgSD" width="420" height="610" title="5000포인트" id="i2" style="display:none;"></iframe> -->
<!-- 						<iframe src="https://payapplite.com/l/Ld2YZQ" width="420" height="610" title="10000포인트" id="i3" style="display:none;"></iframe> -->
<!-- 						<iframe src="https://payapplite.com/l/yAMS13" width="420" height="610" title="30000포인트" id="i4" style="display:none;"></iframe> -->
<!-- 						<iframe src="https://payapplite.com/l/7Jgnt8" width="420" height="610" title="50000포인트" id="i5" style="display:none;"></iframe>		 -->
						<h4 style="text-align: center;" id="userInputPoint" >  </h4>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-success" onclick="charge()">확인</button>
				</div>
			</div>
		</div>
		
	</div>
	
	<!-- Modal -->
	<div id="myModalRefund" class="modal fade" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">포인트 환불하기</h4>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<input type="text" id="pointRefundInput" value="" name="RefundPoint">
					</div>
				</div>
				<div class="modal-footer">
					<p style="color: red;">※ 환불은 현재 보유 포인트가 1000 포인트 이상일 때만 환불이 가능합니다.</p>
					<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
					<button type="button" class="btn btn-success" onclick="refund()">확인</button>
				</div>
			</div>
		</div>
		
	</div>

	<!-- 회원정보 수정  -->
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>

		<!-- 회원정보 수정 -->
		<div class="col-sm-8">
		<br><br>
			<div id="pointDiv">
			<form action="#" id="regiForm">
				<h3>포인트 충전/환불</h3>
				<br>
				<h4 style="text-align: center;">현재 보유포인트 <%=uv.getUserMoney()%></h4>
				<br>
				<!-- Trigger the modal with a button -->
				<button type="button" class="btn btn-success"
					data-toggle="modal" data-target="#myModal">충전</button>
				<button type="button" class="btn btn-success"
					data-toggle="modal" data-target="#myModalRefund">환불</button>
			
				<br><br>
				<div>
					<p style="color: red;">※ 환불은 현재 보유 포인트가 1000 포인트 이상일 때만 환불이
						가능합니다.</p>
				</div>
			</form>
			</div>
		</div>

		<!-- 여백 2-->
		<div class="col-sm-2"></div>
	</div>

	<form id="fm">
		<input type="hidden" name="userId" id="userId">
		<input type="hidden" name="userMoney" id="userMoney">
		<input type="hidden" name="flag" id="flag">
	</form>
	
</body>
<script type="text/javascript">
$(document).ready(function() { 
	
	  $('#pointSel').change(function() {
	    var point = $('#pointSel option:selected').val();
	    if (point == 1000) {
	      $('#i1').show();
	      $("#i2").hide();
	      $("#i3").hide();
	      $("#i4").hide();
	      $("#i5").hide(); 
	    } else if(point == 5000){
    	  $('#i2').show();
	      $("#i1").hide();
	      $("#i3").hide();
	      $("#i4").hide();
	      $("#i5").hide();
	    } else if(point == 10000){
	      $('#i3').show();
	      $("#i1").hide();
	      $("#i2").hide();
	      $("#i4").hide();
	      $("#i5").hide();
	    } else if(point == 30000){
    	  $('#i4').show();
	      $("#i2").hide();
	      $("#i1").hide();
	      $("#i4").hide();
	      $("#i5").hide();
	    } else if(point == 50000){
    	  $('#i5').show();
	      $("#i2").hide();
	      $("#i3").hide();
	      $("#i4").hide();
	      $("#i1").hide();
	    }
	  }); 
	}); 
	

function charge(){		

var point = $("#pointSel option:selected").val();

	if(point == 1000){

		alert(point + " 포인트 충전이 완료되었습니다.");
		document.getElementById("userMoney").value = 1000;
	 	var fm = document.getElementById("fm");
		fm.action = "userPointHandler.do";
		document.getElementById("flag").value = "U";
		fm.method = "post";
		fm.submit();

	}else if(point == 5000){

		alert(point + " 포인트 충전이 완료되었습니다.");
		document.getElementById("userMoney").value = 5000;
	 	var fm = document.getElementById("fm");
		fm.action = "userPointHandler.do";
		document.getElementById("flag").value = "U";
		fm.method = "post";
		fm.submit();

	}else if(point == 10000){

		alert(point + " 포인트 충전이 완료되었습니다.");
	 	document.getElementById("userMoney").value = 10000;
	 	var fm = document.getElementById("fm");
		fm.action = "userPointHandler.do";
		document.getElementById("flag").value = "U";
		fm.method = "post";
		fm.submit();

	}else if(point == 30000){
		
		alert(point + " 포인트 충전이 완료되었습니다.");
		document.getElementById("userMoney").value = 30000;
	 	var fm = document.getElementById("fm");
		fm.action = "userPointHandler.do";
		document.getElementById("flag").value = "U";
		fm.method = "post";
		fm.submit();

	}else if(point == 50000){
	
		alert(point + " 포인트 충전이 완료되었습니다.");
		document.getElementById("userMoney").value = 50000;
	 	var fm = document.getElementById("fm");
		fm.action = "userPointHandler.do";
		document.getElementById("flag").value = "U";
		fm.method = "post";
		fm.submit();

	}
	
}

function refund(){

	var refundPoint = $("#pointRefundInput").val();
	
	if(refundPoint < <%=uv.getUserMoney() %>){
		document.getElementById("userMoney").value = refundPoint;
			var fm = document.getElementById("fm");
		fm.action = "userPointHandler.do";
		document.getElementById("flag").value = "UF";
		fm.method = "post";
		fm.submit();
	}else if(refundPoint > <%=uv.getUserMoney() %>){
		alert("환불 가능한 금액이 아닙니다.");
		$("#pointRefundInput").focus();
		$("#pointRefundInput").val('');
		return;
	}

	
}
</script>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>

