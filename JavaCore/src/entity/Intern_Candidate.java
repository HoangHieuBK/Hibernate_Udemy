package entity;

/**
 * @author User
 *
 */
public class Intern_Candidate extends Candidate {
    
    private String Majors;
    private String Semester;
    private String University_name;

    /**
     * 
     */
    public Intern_Candidate() {
        // TODO Auto-generated constructor stub
    }
  
    public String getMajors() {
        return Majors;
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
     * @param majors
     * @param semester
     * @param university_name
     */
    public Intern_Candidate(String candidateCode, String firstName, String lastName, int birthDate, String address,
            String email, String phone, String candidate_type, String majors, String semester, String university_name) {
        super(candidateCode, firstName, lastName, birthDate, address, email, phone, candidate_type);
        Majors = majors;
        Semester = semester;
        University_name = university_name;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }

    @Override
    public String toString() {
        return "Intern_Candidate [candidateCode=" + candidateCode + ", FirstName=" + FirstName + ", LastName="
                + LastName + ", BirthDate=" + BirthDate + ", Address=" + Address + ", Email=" + Email + ", Phone="
                + Phone + ", Candidate_type=" + Candidate_type + ", Majors=" + Majors + ", Semester=" + Semester
                + ", University_name=" + University_name + "]";
    }

}
