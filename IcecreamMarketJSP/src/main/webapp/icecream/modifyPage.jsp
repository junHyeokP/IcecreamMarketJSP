<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="icecream.*"
    pageEncoding="UTF-8"%>
    
 <%@ include file = "/common/isAdminLogged.jsp" %>   
 
<%
    String iceIDStr = request.getParameter("iceID");
        	if (iceIDStr == null) {
        	response.sendRedirect("main.jsp");
        	} else {
        		IceService service = new OracleIceService(new OracleIceDAO());
        		Icecream ice = service.load(Integer.parseInt(iceIDStr));
        	if (ice == null) {
        		response.sendRedirect("main.jsp");
        	} else {
    %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이스크림 정보 수정 페이지</title>
</head>
<body>
	<h2>아이스크림에서 원하는 정보를 수정하기</h2>
	<form action = "modify.jsp" method = "post">
	<input type = "hidden" name = "iceID" value = "<%= ice.getIceID() %>" >
	<input type = "text" name = "name" value = <%= ice.getName() %> placeholder = "아이스크림 이름 수정"> <br>
	<input type = "text" name = "price" value = <%= ice.getPrice() %> placeholder = "아이스크림 가격 수정"> <br>
	
	<br>
	<input type = "submit" value = "아이스크림 정보 수정">
	<a href = "detailPage.jsp?iceID=<%= ice.getIceID() %>"><input type = "button" value = "돌아가기"></a>
	</form>
</body>
</html>
	<% }
	} %>