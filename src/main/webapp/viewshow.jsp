<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Details</title>
<link href="form.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%@ include file="header.html"%>
	<jsp:directive.page isELIgnored="false" />
	<jsp:include page="pageheader.jsp">
		<jsp:param value="Select Show ID" name="pageTitle" />
		<jsp:param
			value="<%=new SimpleDateFormat(\"MMM dd,  YYYY\").format(new Date())%>"
			name="date" />
	</jsp:include>
	
	<sql:setDataSource var = "database" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/data?autoReconnect=true&useSSL=false"
         user = "root"  password = "kt"/>
         
         <sql:query var="r" dataSource="${database}" sql="select showid from SHOWS"></sql:query>
      
	
	<form action="showdetails.jsp" method="post">
	SHOW ID:
  <select name="show">
	<c:forEach var ="x" items="${r.rows}">
    <option value='<c:out value="${x.showid}"/>'><c:out value="${x.showid}"/></option>
    </c:forEach>
  
		<br> <input type="submit" value="Submit">
	</form>
</body>
</html>
</body>
</html>