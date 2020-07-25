<%
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "GenerateReport");
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>generate report</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<div id="header"></div>
<div id="navigation">
<font color="white" size="6">GENERATE REPORT</font></div>
<style>
body{
background-image:url(images/bech.jpg);
}
</style>
<body>
<br>
${sorry}
<form action="AdminController" method="post">
 <br>
<div class="form__group">
<input type="text" name="userid" class="form__field" placeholder="Registration number" >
<label for="userId" class="form__label">Enter the Registration number</label>
</div><br>
<input class="btns" type="submit" name="submit" value="Generate Report"/>				 				
</form>		
</body>
</html>