package bll;

import java.util.List;

import dal.Experience_CandidateDAL;
import entity.Experience_Candidate;

/**
 * @author User
 *
 */
public class Experience_CandidateBLL implements BaseBLL<Experience_Candidate>{
    
    Experience_CandidateDAL exp_candidate ;
    
    

    /**
     * 
     */
    public Experience_CandidateBLL() {
        super();
        exp_candidate = new Experience_CandidateDAL();
    }

    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 3, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 3, 2019
     * Description: ....
     * Version 1.0
     * @return
     */
    @Override
    public List<Experience_Candidate> getAll() {
        // TODO Auto-generated method stub
        return exp_candidate.getAll();
    }

    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 3, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 3, 2019
     * Description: ....
     * Version 1.0
     * @param object
     * @return
     */
    @Override
    public int insert(Experience_Candidate object) {
        // TODO Auto-generated method stub
        return exp_candidate.insertExperience_Candidate(object);
    }

}
