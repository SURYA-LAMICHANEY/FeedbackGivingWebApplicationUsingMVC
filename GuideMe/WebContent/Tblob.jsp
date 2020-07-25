<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Teacher photo</title>
</head>
<body>
<%@page import="java.sql.*"%>
        <%@page import="java.io.*"%>
        <%@page import ="java.util.Base64"%>
        <%
    String idd=request.getParameter("userid");
    String dbURL = "jdbc:mysql://localhost:3306/GuideMe";
     String dbUser = "root";
    String dbPass = "sairam";
    Blob image = null;
Connection con = null;
byte[ ] imgData =null ;
Statement stmt = null;
ResultSet rs = null;
try {
Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection(dbURL, dbUser, dbPass);
stmt = con.createStatement();
rs = stmt.executeQuery("select TPhoto from Teacher where Tid ="+idd);
if (rs.next()) {
image = rs.getBlob(1);
imgData = image.getBytes(1,(int)image.length());
}
else {
out.println("image not found for given id");
return;
}
// display the image
response.setContentType("image/jpg");
OutputStream o = response.getOutputStream();
o.write(imgData);
o.flush();
o.close();
} catch (Exception e) {
out.println("Unable To Display image");
out.println("Image Display Error=" + e.getMessage());
return;
} finally {
try {
rs.close();
stmt.close();
con.close();
} catch (SQLException e) {
e.printStackTrace();
}
}
%> 
</body>
</html>