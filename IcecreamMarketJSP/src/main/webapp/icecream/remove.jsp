<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="icecream.*"
	
    pageEncoding="UTF-8"%>
   <%@ include file = "/common/isAdminLogged.jsp" %> 
<%
 String iceID = request.getParameter("iceID");
  	
  	if (iceID == null || iceID.isEmpty()) {
  		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?removeError=1");
  	} else {
  		IceService service = new OracleIceService(new OracleIceDAO());
  		if (service.remove(Integer.parseInt(iceID))) {
  			response.sendRedirect("main.jsp");
  		} else {
  			response.sendRedirect("detailPage.jsp?iceID=" + iceID);
  		}
  	}
 %>