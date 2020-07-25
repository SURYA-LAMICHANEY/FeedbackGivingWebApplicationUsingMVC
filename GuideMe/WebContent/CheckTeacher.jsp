<%  
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "CheckTeacher");
    HttpSession sessio=request.getSession();        
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Check Teacher</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<div id="header"></div>
<div id="navigation">
<font color="white" size="6">CHECK TEACHER</font></div>
<style>
body{
background-image:url(images/bech.jpg);
}
</style>
</head>
<body>
<form action="AdminController" method="post">
 <br>
 ${sorry}
<div class="form__group">
<input type="text" name="userid" class="form__field" required placeholder="Identity card number" >
<label for="userId" class="form__label">Enter the Identity card  number</label>
</div><br>
<input class="btns" type="submit" name="submit" value="Check"/>				 				
</form>
</body>
</html>