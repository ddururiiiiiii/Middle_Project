<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@page import="kr.or.ddit.project.vo.ProjectOptionVO"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<%
	ProjectVO pv = (ProjectVO) request.getAttribute("pv");

	List<ProjectVO> list = (List<ProjectVO>) request.getAttribute("list");

	ProjectOptionVO pov = (ProjectOptionVO) request.getAttribute("pov");

	List<ProjectOptionVO> listOption = (List<ProjectOptionVO>) request.getAttribute("listOption");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");

	uv = (UserVO) session.getAttribute("userVO");

	/* pov.setPjNm(pjNm); */
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/prj/prjInsert.css">
<script type="text/javascript">
	function addOp() {
		var opDiv = $('#addOpDiv').children().length;
		var str = "<div>"
				+ "<p><h4>추가 옵션</h4></p>"
				+ "<label>리워드명 </label><br><input type='text' class='form-control' id='poName' name='poName'><br>"
				+ "<label>내용 </label><br><input type='text' class='form-control' id='poContent' name='poContent'>"
				+ "<label>후원금액 </label><br><input type='text' class='form-control' id='poAddPrice' name='poAddPrice'>원<br><br>"
				+ "<button type='button' class='btn btn-success' onclick='removeOp(this)'>옵선 삭제</button><hr>"
				+ "</div>";
		if (opDiv < 2) {
			$("#addOpDiv").append(str);
		} else {
			alert("리워드 옵션은 최대 3개까지 가능합니다.");
		}
	}

	function removeOp(obj) {
		document.getElementById('addOpDiv').removeChild(obj.parentNode);
	}

	function setThumbnail() {
		var files = document.getElementById("atchFileId").files;
		var file = files[0];

		/* 선택된 파일이 없을때 경고문 출력 */
		if (files.length < 1) {
			alert("선택된 파일이 없습니다.");
			return;
		}

		/* 기존 이미지파일 제거 */
		if (document.getElementById("imgPrint").children.length > 0) {
			document.getElementById("imgPrint").children[0].remove();
		}

		/* 파일출력 */
		var reader = new FileReader();
		/* 1.이미지 파일일 경우 파일내용 불러오기*/
		if (file.type.substr(0, 5) == "image") {
			reader.readAsDataURL(file);

			/* 2.그 외의 경우 파일내용 불러오기*/
		} else {
			var reader = new FileReader();
			reader.readAsText(file);
		}

		/* 3-1.무명함수를 이용해서 불러온 파일내용 출력*/
		reader.onload = function() {
			/* 3-2.이미지파일일 경우 img태그를 생성해서 이미지 출력*/
			if (file.type.match("image")) {
				var imgObj;
				imgObj = document.createElement("img");
				imgObj.src = reader.result;
				imgObj.style.width = "100px";
				document.getElementById("imgPrint").style.height = "100px";
				document.getElementById("imgPrint").style.width = "100px";
				document.getElementById("imgPrint").appendChild(imgObj);
			}
		}
	}
</script>
<style type="text/css">
input#pjPriceAmount.form-control {
	width: 300px;
}

input#pjDday.form-control {
	width: 300px;
}

select#pjAcntBank.form-control {
	width: 300px;
}

input#pjAcntHolder.form-control {
	width: 300px;
}

input#poAddPrice.form-control {
	width: 300px;
}

input#pjAcntNum.form-control {
	width: 300px;
}

