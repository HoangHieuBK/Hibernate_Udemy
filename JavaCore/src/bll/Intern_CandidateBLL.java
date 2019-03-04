package bll;

import java.util.List;

import dal.Intern_CandidateDAL;
import entity.Intern_Candidate;

/**
 * @author User
 *
 */
public class Intern_CandidateBLL implements BaseBLL<Intern_Candidate>{
    
    Intern_CandidateDAL intern_can ;
    
    

    /**
     * 
     */
    public Intern_CandidateBLL() {
        super();
        intern_can = new Intern_CandidateDAL();
    }

    /* (non-Javadoc)
     * @see bll.BaseBLL#getAll()
     */
    @Override
    public List<Intern_Candidate> getAll() {
        // TODO Auto-generated method stub
        return intern_can.getAll();
    }

    /* (non-Javadoc)
     * @see bll.BaseBLL#insert(java.lang.Object)
     */
    @Override
    public int insert(Intern_Candidate object) {
        // TODO Auto-generated method stub
        return intern_can.insertIntern_Candidate(object);
    }

}
