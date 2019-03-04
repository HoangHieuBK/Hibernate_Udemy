/**
 * 
 */
package utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
   * Create by: BuiHoangHieu - CMC
   * Create date: Jan 3, 2019
   * Modifier: BuiHoangHieu
   * Modified date: Jan 3, 2019
   * Description: handle connect to DBMS
   * Version 1.0
 */
public class DbConnection {
        // MySQL
        // driver
        static final String DRIVER = "com.mysql.jdbc.Driver";
        // url
        static final String URL = "jdbc:mysql://localhost:3306/javacoreexam";
        // userName
        static final String USER_NAME = "root";
        // passWord
        static final String PASSWORD = "root";

        /**
         * Create by: BuiHoangHieu - CMC
         * Create date: Jan 3, 2019
         * Modifier: BuiHoangHieu
         * Modified date: Jan 3, 2019
         * Description: ....
         * Version 1.0
         * @return
         * @throws ClassNotFoundException
         * @throws SQLException
         */
        public static Connection connect() {
                // load driver
                try {
                        Class.forName(DRIVER);
                } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                }
                // get connection instance
                Connection connection = null;
                try {
                        connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                } catch (SQLException e) {
                        e.printStackTrace();
                }
                return connection;
        }
        
        
        
        /**
         * Create by: BuiHoangHieu - CMC
         * Create date: Jan 3, 2019
         * Modifier: BuiHoangHieu
         * Modified date: Jan 3, 2019
         * Description: đóng kết nối
         * Version 1.0
         * @param conn
         * @param calls
         */
        public static void closeConnect(Connection conn, CallableStatement calls) {
            // close connection
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            
            // close callAbleStatement
            if(calls != null) {
                try {
                    calls.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        
        public static void main(String[] args) {
            try {
                Connection connect = connect();
                if(connect != null)
                {
                    System.out.println("kết nối thành công!");
                }
                else {
                    System.out.println("Kết nối thất bại!");
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

}
