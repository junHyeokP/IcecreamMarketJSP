<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="icecream.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isAdminLogged.jsp" %>    
<%
    String iceIDStr = request.getParameter("iceID");
        		if (iceIDStr == null) {
        	response.sendRedirect("detailPage.jsp");
        	
        	} else {
        		
        		IceService service = new OracleIceService(new OracleIceDAO());
        		Icecream ice = service.load(Integer.parseInt(iceIDStr));
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 정보 삭제 페이지</title>
</head>
<body>
	<h2>책 정보 삭제</h2>
	<% if (ice == null) { %>
	<p>도서 정보가 없습니다.</p>
	<% } else { %>
	<ul>
		<li>아이스크림 번호 : <%= ice.getIceID() %></li>
	 	<li>아이스크림 이름 : <%= ice.getName() %></li>
	 	<li>아이스크림 가격 : <%= ice.getPrice() %></li>
	</ul>
	<br>
	
	아이스크림 정보를 삭제하시겠습니까?
	<a href = "remove.jsp?iceID=<%= ice.getIceID() %>"><button>삭제</button></a>
	<a href = "detailPage.jsp?iceID=<%= ice.getIceID() %>"><button>취소</button></a>
	<% } %>
</body>
</html>
<% } %>