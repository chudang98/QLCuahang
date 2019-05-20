/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.Controller;

import Control.Nha_Cung_Cap;
import Control_DAO.DAO;
import com.mysql.cj.xdevapi.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Duck
 */
public class NhaCCDAO extends DAO{
    
    private static String $table = "Nha_Cung_Cap";
    
    public NhaCCDAO() throws ClassNotFoundException, SQLException{
        super();
    }
    
    private static ResultSet executeSelect(String sql) throws SQLException{
       
        Statement state = con.createStatement();
        ResultSet rs = state.executeQuery(sql);
        
        return rs;
    }
    
    
    public static ArrayList<Nha_Cung_Cap> getAllNCC() throws SQLException{
        ArrayList<Nha_Cung_Cap> list = new ArrayList<Nha_Cung_Cap>();
        String sql = "SELECT * FROM " + $table;
     
        ResultSet rs = executeSelect(sql);
        
        while(rs.next()){
            String cmnd = rs.getString("cmnd"), ten = rs.getString("ten"),
                    diachi = rs.getString("dia_chi"), sdt = rs.getString("sdt"), email = rs.getString("email");
            Nha_Cung_Cap t = new Nha_Cung_Cap(cmnd, ten, diachi, sdt, email);
            list.add(t);
        }    
        return list;
    }
    
    
    
}
