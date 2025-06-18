package dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import util.DBUtil;

public class EmpRegisterDAO extends DBUtil{
    public void execute(String empid,String empfname,String emplname,String emppasswd,int emprole){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        String hashedPassword = hashPassword(emppasswd);
        
        try (Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS);){
            
            String sql = "INSERT INTO employee(empid,empfname,emplname,emppasswd,emprole) VALUES(?,?,?,?,?)";
            
            PreparedStatement pStmt = conn.prepareStatement(sql);
            
            pStmt.setString(1,empid);
            pStmt.setString(2,empfname);
            pStmt.setString(3,emplname);
            pStmt.setString(4,hashedPassword);
            pStmt.setInt(5,emprole);            
            pStmt.executeUpdate();
            
        } catch (SQLException e) {
            // TODO 自動生成された catch ブロック
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