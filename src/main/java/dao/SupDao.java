package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Sup;

public class SupDao {
    public List<Sup> getSup(){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        List<Sup> SupList = new ArrayList<>();
        
        try {
            
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/kadai1", "root", "password");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT shiireid, shiiremei, shiireaddress, shiiretel, shihonkin, nouki FROM shiiregyosha");
            
            while (rs.next()) {
                
                Sup sup = new Sup();
                sup.setshiireid(rs.getString("shiireid"));
                sup.setshiiremei(rs.getString("shiiremei"));
                sup.setshiireaddress(rs.getString("shiireaddress"));
                sup.setshiiretel(rs.getString("shiiretel"));
                sup.setshihonkin(rs.getInt("shihonkin"));
                sup.setnouki(rs.getInt("nouki"));
                
                SupList.add(sup);
            }
            
            return SupList;
            
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return SupList;
        
    }

}