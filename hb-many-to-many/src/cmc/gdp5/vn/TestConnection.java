package cmc.gdp5.vn;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String user = "hbstudent";
		String password = "hbstudent";
		try {
			Connection connect = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Succesfull!!!");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
