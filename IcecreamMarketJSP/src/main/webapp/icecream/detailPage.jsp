<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="icecream.*"
    pageEncoding="UTF-8"%> 
 <%
  String iceIDStr = request.getParameter("iceID");
     	if (iceIDStr == null || iceIDStr.isEmpty()) {
     		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?idError=1");
     	} else {
     	IceService service = new OracleIceService(new OracleIceDAO());
     	Icecream ice = service.load(Integer.parseInt(iceIDStr));
  %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이스크림 상세정보 페이지</title>
</head>
<body>
	<%@ include file = "/common/header.jsp" %>
	<h1>아이스크림 상세정보</h1>
	<%if (ice == null) {%>
		<p>해당 아이스크림에 대한 정보가 없습니다.</p>
	<% } else { %>
	 <ul>
	 	<li>번호 : <%= ice.getIceID() %></li>
	 	<li>이름 : <%= ice.getName() %></li>
	 	<li>가격 : <%= ice.getPrice() %></li>
	 </ul>
	 <br>
	 
	 <%
	 if (session.getAttribute("adminID") != null) { %>
	
	 <a href = "modifyPage.jsp?iceID=<%= ice.getIceID() %>"><button>아이스크림 정보 수정</button></a>
	 <a href = "removePage.jsp?iceID=<%= ice.getIceID() %>"><button>아이스크림 정보 삭제</button></a>
	 	
	 		<% } else if (session.getAttribute("MemberID") != null) { %>
	 		
	 				<a href = "<%= request.getContextPath() %>/cart/add.jsp?iceID=<%= ice.getIceID()%>"><button>장바구니 담기</button></a>
	 			<% } %>
	 			
	 		<a href = "<%= request.getContextPath() %>/index.jsp"><button>아이스크림 목록</button></a>
	 <% } %>
	  <%@ include file = "/common/footer.jsp" %>
</body>
</html>
<% } %>