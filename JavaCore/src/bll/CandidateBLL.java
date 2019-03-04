package bll;

import dal.CandidateDAL;
import entity.Candidate;


/**
 * @author User
 *
 */
public class CandidateBLL {
    CandidateDAL candidateDAL;
    
    public CandidateBLL() {
        candidateDAL = new CandidateDAL();
    }
    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: ....
     * Version 1.0
     * @param id
     * @return
     */
    public Candidate findCandidateByID(String id) {
        return candidateDAL.findCandidateByID(id);
  }
    
    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: ....
     * Version 1.0
     * @param Id
     * @return
     */
    public boolean checkID(String Id) {
        return candidateDAL.checkID(Id);
  }
}
