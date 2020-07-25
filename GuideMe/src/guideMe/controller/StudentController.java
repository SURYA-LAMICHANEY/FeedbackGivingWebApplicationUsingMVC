package guideMe.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import guideMe.DAO.AdminDAO;
import guideMe.DAO.AdminDAOimpl;
import guideMe.DAO.StudentDAO;
import guideMe.DAO.StudentDAOimpl;
import guideMe.model.Academic;
import guideMe.model.Miscellaneous;
import guideMe.model.SelfReliance;
import guideMe.model.Student;

@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");				
		switch(action) {
			
			case "StudentProfile":
				studentprofile(request, response);
				break;
				
			case "AcademicFeedback":
				academicfeedback(request, response);
				break;
				
			case "SelfRelianceFeedback":
				selfreliancefeedback(request, response);
				
				break;
				
			case "MiscellaneousFeedback":
				 miscellaneousfeedback(request, response);
				break;
				
		}
		
	}
	
       	private void studentprofile(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           Student s=new Student();
     	   AdminDAO ado=new AdminDAOimpl();
     	   HttpSession session=request.getSession();
           String sid= (String) session.getAttribute("sid");
     	   s=ado.getstudent(sid);
     	   request.getSession().setAttribute("sid", sid);
     	   request.getSession().setAttribute("profile",         		 
            		"<br><h1><font color=\"white\">"+s.getName()+"</font></h1><br>" + 
            		"<p class=\"title\">"+s.getUserid()+"</p><br>" + 
            		"<p class=\"title\">"+s.getDepartment()+"</p><br>" + 
            		"<p class=\"title\">"+s.getCourse()+"</p><br>" + 
            		"<p class=\"title\">sem-"+s.getSem()+"</p><br>"+
            		"<p class=\"title\">"+s.getSelfreliance()+"</p><br>"            		            		
            );
     	   response.sendRedirect("SProfile.jsp");}
     	                
       	private void academicfeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        	StudentDAO sta= new StudentDAOimpl();       	
        	HttpSession session=request.getSession();
            String sid= (String) session.getAttribute("sid");
            List<Academic>thelist=sta.getAcaFeedback(sid);                        
            request.setAttribute("list",thelist);
            request.getRequestDispatcher("AcaFeedback.jsp").forward(request,response);
            
        }
           
       	private void selfreliancefeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	StudentDAO stsr= new StudentDAOimpl();
        	HttpSession session=request.getSession();
            String sid= (String) session.getAttribute("sid");
            List<SelfReliance> thelist2=stsr.getSRFeedback(sid);
            request.setAttribute("list2",thelist2);
            request.getRequestDispatcher("SRFeedback.jsp").forward(request,response);
            
        }
           
    	private void miscellaneousfeedback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	StudentDAO stms= new StudentDAOimpl();
        	HttpSession session=request.getSession();
            String sid= (String) session.getAttribute("sid");
            List<Miscellaneous> thelist3=stms.getMisFeedback(sid);
            request.setAttribute("list3",thelist3);
            request.getRequestDispatcher("MisFeedback.jsp").forward(request,response);
            
	}

}
