<%@ page language="java" contentType="text/html; charset=UTF-8"
	import = "cart.*"
    pageEncoding="UTF-8"%>
    <%@ include file = "/common/isLoggedIn.jsp" %>
<%

	//CartService service = new OracleCartService(new OracleCartDAO());
	CartService service = new OracleCartService(HashMapCartDAO.getInstance());
	String iceIDStr = request.getParameter("iceID");
	
	if (iceIDStr == null || iceIDStr.isEmpty()) {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?iceIDErr=1");
		return;
	}
	
	if (service.add(new CartItem(memberNo, Integer.parseInt(iceIDStr), 1))) {
		response.sendRedirect(request.getContextPath() + "/cart/main.jsp");
		
	} else {
		response.sendRedirect(request.getContextPath() + "/common/errorPage.jsp?iceIDErr=1");
	}
	
%>   