package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ShiireBean;
import util.DBUtil;

public class ShowTable extends DBUtil {
	public List<ShiireBean> exce() {
		List<ShiireBean> shiireList = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM shiiregyosha";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			ResultSet rs = pStmt.executeQuery();
			rs.next();
			do {
				String shiireid = rs.getString("shiireid");
				String shiiremei = rs.getString("shiiremei");
				String shiireaddress = rs.getString("shiireaddress");
				String shiiretel = rs.getString("shiiretel");
				int shihonkin = rs.getInt("shihonkin");
				int nouki = rs.getInt("nouki");
				ShiireBean shohinBean = new ShiireBean(shiireid, shiiremei, shiireaddress, shiiretel, shihonkin, nouki);
				shiireList.add(shohinBean);
			} while (rs.next());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shiireList;
	}

	public void execute(String shiireid, String shiiremei, String shiireaddress, String shiiretel, int shihonkin,
			int nouki) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);) {

			String sql = "INSERT INTO shiiregyosha(shiireid,shiiremei,shiireaddress,shiiretel,shihonkin,nouki) VALUES(?,?,?,?,?,?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			pStmt.setString(1, shiireid);
			pStmt.setString(2, shiiremei);
			pStmt.setString(3, shiireaddress);
			pStmt.setString(4, shiiretel);
			pStmt.setInt(5, shihonkin);
			pStmt.setInt(6, nouki);

			pStmt.executeUpdate();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
	public List<ShiireBean> Result(int shihon) {
		List<ShiireBean> shiireList = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){
            String sql = "SELECT * FROM shiiregyosha WHERE shihonkin >= ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setInt(1, shihon);
            ResultSet rs = pStmt.executeQuery();
            rs.next();
            do {
                String shiireid = rs.getString("shiireid");
                String shiiremei = rs.getString("shiiremei");
                String shiireaddress = rs.getString("shiireaddress");
                String shiiretel = rs.getString("shiiretel");
                int shihonkin = rs.getInt("shihonkin");
                int nouki = rs.getInt("nouki");
                ShiireBean shohinBean = new ShiireBean(shiireid,shiiremei,shiireaddress,shiiretel,shihonkin,nouki);
                 shiireList.add(shohinBean);
            }while(rs.next());
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return shiireList;
    }
}
