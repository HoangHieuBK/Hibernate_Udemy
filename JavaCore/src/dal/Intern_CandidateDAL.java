package dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Intern_Candidate;
import utils.DbConnection;

/**
 * @author User
 *
 */
public class Intern_CandidateDAL implements BaseDAL<Intern_Candidate>{

    @Override
    public List<Intern_Candidate> getAll() {
        Connection connect = null;
        CallableStatement callst = null;
        List<Intern_Candidate> listInternCan = new ArrayList<Intern_Candidate>();
        try {
           connect = DbConnection.connect();
           callst = connect.prepareCall("{call getAllIntern_Candidate()}");
           ResultSet result = callst.executeQuery();
           while(result.next())
           {
               Intern_Candidate InternCan = new Intern_Candidate();
               InternCan.setCandidateCode(result.getString("candidateCode"));
               InternCan.setFirstName(result.getString("FirstName"));
               InternCan.setLastName(result.getString("LastName"));
               InternCan.setBirthDate(result.getInt("BirthDate"));
               InternCan.setAddress(result.getString("Address"));
               InternCan.setEmail(result.getString("Email"));
               InternCan.setPhone(result.getString("Phone"));
               InternCan.setCandidate_type(result.getString("Candidate_type"));
               InternCan.setMajors(result.getString("Majors"));
               InternCan.setSemester(result.getString("Semester"));
               InternCan.setUniversity_name(result.getString("University_name"));
               listInternCan.add(InternCan);
           }
       } catch (Exception e) {
           // TODO: handle exception
       }finally {
           DbConnection.closeConnect(connect, callst);
       }
        return listInternCan;
    }

    /* (non-Javadoc)
     * @see dal.BaseDAL#insertExperience_Candidate(java.lang.Object)
     */
    @Override
    public int insertExperience_Candidate(Intern_Candidate object) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see dal.BaseDAL#insertFresher_Candidate(java.lang.Object)
     */
    @Override
    public int insertFresher_Candidate(Intern_Candidate object) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see dal.BaseDAL#insertIntern_Candidate(java.lang.Object)
     */
    @Override
    public int insertIntern_Candidate(Intern_Candidate object) {
        Connection connect = null;
        CallableStatement callst = null;
        int ketqua = 0;
        try {
            
            // tạo kết nối đến csdl
            connect = DbConnection.connect();
            callst = connect.prepareCall("{call insertExperience_Candidate(?,?,?,?,?,?,?,?,?,?,?)}");
            
            // set các giá trị cho callst
            callst.setString(1, object.getCandidateCode());
            callst.setString(2, object.getFirstName());
            callst.setString(3, object.getLastName());
            callst.setInt(4, object.getBirthDate());
            callst.setString(5, object.getAddress());
            callst.setString(6, object.getEmail());
            callst.setString(7, object.getPhone());
            callst.setString(8, object.getCandidate_type());
            callst.setString(9, object.getMajors());
            callst.setString(10, object.getSemester());
            callst.setString(11, object.getUniversity_name());
            
            // thực hiện gọi procedure
            ketqua = callst.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
            ketqua = 0;
        } finally {
            DbConnection.closeConnect(connect, callst);
        }
        
        return ketqua;
    }

}
