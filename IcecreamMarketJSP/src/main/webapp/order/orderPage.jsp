<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "cart.*"
    import = "icecream.*"
    import = "member.*"
    import = "java.util.List"
    %>
<%@ include file = "/common/isLoggedIn.jsp" %>
<%
CartService cartService = new OracleCartService(new OracleCartDAO());
	IceService iceService = new OracleIceService(new OracleIceDAO());
	MemberService memberService = new PMemberService(new OracleMemberDAO());
	
	List<CartItem> itemList = cartService.listAll(memberNo);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이스크림 주문</title>
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
  <%@ include file = "/common/header.jsp" %>
  <h2>주문하기</h2>
  <h3>주문할 아이스크림 목록</h3>
 	 <table border = 2>
			<tr><th>번호</th><th>제목</th><th>가격</th><th>갯수</th></tr>
			<% 
			int numItems = 0, totalPrice = 0, i = 0; 
			 for (CartItem item : itemList) {
					Icecream ice = iceService.load(item.getIceID());
					numItems += item.getQuantity();
					totalPrice += ice.getPrice() * item.getQuantity();
					i++;
			 %>
			 <tr>
				<td> <%= i %> </td>
				<td> <%= ice.getName() %> </td>
				<td> <%= ice.getPrice() * item.getQuantity() %> </td>
				<td> <%= item.getQuantity() %></td>
			</tr>	
			 <% } %>
			 
		</table>
		<table border = 3>
			<tr><th>총 가격</th><th>총 갯수</th></tr>
			<tr><td> <%= totalPrice %>원</td> <td> 총 <%= numItems %>개 </td></tr>
		</table>
		<%
			Member member = memberService.read(memberNo);
		%>
		<h4>배송 정보</h4>
		이름 : <%= member.getNickname() %><br>
		<form action = "order.jsp" method="post">
			
			<input type = "hidden" value = "<%= memberNo %>">
			모바일 : <input type = "text" name = "mobile" value = "<%= member.getMobile() == null ? "" : member.getMobile() %>"><br>
			이메일주소 :  <input type = "text" name = "email" value = "<%= member.getEmail() == null ? "" : member.getEmail() %>"><br>
			주소 :  <input type = "text" name = "address" value = "<%= member.getAddress() == null ? "" : member.getAddress() %>"><br>
			<input type = "checkbox" name = "modifyMember">회원정보수정<br>
			<input type = "submit" value = "주문">
			<a href = "<%= request.getContextPath() %>/cart/main.jsp"><input type = "button" value = "취소"></a>
		</form>
</body>
</html>