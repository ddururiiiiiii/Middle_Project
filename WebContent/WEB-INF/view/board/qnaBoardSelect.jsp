<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.boardComment.vo.QnaCmVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.QnaBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<%
	QnaBoardVO qbv = (QnaBoardVO)request.getAttribute("qbv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	
	AtchFileVO atchVO = new AtchFileVO();
	
	List<QnaCmVO> qnaCmList = (List<QnaCmVO>)request.getAttribute("qnaCmList");
	
	uv = (UserVO)session.getAttribute("userVO");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회</title>
<meta charset="utf-8">
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/boardDetail.css">
<style type="text/css">
#menu_title {
	text-align: center;
	background-image: url('/Team_Sprout/images/main_image.png');
	width: 100%;
	height: 250px;
	color: white;
}
div.col-sm-12 {
	margin: 0px;
	padding: 0px;
}
.table>tbody>tr>td, .table>tbody>tr>th, .table>tfoot>tr>td, .table>tfoot>tr>th, .table>thead>tr>td, .table>thead>tr>th {
    width: 10px;
}
</style>
</head>
<body>
<!-- 헤더 이미지 및 문구 -->
	<div class="col-sm-12">
		<div id="menu_title">
			<p>
			
			<br><br><br>
				<h3><b>Q & A</b></h3>
				<br>
				* 이용 중 궁금한 사항들을 질문하는 게시판입니다.
			</p>
		</div>
	</div>
		<!-- 전체-->
	<div class="col-sm-12">

		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>

		<!-- 게시판 -->
		<div class="col-sm-8">
		<br><br>
		<table class="table">
			<thead>
				<tr id="head">
					<th>번호</th>
					<td><%=qbv.getQnaNm() %></td>
					<th>작성일</th>
					<td><%=qbv.getQnaDate() %></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>작성자</th>
					<td colspan="3"><%=qbv.getQnaWriter() %></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><%=qbv.getQnaTitle() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3" id="imgPrint"><%=qbv.getQnaContent() %>
								<%
			if(atchFileList != null){
				for(AtchFileVO atchFileVO : atchFileList){
			%>
				<img src='<%=atchFileVO.getImgUrl()%>' style="width: 100%;">
			<%
				}
			}
			 %>
			</td>

				<tr>
					<th>첨부파일</th>
					<td colspan="3">
						<%
					if(atchFileList != null){
						for(AtchFileVO atchFileVO : atchFileList){
					%>
						<div>
							<a
							href="<%=request.getContextPath() %>/filedownload.do?fileId=<%=atchFileVO.getAtchFileId() %>&fileSn=<%=atchFileVO.getFileSn()%>">
							<%=atchFileVO.getOrignlFileNm() %></a>
						</div>
						<%	
						}
					}
					%>
				</td>
			</tr>
			</tbody>
		</table>
		<form id="fm" enctype="multipart/form-data">
			<input type="hidden" name="qnaNm" id="qnaNm">
			<input type="hidden" name="flag" id="flag">
		</form>
		<hr>
		<!-- 등록 수정 삭제 버튼  -->
		<div id="btn" align="right">
			<button type="button" class="btn btn-success" onclick="goList()">목록</button>
			<button type="button" id="updateWrite" class="btn btn-success" onclick="updateBoard()">수정</button>
			<button type="button" id="deleteWrite" class="btn btn-success" onclick="deleteBoard()">삭제</button>
		</div>	
		<hr>
		<!-- 댓글 조회 -->
		<h4><b><span>댓글 총 <%=qnaCmList.size() %>개</span></b></h4>
		<table class="table">
			<thead>
				<tr>
					<th style="text-align: center;">작성자</th>
					<th style="text-align: center;">댓글</th>
					<th style="text-align: center;">작성일</th>
				</tr>
			</thead>
			<tbody>
			<%
			for(int i = 0; i < qnaCmList.size(); i++){
				if(qnaCmList.size() == 0){
				%>
				<tr>
					<td colspan="3" align="center">댓글이 없습니다.</td>
				</tr>
				<%	
				} else {
				%>
				<tr>
					<td style="text-align: center;">
					<%=qnaCmList.get(i).getqcWriter() %>
					</td>
					<td style="text-align: left;"><%=qnaCmList.get(i).getQcContent() %></td>
					<td style="text-align: right;"><%=qnaCmList.get(i).getQcDate() %>
						<%if(uv != null) {
							if(uv.getUserNickName().equals(qnaCmList.get(i).getqcWriter())){
							%>
							<div class="btn-group" style="float: right;">
								<button type="button" class="btn btn-default btn-xs dropdown-toggle"
									data-toggle="dropdown">
									<span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu" id="cmtMenu">
									<li><a data-toggle="modal" data-target="#myModal" onclick="openModifyModal('<%=qnaCmList.get(i).getQcNm() %>')">수정</a>
									</li>
									<li><a href="#" onclick="cmDelete('<%=qnaCmList.get(i).getQcNm() %>')">삭제</a></li>
								</ul>
							</div>
							<%
							}
						}
						%>
					</td>
				</tr>
			<%
				}
			}
			%>
			</tbody>
		</table>
		<hr>
		<!-- 댓글 작성  -->
		<h4><b><span>댓글 작성</span></b></h4>
		<table class="table">
			<thead>
				<tr>
					<th></th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td colspan="3">
						<%
						if(uv == null)  {
						%>
						<textarea class="form-control" readonly="readonly" rows="5" placeholder="댓글은 회원만 작성할 수 있습니다."></textarea>
						<%
						} else {
						%>
						<textarea class="form-control" rows="5" id="commentWrite"></textarea>
<!-- 						<div class="checkbox"> -->
<!-- 							<label><input type="checkbox" id="secret">비공개</label> -->
<!-- 						</div> -->
						<%
						}
						%>
					</td>
				</tr>
				<tr>
					<td colspan="3" style="text-align: right;">
						<button type="button" class="btn btn-success" onclick="cmCreate()">댓글 등록</button>
					</td>
				</tr>	
				
			</tbody>
		</table>
		
		<!-- 댓글 수정 Modal -->
		<div class="modal fade" id="myModal" role="dialog">
			<div class="modal-dialog">
		      <!-- 수정 Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">댓글 수정하기</h4>
		        </div>
		        <div class="modal-body">
		          <textarea class="form-control" rows="3" id="editCm"></textarea>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" onclick="cmUpdate()">저장</button>
		          <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
		          <input type="hidden" id="modalQcNm">
		        </div>
		      </div>
		 	</div>
  		</div>
  		<!-- 댓글 수정 Modal END -->
		  		
		<form id="fmCm">
			<input type="hidden" id="qnaNmCm" name="qnaNmCm">
			<input type="hidden" id="fmQcNm" name="qcNmCm">
			<input type="hidden" id="comment" name="qcContent">
			<input type="hidden" id="userId" name="userId">
			<input type="hidden" id="cmType" name="qcType">
			<input type="hidden" id="flagCm" name="flagCm">
		</form>
				<!-- 등록 수정 삭제 버튼  -->
		<div id="btn" align="right">
			<button type="button" class="btn btn-success" onclick="goList()">목록</button>
			<button type="button" id="updateWrite" class="btn btn-success" onclick="updateBoard()">수정</button>
			<button type="button" id="deleteWrite" class="btn btn-success" onclick="deleteBoard()">삭제</button>
		</div>
	</div>
			
		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>
	</div>
	</body>
