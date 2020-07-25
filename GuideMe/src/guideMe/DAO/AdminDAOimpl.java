package guideMe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import guideMe.MyConnectionProvider;
import guideMe.model.Student;
import guideMe.model.Teacher;

public class AdminDAOimpl implements AdminDAO {
	static Connection con = null;
    static PreparedStatement ps= null;
    static PreparedStatement ps2= null;
    static PreparedStatement ps3= null;
    static PreparedStatement ps4= null;
    static PreparedStatement ps5= null;
    static PreparedStatement ps6= null;
    static PreparedStatement ps7= null;
    static PreparedStatement ps8= null;
    static PreparedStatement ps9= null;
    static PreparedStatement ps10= null;
	@Override
	public int insertstudent(Student s) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();                      
			ps=con.prepareStatement("insert into Student values(?,?,?,?,?,?,?)");
			ps.setString(1,s.getUserid());
			ps.setString(2,s.getName());
			ps.setString(3,s.getCourse());
			ps.setString(4,s.getSem());
			ps.setString(5,s.getSelfreliance());
			ps.setBlob(6,s.getPhoto());
			ps.setString(7,s.getDepartment());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
		
	}

	@Override
	public Student getstudent(String username){
        Student s=new Student();       
	try {
		
		con=MyConnectionProvider.getCon();	
		ps5=con.prepareStatement("select * from Student where Sid=?");
		ps5.setString(1,username);				
		ResultSet rs=ps5.executeQuery();
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
	public int insertteacher(Teacher t) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();                      
			ps2=con.prepareStatement("insert into Teacher values(?,?,?,?)");
			ps2.setString(1,t.getUserid());
			ps2.setString(2,t.getName());			
			ps2.setBlob(3,t.getPhoto());
			ps2.setString(4, t.getDepartment());
			status=ps2.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public List<Teacher> getteacher(String username) {		  
		   List <Teacher> acad=null;				
		   Teacher t=null;		  
		try {
			acad=new ArrayList<Teacher>();			
			con=MyConnectionProvider.getCon();	
			ps6=con.prepareStatement("select * from Teacher where Tid=?");
			ps6.setString(1,username);				
			ResultSet rs1=ps6.executeQuery();			
			while(rs1.next()) {
				t=new Teacher();
				t.setName(rs1.getString(2));
				t.setUserid(rs1.getString(1));
				t.setDepartment(rs1.getString(4));
				acad.add(t);
				}			   						
		}catch(Exception e) {
			System.out.println(e);
		}
		return acad;
	}

	@Override
	public String generatereport(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertsubject(Teacher s) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();                      
			ps3=con.prepareStatement("insert into Tsub values(?,?,?)");
			ps3.setString(1,s.getSubid());
			ps3.setString(2,s.getSubname());			
			ps3.setString(3,s.getUserid());
			status=ps3.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public int insertselfreliance(Teacher sr) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();                      
			ps4=con.prepareStatement("insert into TSR values(?,?)");
			ps4.setString(1,sr.getUserid());
			ps4.setString(2,sr.getSelfreliance());						
			status=ps4.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Teacher checksubject(String sub, String tid) {
		Teacher t=new Teacher();      
		try {
			
			con=MyConnectionProvider.getCon();	
			ps9=con.prepareStatement("select Subid from Tsub where Tid=? and Subid=?");
			ps9.setString(1,tid);
			ps9.setString(2,sub);
			ResultSet rs1=ps9.executeQuery();
			while(rs1.next()) {
			t.setSubid(rs1.getString(1));			
			}}catch(Exception e) {
				System.out.println(e);
			}
		return t;
	}

	@Override
	public Teacher checkselfreliance(String self, String tid) {
		Teacher t=new Teacher();      
		try {
			
			con=MyConnectionProvider.getCon();	
			ps10=con.prepareStatement("select SRname from TSR where Tid=? and SRname=?");
			ps10.setString(1,tid);
			ps10.setString(2,self);
			ResultSet rs1=ps10.executeQuery();
			while(rs1.next()) {
			t.setSelfreliance(rs1.getString(1));			
			}}catch(Exception e) {
				System.out.println(e);
			}
		return t;
	}

	@Override
	public Teacher getteachers(String username) {
		 Teacher t=new Teacher();       
			try {
				con=MyConnectionProvider.getCon();	
				ps5=con.prepareStatement("select * from Teacher where Tid=?");
				ps5.setString(1,username);				
				ResultSet rs=ps5.executeQuery();
				while(rs.next()) {
				t.setName(rs.getString("TName"));								
				t.setUserid(rs.getString("Tid"));				
				t.setDepartment(rs.getString("Department"));
				}
				
			}catch(Exception e) {
				System.out.println(e);
			}
			return t;
		
	}

	@Override
	public List<Teacher> getsubject(String t) {
		List <Teacher> acad=null;				
		Teacher tsub=null;
		try {
			acad=new ArrayList<Teacher>();			
			con=MyConnectionProvider.getCon();
			ps8=con.prepareStatement("select * from Tsub where Tid=?");
			ps8.setString(1,t);				
			ResultSet rs2=ps8.executeQuery();
			while(rs2.next()) {
		    	tsub=new Teacher();
				tsub.setSubid(rs2.getString("Subid"));
				acad.add(tsub);
			}	
		   }catch(Exception e) {
				System.out.println(e);
			}
		return acad;
	}

	@Override
	public List<Teacher> getselfreliance(String t) {
		List <Teacher> acad=null;				
		Teacher tsr=null;
		try {
			acad=new ArrayList<Teacher>();			
			con=MyConnectionProvider.getCon();
			ps8=con.prepareStatement("select * from TSR where Tid=?");
			ps8.setString(1,t);				
			ResultSet rs3=ps8.executeQuery();
			while(rs3.next()) {
		    	 tsr=new Teacher();
		         tsr.setSelfreliance(rs3.getString("SRname"));
		         acad.add(tsr);
		    }	
		   }catch(Exception e) {
				System.out.println(e);
			}
		return acad;
	}

}
