package guideMe.DAO;
import java.util.List;

import guideMe.model.Student;
import guideMe.model.Teacher;

public interface AdminDAO {
	public int insertstudent(Student s);
	public Student getstudent(String username);
	public Teacher getteachers(String username);
	public int insertteacher(Teacher t);
	public int insertsubject(Teacher s);
	public int insertselfreliance(Teacher sr);
	List<Teacher> getteacher(String tid);
	public String generatereport(String username);
	public Teacher checksubject(String sub,String tid);
	public Teacher checkselfreliance(String self, String tid);
	List<Teacher> getsubject(String t);
	List<Teacher> getselfreliance(String t);
}
