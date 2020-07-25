<%  response.setHeader("cache-control", "no-store");
    response.setHeader("pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>
<%
session.invalidate();
response.sendRedirect("Login.jsp");
%>