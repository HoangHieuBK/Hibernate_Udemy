package bll;

import java.util.List;

import dal.Fresher_CandidateDAL;
import entity.Fresher_Candidate;

/**
 * @author User
 *
 */
public class Fresher_CandidateBLL implements BaseBLL<Fresher_Candidate>{
    
    Fresher_CandidateDAL fres_can;
    
    

    /**
     * 
     */
    public Fresher_CandidateBLL() {
        super();
        fres_can = new Fresher_CandidateDAL();
    }

    /* (non-Javadoc)
     * @see bll.BaseBLL#getAll()
     */
    @Override
    public List<Fresher_Candidate> getAll() {
        // TODO Auto-generated method stub
        return fres_can.getAll();
    }

    /* (non-Javadoc)
     * @see bll.BaseBLL#insert(java.lang.Object)
     */
    @Override
    public int insert(Fresher_Candidate object) {
        // TODO Auto-generated method stub
        return fres_can.insertFresher_Candidate(object);
    }

}
