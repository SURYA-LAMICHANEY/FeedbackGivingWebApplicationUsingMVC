package guideMe.DAO;
import guideMe.model.user;

public interface userDAO {
public int insertuser(user u);
public user getuser(String username,String pass);
public user changepassword( user u);
}
