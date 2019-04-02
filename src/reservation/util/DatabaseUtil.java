package reservation.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			// �ؽ�Ʈ ���Ͽ��� �� �پ� �����ͺ��̽� ���̵�, ��й�ȣ�� �Է��Ͽ� �����մϴ�.
	        BufferedReader in = new BufferedReader(new FileReader(ServerUtil.authenticationPath + "Database.txt"));
			String dbURL = "jdbc:mysql://localhost:3306/" + in.readLine() + "?useSSL=false&useUnicode=true";
			String dbID = in.readLine();
			String dbPassword = in.readLine();
			in.close();
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
}