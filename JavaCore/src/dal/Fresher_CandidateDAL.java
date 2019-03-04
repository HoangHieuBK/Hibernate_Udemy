package dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Fresher_Candidate;
import utils.DbConnection;

/**
 * @author User
 *
 */
public class Fresher_CandidateDAL implements BaseDAL<Fresher_Candidate>{

    /* (non-Javadoc)
     * @see dal.BaseDAL#getAll()
     */
    @Override
    public List<Fresher_Candidate> getAll() {
        Connection connect = null;
        CallableStatement callst = null;
        List<Fresher_Candidate> listFreshCan = new ArrayList<Fresher_Candidate>();
        try {
           connect = DbConnection.connect();
           callst = connect.prepareCall("{call getAllFresher_Candidate()}");
           ResultSet result = callst.executeQuery();
           while(result.next())
           {
               Fresher_Candidate FreshCan = new Fresher_Candidate();
               FreshCan.setCandidateCode(result.getString("candidateCode"));
               FreshCan.setFirstName(result.getString("FirstName"));
               FreshCan.setLastName(result.getString("LastName"));
               FreshCan.setBirthDate(result.getInt("BirthDate"));
               FreshCan.setAddress(result.getString("Address"));
               FreshCan.setEmail(result.getString("Email"));
               FreshCan.setPhone(result.getString("Phone"));
               FreshCan.setCandidate_type(result.getString("Candidate_type"));
               FreshCan.setGraduration_date(result.getString("Graduration_date"));
               FreshCan.setGraduation_rank(result.getString("Graduation_rank"));
               FreshCan.setEducation(result.getString("Education"));
               listFreshCan.add(FreshCan);
           }
       } catch (Exception e) {
           // TODO: handle exception
       }finally {
           DbConnection.closeConnect(connect, callst);
       }
        return listFreshCan;
    }

    /* (non-Javadoc)
     * @see dal.BaseDAL#insertExperience_Candidate(java.lang.Object)
     */
    @Override
    public int insertExperience_Candidate(Fresher_Candidate object) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see dal.BaseDAL#insertFresher_Candidate(java.lang.Object)
     */
    @Override
    public int insertFresher_Candidate(Fresher_Candidate object) {
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
            callst.setString(9, object.getGraduration_date());
            callst.setString(10, object.getGraduation_rank());
            callst.setString(11, object.getEducation());
            
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

    /* (non-Javadoc)
     * @see dal.BaseDAL#insertIntern_Candidate(java.lang.Object)
     */
    @Override
    public int insertIntern_Candidate(Fresher_Candidate object) {
        // TODO Auto-generated method stub
        return 0;
    }



}
