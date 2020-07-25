<%
    HttpSession sess = request.getSession(true);
    sess.setAttribute("page", "TeacherMiscellaneous");
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
<title>miscellaneous</title>
<link href="guideme.css" rel="stylesheet" type="text/css">		
</head>

<div id="header"></div>
<style>
body{
background:url(images/bech.jpg);
}
</style>
<a href = "${pageContext.request.contextPath}/TeacherController?action=MiscellaneousAcknowledgement"><button class ="btnm" > Sent Feedbacks</button></a>


<body>
<br>
${sorry}
${success}
<br>
<form action="TeacherController" method="post">
<div class="scroll">
<div class="form__group">
<input type="text" name="userid" class="form__field" required placeholder="Registration number" >
<label for="userId" class="form__label">Student</label>
</div>
<div class="containerr">			
  <ul>
  <li>
    <input type="radio" id="f-option" name="selector" value="Honesty and Integrity">
    <label for="f-option">Honesty and Integrity</label>    
    <div class="check"></div>
  </li>
  <li>
    <input type="radio" id="s-option" name="selector" value="Regularity and Punctuality">
    <label for="s-option">Regularity and Punctuality</label>
    
    <div class="check"><div class="inside"></div></div>
  </li>
  
<li>
    <input type="radio" id="t-option" name="selector" value="Leadership">
    <label for="t-option">Leadership</label>
    <div class="check"><div class="inside"></div></div>
  </li>
  
  <li>
    <input type="radio" id="fr-option" name="selector" value="Service Attitude">
    <label for="fr-option">Service Attitude</label>
    <div class="check"><div class="inside"></div></div>
  </li>
  
  <li>
    <input type="radio" id="fv-option" name="selector" value="Behavior and Conduct">
    <label for="fv-option">Behaviour and Conduct</label>
    <div class="check"><div class="inside"></div></div>
  </li>
  
  <li>
    <input type="radio" id="sx-option" name="selector" value="Talent and Creativity">
    <label for="sx-option">Talent and Creativity</label>
    <div class="check"><div class="inside"></div></div>
  </li>
</ul>
</div>
<div class="form__group">
<input type="number" min="0" max="5" step="0.5" name="mark" class="form__field" placeholder="Marks" >
<label class="form__label">Marks (leave 0 if not awarding mark)</label>
</div>
<div class="form__group">
<textarea name="feedback" class="form__field" required placeholder="Write feedback" rows="4"></textarea>
<label for="feedback" class="form__label">Feedback</label>
</div><br>							
<input class="btns" type="submit" name="submit" value="Send"/>				 			
</div></form>				
</body>
</html>