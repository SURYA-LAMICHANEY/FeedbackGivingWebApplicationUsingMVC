package guideMe.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import guideMe.MyConnectionProvider;
import guideMe.model.user;

public class userDAOimpl implements userDAO {
    static Connection con = null;
    static PreparedStatement ps= null;
    static PreparedStatement ps2= null;
	@Override
	public int insertuser(user u) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();                      
			ps=con.prepareStatement("insert into Admin values(?,?,?)");
			ps.setString(3,u.getType());
			ps.setString(1,u.getUsername());
			ps.setString(2,u.getPassword());		
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}

	@Override
	public user getuser(String userId, String pass) {
                    user u=new user();       
		try {
			
			con=MyConnectionProvider.getCon();	
			ps=con.prepareStatement("select * from Admin where UserId=? and Pswd=?");
			ps.setString(1,userId);
			ps.setString(2,pass );
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
			u.setType(rs.getString(3));
			u.setUsername(rs.getString(1));
			u.setPassword(rs.getString(2));									
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		return u;
	}

	@Override
	public user changepassword( user u) {		
		try {			
		con=MyConnectionProvider.getCon();		
		ps2=con.prepareStatement("update Admin set Pswd=? where UserId=?");  
        ps2.setString(1,u.getPassword());
        ps2.setString(2,u.getUsername());        
        ps2.executeUpdate();       
	}catch(Exception e) {
		System.out.println(e);
	} return u;

}
}
