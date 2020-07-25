package guideMe.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import guideMe.model.user;
import guideMe.DAO.userDAO;
import guideMe.DAO.userDAOimpl;
import guideMe.DAO.AdminDAO;
import guideMe.DAO.AdminDAOimpl;
import guideMe.DAO.StudentDAO;
import guideMe.DAO.StudentDAOimpl;
import guideMe.model.Academic;
import guideMe.model.Miscellaneous;
import guideMe.model.SelfReliance;
import guideMe.model.Student;
import guideMe.model.Teacher;

@WebServlet("/AdminController")
@MultipartConfig(maxFileSize = 16177215)
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	public static boolean isNullOrEmpty(String str) {
        if(str != null && !str.trim().isEmpty())
            return false;
        return true;
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
        String page = (String)sess.getAttribute("page");        
       
       switch(page) {
       case "AddStudent":
    	   AdminDAO sad=new AdminDAOimpl();
    	   userDAO sud=new userDAOimpl();
    	                                
           InputStream sinputStream = null; 	           	           
           Part sfilePart = request.getPart("photo");	            
           if (sfilePart != null) {	                
               sinputStream = sfilePart.getInputStream();
           }                 
           Student ss=sad.getstudent(request.getParameter("userid")) ;                                                             
           if(ss.getUserid().equals(request.getParameter("userid"))){
        	 request.setAttribute("sorry","<div class=\"alert\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>Student with userid-"+request.getParameter("userid")+" already exists.</strong>" + "</div>"); 
        	 request.getRequestDispatcher("AddStudent.jsp").forward(request, response);			         	   	  
       }else{
    	   Student s=new Student();         
           s.setName(request.getParameter("name"));
           s.setUserid(request.getParameter("userid"));
           s.setCourse(request.getParameter("course"));
           s.setSem(request.getParameter("semester"));
           s.setSelfreliance(request.getParameter("self"));
           s.setPhoto(sinputStream);
           s.setDepartment(request.getParameter("depart"));
           sad.insertstudent(s); 
           
           user u =new user();
           u.setType("Student");
           u.setPassword(request.getParameter("password"));
           u.setUsername(request.getParameter("userid"));
           sud.insertuser(u);
           request.setAttribute("success2","<div class=\"success\">" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>Student account created for:"+request.getParameter("name")+"</strong>" + "</div>");
           request.getRequestDispatcher("Admin.jsp").forward(request, response);		      
}  break;
       case "AddTeacher":
    	   AdminDAO tad=new AdminDAOimpl();
    	   userDAO tud=new userDAOimpl();
    	   String tname=request.getParameter("name");
           String tuserid=request.getParameter("userid");
           String tpassword=request.getParameter("password");  
           String tuid="Teacher";
           String depart=request.getParameter("depart");
           InputStream tinputStream = null; 	           	           
            Part tfilePart = request.getPart("photo");	            
            if (tfilePart != null) {	                
                tinputStream = tfilePart.getInputStream();
            }
            Teacher tt=tad.getteachers(tuserid) ;
            user tu=tud.getuser(tuserid, tpassword);
            if(tt.getUserid().equals(tuserid)){
            request.setAttribute("sorry","<div class=\"alert\">" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" + "<strong>Teacher with userid-"+tuserid+" already exists.</strong>" + "</div>");
            request.getRequestDispatcher("AddTeacher.jsp").forward(request, response);    			
           }else{
        	   Teacher t=new Teacher();
           	t.setName(tname);
           	t.setUserid(tuserid);
           	t.setPhoto(tinputStream);
           	t.setDepartment(depart);
           	tad.insertteacher(t);
           	
           	tu.setType(tuid);
           	tu.setPassword(tpassword);
           	tu.setUsername(tuserid);
           	tud.insertuser(tu);
           	
           	String subname1=request.getParameter("subname1");
               String subid1=request.getParameter("subid1"); 
               if(isNullOrEmpty(subname1) && isNullOrEmpty(subid1)) {}else {
               	t.setSubid(subid1);
               	t.setSubname(subname1);
               	t.setUserid(tuserid);
               	tad.insertsubject(t);               		               
              } 
              String subname2=request.getParameter("subname2");
              String subid2=request.getParameter("subid2");
              if(isNullOrEmpty(subname2) && isNullOrEmpty(subid2)) {}else {
           	   t.setSubid(subid2);
           	   t.setSubname(subname2);
           	   t.setUserid(tuserid);
              	   tad.insertsubject(t);             	   
              }
              String subname3=request.getParameter("subname3");
              String subid3=request.getParameter("subid3");
              if(isNullOrEmpty(subname3) && isNullOrEmpty(subid3)) {}else {
           	   t.setSubid(subid3);
           	   t.setSubname(subname3);
           	   t.setUserid(tuserid);
              	   tad.insertsubject(t);             	   
              }
              String subname4=request.getParameter("subname4");
              String subid4=request.getParameter("subid4");
              if(isNullOrEmpty(subname4) && isNullOrEmpty(subid4)) {}else {
           	   t.setSubid(subid4);
           	   t.setSubname(subname4);
           	   t.setUserid(tuserid);
              	   tad.insertsubject(t);            	   
              }
              String subname5=request.getParameter("subname5");
              String subid5=request.getParameter("subid5");
              if(isNullOrEmpty(subname5) && isNullOrEmpty(subid5)) {}else {
           	   t.setSubid(subid5);
           	   t.setSubname(subname5);
           	   t.setUserid(tuserid);
              	   tad.insertsubject(t);             	   
              }
              String subname6=request.getParameter("subname6");
              String subid6=request.getParameter("subid6");
              if(isNullOrEmpty(subname6) && isNullOrEmpty(subid6)) {}else {
           	   t.setSubid(subid6);
           	   t.setSubname(subname6);
           	   t.setUserid(tuserid);
              	   tad.insertsubject(t);             	   
              }
              String sr1=request.getParameter("sr1");                
              if(isNullOrEmpty(sr1)) {}else {
           	  t.setSelfreliance(sr1);
           	  t.setUserid(tuserid);
           	  tad.insertselfreliance(t);
}
              String sr2=request.getParameter("sr2");                
              if(isNullOrEmpty(sr2)) {}else {
           	  t.setSelfreliance(sr2);
           	  t.setUserid(tuserid);
           	  tad.insertselfreliance(t);
}
              String sr3=request.getParameter("sr3");                
              if(isNullOrEmpty(sr3)) {}else {
           	  t.setSelfreliance(sr3);
           	  t.setUserid(tuserid);
           	  tad.insertselfreliance(t);
}
              request.setAttribute("success","<div class=\"success\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" + "<strong>Teacher account created for:"+tname+"</strong>" +"</div>");  
              request.getRequestDispatcher("Admin.jsp").forward(request, response);																						    	    	    	                
           } 	
       break;
       case "CheckStudent":
    	   Student s=new Student();
    	   AdminDAO ado=new AdminDAOimpl();
    	   String rno=request.getParameter("userid");
    	   s=ado.getstudent(rno);
    	   if(s.getUserid().equals("u")) {
    	    request.setAttribute("sorry","<div class=\"alert\">" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" + "<strong>Student with userid-"+rno+" does not exists.</strong>" +"</div>");
    	    request.getRequestDispatcher("CheckStudent.jsp").forward(request, response);		          			           											    	                
    	   }else {
    	   request.getSession().setAttribute("sid", rno);
    	   request.getSession().setAttribute("profile","<br><h1><font color=\"white\">"+s.getName()+"</font></h1><br>" + "<p class=\"title\">"+s.getUserid()+"</p><br>" +           		"<p class=\"title\">"+s.getDepartment()+"</p><br>" + "<p class=\"title\">"+s.getCourse()+"</p><br>" + "<p class=\"title\">sem-"+s.getSem()+"</p><br>"+"<p class=\"title\">"+s.getSelfreliance()+"</p><br>"   );
    	   response.sendRedirect("SProfile.jsp");       		            	          	       	  
    	   }
    	   break;
       case "CheckTeacher":    	   
    	   AdminDAO ado2=new AdminDAOimpl();
    	   String idno=request.getParameter("userid");   	   
    	   Teacher t=new Teacher();
    	   t=ado2.getteachers(idno);
           if(t.getUserid().equals("u")) {
    		request.setAttribute("sorry","<div class=\"alert\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +  "<strong>Teacher with userid-"+idno+" does not exists.</strong>" + "</div>");
    		request.getRequestDispatcher("CheckTeacher.jsp").forward(request, response);		
    	   }else {
           List<Teacher>thelist=ado2.getteacher(idno);
           List<Teacher>thelist2=ado2.getselfreliance(idno);
           List<Teacher>thelist3=ado2.getsubject(idno);
           
           request.getSession().setAttribute("tid", idno);
           request.getSession().setAttribute("list",thelist);
           request.getSession().setAttribute("list2",thelist2);
           request.getSession().setAttribute("list3",thelist3);
           response.sendRedirect("TProfile.jsp");             	       	    	      
    	   }break;
       case "GenerateReport":
    	   StudentDAO sta= new StudentDAOimpl();
    	   AdminDAO ado3=new AdminDAOimpl();
           String sid=request.getParameter("userid");
           Student sp=ado3.getstudent(sid);
           if(sp.getUserid().equals("u")) {
            request.setAttribute("sorry","<div class=\"alert\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +  "<strong>Student with userid-"+sid+" does not exists.</strong>" + "</div>");
       		request.getRequestDispatcher("GenerateReport.jsp").forward(request, response);		
       	   }else {
           }
           List<Academic>thelist=sta.getAcaFeedback(sid);          
           List<SelfReliance> thelist2=sta.getSRFeedback(sid);
           List<Miscellaneous> thelist3=sta.getMisFeedback(sid);
           request.getSession().setAttribute("name",sp.getName());
           request.getSession().setAttribute("userid",sp.getUserid());
           request.getSession().setAttribute("clas",sp.getCourse());
           request.getSession().setAttribute("sem",sp.getSem());           
           request.getSession().setAttribute("list3",thelist3);
           request.getSession().setAttribute("list2",thelist2);
           request.getSession().setAttribute("list",thelist);
           response.sendRedirect("StudentReport.jsp");
}}}
