/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Dang.Controller;

import Control.Hoa_Don_Nhap_Hang;
import Control_DAO.DAO;
import java.sql.PreparedStatement;
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
                + "WHERE san_pham.ma_san_pham = mat_hang_nhap.ma_san_pham AND mat_hang_nhap.hd_nhap = hoa_don_nhap_hang.ma_hd_nhap AND hoa_don_nhap_hang.ma_hd_nhap = '" + HDN + "'";

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
    public static String[] getInforHDN(String maHD) throws SQLException{
        String sql = "SELECT nhan_vien.ho_ten, nha_cung_cap.ten, hoa_don_nhap_hang.thoi_gian, hoa_don_nhap_hang.ghi_chu " +
                    "FROM nhan_vien, hoa_don_nhap_hang, nha_cung_cap " +
                    "WHERE nhan_vien.cmnd = hoa_don_nhap_hang.cmnd_nv_kho AND hoa_don_nhap_hang.ncc_cmnd = nha_cung_cap.cmnd AND hoa_don_nhap_hang.ma_hd_nhap = '" + maHD + "'";
        ResultSet rs = executeSelect(sql);
        rs.next();
        String[] kq = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)};
        return kq;
    }
    
    public static String nextID() throws SQLException{
        String sql = "SELECT MAX(ma_hd_nhap) FROM hoa_don_nhap_hang";
        ResultSet rs = executeSelect(sql);
        rs.next();
        String kq = rs.getString(1);
        
        int x = Integer.valueOf(kq.substring(3));
        x++;
        if(x < 10){
            String result = "HDN00" + x;
            return result;
        }
        if(x < 100){
            String result = "HDN0" + x;
            return result;
        }
        String result = "HDN" + x;
        return result;
    }
    
    public static void addHoadon(String maHD, String date, String note, String nv, String ncc) throws SQLException{
        String sql = "INSERT INTO hoa_don_nhap_hang(ma_hd_nhap, thoi_gian, ghi_chu, cmnd_nv_kho, ncc_cmnd) VALUES (?,?,?,?,?)";
        PreparedStatement prestate = con.prepareStatement(sql);
        prestate.setString(1, maHD);
        prestate.setString(2, date);
        prestate.setString(3, note);
        prestate.setString(4, nv);
        prestate.setString(5, ncc);
        prestate.executeUpdate();
    }
    
    public static void addMathang(String maHD, String maSP, String maMH) throws SQLException{
        String sql = "INSERT INTO mat_hang_nhap(ma_mat_hang, ma_san_pham, hd_nhap) VALUES (?,?,?)";
        PreparedStatement prestate = con.prepareStatement(sql);
        prestate.setString(1, maMH);
        prestate.setString(2, maSP);
        prestate.setString(3, maHD);
        prestate.executeUpdate();

    }
}
