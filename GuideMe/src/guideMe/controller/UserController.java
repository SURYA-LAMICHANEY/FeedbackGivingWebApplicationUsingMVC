package guideMe.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import guideMe.MyConnectionProvider;
import guideMe.model.user;
import guideMe.DAO.userDAO;
import guideMe.DAO.userDAOimpl;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;
	static Connection con2=null;
	static PreparedStatement ps= null;
	static PreparedStatement ps2=null;   
	static Connection con3=null;
	static PreparedStatement ps3= null;
	static Connection con4=null;
	static PreparedStatement ps4= null;
	static Connection con5=null;
	static PreparedStatement ps5= null;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        userDAO ud=new userDAOimpl();
        HttpSession sess = request.getSession(true);
        String page = (String)sess.getAttribute("page");
        String uid=(String)sess.getAttribute("uid");
        response.setContentType("text/html"); 
	    String username=request.getParameter("userId");	
	    String password=request.getParameter("password");	    
	    user u=ud.getuser(username, password);
	    HttpSession session1=request.getSession();
	    session1.setAttribute("id", username);
	   
	    String tuid="Teacher";
	    String auid="Admin";
	    String suid="Student";
	    
	  switch(page) {
	  case "Login": {	      
	    if( u.getType().equals(auid) && u.getPassword().equals(password)) {	
	    	    sess.setAttribute("utype","Admin");
				request.getSession().setAttribute("messageu","Administrator" );								    	    
	    	    response.sendRedirect("Admin.jsp");	    	   
	    }else if( u.getType().equals(suid) && u.getPassword().equals(password) ) {
	    	try {			   
	           response.setContentType("text/html");	           
		       con=MyConnectionProvider.getCon(); 
		       ps=con.prepareStatement("select SName from Student where Sid=?");
		   	   ps.setString(1,username);
		   	   ResultSet rs=ps.executeQuery();
		   	   
		       con3=MyConnectionProvider.getCon(); 
		       ps3=con3.prepareStatement("select count(Status) from Subject where Sid=? and Status=0");
		   	   ps3.setString(1,username);
		   	   ResultSet rs3=ps3.executeQuery();
		   	   
		   	   con4=MyConnectionProvider.getCon(); 
		       ps4=con4.prepareStatement("select count(Status) from Self_Reliance where Sid=? and Status=0");
		   	   ps4.setString(1,username);
		   	   ResultSet rs4=ps4.executeQuery();
		   	   
		       con5=MyConnectionProvider.getCon(); 
		       ps5=con5.prepareStatement("select count(Status) from Miscellaneous where Sid=? and Status=0");
		   	   ps5.setString(1,username);
		   	   ResultSet rs5=ps5.executeQuery();
		   	   
		       	while(rs.next() && rs3.next() && rs4.next() && rs5.next()) {
		       	 int aca=0;
		       	 int sr=0;
		       	 int mis=0;
		       	 aca=rs3.getInt(1);
		       	 sr=rs4.getInt(1);
		       	 mis=rs5.getInt(1);
		       	 
	 	         request.getSession().setAttribute("messageu",rs.getString(1));
	 	         if(aca>0)
	 	         request.getSession().setAttribute("academic",aca);
	 	         else
	 	         request.getSession().setAttribute("academic","");
	 	         
	 	         if(sr>0)
	 	         request.getSession().setAttribute("selfreliance",sr);
	 	         else
	 	         request.getSession().setAttribute("selfreliance","");
	 	         
	 	         if(mis>0)
		 	     request.getSession().setAttribute("miscellaneous",mis);
		 	     else
		 	     request.getSession().setAttribute("miscellaneous","");
	 	         sess.setAttribute("utype","Student");
	 	         response.sendRedirect("Student.jsp");
	 	         HttpSession session2=request.getSession();
		 	     session2.setAttribute("sid", username);		 	     
		 	       }
	    	}catch(Exception e) {
	    		System.out.println(e);
	    	}
	    	
	    }else if( u.getType().equals(tuid) && u.getPassword().equals(password)) {
	    	try {	HttpSession session2=request.getSession(true);
      		        session2.setAttribute("utype","Teacher");		   
		           response.setContentType("text/html");
			       con2=MyConnectionProvider.getCon(); 
			       ps2=con2.prepareStatement("select TName from Teacher where Tid=?");
			   	   ps2.setString(1,username);
			   	   ResultSet rs2=ps2.executeQuery();
			   	   
			      	while(rs2.next()) {				      		
			      		HttpSession session=request.getSession();
				 	    session.setAttribute("tid", username);
		 	            request.getSession().setAttribute("messageu",rs2.getString(1));
		 	            response.sendRedirect("Teacher.jsp");
		 	          			 	      
			      	}
		    	}catch(Exception e) {
		    		System.out.println(e);
		    	}	 		
	    }else {
	    	request.getSession().setAttribute("message","<div class=\"alert\">\n" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>\n" +"<strong>Wrong Username or Password.</strong>\n" + "</div>");
	    	response.sendRedirect("Login.jsp");						 
	    }
	    }break;
	  case "ChangePassword":
		  userDAO uud=new userDAOimpl();		 
          String cpass=request.getParameter("cpass");
          String npass=request.getParameter("npass");                   
          user ug=uud.getuser(uid, cpass);         
          if(ug.getPassword().equals(cpass)) {
        	 ug.setPassword(npass);
        	 ug.setType(ug.getType());
        	 ug.setUsername(ug.getUsername());
             uud.changepassword(ug);          
                   
          if(ug.getType().equals(suid)) {
        	  request.setAttribute("success","<div class=\"success\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" + "<strong>Password changed successfully.</strong>" +"</div>");
        	  request.getRequestDispatcher("Student.jsp").forward(request, response);      	  			       	  	        
          }else if(ug.getType().equals(tuid)) {
        	  request.setAttribute("message2","<div class=\"success\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>Password changed successfully.</strong>" + "</div>"); 
        	  request.getRequestDispatcher("Teacher.jsp").forward(request, response);       	  			       	  		      	  	        
          }else if(ug.getType().equals(auid)) {
        	  request.setAttribute("message2","<div class=\"success\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" + "<strong>Password changed successfully.</strong>" + "</div>");
        	  request.getRequestDispatcher("Admin.jsp").forward(request, response);			        	  			       	  			      	  	        
          }
          }else {
        	  request.setAttribute("message3","<div class=\"alert\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +	"<strong>Incorrect current password.</strong>" + "</div>"); 
        	  request.getRequestDispatcher("ChangePassword.jsp");	       	  		      	  			  	    
          }                   
}}}
