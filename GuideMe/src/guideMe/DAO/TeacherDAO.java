package guideMe.DAO;
import java.util.List;
import guideMe.model.*;

public interface TeacherDAO {
	
	public int AcaFeedback(Academic a);
	public int SRFeedback(SelfReliance s);
	public int MisFeedback(Miscellaneous m);			
	List<Academic> getAcaAck(String tid);
	List<SelfReliance> getSRAck(String tid);
	List<Miscellaneous> getMisAck(String tid);
	
}
