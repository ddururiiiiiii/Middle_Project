<%@page import="java.util.Arrays"%>
<%@page import="kr.or.ddit.project.vo.ProjectVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/view/include/head.jsp"%>
<jsp:include page="/WEB-INF/view/include/slide.html" />
<%
	List<ProjectVO> projectList = (List<ProjectVO>)request.getAttribute("projectList");
%>
<!DOCTYPE html>
<head>
<title>Sprout</title>
<meta charset="utf-8">
<style>
img.img-rounded {
	width: 100%;
	height: 200px;
}

.gold {
	font-weight: bolder;
}
p.pHei {
	height: 55px;
}
</style>
</head>
<body>
	<div class="col-sm-12">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<h3 style="text-align: left; font-weight: bold">오늘 마감 프로젝트</h3>
		</div>
		<div class="col-sm-2"></div>
	</div>
	<!-- 펀딩 리스트 12 -->
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>
		<%
			int cnt = 0;
			for(int i = 0; i < projectList.size(); i++){
				if(Integer.parseInt(projectList.get(i).getPjExpDate()) == 0){%>
		<div class="col-sm-2">
			<img
				src="<%=request.getContextPath()%>/filedownload.do?fileId=<%=projectList.get(i).getAtchFileId()%>&fileSn=1"
				class="img-rounded" style="width: 100%" alt="Image">
			<h4>
				<p class="pHei" onclick="projectSelect('<%=projectList.get(i).getPjNm() %>')">
					<%=projectList.get(i).getPjName() %>
				</p>
			</h4>
			<p>
				<%=projectList.get(i).getPjCategory() %>
			</p>
			<span class="gold"><%=projectList.get(i).getPjPricePer() %>%
				달성</span>
			<div class="progress">
				<%
					int per = projectList.get(i).getPjPricePer();
					if (per > 100){
						per = 100;
					}
					%>
				<div class="progress-bar progress-bar-success" role="progressbar"
					aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
					style="width:<%=per%>%">
				</div>
			</div>







			<div class="time">
				<span class="glyphicon glyphicon-time"></span> <span>오늘 마감</span>
			</div>
		</div>
		<%
				cnt = cnt + 1;
				}
				if(cnt % 4 == 0) {%>
		<!-- 오른쪽 여백 2-->
		<div class="col-sm-2"></div>
	</div>
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>
		<%}
			}
			%>
		<!-- 오른쪽 여백 2-->
		<div class="col-sm-2"></div>
	</div>

	<!-- main 12-->
	<div class="col-sm-12">
		<div class="col-sm-2"></div>
		<div class="col-sm-8">
			<h3 style="text-align: left; font-weight: bold">주목할만한 프로젝트</h3>
			<br>
		</div>
		<div class="col-sm-2"></div>
	</div>

	<!-- 펀딩 리스트 12 -->
	<div class="col-sm-12">
		<!-- 왼쪽 공백 2 -->
		<div class="col-sm-2"></div>
		<%
		int[] nums = new int[4];
		int tmp = 0;
		for(int i = 0; i < 4; i++){
			nums[i] = (int)(Math.random() * projectList.size() - 1);
			for(int j = 0; j < i; j++){
				if(nums[i] == nums[j]){
					i--;
					break;
				}
			}
		}
		Arrays.sort(nums);
		System.out.print(Arrays.toString(nums));
		for(int i = 0; i < 4; i++){
		%>
		<div class="col-sm-2">
			<img
				src="<%=request.getContextPath()%>/filedownload.do?fileId=<%=projectList.get(nums[i]).getAtchFileId()%>&fileSn=1"
				class="img-rounded" style="width: 100%" alt="Image">
			<h4>
				<p class="pHei" onclick="projectSelect('<%=projectList.get(i).getPjNm() %>')">
					<%=projectList.get(i).getPjName() %>
				</p>
			</h4>
			<p>
				<%=projectList.get(nums[i]).getPjCategory() %>
			</p>
			<span class="gold"><%=projectList.get(nums[i]).getPjPricePer() %>%
				달성</span>
			<div class="progress">
				<%
					int per = projectList.get(nums[i]).getPjPricePer();
					if (per > 100){
						per = 100;
					}
					%>
				<div class="progress-bar progress-bar-success" role="progressbar"
					aria-valuenow="40" aria-valuemin="0" aria-valuemax="100"
					style="width:<%=per%>%">
				</div>
			</div>


			<div class="time">
				<span class="glyphicon glyphicon-time"></span> <span><%=projectList.get(nums[i]).getPjExpDate() %>일
					남음</span>
			</div>
		</div>
		<%
		}%>
		<!-- 오른쪽 여백 2-->
		<div class="col-sm-2"></div>
	</div>
	<form id="fm">
		<input type="hidden" id="pjNm" name="pjNm"> <input
			type="hidden" id="flag" name="flag">
	</form>
	<script type="text/javascript">
	function projectSelect(pjNm){
		document.getElementById("pjNm").value = pjNm;
		document.getElementById("flag").value = "SEL";
		var fm = document.getElementById("fm");
		fm.method = "post";
		fm.action = "/Team_Sprout/project/projectBoard.do";
		fm.submit();
	}
</script>
</body>
<%@include file="/WEB-INF/view/include/footer.jsp"%>
</html>

