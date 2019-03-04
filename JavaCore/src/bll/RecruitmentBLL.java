package bll;

import java.util.List;

import dal.RecruitmentDAL;
import entity.Candidate;
import entity.Recruitment;


public class RecruitmentBLL {
    private RecruitmentDAL recruitmentDAL;

    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: ....
     * Version 1.0
     * @return
     */
    public List<Recruitment> getAllRecruitment(){
        recruitmentDAL = new RecruitmentDAL();
            return recruitmentDAL.getAllRecruitment();
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
    public Recruitment findRecruitmentByID(int id) {
        recruitmentDAL = new RecruitmentDAL();
        return recruitmentDAL.findRecruitmentByID(id);
}
    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: ....
     * Version 1.0
     * @param candidate
     * @param recruitment
     * @return
     */
    public boolean submitCandidateToRecruitment(Candidate candidate, Recruitment recruitment) {
        recruitmentDAL = new RecruitmentDAL();
            return recruitmentDAL.submitCandidateToRecruitment(candidate, recruitment);
    }
}
