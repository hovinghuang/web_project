package jdbc;

import java.sql.*;

public class DBUtil {
	boolean bInited = false;

	// ��������
	public void initJDBC() throws ClassNotFoundException {
		// ����MYSQL JDBC��������
		System.out.println("����MYSQL JDBC��������!");
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(Exception ex){
			throw new RuntimeException(ex+"����MYSQL JDBC��������ʧ��");
		}
		bInited = true;
		System.out.println("Success loading Mysql Driver!");
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		if (!bInited) {
			initJDBC();
		}
		// ����URLΪ jdbc:mysql//��������ַ/���ݿ���
		// �����2�������ֱ��ǵ�½�û���������
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/login", "root", "root");
		return conn;
	}

	public boolean loginSuccess(String username, String password) {
		boolean returnValue = false;
		String sql = "SELECT * FROM login";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String userNameInDB = rs.getString("username");
				String passwordInDB = rs.getString("password");
				if (userNameInDB.equals(username) && passwordInDB.equals(password)) {
					returnValue = true;
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return returnValue;

	}
}
