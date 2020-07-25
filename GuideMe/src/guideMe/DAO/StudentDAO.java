package guideMe.DAO;
import java.util.List;

import guideMe.model.*;

public interface StudentDAO {

	public Student getSProfile(String susername);
	List<Academic> getAcaFeedback(String tid);
	List<SelfReliance> getSRFeedback(String tid);
	List<Miscellaneous> getMisFeedback(String tid);
  }
