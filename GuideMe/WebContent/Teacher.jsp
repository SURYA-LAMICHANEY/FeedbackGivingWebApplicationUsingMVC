<% response.setHeader("cache-control", "no-store");
    response.setHeader("pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<%
  String usertype = "";
  String username="";
  HttpSession sess = request.getSession(true); 
    usertype = (String)sess.getAttribute("utype");
    username = (String)sess.getAttribute("username");
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
<title>Teacher</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<script>
history.pushState(null, null, location.href);
window.onpopstate = function () 
{
  history.go(1);
};   
</script>
<style>
body{
background:url(images/bech.jpg);
}
</style>
<div id="header"></div>
<div id="navigation">
 <ul>   
 <li>
<div class ="dropdown">
<button  onclick="myFunction()" class="dropbtn">${messageu}</button>
<div id=myDropdown class="dropdown-content">
<a href="ChangePassword.jsp">Change password</a>
<a href="logout.jsp">Logout</a>
<a href = "${pageContext.request.contextPath}/TeacherController?action=TeacherProfile"><button class="profilebtn"><b>Profile</b></button></a>

</div></div></li>
 </ul></div>
<body onLoad="noBack();" onpageshow="if (event.persisted) noBack();" onUnload="">
<br>
${message2}
<br>
<a href="TeacherAcademic.jsp"><button class ="btn">ACADEMIC</button></a><br><br>
<a href="TeacherSelfReliance.jsp"><button class ="btn">SELF RELIANCE</button></a><br><br>
<a href="TeacherMiscellaneous.jsp"><button class ="btn">MISCELLANEOUS</button></a><br><br>
<a href="CheckStudent.jsp"><button class ="btn">CHECK STUDENT</button></a><br>
</body>
</html>
