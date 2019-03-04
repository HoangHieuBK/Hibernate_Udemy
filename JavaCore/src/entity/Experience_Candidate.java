package entity;

/**
 * @author User
 *
 */
public class Experience_Candidate extends Candidate {
    
    private int ExpInYear;
    private String ProSkill;
 
    /**
     * 
     */
    public Experience_Candidate() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param candidateCode
     * @param firstName
     * @param lastName
     * @param birthDate
     * @param address
     * @param email
     * @param phone
     * @param candidate_type
     * @param ExpInYear
     * @param ProSkill
     */
    public Experience_Candidate(String candidateCode, String firstName, String lastName, int birthDate, String address,
            String email, String phone, String candidate_type, int ExpInYear, String ProSkill) {
        super(candidateCode, firstName, lastName, birthDate, address, email, phone, candidate_type);
        this.ExpInYear = ExpInYear;
        this.ProSkill = ProSkill;
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public String toString() {
        return "Experience_Candidate [candidateCode=" + candidateCode + ", FirstName=" + FirstName + ", LastName="
                + LastName + ", BirthDate=" + BirthDate + ", Address=" + Address + ", Email=" + Email + ", Phone="
                + Phone + ", Candidate_type=" + Candidate_type + ", ExpInYear=" + ExpInYear + ", ProSkill=" + ProSkill
                + "]";
    }
    
    

}
