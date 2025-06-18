package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class LoginDAO extends DBUtil {

	public int loginexe(String empid, String emppasswd) {
		int role = 99;

		

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECTを準備
			String sql = "SELECT emprole FROM employee where empid like ? and emppasswd like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, empid);
			pStmt.setString(2, emppasswd);

			//SELECTを実行し、結果表を取得
			ResultSet rs = pStmt.executeQuery();

			//結果表に格納されたレコードの内容を
			//Employeeインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				try {
					role = Integer.parseInt(rs.getString("emprole"));
				} catch (NumberFormatException e) {
					role = 99;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 99;
		}
		return role;
	}
}