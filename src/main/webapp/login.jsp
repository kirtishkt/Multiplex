<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Log In</title>
<link href="login.css" rel="stylesheet" type="text/css">
</head>
<body>
	<jsp:directive.page isELIgnored="false" />
	<jsp:include page="pageheader.jsp">
		<jsp:param value="Enter Login Details.." name="pageTitle" />
		<jsp:param
			value="<%=new SimpleDateFormat(\"MMM dd,  YYYY\").format(new Date())%>"
			name="date" />
	</jsp:include>
	
	<form class="modal-content animate" action="login" method="post">
    <div class="imgcontainer">
      
      <img src="img_avatar2.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
      <label><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="user" required>

      <label><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="pass" required>
        
      <button type="submit">Login</button>
      <label>
        <input type="checkbox" checked="checked"> Remember me
      </label>
    </div>

    <div class="container" style="background-color:#f1f1f1">
      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
      <span class="psw">Forgot <a href="#">password?</a></span>
    </div>
  </form>
</body>
</html>