<script type="text/javascript">
	$(document).ready(function(){
		$("#updateWrite").css("display", "none");
		$("#deleteWrite").css("display", "none");
		<%
		if(uv != null){
			if(uv.getUserNickName().equals(qbv.getQnaWriter())){
			%>
				$("#updateWrite").css("display", "inline");
				$("#deleteWrite").css("display", "inline");
			<%
			}
		}
		%>
	});
	
	function goList(){
		location.href = "qnaBoard.do";
	}
	
	function updateBoard(){
		document.getElementById("qnaNm").value = "<%=qbv.getQnaNm() %>";
		document.getElementById("flag").value = "UPD";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "qnaBoard.do";
		fm.submit();
	}
	
	function deleteBoard(){
		if(confirm("정말로 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			document.getElementById("qnaNm").value = "<%=qbv.getQnaNm() %>";
			document.getElementById("flag").value = "D";
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "qnaBoard.do";
			fm.submit();
		} else {
			return;
		}
	}
	function cmCreate(){
		<%if(uv == null){%>
			alert("댓글은 회원만 작성 가능합니다.");
			return;
		<%}%>
		document.getElementById("qnaNmCm").value = "<%=qbv.getQnaNm() %>";
		<%
		if(uv != null){
		%>
		document.getElementById("userId").value = "<%=uv.getUserId() %>";
		<%}%>
		document.getElementById("comment").value = $("#commentWrite").val();
		document.getElementById("flagCm").value = "C";
		var fmCm = document.getElementById("fmCm");
		fmCm.method = "post";
		fmCm.action = "qnaBoardComment.do";
		fmCm.submit();
	}
	
	function cmUpdate(){
		var qcNm = $("#modalQcNm").val();
		if(confirm("수정하시겠습니까?")){
			alert("수정이 완료되었습니다.");
			<%
			if(uv != null){
			%>
			document.getElementById("userId").value = "<%=uv.getUserId() %>";
			<%}%>
			document.getElementById("qnaNmCm").value = "<%=qbv.getQnaNm() %>";
			document.getElementById("fmQcNm").value = qcNm;
			document.getElementById("comment").value = $("#editCm").val();
			document.getElementById("flagCm").value = "U";
			var fmCm = document.getElementById("fmCm");
			fmCm.method = "post";
			fmCm.action = "qnaBoardComment.do";
			fmCm.submit();
		}
		return;
	}
	
	function cmDelete(qcNm){
		if(confirm("정말 댓글을 삭제하시겠습니까?")){
			alert("댓글이 삭제되었습니다.");
			<%
			if(uv != null){
			%>
			document.getElementById("userId").value = "<%=uv.getUserId() %>";
			<%}%>
			document.getElementById("qnaNmCm").value = "<%=qbv.getQnaNm() %>";
			document.getElementById("fmQcNm").value = qcNm;
			document.getElementById("flagCm").value = "D";
			var fmCm = document.getElementById("fmCm");
			fmCm.method = "post";
			fmCm.action = "qnaBoardComment.do";
			fmCm.submit();
		}
		return;
	}
	
	function openModifyModal(qcNm){
		$("#modalQcNm").val(qcNm);
	}
</script>

<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>

