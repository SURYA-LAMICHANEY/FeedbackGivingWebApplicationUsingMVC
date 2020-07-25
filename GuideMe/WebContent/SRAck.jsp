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
    pageEncoding="UTF-8" import="java.util.*" import="guideMe.model.SelfReliance"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SelfReliance Acknowledgement</title>
<link href="guideme.css" rel="stylesheet" type="text/css">
</head>
<div id="header"></div>
<style>
body{
background:url(images/wat.jpg);
}
</style>
<body>
<div class="navbarx">
<a href="#"><font color="white" size="6">SelfReliance Acknowledgement</font></a></div>
<div class="navbar">
<a href="Teacher.jsp">Home</a></div>
<div class="scroll">
<c:if test = "${list2 == '[]'}">
<br><center><font color="red" size="20">No acknowledgement to show</font></center>
</c:if>
<c:forEach items="${list2}" var="ac">
				<c:if test = "${ac.status == 0}">   
                 <br><div class="sent">	  
						<b>${ac.date},
						${ac.dept},
						${ac.sid}:</b><br>
						${ac.remarks}
				        </div>
</c:if>
		<c:if test = "${ac.status == 1}">   
                      <br><div class="seen">
	  
					<b>${ac.date},${ac.dept},
						${ac.sid}: </b><br>
						${ac.remarks}
				        </div>
		</c:if>
					
</c:forEach></div>
</body>
</html>