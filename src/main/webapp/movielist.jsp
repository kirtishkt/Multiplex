<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="header.html"%>
	<jsp:include page="pageheader.jsp">
		<jsp:param value="Movie Details Details.." name="pageTitle" />
		<jsp:param
			value="<%=new SimpleDateFormat(\"MMM dd,  YYYY\").format(new Date())%>"
			name="date" />
	</jsp:include>
	<jsp:useBean id="user" class="multiplex.model.Users"></jsp:useBean>

	<sql:setDataSource var="database" driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/data?autoReconnect=true&useSSL=false"
		user="root" password="kt" />
	<sql:query var="set" dataSource="${database}"
		sql="select s.showid,s.hallid,s.slotno,s.fromdate,s.todate 
				from SHOWS s,MOVIES m where s.movieid = m.movieid and m.movieid ='${param.movie}'"></sql:query>
				

	<c:set value="${param.movie}" scope="session" var="movie"></c:set>
	<c:set value="${param.date}" scope="session" var="date"></c:set>
	<c:if test="${sessionScope.user.userType eq  \"A\".charAt(0)}">
	
		<div class="table-responsive">
			<table class="table">
				<thead class="thead-inverse">
					<tr>
						<th>#</th>
						<th>ShowID</th>
						<th>HallID</th>
						<th>SlotNo</th>
						<th>From Date</th>
						<th>To Date</th>
					</tr>
				</thead>
				<c:forEach items="${set.rows}" var="x" varStatus="count">
					<form action="bookmovie">
					<tr>
						<td>${count.index +1}</td>

						<td><c:out value="${x.showid}"></c:out></td>
						<c:set var="showid" value="${x.showid}" scope="request"></c:set>

						<td><c:out value="${x.hallid}"></c:out></td>
						<td><c:out value="${x.slotno}"></c:out></td>
						<td><c:out value="${x.fromdate}"></c:out></td>
						<td><c:out value="${x.todate}"></c:out></td>
						<td><input type="hidden" name="hallid" value="${x.hallid}"><br>
							<input type="hidden" name="showid" value="${x.showid}">
							<input type="hidden" name="slotno" value="${x.slotno}">
							
							<input type="hidden" name="fromdate" value="${x.fromdate}">
							<input type="hidden" name="todate" value="${x.todate}">

							<div class="container">
								<!-- Trigger the modal with a button -->
								<button type="button" class="btn btn-info btn-lg"
									data-toggle="modal" data-target="#myModal">Book</button>

								<!-- Modal -->
								<div class="modal fade" id="myModal" role="dialog">
									<div class="modal-dialog">
								<sql:query var="st" dataSource="${database}" sql="select seattypedesc from HALLCAPACITIES where hallid='${x.hallid}'"></sql:query>
										<!-- Modal content-->
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal">&times;</button>
												<h4 class="modal-title">Enter Booking Details...</h4>
											</div>
											<div class="modal-body">
												<form>
													Seat Type:
													<select name="seattype">
													<c:forEach items="${st.rows}" var="q">
													<option value='<c:out value="${q.seattypedesc}"/>'><c:out value="${q.seattypedesc}"/></option>
													</c:forEach>
													</select><br>
													Date: <input type="date" name="date"><br>
													No of Seats:<input name="seatcount" name="number"> 
													<input type="submit" value="Go Book!!">
												</form>
											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
											</div>
										</div>

									</div>
								</div>

							</div>

							</form></td>
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