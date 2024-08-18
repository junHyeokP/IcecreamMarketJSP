<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="icecream.*"
    pageEncoding="UTF-8"%>
<%
String name = request.getParameter("name");
	String tempPrice = request.getParameter("price");
	
	 if (name == null || name.isBlank() ||tempPrice == null || tempPrice.isBlank()) { 
		
		response.sendRedirect("registPage.jsp");
		
	} else {
		
		out.print(tempPrice);
		
		int price = Integer.parseInt(tempPrice);
		
		IceService service = new OracleIceService(new OracleIceDAO());
		
		Icecream ice = new Icecream(name, price);
		
		if (service.add(ice)) { 
	
	response.sendRedirect("main.jsp");
		
		} else { 
	
	response.sendRedirect("registPage.jsp"); 
	
	 }
	}
%>
