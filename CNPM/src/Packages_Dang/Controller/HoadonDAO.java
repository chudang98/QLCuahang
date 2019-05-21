/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.Controller;

import Control_DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Duck
 */
public class HoadonDAO extends DAO{
    
    private static Statement state;
    
    public HoadonDAO() throws ClassNotFoundException, SQLException{
        super();
        state = con.createStatement();
    }
    private static ResultSet executeSelect(String sql) throws SQLException{
        ResultSet rs = state.executeQuery(sql);
        return rs;
    }
    @SuppressWarnings("empty-statement")
    public static ArrayList<String[]> getHoadon() throws SQLException{
        ArrayList<String[]> list = new ArrayList<String[]>();
        
        String SQL = "SELECT * FROM hoa_don_nhap_hang";
                
        ResultSet rs = executeSelect(SQL);
        
        while(rs.next()){
            String ma = rs.getString("ma_hd_nhap"), time = rs.getString("thoi_gian"),
                    note = rs.getString("ghi_chu"), nvk = rs.getString("cmnd_nv_kho"), ncc = rs.getString("ncc_cmnd");
            String[] t = {ma, time, note, nvk, ncc};
            list.add(t);
        }
        return list;
    }
}
