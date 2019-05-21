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
    public static ArrayList<String[]> getMathangHDN(String HDN) throws SQLException{
        String sql = "SELECT san_pham.ma_san_pham, mat_hang_nhap.ma_mat_hang,san_pham.ten_san_pham, san_pham.loai_san_pham, san_pham.kick_co, san_pham.mau_sac, san_pham.gia_nhap, san_pham.gia_ban "
                + "FROM san_pham, hoa_don_nhap_hang, mat_hang_nhap "
                + "WHERE san_pham.ma_san_pham = mat_hang_nhap.ma_san_pham AND mat_hang_nhap.hd_nhap = hoa_don_nhap_hang.ma_hd_nhap AND hoa_don_nhap_hang.ma_hd_nhap = " + HDN ;
        ArrayList<String[]> list = new ArrayList<String[]>();
        ResultSet rs = executeSelect(sql);
        
        while(rs.next()){
//            String ma = rs.getString("ma_san_pham"), maMH = rs.getString("ma_mat_hang"), ten = rs.getString("ten_mat_hang");
            String ma = rs.getString(1), maMH = rs.getString(2), ten = rs.getString(3), loai = rs.getString(4), size = rs.getString(5),
                    mau = rs.getString(6);
            int gianhap = rs.getInt(7), giaban = rs.getInt(8);
            
            String[] t = {ma, maMH, ten, loai, size, mau, Integer.toString(gianhap), Integer.toString(giaban)};
            list.add(t);
        }
        return list;
    }
}
