<%@page import="kr.or.ddit.comm.vo.PagingVO"%>
<%@page import="kr.or.ddit.user.vo.UserVO"%>
<%@page import="kr.or.ddit.boardComment.vo.FreeCmVO"%>
<%@page import="kr.or.ddit.comm.vo.AtchFileVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.board.vo.FreeBoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@include file="/WEB-INF/view/include/adminHead.jsp"%>
<%
	FreeBoardVO fv = (FreeBoardVO)request.getAttribute("fv");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
	
	List<FreeCmVO> freeCmList = (List<FreeCmVO>)request.getAttribute("freeCmList");
	
	 UserVO uv = (UserVO)session.getAttribute("userVO");
	
	PagingVO pv = (PagingVO)request.getAttribute("pv");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세조회</title>
<link rel="stylesheet" type="text/css"
	href="/Team_Sprout/css/main/main.css">
<link rel="stylesheet" href="/Team_Sprout/css/main/boardDetail.css">
</head>
<body>
	<!-- 전체-->
	<div class="col-sm-12">

		<!-- 왼쪽 여백 -->
		<div class="col-sm-2"></div>

		<!-- 게시판 -->
		<div class="col-sm-8">
			<h4>
				<b>자유게시판 상세조회</b>
			</h4>
			<table class="table">
			<thead>
				<tr id="head">
					<th>번호</th>
					<td><%=fv.getFreeNm() %></td>
					<th>작성일</th>
					<td><%=fv.getFreeDate() %></td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>작성자</th>
					<td colspan="3"><%=fv.getFreeWriter() %></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><%=fv.getFreeTitle() %></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3" id="imgPrint">
					<p><%=fv.getFreeContent() %></p>
				<%
					if (atchFileList != null) {
						for (AtchFileVO atchFileVO : atchFileList) {
							System.out.println(atchFileVO.getImgUrl());
				%>
				<img src='<%=atchFileVO.getImgUrl()%>' >
				<%
					}
					}
				%>
				</td>
				</tr>
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
			<input type="hidden" name="freeNm" id="freeNm">
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
		<h4><b><span>댓글 총 <%=freeCmList.size() %>개</span></b></h4>
		<table class="table">
			<thead>
				<tr>
					<th>작성자</th>
					<th style="text-align: left;">댓글</th>
					<th style="text-align: left;">작성일</th>
				</tr>
			</thead>
			<tbody>
			<%
			if(freeCmList.size() == 0){
			%>
			<tr>
				<td colspan="3" align="center">댓글이 없습니다.</td>
			</tr>
			<%	
			} else {
				for(int i = 0; i < freeCmList.size(); i++){
			%>
			<tr>
				<td style="text-align: left;">
				<%=freeCmList.get(i).getFcWriter() %>
				</td>
				<td style="text-align: left;"><%=freeCmList.get(i).getFcContent() %></td>
				<td><%=freeCmList.get(i).getFcDate() %>
					<%if(uv != null) {
						if(uv.getUserNickName().equals(freeCmList.get(i).getFcWriter())){
						%>
						<div class="btn-group" style="float: right;">
							<button type="button" class="btn btn-default btn-xs dropdown-toggle"
								data-toggle="dropdown">
								<span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu" id="cmtMenu">
								<li><a data-toggle="modal" data-target="#myModal" onclick="openModifyModal('<%=freeCmList.get(i).getFcNm() %>')">수정</a>
								</li>
								<li><a href="#" onclick="cmDelete('<%=freeCmList.get(i).getFcNm() %>')">삭제</a></li>
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
			<!-- 페이징 처리 시작 -->
			<%if(pv.getTotalCount() > 0) {%>
			<tr align="center">
				<td>
				<%if(pv.getFirstPageNo() > pv.getPageSize()) { %>
				<a href="adminFreeBoardComment.do?freeNm=<%=fv.getFreeNm() %>&pageNo=<%=pv.getFirstPageNo() - pv.getPageSize() %>">이전</a>
				<%} %>
				<%for(int pNo = pv.getFirstPageNo(); pNo <= pv.getLastPageNo(); pNo++){ %>
					<a href="adminFreeBoardComment.do?freeNm=<%=fv.getFreeNm() %>&pageNo=<%=pNo %>">
						<%=pNo %>
					</a>
				<%} %>
				<%if(pv.getLastPageNo() < pv.getTotalPageCount()){ %>
				<a href="adminFreeBoardComment.do?freeNm=<%=fv.getFreeNm() %>&pageNo=<%=pv.getFirstPageNo() + pv.getPageSize() %>">다음</a>
				<td>
			</tr>
			<%}
			} %>
		<!-- 페이징 처리 끝.. -->
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
		          <input type="hidden" id="modalFcNm">
		        </div>
		      </div>
		 	</div>
  		</div>
  		<!-- 댓글 수정 Modal END -->
		  		
		<form id="fmCm">
			<input type="hidden" id="freeNmCm" name="freeNmCm">
			<input type="hidden" id="fmFcNm" name="fcNmCm">
			<input type="hidden" id="comment" name="fcContent">
			<input type="hidden" id="userId" name="userId">
			<input type="hidden" id="cmType" name="fcType">
			<input type="hidden" id="flagCm" name="flagCm">
		</form>
</div>
		
		<!-- 오른쪽 여백 -->
		<div class="col-sm-2"></div>
		
	</div>
</body>
<script type="text/javascript">
// 	$(document).ready(function(){
// 		$("#updateWrite").css("display", "none");
// 		$("#deleteWrite").css("display", "none");
<%-- 		<% --%>
// 		if(uv != null){
// 			if(uv.getUserNickName().equals(fv.getFreeWriter())){
<%-- 			%> --%>
// 			$("#updateWrite").css("display", "inline");
// 			$("#deleteWrite").css("display", "inline");
<%-- 			<% --%>
// 			}
// 		}
<%-- 		%> --%>
// 	});
	
	function goList(){
		location.href = "adminFreeBoard.do";
	}
	function updateBoard(){
		document.getElementById("freeNm").value = "<%=fv.getFreeNm() %>";
		document.getElementById("flag").value = "UPD";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "adminFreeBoard.do";
		fm.submit();
	}
	function deleteBoard(){
		if(confirm("정말로 삭제하시겠습니까?")){
			alert("삭제되었습니다.");
			document.getElementById("freeNm").value = "<%=fv.getFreeNm() %>";
			document.getElementById("flag").value = "D";
			var fm = document.getElementById("fm");
			fm.method = "post";
			fm.action = "adminFreeBoard.do";
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
		document.getElementById("freeNmCm").value = "<%=fv.getFreeNm() %>";
		<%
		if(uv != null){
		%>
		document.getElementById("userId").value = "<%=uv.getUserId() %>";
		<%}%>
		document.getElementById("comment").value = $("#commentWrite").val();
		document.getElementById("flagCm").value = "C";
		var fmCm = document.getElementById("fmCm");
		fmCm.method = "post";
		fmCm.action = "adminFreeBoardComment.do";
		fmCm.submit();
	}
	
	function cmUpdate(){
		var fcNm = $("#modalFcNm").val();
		if(confirm("수정하시겠습니까?")){
			alert("수정되었습니다.");
			<%
			if(uv != null){
			%>
			document.getElementById("userId").value = "<%=uv.getUserId() %>";
			<%}	%>
			document.getElementById("freeNmCm").value = "<%=fv.getFreeNm() %>";
			document.getElementById("fmFcNm").value = fcNm;
			document.getElementById("comment").value = $("#editCm").val();
			document.getElementById("flagCm").value = "U";
			var fm = document.getElementById("fmCm");
			fmCm.method = "post";
			fmCm.action = "adminFreeBoardComment.do";
			fmCm.submit();
		}
		return;
	}
	
	function cmDelete(fcNm){
		if(confirm("정말 댓글을 삭제하시겠습니까?")){
			alert("댓글이 삭제되었습니다.");
			<%
			if(uv != null){
			%>
			document.getElementById("userId").value = "<%=uv.getUserId() %>";
			<%}%>
			document.getElementById("freeNmCm").value = "<%=fv.getFreeNm() %>";
			document.getElementById("fmFcNm").value = fcNm;
			document.getElementById("flagCm").value = "D";
			var fmCm = document.getElementById("fmCm");
			fmCm.method = "post";
			fmCm.action = "adminFreeBoardComment.do";
			fmCm.submit();
		}
		return;
	}
	
	function openModifyModal(fcNm){
		$("#modalFcNm").val(fcNm);
	}
</script>
</html>