#btnDiv {
	text-align: right;
}
</style>
</head>
<body>
	<!-- 상단 전체   -->
	<div class="col-sm-12">

		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>

		<!-- 프로젝트 등록 창 -->
		<div class="col-sm-8">
			<br>
			<h3>
				<b>프로젝트 올리기</b>
			</h3>
			<form id="pj" enctype="multipart/form-data">
				<div class="form-group">
					<br>
					<br>
					<!-- 프로젝트 제목 -->
					<label>프로젝트 제목 </label> <br> <input type="text"
						class="form-control" id="pjName" name='pjName'>

					<!-- 프로젝트 카테고리 -->
					<br>
					<br>
					<label>프로젝트 카테고리</label><br> <select class="form-control"
						id="pjCategory" name="pjCategory">
						<option>게임</option>
						<option>공연</option>
						<option>디자인</option>
						<option>만화</option>
						<option>예술</option>
						<option>공예</option>
						<option>사진</option>
						<option>영화</option>
						<option>음식</option>
						<option>책</option>
						<option>테크</option>
						<option>패션</option>
					</select>

					<!-- 프로젝트 대표 이미지 (썸네일) -->
					<br>
					<br>
					<label>프로젝트 대표 이미지 </label><br> <input type="file"
						multiple="multiple" id="atchFileId" name="atchFileId"
						onchange="setThumbnail()">
					<div id="imgPrint" style="width: 100px; height: 100px;"></div>

					<!-- 프로젝트  -->
					<br>
					<br>
					<label>프로젝트 목표 금액</label><br> <input type="text"
						class="form-control" id="pjPriceAmount" name="pjPriceAmount">원

					<!-- 프로젝트 마감일 -->
					<br>
					<br>
					<label>프로젝트 마감일</label><br> <input type="date"
						class="form-control" id="pjDday" name="pjDday">

					<!-- 프로젝트 소개글 -->
					<br>
					<br>
					<label>프로젝트 소개글</label><br>
					<textarea rows="20" class="form-control" id="pjContent"
						name="pjContent"></textarea>

					<!--  프로젝트 리워드 옵션  -->
					<br>
					<br>
					<p>
					<h4>프로젝트 리워드 옵션</h4>
					</p>
					<span style="color: red;">* 프로젝트 성공 시 후원자에게 전달할 리워드를 입력해주세요.</span>
					<br>
					<br>

					<!-- 리워드 옵션 부분 -->
					<div id="option">
						<h4><p><b>필수 옵션<b></p></h4>
						<label>리워드명 </label><br> <input type="text"
							class="form-control" name='poName'><br>
						<br>
						<label>내용 </label><br> <input type="text"
							class="form-control" name='poContent'><br>
						<br> <br>
						<label>후원금액 </label><br> <input type="text"
							class="form-control" name='poAddPrice'>원<br>
						<br>
					</div>

					<!-- 옵션 추가될 곳 -->
					<div id="addOpDiv"></div>

					<!-- 옵션 추가 버튼 -->
					<br>
					<button type="button" class="btn btn-success" onclick="addOp()">옵션
						추가</button>
					<br>
					<br>

					<!-- 은행선택 -->
					<br>
					<br>
					<label>은행선택</label> <span style="color: red;">* 프로젝트 성공시
						후원금을 입금받을 계좌를 입력하세요.</span> <br> <select class="form-control"
						id="pjAcntBank" name="pjAcntBank">
						<option>은행을 선택해주세요.</option>
						<option>국민은행</option>
						<option>우리은행</option>
						<option>우체국</option>
						<option>기업은행</option>
						<option>제주은행</option>
						<option>부산은행</option>
						<option>대구은행</option>
						<option>농협</option>
						<option>수협</option>
						<option>우체국</option>
						<option>카카오뱅크</option>
						<option>케이뱅크</option>
					</select>

					<!-- 예금주 -->
					<br>
					<br>
					<label>예금주</label><br> <input type="text" class="form-control"
						id="pjAcntHolder" name="pjAcntHolder">

					<!-- 계좌번호 -->
					<br>
					<br>
					<label>계좌번호</label><br> <input type="text"
						class="form-control" id="pjAcntNum" name="pjAcntNum"> <br>
					<br> <input type="hidden" name="pjCondition" id="pjCondition"
						value="심사중"> 
						<input type="hidden" name="flag" id="flag">
				</div>


				<!-- 신청하기 버튼 -->
				<div id="btnDiv">
					<button type="button" class="btn btn-success" onclick="upload()">등록하기</button>
					<button type="button" class="btn btn-success" onclick="cancel()">취소하기</button>
				</div>
			</form>
		</div>

		<!-- 오른쪽 공백 2 -->
		<div class="col-sm-2"></div>
	</div>
</body>
<script type="text/javascript">
	function upload() {
		if (confirm("프로젝트를 등록 하시겠습니까?")) {
			document.getElementById("flag").value = "C";
			var pj = document.getElementById("pj");
			pj.method = "post";
			pj.action = "projectBoard.do";
			pj.submit();

		} else {
			return;
		}
	}

	function cancel() {
		if (confirm("글 작성을 취소하시겠습니까?")) {
			alert("목록으로 돌아갑니다.");
			var pj = document.getElementById("pj");
			pj.method = "post";
			pj.action = "projectBoard.do";
			pj.submit();
		} else {
			return;
		}
	}
</script>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>