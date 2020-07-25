package guideMe.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import guideMe.DAO.AdminDAO;
import guideMe.DAO.AdminDAOimpl;
import guideMe.DAO.TeacherDAO;
import guideMe.DAO.TeacherDAOimpl;
import guideMe.model.Academic;
import guideMe.model.Miscellaneous;
import guideMe.model.SelfReliance;
import guideMe.model.Student;
import guideMe.model.Teacher;

@WebServlet("/TeacherController")
public class TeacherController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Connection con = null;
    static PreparedStatement ps= null;
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {    		
    		String action = request.getParameter("action");				
    		switch(action) {
    			
    			case "StudentProfile":
    				studentprofile(request, response);
    				break;
    			case "TeacherProfile":
    				teacherprofile(request, response);
    				break;
    				
    			case "AcademicAcknowledgement":
    				academicacknowledgement(request, response);
    				break;
    				
    			case "SelfRelianceAcknowledgement":
    				selfrelianceacknowledgement(request, response);
    				
    				break;
    				
    			case "MiscellaneousAcknowledgement":
    				 miscellaneousacknowledgement(request, response);
    				break;    				    			
    				
    		}
    		
    	}      	           
	private void academicacknowledgement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             TeacherDAO tdd= new TeacherDAOimpl();
             HttpSession session=request.getSession();
        	 String tid=(String) session.getAttribute("tid");
             List<Academic> thelist=tdd.getAcaAck(tid);
             request.getSession().setAttribute("list",thelist);
             response.sendRedirect("AcaAck.jsp");
         }
	private void selfrelianceacknowledgement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	TeacherDAO tdsr= new TeacherDAOimpl();
        	HttpSession session=request.getSession();
        	String tid=(String) session.getAttribute("tid");
            List<SelfReliance> thelist2=tdsr.getSRAck(tid);
            request.getSession().setAttribute("list2",thelist2);
            response.sendRedirect("SRAck.jsp");
	}
	private void miscellaneousacknowledgement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	TeacherDAO tdms= new TeacherDAOimpl();
        	HttpSession session=request.getSession();
        	String tid=(String) session.getAttribute("tid");
            List<Miscellaneous> thelist3=tdms.getMisAck(tid);
            request.getSession().setAttribute("list3",thelist3);
            response.sendRedirect("MAck.jsp");          
        }
	private void studentprofile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student s=new Student();
 	   AdminDAO ado=new AdminDAOimpl();
 	   String rno=request.getParameter("userid");
 	   s=ado.getstudent(rno);
 	   request.getSession().setAttribute("sid", rno);
 	   request.getSession().setAttribute("profile","<br><h1><font color=\"white\">"+s.getName()+"</font></h1><br>" +"<p class=\"title\">"+s.getUserid()+"</p><br>" +"<p class=\"title\">"+s.getDepartment()+"</p><br>" +"<p class=\"title\">"+s.getCourse()+"</p><br>" + "<p class=\"title\">sem-"+s.getSem()+"</p><br>"+"<p class=\"title\">"+s.getSelfreliance()+"</p><br>");  
 	   response.sendRedirect("SProfile.jsp");
	
	}
	private void teacherprofile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminDAO ado2=new AdminDAOimpl();
		HttpSession session=request.getSession();
    	String idno=(String)session.getAttribute("id");
    	System.out.print(idno);
        List<Teacher>thelist=ado2.getteacher(idno);
        List<Teacher>thelist2=ado2.getselfreliance(idno);
        List<Teacher>thelist3=ado2.getsubject(idno);
        
        request.getSession().setAttribute("tid", idno);
        request.getSession().setAttribute("list",thelist);
        request.getSession().setAttribute("list2",thelist2);
        request.getSession().setAttribute("list3",thelist3);
        response.sendRedirect("TProfile.jsp");             	       	 
 	    
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(true);
        String page = (String)sess.getAttribute("page");
        
 switch(page){
	case "TeacherAcademic":
		teacheracademic(request, response);
		break;
		
	case "TeacherSelfReliance":
		teacherselfreliance(request, response);
		
		break;
		
	case "TeacherMiscellaneous":
		 teachermiscellaneous(request, response);
		break;
        
	        }
 }
	
	private void teacheracademic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	TeacherDAO td=new TeacherDAOimpl();
    	AdminDAO ad=new AdminDAOimpl();
    	Academic a = new Academic();        	           
        LocalDateTime fdate=LocalDateTime.now();
        Timestamp today=Timestamp.valueOf(fdate);	           
             	                              
        a.setSid(request.getParameter("userid"));
        a.setRemarks(request.getParameter("feedback"));            
        a.setSubid(request.getParameter("subject"));
        a.setMarks(request.getParameter("mark"));
        HttpSession session=request.getSession();       	    
        a.setTid((String) session.getAttribute("tid"));           
        a.setFid(0);
        a.setStatus(0);
        a.setDate(today);            
        Student stu=ad.getstudent(request.getParameter("userid"));
        Teacher ch=ad.checksubject(request.getParameter("subject"), (String) session.getAttribute("tid"));
        if(stu.getUserid().equals("u")) {
         request.setAttribute("success","<div class=\"alert\">" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>No student with roll no-" +request.getParameter("userid")+"</strong>" +"</div>");
		 request.getRequestDispatcher("TeacherAcademic.jsp").forward(request, response);
        }
        if(ch.getSubid().equals(request.getParameter("subject"))) {
        td.AcaFeedback(a);           
         request.setAttribute("success","<div class=\"success\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" + "<strong>Feedback sent to-"+request.getParameter("userid")+"</strong>" + "</div>");
			 request.getRequestDispatcher("TeacherAcademic.jsp").forward(request, response);
        }else{
        	request.setAttribute("success","<div class=\"alert\">" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>You can't give feedback for - " +request.getParameter("subject")+"</strong>" +"</div>");
        	request.getRequestDispatcher("TeacherAcademic.jsp").forward(request, response);		  						 
        }
        	                              
   	}   
      
   	private void teacherselfreliance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	   AdminDAO asr=new AdminDAOimpl();
    	   TeacherDAO tds=new TeacherDAOimpl();
    	   SelfReliance sr=new SelfReliance();       	   
    	   Student st=new Student();
    	        	   	           
           LocalDateTime sfdate=LocalDateTime.now();
           Timestamp srtoday=Timestamp.valueOf(sfdate);			           
           HttpSession srsession=request.getSession();
           	           	           
           sr.setTid((String) srsession.getAttribute("tid"));
           sr.setSid(request.getParameter("userid"));
           sr.setDept(request.getParameter("srdpt"));             
           sr.setMarks(request.getParameter("mark"));
           sr.setRemarks(request.getParameter("feedback"));
           sr.setFid(1);
           sr.setStatus(0);
           sr.setDate(srtoday);               
           st=asr.getstudent(request.getParameter("userid"));
           Teacher chs=asr.checkselfreliance(request.getParameter("srdpt"),(String) srsession.getAttribute("tid"));
           if(st.getUserid().equals("u")) {
        	request.setAttribute("success","<div class=\"alert\">" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>No student with roll no-" +request.getParameter("userid")+"</strong>" +"</div>");
 			request.getRequestDispatcher("TeacherSelfReliance.jsp").forward(request, response);
           }else {
        	
           if(chs.getSelfreliance().equals(request.getParameter("srdpt")) && st.getSelfreliance().equals(request.getParameter("srdpt"))) {
             tds.SRFeedback(sr);                              
           	    request.setAttribute("success","<div class=\"success\">" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>Feedback sent to-"+request.getParameter("userid")+"</strong>" +"</div>");    						     						   														    	    
	    	    request.getRequestDispatcher("TeacherSelfReliance.jsp").forward(request, response);
           } else {
        	request.setAttribute("success","<div class=\"alert\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" + "<strong>"+request.getParameter("srdpt")+" is not the common department of you and "+st.getName()+"</strong>" +"</div>"); 
			request.getRequestDispatcher("TeacherSelfReliance.jsp").forward(request, response);
           }}
 }
           
private void teachermiscellaneous(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	AdminDAO asm=new AdminDAOimpl();
    	TeacherDAO tdm=new TeacherDAOimpl();
    	Miscellaneous m =new Miscellaneous();
    	Student s=new Student();          
        LocalDateTime mfdate=LocalDateTime.now();
        Timestamp mtoday=Timestamp.valueOf(mfdate);              
        HttpSession msession=request.getSession();
        
        s=asm.getstudent(request.getParameter("userid"));
        if(s.getUserid().equals("u")) {
         request.setAttribute("success","<div class=\"alert\">" +"<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>No student with roll no-" +request.getParameter("userid")+"</strong>" + "</div>");	   						
		     request.getRequestDispatcher("TeacherMiscellaneous.jsp").forward(request, response);
		     
        }else {
        m.setFid(2);
        m.setTid((String) msession.getAttribute("tid"));
        m.setSid(request.getParameter("userid"));
        m.setRemarks(request.getParameter("feedback"));
        m.setArea(request.getParameter("selector"));
        m.setDate(mtoday);
        m.setStatus(0);
        m.setMarks(request.getParameter("mark"));
        tdm.MisFeedback(m);                         
        request.setAttribute("success","<div class=\"success\">" + "<span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>" +"<strong>Feedback sent to-"+request.getParameter("userid")+"</strong>" +"</div>");	     						    						      													    	    
	    	request.getRequestDispatcher("TeacherMiscellaneous.jsp").forward(request, response);
        }                              
        
} 
}


