<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="icecream.*"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/isAdminLogged.jsp" %>    
<%
    String iceIDStr = request.getParameter("iceID");
        	String name = request.getParameter("name");
        	String priceStr = request.getParameter("price");

        	if (iceIDStr == null) {
        	response.sendRedirect("main.jsp");
        	} 
        	else if (name.isBlank() || priceStr.isBlank()) {
        		response.sendRedirect("detailPage.jsp?no=" + iceIDStr);
        	} else if (name == null || priceStr == null) {
        		response.sendRedirect("detailPage.jsp?no=" + iceIDStr);
        	} else {
        	
        	IceService service = new OracleIceService(new OracleIceDAO());
        	Icecream ice = service.load(Integer.parseInt(iceIDStr));
        	
        	int price = Integer.parseInt(priceStr);
        	
        	if (ice == null) {
        		response.sendRedirect("main.jsp");
        	} else {
        		
        	 	ice.setName(name);
        	 	ice.setPrice(price);
        	 	 if (service.edit(ice)) { 
        			response.sendRedirect("main.jsp");
        				} else {
        					response.sendRedirect("modifyPage.jsp");
        					}
        			}	
        	}
    %>    
