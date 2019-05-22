/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Packages_Hung;

import Control.Hoa_Don_Ban_Hang;
import Control.Khach_Hang;
import Control.Nhan_Vien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author HuyKa
 */
public class DAO_Hoa_Don_Ban_Hang extends DAO{

    public DAO_Hoa_Don_Ban_Hang() throws ClassNotFoundException, SQLException {
        super();
    }
    
    public int get_tong_tien_from_year(String date_year) {
        String time_year = date_year;
        String sql = "SELECT san_pham.gia_ban FROM hoa_don_ban_hang,mat_hang_ban,san_pham"
                + " WHERE (hoa_don_ban_hang.ma_hoa_don = mat_hang_ban.ma_hoa_don) AND "
                + "(mat_hang_ban.ma_san_pham = san_pham.ma_san_pham) AND "
                + "YEAR(hoa_don_ban_hang.thoi_gian) = " + time_year;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int tong_tien = 0;
            while (rs.next()) {
               int gia_ban = rs.getInt("san_pham.gia_ban");
               tong_tien += gia_ban;
            }
            return tong_tien;
        }catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return -1;
    }
    public int get_tong_tien_from_month(String date_month) {
        String[] s = date_month.split("/");
        String time_year = s[1];
        String time_month = s[0];
        String sql = "SELECT san_pham.gia_ban FROM hoa_don_ban_hang,mat_hang_ban,san_pham"
                + " WHERE (hoa_don_ban_hang.ma_hoa_don = mat_hang_ban.ma_hoa_don) AND "
                + "(mat_hang_ban.ma_san_pham = san_pham.ma_san_pham) AND "
                + "YEAR(hoa_don_ban_hang.thoi_gian) = " + time_year + " AND "
                + "MONTH(hoa_don_ban_hang.thoi_gian) = " + time_month;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int tong_tien = 0;
            while (rs.next()) {
               int gia_ban = rs.getInt("san_pham.gia_ban");
               tong_tien += gia_ban;
            }
            return tong_tien;
        }catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return -1;
    }
    public int get_tong_tien_from_day(String date_day) {
        String[] s = date_day.split("/");
        String time_year = s[2];
        String time_month = s[1];
        String time_day = s[0];
        String sql = "SELECT san_pham.gia_ban FROM hoa_don_ban_hang,mat_hang_ban,san_pham"
                + " WHERE (hoa_don_ban_hang.ma_hoa_don = mat_hang_ban.ma_hoa_don) AND "
                + "(mat_hang_ban.ma_san_pham = san_pham.ma_san_pham) AND "
                + "YEAR(hoa_don_ban_hang.thoi_gian) = " + time_year + " AND "
                + "MONTH(hoa_don_ban_hang.thoi_gian) = " + time_month + " AND "
                + "DAY(hoa_don_ban_hang.thoi_gian) = " + time_day ;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            int tong_tien = 0;
            while (rs.next()) {
               int gia_ban = rs.getInt("san_pham.gia_ban");
               tong_tien += gia_ban;
            }
            return tong_tien;
        }catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return -1;
    }
    
    public ArrayList<String> getDetail(String date_day) {
        ArrayList<String> list = new ArrayList<>();
        String[] s = date_day.split("/");
        String time_year = s[2];
        String time_month = s[1];
        String time_day = s[0];
        String sql = "SELECT san_pham.ten_san_pham,san_pham.loai_san_pham,san_pham.kick_co,"
                + "san_pham.mau_sac,san_pham.gia_ban,nhan_vien.ho_ten,khach_hang.ten "
                + "FROM hoa_don_ban_hang,mat_hang_ban,san_pham,nhan_vien,khach_hang "
                + "WHERE (hoa_don_ban_hang.ma_hoa_don = mat_hang_ban.ma_hoa_don) AND "
                + "hoa_don_ban_hang.cmnd_nv_ban = nhan_vien.cmnd AND "
                + "hoa_don_ban_hang.kh_cmnd = khach_hang.cmnd AND "
                + "(mat_hang_ban.ma_san_pham = san_pham.ma_san_pham) AND "
                + "YEAR(hoa_don_ban_hang.thoi_gian) = " + time_year + " AND "
                + "MONTH(hoa_don_ban_hang.thoi_gian) = " + time_month + " AND "
                + "DAY(hoa_don_ban_hang.thoi_gian) = " + time_day ;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               String ten_san_pham = rs.getString("san_pham.ten_san_pham");
               String loai_san_pham = rs.getString("san_pham.loai_san_pham");
               String kich_co = rs.getString("san_pham.kick_co");
               String mau_sac = rs.getString("san_pham.mau_sac");
               int gia_ban = rs.getInt("san_pham.gia_ban");
               String ho_ten = rs.getString("nhan_vien.ho_ten");
               String ten = rs.getString("khach_hang.ten");
               String data = "";
               data += ten_san_pham + "-" + loai_san_pham + "-" + kich_co + "-" + mau_sac + "-" 
                       + String.valueOf(gia_ban) + "-" + ho_ten + "-" + ten;
               list.add(data);
            }
            
        }catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        
        return list;
    }
}
