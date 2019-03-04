package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entity.Candidate;
import entity.Recruitment;
import utils.DbConnection;


public class RecruitmentDAL {
    
    /**
     * Create by: BuiHoangHieu - CMC
     * Create date: Jan 4, 2019
     * Modifier: BuiHoangHieu
     * Modified date: Jan 4, 2019
     * Description: ....
     * Version 1.0
     * @return
     */
    public List<Recruitment> getAllRecruitment() {
        Connection conn = DbConnection.connect();
        List<Recruitment> listRecruitments = new ArrayList<>();
        Statement statement = null;
        ResultSet resultSet = null;
        Recruitment recruitment = null;
        String sql = "select RecruitmentCode,Position,RecruitmentPackage,Amount from Recruitment";
        try {
                statement = conn.createStatement();
                resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                        int id = resultSet.getInt("RecruitmentCode");
                        String position = resultSet.getString("Position");
                        String recruitmentPackage = resultSet.getString("RecruitmentPackage");
                        int amount = resultSet.getInt("Amount");
                        recruitment = new Recruitment(id, position, recruitmentPackage, amount);
                        listRecruitments.add(recruitment);
                }
        } catch (SQLException e) {
                e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                statement.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return listRecruitments;
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
        Connection conn = DbConnection.connect();
        ResultSet resultSet = null;
        Recruitment recruiment = null;
        PreparedStatement preparedStatement = null;
        String sql = "select * from Recruitment where RecruitmentCode = ?";
        try {
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                        recruiment = new Recruitment();
                        recruiment.setRecruimentCode(resultSet.getInt(1));
                        recruiment.setPosition(resultSet.getString(2));
                        recruiment.setRecruimentPackage(resultSet.getString(3));
                        recruiment.setAmount(resultSet.getInt(4));
                }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();
                preparedStatement.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return recruiment;
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
        Connection conn = DbConnection.connect();
        PreparedStatement preparedStatement = null;
        String candidateType = candidate.getCandidate_type();
        String recruitmentPackageMatching ;
        if ("0".equals(candidateType)) {
                recruitmentPackageMatching = "A";
        } else if ("1".equals(candidateType)) {
                recruitmentPackageMatching = "B";
        } else {
                recruitmentPackageMatching = "C";
        }
        if (recruitmentPackageMatching.equals(recruitment.getRecruimentPackage())) {
                String sql = "update Recruitment set Amount = ? where RecruitmentCode = ?";
                try {
                        preparedStatement = conn.prepareStatement(sql);
                        preparedStatement.setInt(1, recruitment.getAmount() + 1);
                        preparedStatement.setInt(2, recruitment.getRecruimentCode());
                        preparedStatement.executeUpdate();
                        System.err.println("Submitted this candidate succesfully");

                } catch (SQLException e) {
                        e.printStackTrace();
                } finally {
                    try {
                        preparedStatement.close();
                        conn.close();
                    } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
        } else {
                System.err.println("This candidate is not matching");
        }

        return false;
}
    
}
