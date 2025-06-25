package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class LoginDAO extends DBUtil {

	public int loginexe(String empid, String emppasswd) {
		int role = 99;
		String hashedPassword = hashPassword(emppasswd);
		

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			//SELECTを準備
			String sql = "SELECT emprole FROM employee where empid like ? and emppasswd like ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, empid);
			pStmt.setString(2, hashedPassword);

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
	// パスワードのハッシュ化
    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            return bytesToHex(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    // バイト配列を16進数文字列に変換
    private String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}