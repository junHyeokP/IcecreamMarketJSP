<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isAdminLogged.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 창</title>
</head>
<body>
<%@ include file = "/common/header.jsp" %>
 <ul>
	<li><a href ="<%= request.getContextPath() %>/member/main.jsp">회원관리</a></li>
	<li><a href ="<%= request.getContextPath() %>/icecream/main.jsp">아이스크림 목록 관리</a></li>
</ul>
<%@ include file = "/common/footer.jsp" %>
</body>
</html>