package entity;

/**
 * @author User
 *
 */
public class Fresher_Candidate extends Candidate {
    
    private String Graduration_date;
    private String Graduation_rank;
    private String Education;

    public Fresher_Candidate() {
        
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
     * @param Graduration_date
     * @param Graduation_rank
     * @param Education
     */
    public Fresher_Candidate(String candidateCode, String firstName, String lastName, 
            int birthDate, String address, String email, String phone, String candidate_type, 
            String Graduration_date, String Graduation_rank, String Education) {
        super(candidateCode, firstName, lastName, birthDate, address, email, phone, 
                candidate_type);
         this.Graduration_date = Graduration_date;
         this.Graduation_rank = Graduation_rank;
         this.Education = Education;
    }

    public String getGraduration_date() {
        return Graduration_date;
    }

    public void setGraduration_date(String graduration_date) {
        Graduration_date = graduration_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    @Override
    public String toString() {
        return "Fresher_Candidate [candidateCode=" + candidateCode + ", FirstName=" + FirstName + ", LastName="
                + LastName + ", BirthDate=" + BirthDate + ", Address=" + Address + ", Email=" + Email + ", Phone="
                + Phone + ", Candidate_type=" + Candidate_type + ", Graduration_date=" + Graduration_date
                + ", Graduation_rank=" + Graduation_rank + ", Education=" + Education + "]";
    }
    
    
}
