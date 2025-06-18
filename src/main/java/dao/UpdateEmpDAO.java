package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBUtil;

public class UpdateEmpDAO extends DBUtil{
	public void UpdateEmpName(String empid,String fname,String lname) {
		
		try (Connection con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {
            String sql = "UPDATE employee SET empfname = ?, emplname = ? WHERE empid = ?";
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, fname);
                pst.setString(2, lname);
                pst.setString(3, empid);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
		
	}
	public void UpdateEmpPass(String empid,String emppasswd) {
		try (Connection con = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)) {
            String sql = "UPDATE employee SET emppasswd = ? WHERE empid = ?";
            String hashedPassword = hashPassword(emppasswd); 
            try (PreparedStatement pst = con.prepareStatement(sql)) {
                pst.setString(1, hashedPassword);
                pst.setString(2, empid);
                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
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
