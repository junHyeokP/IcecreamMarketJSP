<%@ page language="java" contentType="text/html; charset=UTF-8"
	import = "icecream.*"
	import = "java.util.List"
    pageEncoding="UTF-8"%>
    
<%
    	IceService service = new OracleIceService(new OracleIceDAO());
    	List<Icecream> iceList = service.listAll();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ColdTaste</title>

<style>
		table {
			border-collapse : collapse;
			text-align : center
		}
		td {
			padding : 5px;
		}
</style>
</head>
<body>

	<% if (request.getParameter("order") != null) { %>
		<script>
			alert("주문을 완료하였습니다.")
		</script>
		<% } %>
	
	<%@ include file = "common/header.jsp" %>
	
	<h3>도서목록</h3>
		<% if (iceList.size() == 0) { %>
			<p>등록된 아이스크림이 존재하지 않습니다.</p>
		<% } else { %>
				<table border = 1>
					<tr><th>번호</th><th>아이스크림</th><th>가격</th></tr>
						<% for (Icecream ice : iceList) { %>
					<tr>
						<td> <%= ice.getIceID() %></td>
						<td> <a href = "<%= request.getContextPath()%>/icecream/detailPage.jsp?iceID=<%= ice.getIceID() %>"> <%= ice.getName() %></a></td>
						<td> <%= String.format("%,d", ice.getPrice()) %>원 </td>
					</tr>	
			<% } %>
		</table>
	<% } %>
	
	<%@ include file = "common/footer.jsp" %>
	
</body>
</html>