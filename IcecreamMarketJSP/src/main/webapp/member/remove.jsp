<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="member.*"
    pageEncoding="UTF-8"%>
<%
String noStr = request.getParameter("no");
		if (noStr == null) {
		response.sendRedirect("main.jsp");
		} else {
		MemberService service = new PMemberService(new OracleMemberDAO());
		if (service.remove(Integer.parseInt(noStr))) {
				response.sendRedirect("main.jsp");
		} else {
				response.sendRedirect("detailPage.jsp?no=" + noStr);
		}
		}
%>    
