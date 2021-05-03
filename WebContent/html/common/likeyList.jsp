<%@page import="kr.or.ddit.comm.vo.LikeyVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
	List<LikeyVO> list = (List<LikeyVO>)request.getAttribute("list");

	for(int i = 0; i < list.size(); i++) {
		if(i > 0){
			%>, <%
		}
		%>
		{
			"likeyCode" : "<%=list.get(i).getLikeyCode() %>"
			, "likeyName" : "<%=list.get(i).getLikeyName() %>"
		}
		<%
	}
%>
]