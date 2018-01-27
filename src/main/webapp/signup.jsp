<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.html" %>
<jsp:include page="pageheader.jsp" >
<jsp:param value="Enter Movie Details.." name="pageTitle"/>
<jsp:param value="<%=new SimpleDateFormat(\"MMM dd,  YYYY\").format(new Date())%>" name="date"/>
</jsp:include>
<form action="signup" method="post">
User Name :<input type="text" name="user"> <br>
		<br> Mobile No: <input type="text" name="mobile"> <br>
		<br> Email ID: <input type="text" name="email"> <br>
		<br> <input type="submit" value="Submit">
</form>
</body>
</html>
	