package dal;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Experience_Candidate;
import utils.DbConnection;

/**
 * @author User
 *
 * @param <Experience_Candidate>
 */
public class Experience_CandidateDAL implements BaseDAL<Experience_Candidate>{

    /* (non-Javadoc)
     * @see dal.BaseDAL#getAll()
     */
    @Override
    public List<Experience_Candidate> getAll() {
         Connection connect = null;
         CallableStatement callst = null;
         List<Experience_Candidate> listExpCan = new ArrayList<Experience_Candidate>();
         try {
            connect = DbConnection.connect();
            callst = connect.prepareCall("{call getAllExperience_Candidate()}");
            ResultSet result = callst.executeQuery();
            while(result.next())
            {
                Experience_Candidate expCan = new Experience_Candidate();
                expCan.setCandidateCode(result.getString("candidateCode"));
                expCan.setFirstName(result.getString("FirstName"));
                expCan.setLastName(result.getString("LastName"));
                expCan.setBirthDate(result.getInt("BirthDate"));
                expCan.setAddress(result.getString("Address"));
                expCan.setEmail(result.getString("Email"));
                expCan.setPhone(result.getString("Phone"));
                expCan.setCandidate_type(result.getString("Candidate_type"));
                expCan.setExpInYear(result.getInt("ExpInYear"));
                expCan.setProSkill(result.getString("ProSkill"));
                listExpCan.add(expCan);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            DbConnection.closeConnect(connect, callst);
        }
         return listExpCan;
    }


    /* (non-Javadoc)
     * @see dal.BaseDAL#insertExperience_Candidate(java.lang.Object)
     */
    @Override
    public int insertExperience_Candidate(Experience_Candidate object) {
        Connection connect = null;
        CallableStatement callst = null;
        int ketqua = 0;
        try {
            
            // tạo kết nối đến csdl
            connect = DbConnection.connect();
            callst = connect.prepareCall("{call insertExperience_Candidate(?,?,?,?,?,?,?,?,?,?)}");
            
            // set các giá trị cho callst
            callst.setString(1, object.getCandidateCode());
            callst.setString(2, object.getFirstName());
            callst.setString(3, object.getLastName());
            callst.setInt(4, object.getBirthDate());
            callst.setString(5, object.getAddress());
            callst.setString(6, object.getEmail());
            callst.setString(7, object.getPhone());
            callst.setString(8, object.getCandidate_type());
            callst.setInt(9, object.getExpInYear());
            callst.setString(10, object.getProSkill());
            
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
     * @see dal.BaseDAL#insertFresher_Candidate(java.lang.Object)
     */
    @Override
    public int insertFresher_Candidate(Experience_Candidate object) {
        // TODO Auto-generated method stub
        return 0;
    }

    /* (non-Javadoc)
     * @see dal.BaseDAL#insertIntern_Candidate(java.lang.Object)
     */
    @Override
    public int insertIntern_Candidate(Experience_Candidate object) {
        // TODO Auto-generated method stub
        return 0;
    }
    

    

}
