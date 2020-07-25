package guideMe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import guideMe.MyConnectionProvider;
import guideMe.model.Academic;
import guideMe.model.Miscellaneous;
import guideMe.model.SelfReliance;
import guideMe.model.Student;

public class StudentDAOimpl implements StudentDAO {
	static Connection con = null;
    static PreparedStatement ps= null;
    static PreparedStatement ps2= null;
    static PreparedStatement ps3= null;
    static PreparedStatement ps4= null;
    static PreparedStatement ps5= null;
    static PreparedStatement ps6= null;
    static PreparedStatement ps7= null;
	@Override
	public Student getSProfile(String susername) {
		
		Student s=new Student();       
		try {			
			con=MyConnectionProvider.getCon();	
			ps=con.prepareStatement("select * from Student where Sid=?");
			ps.setString(1,susername);				
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			s.setName(rs.getString(2));
			s.setCourse(rs.getString(3));
			s.setSem(rs.getString(4));
			s.setUserid(rs.getString(1));
			s.setSelfreliance(rs.getString(5));
			s.setDepartment(rs.getString(7));
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return s;
	}

	@Override
	public List<Academic> getAcaFeedback(String sid) {
		List <Academic> acad=null;
		Academic ac=null;
		try {
			acad=new ArrayList<Academic>();
		con=MyConnectionProvider.getCon();
		ps2=con.prepareStatement("select Date ,Tid,Remarks,Status,Subid,Marks from Subject where Sid=?  order by Status asc");  
        ps2.setString(1,sid);           
        ResultSet rs=ps2.executeQuery();       
        while(rs.next()) {
        	ac=new Academic();
        	ac.setDate(rs.getTimestamp(1));
        	ac.setTid(rs.getString("Tid"));
        	ac.setRemarks(rs.getString("Remarks"));
        	ac.setMarks(rs.getString("Marks"));
        	ac.setSubid(rs.getString("Subid"));
        	ac.setStatus(rs.getInt("Status"));
        	acad.add(ac); 
        }
        ps4=con.prepareStatement("select Tid from Subject where Status=0 and Sid=?");
        ps4.setString(1,sid);
        ResultSet rs4=ps4.executeQuery();
        while(rs4.next()) { 
        LocalDateTime fdate=LocalDateTime.now();
        Timestamp today=Timestamp.valueOf(fdate);
        con=MyConnectionProvider.getCon();	           
        ps5=con.prepareStatement("insert into Acknowledgement values(?,?,?)");
        ps5.setTimestamp(1,today);
        ps5.setString(3,sid);
        ps5.setString(2,rs4.getString(1));


        ps6=con.prepareStatement("update Subject set Status=1 where Status=0 and Sid=? and Tid=?");
        ps6.setString(1, sid);
        ps6.setString(2, rs4.getString(1));
        ps5.executeUpdate();
        ps6.executeUpdate();
         }
	        }catch(Exception e) {
		System.out.println(e);
	}  
		return acad;
	  
		}
	
	@Override
	public List<SelfReliance> getSRFeedback(String sid) {
		List <SelfReliance> acad=null;
		SelfReliance ac=null;
		try {
			acad=new ArrayList<SelfReliance>();
		con=MyConnectionProvider.getCon();
		ps3=con.prepareStatement("select Date,Tid,Remarks,Status,Dept,Marks from Self_Reliance where Sid=?  order by Status asc");  
        ps3.setString(1,sid);           
        ResultSet rs=ps3.executeQuery();       
        while(rs.next()) {
        	ac=new SelfReliance();
        	ac.setDate(rs.getTimestamp("Date"));
        	ac.setTid(rs.getString("Tid"));
        	ac.setRemarks(rs.getString("Remarks"));
        	ac.setDept(rs.getString("Dept"));
        	ac.setMarks(rs.getString("Marks"));
        	ac.setStatus(rs.getInt("Status"));
        	acad.add(ac);       	   	       
        }     
                 
             ps4=con.prepareStatement("select Tid from Self_Reliance where Status=0 and Sid=?");
             ps4.setString(1,sid);
             ResultSet rs4=ps4.executeQuery();
	         while(rs4.next()) { 
	         LocalDateTime fdate=LocalDateTime.now();
	         Timestamp today=Timestamp.valueOf(fdate);
             con=MyConnectionProvider.getCon();	           
             ps5=con.prepareStatement("insert into Acknowledgement values(?,?,?)");
             ps5.setTimestamp(1,today);
             ps5.setString(3,sid);
             ps5.setString(2,rs4.getString(1));
    
     
             ps6=con.prepareStatement("update Self_Reliance set Status=1 where Status=0 and Sid=? and Tid=?");
             ps6.setString(1, sid);
             ps6.setString(2, rs4.getString(1));
             ps5.executeUpdate();
	         ps6.executeUpdate();
	          }
        }catch(Exception e) {
		System.out.println(e);
	}  
		return acad;
	}

	@Override
	public List<Miscellaneous> getMisFeedback(String sid) {
		List <Miscellaneous> acad=null;
		Miscellaneous ac=null;
		try {
			acad=new ArrayList<Miscellaneous>();
		con=MyConnectionProvider.getCon();
		ps4=con.prepareStatement("select Date,Tid,Remarks,Status,FBArea,Marks from Miscellaneous where Sid=?  order by Status asc");  
        ps4.setString(1,sid);           
        ResultSet rs=ps4.executeQuery();       
        while(rs.next()) {
        	ac=new Miscellaneous();
        	ac.setDate(rs.getTimestamp("Date"));
        	ac.setTid(rs.getString("Tid"));
        	ac.setArea(rs.getString("FBArea"));
        	ac.setRemarks(rs.getString("Remarks"));
        	ac.setMarks(rs.getString("Marks"));
        	ac.setStatus(rs.getInt("Status"));
        	acad.add(ac);
        }
        ps7=con.prepareStatement("select Tid from Miscellaneous where Status=0 and Sid=?");
        ps7.setString(1,sid);
        ResultSet rs4=ps7.executeQuery();
        while(rs4.next()) { 
        LocalDateTime fdate=LocalDateTime.now();
        Timestamp today=Timestamp.valueOf(fdate);
        con=MyConnectionProvider.getCon();	           
        ps5=con.prepareStatement("insert into Acknowledgement values(?,?,?)");
        ps5.setTimestamp(1,today);
        ps5.setString(3,sid);
        ps5.setString(2,rs4.getString(1));


        ps6=con.prepareStatement("update Miscellaneous set Status=1 where Status=0 and Sid=? and Tid=?");
        ps6.setString(1, sid);
        ps6.setString(2, rs4.getString(1));
        ps5.executeUpdate();
        ps6.executeUpdate();
         }
	
        }catch(Exception e) {
		System.out.println(e);
	}  
		return acad;
	}
	}

