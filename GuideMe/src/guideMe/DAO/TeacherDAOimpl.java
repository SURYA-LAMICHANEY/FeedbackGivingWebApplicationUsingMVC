package guideMe.DAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import guideMe.MyConnectionProvider;
import guideMe.model.Academic;
import guideMe.model.Miscellaneous;
import guideMe.model.SelfReliance;

public class TeacherDAOimpl implements TeacherDAO {
	static Connection con = null;
    static PreparedStatement ps= null;
    static PreparedStatement ps2= null;
    static PreparedStatement ps3= null;
    static PreparedStatement ps4= null;
    static PreparedStatement ps5= null;
    static PreparedStatement ps6= null;
    
	@Override
	public int AcaFeedback(Academic a) {		
			int status=0;
			try {
				con=MyConnectionProvider.getCon();                      
				ps2=con.prepareStatement("insert into Subject values(?,?,?,?,?,?,?,?)");
				ps2.setInt(1,a.getFid());
				ps2.setString(2, a.getTid());
				ps2.setString(3, a.getSid());
				ps2.setString(4, a.getSubid());
				ps2.setTimestamp(5, a.getDate());
				ps2.setString(6,a.getMarks());
				ps2.setString(7,a.getRemarks());
				ps2.setInt(8, a.getStatus());
				status=ps2.executeUpdate();
				con.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			return status;	
	}

	@Override
	public int SRFeedback(SelfReliance s) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();                      
			ps=con.prepareStatement("insert into Self_Reliance values(?,?,?,?,?,?,?,?)");
			ps.setInt(1,s.getFid());
			ps.setString(2, s.getTid());
			ps.setString(3, s.getSid());
			ps.setString(4, s.getDept());
			ps.setTimestamp(6, s.getDate());
			ps.setString(5,s.getMarks());
			ps.setString(7,s.getRemarks());
			ps.setInt(8, s.getStatus());
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public int MisFeedback(Miscellaneous m) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();                      
			ps3=con.prepareStatement("insert into Miscellaneous values(?,?,?,?,?,?,?,?)");
			ps3.setInt(1,m.getFid());
			ps3.setString(2, m.getTid());
			ps3.setString(3, m.getSid());			
			ps3.setTimestamp(4, m.getDate());
			ps3.setString(6,m.getArea());
			ps3.setString(5,m.getRemarks());
			ps3.setInt(7, m.getStatus());
			ps3.setString(8, m.getMarks());
			status=ps3.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
		
	@Override
	public List<Academic> getAcaAck(String tid) {						
		List <Academic> acad=null;
		Academic ac=null;
		try {
			acad=new ArrayList<Academic>();
		con=MyConnectionProvider.getCon();
		ps4=con.prepareStatement("select Date,Sid,Remarks,Status,Subid from Subject where Tid=? order by Date desc");  
        ps4.setString(1,tid);           
        ResultSet rs=ps4.executeQuery();       
        while(rs.next()) {
        	ac=new Academic();
        	ac.setDate(rs.getTimestamp("Date"));
        	ac.setSid(rs.getString("Sid"));
        	ac.setRemarks(rs.getString("Remarks"));
        	ac.setStatus(rs.getInt("Status"));
        	ac.setSubid(rs.getString("Subid"));
        	acad.add(ac);       	   	       
	}
        }catch(Exception e) {
		System.out.println(e);
	}  
		return acad;
	  
		}

	@Override
	public List<SelfReliance> getSRAck(String tid) {
		List <SelfReliance> acad=null;
		SelfReliance ac=null;
		try {
			acad=new ArrayList<SelfReliance>();
		con=MyConnectionProvider.getCon();
		ps4=con.prepareStatement("select Date,Sid,Remarks,Status,Dept from Self_Reliance where Tid=?  order by  Date desc");  
        ps4.setString(1,tid);           
        ResultSet rs=ps4.executeQuery();       
        while(rs.next()) {
        	ac=new SelfReliance();
        	ac.setDate(rs.getTimestamp("Date"));
        	ac.setSid(rs.getString("Sid"));
        	ac.setRemarks(rs.getString("Remarks"));
        	ac.setDept(rs.getString("Dept"));
        	ac.setStatus(rs.getInt("Status"));
        	acad.add(ac);       	   	       
	}
        }catch(Exception e) {
		System.out.println(e);
	}  
		return acad;
	}

	@Override
	public List<Miscellaneous> getMisAck(String tid) {
		List <Miscellaneous> acad=null;
		Miscellaneous ac=null;
		try {
			acad=new ArrayList<Miscellaneous>();
		con=MyConnectionProvider.getCon();
		ps4=con.prepareStatement("select Date,Sid,Remarks,Status,FBArea from Miscellaneous where Tid=?  order by  Date desc");  
        ps4.setString(1,tid);           
        ResultSet rs=ps4.executeQuery();       
        while(rs.next()) {
        	ac=new Miscellaneous();
        	ac.setDate(rs.getTimestamp("Date"));
        	ac.setSid(rs.getString("Sid"));
        	ac.setArea(rs.getString("FBArea"));
        	ac.setRemarks(rs.getString("Remarks"));
        	ac.setStatus(rs.getInt("Status"));
        	acad.add(ac);       	   	       
	}
        }catch(Exception e) {
		System.out.println(e);
	}  
		return acad;
	}

}
