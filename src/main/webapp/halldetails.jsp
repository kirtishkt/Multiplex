<%@page import="multiplex.model.Halls"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
</head>
<body>
	<%@ include file="header.html"%>
	<jsp:directive.page isELIgnored="false" />
	<jsp:include page="pageheader.jsp">
		<jsp:param value="Enter Hall Details" name="pageTitle" />
		<jsp:param
			value="<%=new SimpleDateFormat(\"MMM dd,  YYYY\").format(new Date())%>"
			name="date" />
	</jsp:include>
	<%
	Halls hall = (Halls) request.getAttribute("hall");
	%>
	<h2>Hall ID: ${requestScope.hall.hallId}</h2>
	<h2>Hall Desc: ${requestScope.hall.hallDesc}</h2>
	<h2>Hall capacity: ${requestScope.hall.totalCapacity}</h2>
</body>
</html>