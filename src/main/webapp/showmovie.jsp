<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Movie Details</title>
<link href="form.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@ include file="header.html" %>
<jsp:include page="pageheader.jsp" >
<jsp:param value="Select Movie Name" name="pageTitle"/>
<jsp:param value="<%=new SimpleDateFormat(\"MMM dd,  YYYY\").format(new Date())%>" name="date"/>
</jsp:include>
<sql:setDataSource var = "database" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/data?autoReconnect=true&useSSL=false"
         user = "root"  password = "kt"/>
         
         <sql:query var="s" dataSource="${database}" sql="select movieid,moviename from MOVIES"></sql:query>

<form action="movielist.jsp" method="post">
Movie Name :

<select name="movie">
  <c:forEach var ="x" items="${s.rows}">
    <option value='<c:out value="${x.movieid}"/>'><c:out value="${x.moviename}"/></option>
    </c:forEach>
  </select><br><br>
<input type="submit" value="Submit">
</form>
</body>
</html>