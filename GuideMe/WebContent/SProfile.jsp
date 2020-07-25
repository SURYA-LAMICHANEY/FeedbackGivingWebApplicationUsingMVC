<%  
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "SProfile");
    HttpSession sessio=request.getSession();
    String name= (String) sessio.getAttribute("id");   
    sess.setAttribute("uid", name);   
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="guideme.css" rel="stylesheet" type="text/css">
<meta charset="UTF-8">
<title>Student Profile</title>
<style>
body{
background:url(images/3.jpg);
}
</style>
</head>
<body>
<div class="card">
<img src="blob.jsp?userid=${sid}" alt="Student's Photo" style="width:400px; height:250px;">
${profile}
</div>
</body>
</html>