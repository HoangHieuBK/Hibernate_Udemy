package entity;

/**
 * @author User
 *
 */
public class Candidate {
  protected String candidateCode;
  protected String FirstName;
  protected String LastName;
  protected int BirthDate;
  protected String Address;
  protected String Email;
  protected String Phone;
  protected String Candidate_type;
  
/**
 * 
 */
public Candidate() {
    super();
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
 */
public Candidate(String candidateCode, String firstName, String lastName, int birthDate, String address, String email,
        String phone, String candidate_type) {
    super();
    this.candidateCode = candidateCode;
    FirstName = firstName;
    LastName = lastName;
    BirthDate = birthDate;
    Address = address;
    Email = email;
    Phone = phone;
    Candidate_type = candidate_type;
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
public String getCandidateCode() {
    return candidateCode;
}

/**
 * Create by: BuiHoangHieu - CMC
 * Create date: Jan 3, 2019
 * Modifier: BuiHoangHieu
 * Modified date: Jan 3, 2019
 * Description: ....
 * Version 1.0
 * @param candidateCode
 */
public void setCandidateCode(String candidateCode) {
    this.candidateCode = candidateCode;
}

public String getFirstName() {
    return FirstName;
}

public void setFirstName(String firstName) {
    FirstName = firstName;
}

public String getLastName() {
    return LastName;
}

public void setLastName(String lastName) {
    LastName = lastName;
}

public int getBirthDate() {
    return BirthDate;
}

public void setBirthDate(int birthDate) {
    BirthDate = birthDate;
}

public String getAddress() {
    return Address;
}

public void setAddress(String address) {
    Address = address;
}

public String getEmail() {
    return Email;
}

public void setEmail(String email) {
    Email = email;
}

public String getPhone() {
    return Phone;
}

public void setPhone(String phone) {
    Phone = phone;
}

public String getCandidate_type() {
    return Candidate_type;
}

public void setCandidate_type(String candidate_type) {
    Candidate_type = candidate_type;
}

@Override
public String toString() {
    return "Candidate [candidateCode=" + candidateCode + ", FirstName=" + FirstName + ", LastName=" + LastName
            + ", BirthDate=" + BirthDate + ", Address=" + Address + ", Email=" + Email + ", Phone=" + Phone
            + ", Candidate_type=" + Candidate_type + "]";
}
  
  
}
