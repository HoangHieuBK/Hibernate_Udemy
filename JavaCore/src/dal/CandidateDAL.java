package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Candidate;
import utils.DbConnection;


/**
 * @author User
 *
 */
public class CandidateDAL {
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
        Connection conn = DbConnection.connect();
        ResultSet resultSet = null;
        Candidate candidate = null;
        PreparedStatement preparedStatement = null;
        String sql = "select Candidate_type from Candidate where candidateCode = ?";
        try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, id);
                resultSet = preparedStatement.executeQuery();
                
                while (resultSet.next()) {
                        String candidateType = resultSet.getString("Candidate_type");
                        candidate = new Candidate();
                        candidate.setCandidate_type(candidateType);
                }
        } catch (SQLException e) {
                e.printStackTrace();
        } finally {
           try {
            resultSet.close();
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        }

        return candidate;
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
        Connection connection = DbConnection.connect();
        String sql = "select * from Candidate";
        int check = 0;
        try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                        if (resultSet.getString("candidateCode").equals(Id)) {
                                check++;
                        }
                }
        } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
        }
        if (check == 0) {
                return true;
        } else {
                return false;
        }
  }
    
}
