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
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.html" %>
<jsp:include page="pageheader.jsp" >
<jsp:param value="Show's Details: ${param.show}" name="pageTitle"/>
<jsp:param value="<%=new SimpleDateFormat(\"MMM dd,  YYYY\").format(new Date())%>" name="date"/>
</jsp:include>
<jsp:useBean id="user" class="multiplex.model.Users" ></jsp:useBean>

<sql:setDataSource var = "database" driver = "com.mysql.jdbc.Driver"
         url = "jdbc:mysql://localhost:3306/data?autoReconnect=true&useSSL=false"
         user = "root"  password = "kt"/>
<sql:query var="set" dataSource="${database}" sql="select bookingid,userid,bookeddate,showdate,seattypedesc,noofseats from BOOKINGS where showid = '${param.show}' "></sql:query>

<c:if test="${sessionScope.user.userType eq  \"A\".charAt(0)}">
<div class="table-responsive">
	<table class="table">
	 <thead class="thead-inverse">
		<tr>
			<th>#</th>
			<th>Booking ID</th>
			<th>User ID</th>
			<th>Booked Date</th>
			<th>Show Date</th>
			<th>Seat Type</th>
			<th>No. of Seats</th>
		</tr>
		</thead>		
		<c:forEach items="${set.rows}" var="x" varStatus="count" >
			<tr>
				<td>${count.index +1}</td>
				<td><c:out value="${x.bookingid}"></c:out></td>
				<td><c:out value="${x.userid}"></c:out></td>
				<td><c:out value="${x.bookeddate}"></c:out></td>
				<td><c:out value="${x.showdate}"></c:out></td>
				<td><c:out value="${x.seattypedesc}"></c:out></td>
				<td><c:out value="${x.noofseats}"></c:out></td>
			</tr>
		</c:forEach>
	</table>
	</div>
</c:if>
<c:if test="${sessionScope.user.userType ne  \"A\".charAt(0)}">
UnAutorized Access
</c:if>
</body>
</html>