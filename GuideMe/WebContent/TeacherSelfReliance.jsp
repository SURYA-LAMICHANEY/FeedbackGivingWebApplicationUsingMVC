<%
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "TeacherSelfReliance");
%>
<% response.setHeader("cache-control", "no-store");
    response.setHeader("pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<%
  String usertype = "";
  String username="";
  HttpSession sess2 = request.getSession(true); 
    usertype = (String)sess2.getAttribute("utype");
    username = (String)sess2.getAttribute("username");
   if(usertype==null )
{   
     response.sendRedirect("logout.jsp");
} else{
	if(usertype != "Teacher")
	response.sendRedirect(usertype+".jsp");	
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>self reliance</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<div id="header"></div>
<style>
body{
background:url(images/bech.jpg);
}
</style>
<a href = "${pageContext.request.contextPath}/TeacherController?action=SelfRelianceAcknowledgement"><button class="btnm">Sent Feedbacks</button></a>
<body>
<br>
${sorry}
${success}
<br>
<form action="TeacherController" method="post">
<div class="scroll">
<div class="form__group">
<input type="text" name="srdpt" class="form__field" required placeholder="self reliance department" >
<label for="srdpt" class="form__label">Self Reliance Department</label>
</div>						

<div class="form__group">
<input type="text" name="userid" class="form__field" required placeholder="Registration number" >
<label for="userId" class="form__label">Student</label>
</div>
		
<div class="form__group">
<input type="number" min="0" max="10" step="0.5" name="mark" class="form__field" placeholder="Marks" >
<label class="form__label">Marks (leave 0 if not awarding mark)</label>
</div>							

<div class="form__group">
<textarea name="feedback" class="form__field" required placeholder="Write feedback" rows="4"></textarea>
<label for="feedback" class="form__label">Feedback</label>
</div>
<br>							
<input class="btns" type="submit" name="submit" value="   Send   "/>				 
</div>			
</form>				
</body>
</html>