<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Movie </title>
<link href="form.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.html"%>
	<jsp:directive.page isELIgnored="false" />
	<jsp:include page="pageheader.jsp">
		<jsp:param value="Enter Movie Name.." name="pageTitle" />
		<jsp:param
			value="<%=new SimpleDateFormat(\"MMM dd,  YYYY\").format(new Date())%>"
			name="date" />
	</jsp:include>
	<form action="addmovie" method="post">
		Movie Name :<input type="text" name="movie"> <br><br>
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>