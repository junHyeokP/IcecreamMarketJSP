<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="icecream.*" import="java.util.List" pageEncoding="UTF-8"%>

<%@ include file="/common/isAdminLogged.jsp"%>

<%! 
	IceService service = new OracleIceService(new OracleIceDAO());
	List<Icecream> iceList = service.listAll();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이스크림 관리 메인 페이지</title>
</head>
<body>
	<%@ include file="/common/header.jsp"%>

	<h1>아이스크림 관리 메인 페이지</h1>
	
	<a href="registPage.jsp"><button>아이스크림 등록하기</button></a>
	
	<h3>아이스크림 목록</h3>
	<%
	if (iceList.size() == 0) {
	%>
	<p>등록된 아이스크림이 존재하지 않습니다.</p>
	<%
	} else {
	%>

	<table border=2>
		<tr>
			<th>번호</th>
			<th>아이스크림 이름</th>
			<th>가격</th>
		</tr>	
		<% for (Icecream ice : iceList) { %>
			<tr>
				<td><%=ice.getIceID()%></td>
				<td><a href="detailPage.jsp?iceID=<%=ice.getIceID()%>"><%=ice.getName()%></a></td>
				<td><%=ice.getPrice()%></td>
			</tr>
		<% } %>
	</table>
 <% } %>
</body>
</html>